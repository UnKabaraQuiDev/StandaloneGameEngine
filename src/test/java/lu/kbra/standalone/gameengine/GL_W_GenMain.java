package lu.kbra.standalone.gameengine;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.logging.Level;
import java.util.stream.Collectors;

import javax.lang.model.element.Modifier;

import org.junit.Test;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL32;
import org.lwjgl.opengl.GL33;
import org.lwjgl.opengl.GL40;
import org.lwjgl.opengl.GL43;
import org.lwjgl.opengl.GL46;
import org.lwjgl.opengles.GLES20;
import org.lwjgl.opengles.GLES30;
import org.lwjgl.opengles.GLES32;

import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.FieldSpec;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeName;
import com.squareup.javapoet.TypeSpec;
import com.squareup.javapoet.TypeSpec.Builder;

import lu.kbra.pclib.impl.TriFunction;
import lu.kbra.pclib.logger.GlobalLogger;
import lu.kbra.pclib.logger.PCLogger;
import lu.kbra.standalone.gameengine.utils.GameEngineUtils;

public class GL_W_GenMain extends GenMainConsts {

	public static final String PACKAGE_PATH = GEN_PACKAGE + ".gl_wrapper";

	@Test
	public void generateAll() throws IOException {
		System.out.println("Filtering out: " + NAME_BLACKLIST);

		final List<Class<?>> allGLClasses = Arrays
				.asList(GL33.class, GL32.class, GL40.class, GL43.class, GLES20.class, GLES30.class, GL46.class, GLES32.class);

		collectMethods(allGLClasses);
		collectFields(allGLClasses);

		System.out.println("Collected methods: " + glMethods.size());
		System.out.println("Collected fields: " + glFields.size());

		generateGLWCall();
		System.out.println("GL_W_Call done.");

		generateGLW();
		System.out.println("GL_W done.");

		generateGLWImplementations(allGLClasses, Function.identity(), pckg -> pckg + ".base", (cls, name) -> {
		}, (gm, clazz, explicitSuffix) -> gm.toImplMethod(clazz, explicitSuffix));
		System.out.println("GL_W_<GLxx> done.");

		generateGLWLoggingImplementations(allGLClasses);
		System.out.println("GL_W_<GLxx>_Logging done.");

		generateGLWDebugImplementations(allGLClasses);
		System.out.println("GL_W_<GLxx>_Debug done.");

		generateGLWLoggingDebugImplementations(allGLClasses);
		System.out.println("GL_W_<GLxx>_LoggingDebug done.");

		generateGLWLoggingDebugFlushingImplementations(allGLClasses);
		System.out.println("GL_W_<GLxx>_LoggingDebugFlush done.");

		generateGLWLoggingDebugSyncingImplementations(allGLClasses);
		System.out.println("GL_W_<GLxx>_LoggingDebugSync done.");
	}

	private abstract class GLObject<T> {
		protected final List<Class<?>> sources = new ArrayList<>();
		protected final String name;

		public GLObject(String name, Class<?> source) {
			this.name = name;
			sources.add(source);
		}

		public abstract boolean matches(T method);

		public boolean merge(Class<?> source, T type) {
			if (!matches(type))
				return false;
			if (!containsSource(source))
				sources.add(source);
			return true;
		}

		public boolean containsSource(Class<?> clazz) {
			return sources.contains(clazz);
		}

		public String getName() {
			return name;
		}

		public String getSourcesString() {
			return sources.parallelStream().map(Class::getSimpleName).collect(Collectors.joining(", "));
		}
	}

	private class GLField extends GLObject<Field> {
		private final Type type;

		public GLField(Class<?> source, Field target) {
			super(target.getName(), source);
			type = target.getGenericType();
		}

		@Override
		public boolean matches(Field field) {
			return super.name.equals(field.getName());
		}

		public FieldSpec toFieldSpec() {
			TypeName tn = TypeName.get(type);
			FieldSpec.Builder fb = FieldSpec.builder(tn, name, Modifier.PUBLIC, Modifier.STATIC);
			fb.addJavadoc("$L", getSourcesString());
			return fb.build();
		}
	}

	private class GLMethod extends GLObject<Method> {
		final Type returnType;
		final Parameter[] parameters;

		public GLMethod(Class<?> source, Method target) {
			super(target.getName(), source);
			returnType = target.getGenericReturnType();
			parameters = target.getParameters();
		}

		@Override
		public boolean matches(Method method) {
			if (!name.equals(method.getName()))
				return false;
			if (!returnType.equals(method.getGenericReturnType()))
				return false;
			Parameter[] other = method.getParameters();
			if (other.length != parameters.length)
				return false;
			for (int i = 0; i < parameters.length; i++)
				if (!parameters[i].getType().equals(other[i].getType()))
					return false;
			return true;
		}

		public MethodSpec toInterfaceDefault(boolean explicitSuffix) {
			String methodName = name + (explicitSuffix ? getSuffixReturnTypeName(returnType) : "");
			MethodSpec.Builder mb = MethodSpec.methodBuilder(methodName)
					.addModifiers(Modifier.PUBLIC, Modifier.DEFAULT)
					.returns(TypeName.get(returnType));

			for (Parameter p : parameters)
				mb.addParameter(TypeName.get(p.getParameterizedType()), p.getName());

			mb.addStatement("throw new $T($S)", UnsupportedOperationException.class, "Not implemented yet.");
			return mb.build();
		}

		public MethodSpec toWrapperStatic(boolean explicitSuffix) {
			String methodName = name + (explicitSuffix ? getSuffixReturnTypeName(returnType) : "");
			MethodSpec.Builder mb = MethodSpec.methodBuilder(methodName)
					.addModifiers(Modifier.PUBLIC, Modifier.STATIC)
					.returns(TypeName.get(returnType));

			mb.addJavadoc("$L", getSourcesString());

			for (Parameter p : parameters)
				mb.addParameter(TypeName.get(p.getParameterizedType()), p.getName());

			String argList = Arrays.stream(parameters).map(Parameter::getName).collect(Collectors.joining(", "));
			String call = "WRAPPER." + methodName + "(" + argList + ")";

			if (!TypeName.get(returnType).equals(TypeName.VOID))
				mb.addStatement("return $L", call);
			else
				mb.addStatement("$L", call);

			return mb.build();
		}

		public MethodSpec toImplMethod(Class<?> implClazz, boolean explicitSuffix) {
			String methodName = name + (explicitSuffix ? getSuffixReturnTypeName(returnType) : "");
			MethodSpec.Builder mb = MethodSpec.methodBuilder(methodName)
					.addAnnotation(Override.class)
					.addModifiers(Modifier.PUBLIC)
					.returns(TypeName.get(returnType));

			for (Parameter p : parameters)
				mb.addParameter(TypeName.get(p.getParameterizedType()), p.getName());

			String argList = Arrays.stream(parameters).map(Parameter::getName).collect(Collectors.joining(", "));
			String call = implClazz.getName() + "." + name + "(" + argList + ")";

			if (!TypeName.get(returnType).equals(TypeName.VOID))
				mb.addStatement("return $L", call);
			else
				mb.addStatement("$L", call);

			return mb.build();
		}

		public MethodSpec toLoggingImplMethod(Class<?> implClazz, boolean explicitSuffix) {
			String methodName = name + (explicitSuffix ? getSuffixReturnTypeName(returnType) : "");
			MethodSpec.Builder mb = MethodSpec.methodBuilder(methodName)
					.addAnnotation(Override.class)
					.addModifiers(Modifier.PUBLIC)
					.returns(TypeName.get(returnType));

			for (Parameter p : parameters)
				mb.addParameter(TypeName.get(p.getParameterizedType()), p.getName());

			String argList = Arrays.stream(parameters).map(Parameter::getName).collect(Collectors.joining(", "));
			String call = implClazz.getName() + "." + name + "(" + argList + ")";

			if (!TypeName.get(returnType).equals(TypeName.VOID)) {
				mb.addStatement("$T ret = $L", TypeName.get(returnType), call);
				mb.addStatement("LOGGER.log($T.INFO, \"" + buildLogPrefix(methodName) + " = \" + ret)", Level.class);
				mb.addStatement("return ret");
			} else {
				mb.addStatement("$L", call);
				mb.addStatement("LOGGER.log($T.INFO, \"" + buildLogPrefix(methodName) + "\")", Level.class);
			}

			return mb.build();
		}

		public MethodSpec toLoggingDebugImplMethod(Class<?> implClazz, boolean explicitSuffix) {
			String methodName = name + (explicitSuffix ? getSuffixReturnTypeName(returnType) : "");
			TypeName retType = TypeName.get(returnType);
			boolean returnsValue = !retType.equals(TypeName.VOID);

			MethodSpec.Builder mb = MethodSpec.methodBuilder(methodName)
					.addAnnotation(Override.class)
					.addModifiers(Modifier.PUBLIC)
					.returns(retType);

			for (Parameter p : parameters)
				mb.addParameter(TypeName.get(p.getParameterizedType()), p.getName());

			String argList = Arrays.stream(parameters).map(Parameter::getName).collect(Collectors.joining(", "));
			String call = implClazz.getName() + "." + name + "(" + argList + ")";

			if (returnsValue)
				mb.addStatement("$T ret = $L", retType, call);
			else
				mb.addStatement("$L", call);

			String glGetError = implClazz.getName() + ".glGetError()";
			mb.addStatement("int err = $L", glGetError);

			if (returnsValue) {
				mb.addStatement("LOGGER.log($T.INFO, \"" + buildLogPrefix(methodName) + " = \" + ret + (err != 0 ? $S + err : $S))",
						Level.class,
						" !! ERROR: ",
						"");
				mb.addStatement("if (err != $T.GL_NO_ERROR) throw new $T(\"" + buildLogPrefix(methodName)
						+ " = \" + ret + \" !! ERROR: \" + err)", implClazz, RuntimeException.class);

				mb.addStatement("return ret");
			} else {
				mb.addStatement("LOGGER.log($T.INFO, \"" + buildLogPrefix(methodName) + "\" + (err != 0 ? $S + err : $S))",
						Level.class,
						" !! ERROR: ",
						"");
				mb.addStatement("if (err != $T.GL_NO_ERROR) throw new $T(\"" + buildLogPrefix(methodName) + " !! ERROR: \" + err)",
						implClazz,
						RuntimeException.class);

			}

			return mb.build();
		}

		public MethodSpec toDebugImplMethod(Class<?> implClazz, boolean explicitSuffix) {
			String methodName = name + (explicitSuffix ? getSuffixReturnTypeName(returnType) : "");
			TypeName retType = TypeName.get(returnType);
			boolean returnsValue = !retType.equals(TypeName.VOID);

			MethodSpec.Builder mb = MethodSpec.methodBuilder(methodName)
					.addAnnotation(Override.class)
					.addModifiers(Modifier.PUBLIC)
					.returns(retType);

			for (Parameter p : parameters)
				mb.addParameter(TypeName.get(p.getParameterizedType()), p.getName());

			String argList = Arrays.stream(parameters).map(Parameter::getName).collect(Collectors.joining(", "));
			String call = implClazz.getName() + "." + name + "(" + argList + ")";

			if (returnsValue)
				mb.addStatement("$T ret = $L", retType, call);
			else
				mb.addStatement("$L", call);

			String glGetError = implClazz.getName() + ".glGetError()";
			mb.addStatement("int err = $L", glGetError);

			if (returnsValue) {
				mb.addStatement("if (err != $T.GL_NO_ERROR) throw new $T(\"" + buildLogPrefix(methodName)
						+ " = \" + ret + \" !! ERROR: \" + err)", implClazz, RuntimeException.class);
				mb.addStatement("return ret");
			} else
				mb.addStatement("if (err != $T.GL_NO_ERROR) throw new $T(\"" + buildLogPrefix(methodName) + " !! ERROR: \" + err)",
						implClazz,
						RuntimeException.class);

			return mb.build();
		}

		private String buildLogPrefix(String methodName) {
			return parameters.length == 0 ? methodName + "()"
					: methodName + "(\" + " + Arrays.stream(parameters).map(Parameter::getName).collect(Collectors.joining(" + \", \" + "))
							+ " + \")";
		}

		public MethodSpec toLoggingDebugFlushingImplMethod(Class<?> implClazz, boolean explicitSuffix) {
			String methodName = name + (explicitSuffix ? getSuffixReturnTypeName(returnType) : "");
			TypeName retType = TypeName.get(returnType);
			boolean returnsValue = !retType.equals(TypeName.VOID);

			MethodSpec.Builder mb = MethodSpec.methodBuilder(methodName)
					.addAnnotation(Override.class)
					.addModifiers(Modifier.PUBLIC)
					.returns(retType);

			for (Parameter p : parameters)
				mb.addParameter(TypeName.get(p.getParameterizedType()), p.getName());

			String argList = Arrays.stream(parameters).map(Parameter::getName).collect(Collectors.joining(", "));
			String call = implClazz.getName() + "." + name + "(" + argList + ")";

			if (returnsValue)
				mb.addStatement("$T ret = $L", retType, call);
			else
				mb.addStatement("$L", call);

			String glGetError = implClazz.getName() + ".glGetError()";
			mb.addStatement("int err = $L", glGetError);

			mb.addStatement("$T.glFlush()", GL11.class);

			if (returnsValue) {
				mb.addStatement("if (err != $T.GL_NO_ERROR) throw new $T(\"" + buildLogPrefix(methodName)
						+ " = \" + ret + \" !! ERROR: \" + err)", implClazz, RuntimeException.class);
				mb.addStatement("return ret");
			} else
				mb.addStatement("if (err != $T.GL_NO_ERROR) throw new $T(\"" + buildLogPrefix(methodName) + " !! ERROR: \" + err)",
						implClazz,
						RuntimeException.class);

			return mb.build();
		}

		public MethodSpec toLoggingDebugSyncImplMethod(Class<?> implClazz, boolean explicitSuffix) {
			String methodName = name + (explicitSuffix ? getSuffixReturnTypeName(returnType) : "");
			TypeName retType = TypeName.get(returnType);
			boolean returnsValue = !retType.equals(TypeName.VOID);

			MethodSpec.Builder mb = MethodSpec.methodBuilder(methodName)
					.addAnnotation(Override.class)
					.addModifiers(Modifier.PUBLIC)
					.returns(retType);

			for (Parameter p : parameters)
				mb.addParameter(TypeName.get(p.getParameterizedType()), p.getName());

			String argList = Arrays.stream(parameters).map(Parameter::getName).collect(Collectors.joining(", "));
			String call = implClazz.getName() + "." + name + "(" + argList + ")";

			if (returnsValue)
				mb.addStatement("$T ret = $L", retType, call);
			else
				mb.addStatement("$L", call);

			String glGetError = implClazz.getName() + ".glGetError()";
			mb.addStatement("int err = $L", glGetError);

			mb.addStatement("final long fence = $T.glFenceSync($T.GL_SYNC_GPU_COMMANDS_COMPLETE, 0)", GL32.class, GL32.class);
			mb.addStatement("$T.glFlush()", GL11.class);
			mb.addStatement("final int result = $T.glClientWaitSync(fence, $T.GL_SYNC_FLUSH_COMMANDS_BIT, 100_000_000)",
					GL32.class,
					GL32.class);
			// mb.addStatement("$T.err.println(result)", System.class);
			mb.addStatement("assert result != $T.GL_WAIT_FAILED", GL32.class);

			if (returnsValue) {
				mb.addStatement("if (err != $T.GL_NO_ERROR) throw new $T(\"" + buildLogPrefix(methodName)
						+ " = \" + ret + \" !! ERROR: \" + err)", implClazz, RuntimeException.class);
				mb.addStatement("return ret");
			} else
				mb.addStatement("if (err != $T.GL_NO_ERROR) throw new $T(\"" + buildLogPrefix(methodName) + " !! ERROR: \" + err)",
						implClazz,
						RuntimeException.class);

			return mb.build();
		}
	}

	/*
	 * --------------------------- Suffix helper (same logic as original) ---------------------------
	 */
	private String getSuffixReturnTypeName(Type returnType) {
		if (returnType == int.class)
			return "";
		if (returnType == boolean.class)
			return "_boolean";
		if (returnType == void.class)
			return "";
		if (returnType == long.class)
			return "_long";
		if (returnType == float.class)
			return "_float";
		if (returnType == double.class)
			return "_double";
		if (returnType == short.class)
			return "_short";
		if (returnType == char.class)
			return "_char";
		if (returnType instanceof Class<?>)
			return "_" + ((Class<?>) returnType).getSimpleName();
		return "_" + returnType.getTypeName().replace(".", "_").replace("[]", "Array");
	}

	/*
	 * --------------------------- Main generation logic ---------------------------
	 */

	private final List<String> NAME_BLACKLIST = Arrays.stream(Object.class.getDeclaredMethods())
			.map(Method::getName)
			.distinct()
			.collect(Collectors.toList());

	private final HashMap<String, List<GLMethod>> glMethods = new HashMap<>();
	private final HashMap<String, GLField> glFields = new HashMap<>();

	/*
	 * ----------- collectors -----------
	 */

	private void collectMethods(List<Class<?>> classes) {
		for (Class<?> clazz : classes)
			for (Method m : clazz.getMethods()) {
				if (NAME_BLACKLIST.contains(m.getName()))
					continue;

				if (glMethods.containsKey(m.getName())) {
					boolean merged = false;
					GLMethod candidate = new GLMethod(clazz, m);
					for (GLMethod existing : glMethods.get(m.getName()))
						if (existing.merge(clazz, m)) {
							merged = true;
							break;
						}
					if (!merged)
						glMethods.get(m.getName()).add(candidate);
				} else {
					List<GLMethod> list = new ArrayList<>();
					list.add(new GLMethod(clazz, m));
					glMethods.put(m.getName(), list);
				}
			}
	}

	private void collectFields(List<Class<?>> classes) {
		for (Class<?> clazz : classes)
			for (Field f : clazz.getFields()) {
				if (f.getType() != int.class)
					continue;
				if (glFields.containsKey(f.getName()))
					glFields.get(f.getName()).merge(clazz, f);
				else
					glFields.put(f.getName(), new GLField(clazz, f));
			}
	}

	/*
	 * ----------------------- Generate GL_W_Call (interface) -----------------------
	 */

	private void generateGLWCall() throws IOException {
		TypeSpec.Builder iface = TypeSpec.interfaceBuilder("GL_W_Call").addModifiers(Modifier.PUBLIC);

		for (Map.Entry<String, List<GLMethod>> entry : glMethods.entrySet()) {
			boolean explicitSuffix = entry.getValue().size() > 1;
			for (GLMethod m : entry.getValue())
				iface.addMethod(m.toInterfaceDefault(explicitSuffix));
		}

		iface.addMethod(MethodSpec.methodBuilder("checkError")
				.addModifiers(Modifier.PUBLIC, Modifier.ABSTRACT)
				.returns(boolean.class)
				.addParameter(String.class, "message")
				.build());

		iface.addMethod(MethodSpec.methodBuilder("isGLES").addModifiers(Modifier.PUBLIC, Modifier.ABSTRACT).returns(boolean.class).build());

		iface.addMethod(MethodSpec.methodBuilder("isGL").addModifiers(Modifier.PUBLIC, Modifier.ABSTRACT).returns(boolean.class).build());

		JavaFile jf = JavaFile.builder(PACKAGE_PATH, iface.build()).indent("\t").build();

		jf.writeTo(SRC_MAIN_JAVA_DIR);
	}

	/*
	 * ----------------------- Generate GL_W (holder + wrappers) -----------------------
	 */

	private void generateGLW() throws IOException {
		ClassName glWCall = ClassName.get(PACKAGE_PATH, "GL_W_Call");

		TypeSpec.Builder cls = TypeSpec.classBuilder("GL_W").addModifiers(Modifier.PUBLIC);

		FieldSpec wrapperField = FieldSpec.builder(glWCall, "WRAPPER", Modifier.PUBLIC, Modifier.STATIC).build();
		cls.addField(wrapperField);

		for (GLField gf : glFields.values())
			cls.addField(gf.toFieldSpec());

		for (Map.Entry<String, List<GLMethod>> entry : glMethods.entrySet()) {
			boolean explicitSuffix = entry.getValue().size() > 1;
			for (GLMethod m : entry.getValue())
				cls.addMethod(m.toWrapperStatic(explicitSuffix));
		}

		cls.addMethod(MethodSpec.methodBuilder("checkError")
				.addModifiers(Modifier.PUBLIC, Modifier.STATIC)
				.returns(boolean.class)
				.addParameter(String.class, "message")
				.addStatement("return WRAPPER.checkError(message)")
				.build());

		cls.addMethod(MethodSpec.methodBuilder("checkError")
				.addModifiers(Modifier.PUBLIC, Modifier.STATIC)
				.returns(boolean.class)
				.addStatement("return WRAPPER.checkError(\"\")")
				.build());

		cls.addMethod(MethodSpec.methodBuilder("isGLES")
				.addModifiers(Modifier.PUBLIC, Modifier.STATIC)
				.returns(boolean.class)
				.addStatement("return WRAPPER.isGLES()")
				.build());

		cls.addMethod(MethodSpec.methodBuilder("isGL")
				.addModifiers(Modifier.PUBLIC, Modifier.STATIC)
				.returns(boolean.class)
				.addStatement("return WRAPPER.isGL()")
				.build());

		JavaFile jf = JavaFile.builder(PACKAGE_PATH, cls.build()).indent("\t").build();

		jf.writeTo(SRC_MAIN_JAVA_DIR);
	}

	/*
	 * ----------------------------- Generate GL_W_<GLxx> classes - create inheritance chains inside
	 * each group -----------------------------
	 */

	private void generateGLWImplementations(
			List<Class<?>> allGLClasses,
			Function<String, String> name,
			Function<String, String> pckgs,
			BiConsumer<TypeSpec.Builder, String> classCompleter,
			TriFunction<GLMethod, Class<?>, Boolean, MethodSpec> methodCompleter) throws IOException {
		Map<Class<?>, Class<?>> superclassMap = buildGLFamilyHierarchy(allGLClasses);
		final String newPackage = pckgs.apply(PACKAGE_PATH);

		for (Class<?> clazz : allGLClasses) {
			String simple = clazz.getSimpleName();
			String genName = name.apply("GL_W_" + simple);
			TypeSpec.Builder cls = TypeSpec.classBuilder(genName).addModifiers(Modifier.PUBLIC);

			if (superclassMap.containsKey(clazz)) {
				Class<?> superClazz = superclassMap.get(clazz);
				String superName = name.apply("GL_W_" + superClazz.getSimpleName());
				ClassName superCN = ClassName.get(newPackage, superName);
				cls.superclass(superCN);
			} else {
				ClassName iface = ClassName.get(PACKAGE_PATH, "GL_W_Call");
				cls.addSuperinterface(iface);
			}

			classCompleter.accept(cls, genName);

			MethodSpec.Builder init = MethodSpec.methodBuilder("init").addModifiers(Modifier.PUBLIC);

			init.addStatement("$T.WRAPPER = this", ClassName.get(PACKAGE_PATH, "GL_W"));

			for (Field f : clazz.getFields())
				if (f.getType() == int.class)
					init.addStatement("$T.$L = $T.$L", ClassName.get(PACKAGE_PATH, "GL_W"), f.getName(), ClassName.get(clazz), f.getName());
			cls.addMethod(init.build());

			for (Map.Entry<String, List<GLMethod>> entry : glMethods.entrySet()) {
				boolean explicitSuffix = entry.getValue().size() > 1;
				for (GLMethod gm : entry.getValue()) {
					if (!gm.containsSource(clazz))
						continue;
					cls.addMethod(methodCompleter.apply(gm, clazz, explicitSuffix));
				}
			}

			boolean isGles = clazz.getSimpleName().contains("GLES");
			cls.addMethod(MethodSpec.methodBuilder("checkError")
					.addAnnotation(Override.class)
					.addModifiers(Modifier.PUBLIC)
					.addParameter(String.class, "message")
					.returns(boolean.class)
					.addStatement("$T." + (isGles ? "checkGlESError" : "checkGlError") + "(message)", ClassName.get(GameEngineUtils.class))
					.addStatement("return true")
					.build());

			cls.addMethod(MethodSpec.methodBuilder("isGLES")
					.addAnnotation(Override.class)
					.addModifiers(Modifier.PUBLIC)
					.returns(boolean.class)
					.addStatement("return $L", isGles)
					.build());

			cls.addMethod(MethodSpec.methodBuilder("isGL")
					.addAnnotation(Override.class)
					.addModifiers(Modifier.PUBLIC)
					.returns(boolean.class)
					.addStatement("return $L", !isGles)
					.build());

			JavaFile jf = JavaFile.builder(newPackage, cls.build()).indent("\t").build();

			jf.writeTo(SRC_MAIN_JAVA_DIR);
		}
	}

	private void generateGLWLoggingImplementations(List<Class<?>> allGLClasses) throws IOException {
		generateGLWImplementations(allGLClasses,
				n -> n + "_Logging",
				pckg -> pckg + ".logging",
				this::createLogger,
				(gm, clazz, explicitSuffix) -> gm.toLoggingImplMethod(clazz, explicitSuffix));
	}

	private void generateGLWDebugImplementations(List<Class<?>> allGLClasses) throws IOException {
		generateGLWImplementations(allGLClasses, n -> n + "_Debug", pckg -> pckg + ".debug", (cls, name) -> {
		}, (gm, clazz, explicitSuffix) -> gm.toDebugImplMethod(clazz, explicitSuffix));
	}

	private void generateGLWLoggingDebugImplementations(List<Class<?>> allGLClasses) throws IOException {
		generateGLWImplementations(allGLClasses,
				n -> n + "_LoggingDebug",
				pckg -> pckg + ".logging_debug",
				this::createLogger,
				(gm, clazz, explicitSuffix) -> gm.toLoggingDebugImplMethod(clazz, explicitSuffix));
	}

	private void generateGLWLoggingDebugFlushingImplementations(List<Class<?>> allGLClasses) throws IOException {
		generateGLWImplementations(allGLClasses,
				n -> n + "_LoggingDebugFlush",
				pckg -> pckg + ".logging_debug_flush",
				this::createLogger,
				(gm, clazz, explicitSuffix) -> gm.toLoggingDebugFlushingImplMethod(clazz, explicitSuffix));
	}

	private void generateGLWLoggingDebugSyncingImplementations(List<Class<?>> allGLClasses) throws IOException {
		generateGLWImplementations(allGLClasses,
				n -> n + "_LoggingDebugSync",
				pckg -> pckg + ".logging_debug_sync",
				this::createLogger,
				(gm, clazz, explicitSuffix) -> gm.toLoggingDebugSyncImplMethod(clazz, explicitSuffix));
	}

	public Map<Class<?>, Class<?>> buildGLFamilyHierarchy(Collection<Class<?>> allGlClasses) {
		Map<Class<?>, Class<?>> map = new HashMap<>();

		List<Class<?>> gl = new ArrayList<>();
		List<Class<?>> gles = new ArrayList<>();

		for (Class<?> c : allGlClasses) {
			if (c.getSimpleName().startsWith("GL"))
				gl.add(c);
			if (c.getSimpleName().startsWith("GLES"))
				gles.add(c);
		}

		buildChainForGroup(gl, map);
		buildChainForGroup(gles, map);

		return map;
	}

	private void buildChainForGroup(List<Class<?>> group, Map<Class<?>, Class<?>> map) {
		Set<Class<?>> set = new HashSet<>(group);

		for (Class<?> c : group) {
			Class<?> sup = c.getSuperclass();
			if (set.contains(sup))
				map.put(c, sup);
		}
	}

	private void createLogger(Builder cls, String name) {
		cls.addField(FieldSpec.builder(PCLogger.class, "LOGGER", Modifier.PRIVATE, Modifier.STATIC)
				.initializer("$T.getLogger()", GlobalLogger.class)
				.build());
	}

}
