package lu.kbra.standalone.gameengine.utils.gl.wrapper;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.lwjgl.opengl.GL32;
import org.lwjgl.opengl.GL33;
import org.lwjgl.opengl.GL40;
import org.lwjgl.opengl.GL43;
import org.lwjgl.opengl.GL46;
import org.lwjgl.opengles.GLES20;
import org.lwjgl.opengles.GLES30;
import org.lwjgl.opengles.GLES32;

import lu.kbra.standalone.gameengine.utils.GameEngineUtils;

public final class GL_W_Init {

	private abstract static class GLObject<T> {
		protected final List<Class<?>> sources = new ArrayList();
		protected final String name;

		public GLObject(String name, Class<?> source) {
			this.name = name;
			this.sources.add(source);
		}

		public abstract boolean matches(T method);

		public boolean merge(Class<?> source, T type) {
			if (matches(type)) {
				if (!containsSource(source)) {
					sources.add(source);
				}
				return true;
			} else {
				return false;
			}
		}

		public boolean containsSource(Class<?> clazz) {
			return sources.contains(clazz);
		}

		public String getName() {
			return name;
		}

		public String getSourcesString() {
			return "/** " + sources.parallelStream().map(Class::getSimpleName).collect(Collectors.joining(", ")) + " */";
		}

	}

	private static class GLField extends GLObject<Field> {

		private Type type;

		public GLField(Class<?> source, Field target) {
			super(target.getName(), source);
			this.type = target.getGenericType();
		}

		@Override
		public boolean matches(Field field) {
			return super.name.equals(field.getName());
		}

		@Override
		public String toString() {
			return "\t" + super.getSourcesString() + "\n\tpublic static " + type.getTypeName() + " " + name + ";";
		}

	}

	private static class GLMethod extends GLObject<Method> {
		private Type returnType;
		private Parameter[] parameters;

		public GLMethod(Class<?> source, Method target) {
			super(target.getName(), source);

			this.returnType = target.getGenericReturnType();
			this.parameters = target.getParameters();
		}

		public boolean matches(Method method) {
			return this.name.equals(method.getName()) && returnType.equals(method.getGenericReturnType())
					&& (method.getParameters().length == parameters.length && IntStream
							.range(0, parameters.length)
							.allMatch((i) -> parameters[i].getType().equals(method.getParameters()[i].getType())));
		}

		public boolean merge(Class<?> source, Method method) {
			if (matches(method)) {
				if (!containsSource(source)) {
					sources.add(source);
				}
				return true;
			} else {
				return false;
			}
		}

		// for the interface GL_W_Call
		public String abstractString(boolean explicitReturnValue) {

			final StringBuilder content = new StringBuilder();

			content
					.append("\tdefault " + returnType.getTypeName() + " " + name
							+ (explicitReturnValue ? getSuffixReturnTypeName(returnType) : "") + "(");
			content.append(Arrays.stream(parameters).map((c) -> c.toString()).collect(Collectors.joining(",")));
			content.append(") {throw new " + UnsupportedOperationException.class.getSimpleName() + "(\"Not implemented yet.\");}\n");

			return content.toString();
		}

		public String signatureString() {
			return returnType + " " + name + "(" + Arrays.stream(parameters).map(Parameter::toString).collect(Collectors.joining(", "))
					+ ")";
		}

		// for GL_W class
		public String wrapperString(boolean explicitReturnValue) {
			final StringBuilder content = new StringBuilder();

			content.append("\t" + super.getSourcesString() + "\n");
			content
					.append("\tpublic static " + returnType.getTypeName() + " " + name
							+ (explicitReturnValue ? getSuffixReturnTypeName(returnType) : "") + "("
							+ Arrays.stream(parameters).map((c) -> c.toString()).collect(Collectors.joining(",")) + ") {\n");

			content
					.append("\t\t" + (!"void".equals(returnType.getTypeName()) ? "return " : "") + "WRAPPER." + name
							+ (explicitReturnValue ? getSuffixReturnTypeName(returnType) : "") + "("
							+ Arrays.stream(parameters).map((c) -> c.getName()).collect(Collectors.joining(",")) + ");\n");

			content.append("\t}\n");

			return content.toString();
		}

		public boolean containsSource(Class<?> clazz) {
			return sources.contains(clazz);
		}

		// for GL_W_GLxxxx class
		public String implString(Class<?> clazz, boolean explicitReturnValue) {
			final StringBuilder content = new StringBuilder();

			content.append("\t@Override\n");
			content
					.append("\tpublic " + returnType.getTypeName() + " " + name
							+ (explicitReturnValue ? getSuffixReturnTypeName(returnType) : "") + "(");
			content.append(Arrays.stream(parameters).map((c) -> c.toString()).collect(Collectors.joining(",")));
			content.append(") {");

			content.append("\n\t\t" + (!"void".equals(returnType.getTypeName()) ? "return " : "") + clazz.getName() + "." + name + "(");

			content.append(Arrays.stream(parameters).map((c) -> c.getName()).collect(Collectors.joining(",")));

			content.append(");\n");

			content.append("\t}\n");

			return content.toString();
		}

	}

	private static final String PACKAGE_PATH = GL_W_Init.class.getPackage().getName();
	private static final String GL_W_CONTENT = "package " + PACKAGE_PATH + ";\n" + "\n" + "public class GL_W {\n" + "\n";
	private static final String GL_W_GLxxxx_CONTENT = "package " + PACKAGE_PATH + ";\n" + "\n"
			+ "public class {name} implements GL_W_Call {\n";
	private static final String GL_W_CALL_CONTENT = "package " + PACKAGE_PATH + ";\n" + "\n" + "public interface GL_W_Call {\n";
	private static final List<String> NAME_BLACKLIST = Arrays
			.stream(Object.class.getDeclaredMethods())
			.map((c) -> c.getName())
			.distinct()
			.collect(Collectors.toList());

	private static HashMap<String, List<GLMethod>> glMethods = new HashMap<>();

	public static void main(String[] args) throws IOException {
		System.out.println("Filtering out: " + NAME_BLACKLIST);

		final List<Class<?>> allGLClasses = Arrays
				.asList(GL33.class, GL32.class, GL40.class, GL43.class, GLES20.class, GLES30.class, GL46.class, GLES32.class);

		gl_w_call(allGLClasses);
		System.out.println("GL_W_Call done.");

		gl_w(allGLClasses);
		System.out.println("GL_W done.");

		for (Class<?> c : allGLClasses) {
			gl_w_glxxxx(c, allGLClasses.stream().filter((a) -> !a.equals(c)).collect(Collectors.toList()));
			System.out.println("GL_W_" + c.getSimpleName() + " done.");
		}
	}

	private static void gl_w_glxxxx(Class<?> clazz, List<Class<?>> otherClazzes) throws IOException {
		final String FILE_PATH = "./src/main/java/" + PACKAGE_PATH.replace(".", "/") + "/GL_W_" + clazz.getSimpleName() + ".java";

		final List<String> out = Arrays
				.stream(GL_W_GLxxxx_CONTENT.replace("{name}", "GL_W_" + clazz.getSimpleName()).split("\n"))
				.collect(Collectors.toList());

		out.add("\n\tpublic void init() {");
		out.add("\t\tGL_W.WRAPPER = this;");

		implementFields(clazz, out);

		out.add("\t}");

		for (Entry<String, List<GLMethod>> glMs : glMethods.entrySet()) {
			for (GLMethod glM : glMs.getValue()) {
				if (glM.containsSource(clazz)) {
					out.add(glM.implString(clazz, glMs.getValue().size() > 1));
				}
			}
		}

		if (clazz.getSimpleName().contains("GLES")) {
			out
					.add("	@Override\n" + "	public boolean checkError(String message) {\n		" + GameEngineUtils.class.getName()
							+ ".checkGlESError(message);\n\t\treturn true;\n\t}");
			out.add("	@Override\n" + "	public boolean isGLES() {\n\t\treturn true;\n" + "	}");
			out.add("	@Override\n" + "	public boolean isGL() {\n\t\treturn false;\n" + "	}");
		} else {
			out
					.add("	@Override\n" + "	public boolean checkError(String message) {\n		" + GameEngineUtils.class.getName()
							+ ".checkGlError(message);\n\t\treturn true;\n\t}");
			out.add("	@Override\n" + "	public boolean isGLES() {\n\t\treturn false;\n" + "	}");
			out.add("	@Override\n" + "	public boolean isGL() {\n\t\treturn true;\n" + "	}");
		}

		out.add("}");

		Files.write(Paths.get(FILE_PATH), out);
	}

	private static void implementFields(Class<?> clazz, List<String> out) {
		for (Field f : clazz.getFields()) {
			if (f.getType() == int.class) {
				out.add("\t\tGL_W." + f.getName() + " = " + clazz.getName() + "." + f.getName() + ";");
			}
		}
	}

	private static void gl_w_call(List<Class<?>> clazzes) throws IOException {
		final String FILE_PATH = "./src/main/java/" + PACKAGE_PATH.replace(".", "/") + "/GL_W_Call.java";

		final List<String> out = Arrays.stream(GL_W_CALL_CONTENT.split("\n")).collect(Collectors.toList());

		for (Class<?> clazz : clazzes) {
			for (Method m : clazz.getMethods()) {
				if (NAME_BLACKLIST.contains(m.getName()))
					continue;

				if (glMethods.containsKey(m.getName())) {
					boolean merged = false;
					final GLMethod nGlM = new GLMethod(clazz, m);

					for (GLMethod glM : glMethods.get(m.getName())) {
						if (glM.merge(clazz, m)) {
							merged = true;
							break;
						} else {
							// System.out.println("Couldn't merge: " + nGlM.signatureString() + " with: " +
							// glM.signatureString());
						}
					}

					if (!merged) {
						glMethods.get(m.getName()).add(nGlM);
					}
				} else {
					glMethods.put(m.getName(), new ArrayList<GLMethod>() {
						{
							add(new GLMethod(clazz, m));
						}
					});
				}
			}
		}

		for (Entry<String, List<GLMethod>> glMs : glMethods.entrySet()) {
			for (GLMethod glM : glMs.getValue()) {
				out.add(glM.abstractString(glMs.getValue().size() > 1));
			}
		}

		out.add("	boolean checkError(String message);");

		out.add("	boolean isGLES();");

		out.add("	boolean isGL();");

		out.add("}");

		Files.write(Paths.get(FILE_PATH), out);
	}

	private static void gl_w(List<Class<?>> clazzes) throws IOException {
		final String FILE_PATH = "./src/main/java/" + PACKAGE_PATH.replace(".", "/") + "/GL_W.java";

		final List<String> out = Arrays.stream(GL_W_CONTENT.split("\n")).collect(Collectors.toList());

		out.add("\n\tpublic static GL_W_Call WRAPPER;\n");

		final Map<String, GLField> glFields = new HashMap<>();

		for (Class<?> clazz : clazzes) {
			for (Field f : clazz.getFields()) {
				if (glFields.containsKey(f.getName())) {
					final GLField glF = glFields.get(f.getName());
					glF.merge(clazz, f);
				} else {
					glFields.put(f.getName(), new GLField(clazz, f));
				}
			}
		}

		glFields.values().stream().forEach(f -> out.add(f.toString()));

		for (Entry<String, List<GLMethod>> glMs : glMethods.entrySet()) {
			for (GLMethod glM : glMs.getValue()) {
				out.add(glM.wrapperString(glMs.getValue().size() > 1));
			}
		}

		out.add("\tpublic static boolean checkError(String message) {\n\t\treturn WRAPPER.checkError(message);\n\t}\n");
		out.add("\tpublic static boolean checkError() {\n\t\treturn WRAPPER.checkError(\"\");\n\t}\n");

		out.add("\tpublic static boolean isGLES() {\n\t\treturn WRAPPER.isGLES();\n\t}\n");
		out.add("\tpublic static boolean isGL() {\n\t\treturn WRAPPER.isGL();\n\t}\n");

		out.add("}");

		Files.write(Paths.get(FILE_PATH), out);
	}

	private static String getSuffixReturnTypeName(Type returnType) {
		if (returnType == int.class)
			return "";
		else if (returnType == boolean.class)
			return "_boolean";
		else if (returnType == void.class)
			return "";
		else if (returnType == long.class)
			return "_long";
		else if (returnType == float.class)
			return "_float";
		else if (returnType == double.class)
			return "_double";
		else if (returnType == short.class)
			return "_short";
		else if (returnType == char.class)
			return "_char";
		else if (returnType instanceof Class<?>)
			return "_" + ((Class<?>) returnType).getSimpleName();
		else
			return "_" + returnType.getTypeName().replace(".", "_").replace("[]", "Array");
	}

}
