package lu.kbra.standalone.gameengine.utils.gl.wrapper;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.lwjgl.opengl.GL32;
import org.lwjgl.opengl.GL33;
import org.lwjgl.opengl.GL40;
import org.lwjgl.opengl.GL46;
import org.lwjgl.opengles.GLES20;
import org.lwjgl.opengles.GLES30;
import org.lwjgl.opengles.GLES32;

import lu.kbra.standalone.gameengine.utils.GameEngineUtils;

public final class GL_W_Init {

	public static class GLMethod {
		private List<Class<?>> sources;

		private String name;
		private Class<?> returnType;
		private Parameter[] parameters;

		public GLMethod(Class<?> source, Method target) {
			this.sources = new ArrayList<Class<?>>() {
				{
					add(source);
				}
			};
			this.name = target.getName();
			this.returnType = target.getReturnType();
			this.parameters = target.getParameters();
		}

		public boolean matches(Method method) {
			return this.name.equals(method.getName()) && returnType.equals(method.getReturnType())
					&& (method.getParameters().length == parameters.length && IntStream.range(0, parameters.length).allMatch((i) -> parameters[i].getType().equals(method.getParameters()[i].getType())));
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

		public String abstractString(boolean explicitReturnValue) {
			final String ret = getType(returnType);

			final StringBuilder content = new StringBuilder();

			content.append("\tdefault " + ret + " " + name + (explicitReturnValue ? getSuffixReturnTypeName(returnType) : "") + "(");
			content.append(Arrays.stream(parameters).map((c) -> c.toString()).collect(Collectors.joining(",")));
			content.append(") {throw new RuntimeException(\"Not implemented yet.\");}\n");

			return content.toString();
		}

		public String signatureString() {
			return returnType + " " + name + "(" + Arrays.stream(parameters).map(Parameter::toString).collect(Collectors.joining(", ")) + ")";
		}

		public String wrapperString(boolean explicitReturnValue) {
			final String ret = getType(returnType);

			final StringBuilder content = new StringBuilder();

			content.append("\t/** " + sources.stream().map(Class::getSimpleName).collect(Collectors.joining(", ")) + " */\n");
			content.append("\tpublic static " + ret + " " + name + (explicitReturnValue ? getSuffixReturnTypeName(returnType) : "") + "(" + Arrays.stream(parameters).map((c) -> c.toString()).collect(Collectors.joining(",")) + ") {\n");

			content.append("\t\t" + (!"void".equals(ret) ? "return " : "") + "WRAPPER." + name + (explicitReturnValue ? getSuffixReturnTypeName(returnType) : "") + "("
					+ Arrays.stream(parameters).map((c) -> c.getName()).collect(Collectors.joining(",")) + ");\n");

			content.append("\t}\n\n");

			return content.toString();
		}

		public boolean containsSource(Class<?> clazz) {
			return sources.contains(clazz);
		}

		public String implString(Class<?> clazz, boolean explicitReturnValue) {
			final String ret = getType(returnType);

			final StringBuilder content = new StringBuilder();

			content.append("\t@Override\n");
			content.append("\tpublic " + ret + " " + name + (explicitReturnValue ? getSuffixReturnTypeName(returnType) : "") + "(");
			content.append(Arrays.stream(parameters).map((c) -> c.toString()).collect(Collectors.joining(",")));
			content.append(") {");

			content.append("\n\t\t" + (!"void".equals(ret) ? "return " : "") + clazz.getName() + "." + name + "(");

			content.append(Arrays.stream(parameters).map((c) -> c.getName()).collect(Collectors.joining(",")));

			content.append(");\n");

			content.append("\t}\n");

			return content.toString();
		}

		public String getName() {
			return name;
		}
	}

	private static final String PACKAGE_PATH = "lu.kbra.standalone.gameengine.utils.gl.wrapper";
	private static final String BASE_CONTENT = "package " + PACKAGE_PATH + ";\n" + "\n" + "public class GL_W {\n" + "\n";
	private static final String INSTANCE_CONTENT = "package " + PACKAGE_PATH + ";\n" + "\n" + "public class {name} implements GL_W_Call {\n";
	private static final String CALLER_CONTENT = "package " + PACKAGE_PATH + ";\n" + "\n" + "public interface GL_W_Call {\n";
	private static final List<String> NAME_BLACKLIST = Arrays.stream(Object.class.getDeclaredMethods()).map((c) -> c.getName()).distinct().collect(Collectors.toList());

	private static HashMap<String, List<GLMethod>> glMethods = new HashMap<>();

	public static void main(String[] args) throws IOException {
		System.out.println("Filtering out: " + NAME_BLACKLIST);

		final List<Class<?>> allGLClasses = Arrays.asList(GL33.class, GL32.class, GL40.class, GLES20.class, GLES30.class, GL46.class, GLES32.class);

		callerBase(allGLClasses);
		System.out.println("GL_W_Call done.");

		base(allGLClasses);
		System.out.println("GL_W done.");

		for (Class<?> c : allGLClasses) {
			glInit(c, allGLClasses.stream().filter((a) -> !a.equals(c)).collect(Collectors.toList()));
			System.out.println("GL_W_" + c.getSimpleName() + " done.");
		}
	}

	private static void glInit(Class<?> clazz, List<Class<?>> otherClazzes) throws IOException {
		final String FILE_PATH = "./src/main/java/" + PACKAGE_PATH.replace(".", "/") + "/GL_W_" + clazz.getSimpleName() + ".java";

		List<String> out = Arrays.stream(INSTANCE_CONTENT.replace("{name}", "GL_W_" + clazz.getSimpleName()).split("\n")).collect(Collectors.toList());

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
			out.add("	@Override\n" + "	public void checkError(String message) {\n		" + GameEngineUtils.class.getName() + ".checkGlESError(message);\n" + "	}");
		} else {
			out.add("	@Override\n" + "	public void checkError(String message) {\n		" + GameEngineUtils.class.getName() + ".checkGlError(message);\n" + "	}");
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

	private static void callerBase(List<Class<?>> clazzes) throws IOException {
		final String FILE_PATH = "./src/main/java/" + PACKAGE_PATH.replace(".", "/") + "/GL_W_Call.java";

		List<String> out = Arrays.stream(CALLER_CONTENT.split("\n")).collect(Collectors.toList());

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
							System.out.println("Couldn't merge: " + nGlM.signatureString() + " with: " + glM.signatureString());
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

		out.add("	void checkError(String message);");

		out.add("}");

		Files.write(Paths.get(FILE_PATH), out);
	}

	private static void base(List<Class<?>> clazzes) throws IOException {
		final String FILE_PATH = "./src/main/java/" + PACKAGE_PATH.replace(".", "/") + "/GL_W.java";

		List<String> out = Arrays.stream(BASE_CONTENT.split("\n")).collect(Collectors.toList());

		out.add("\n\tpublic static GL_W_Call WRAPPER;\n");

		final List<String> fields = new ArrayList<String>();

		for (Class<?> clazz : clazzes) {
			for (Field f : clazz.getFields()) {
				if (fields.contains(f.getName()))
					continue;

				if (f.getType() == int.class) {
					out.add("\tpublic static int " + f.getName() + ";");
					fields.add(f.getName());
				}
			}
		}

		for (Entry<String, List<GLMethod>> glMs : glMethods.entrySet()) {
			for (GLMethod glM : glMs.getValue()) {
				/*
				 * if (glM.getName().contains("glGenFramebuffers")) {
				 * System.out.println(glMs.getValue().stream().map(GLMethod::signatureString).collect(Collectors.joining(";"))); }
				 */
				out.add(glM.wrapperString(glMs.getValue().size() > 1));
			}
		}

		out.add("	public static void checkError(String message) {\n" + "		WRAPPER.checkError(message);\n" + "	}");
		out.add("	public static void checkError() {\n" + "		WRAPPER.checkError(\"\");\n" + "	}");

		out.add("}");

		Files.write(Paths.get(FILE_PATH), out);
	}

	private static String getSuffixReturnTypeName(Class<?> returnType) {
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
		else
			return "_" + returnType.getSimpleName();
	}

	private static String getType(Class<?> returnType) {
		if (returnType == int.class)
			return "int";
		else if (returnType == boolean.class)
			return "boolean";
		else if (returnType == void.class)
			return "void";
		else if (returnType == long.class)
			return "long";
		else if (returnType == float.class)
			return "float";
		else if (returnType == double.class)
			return "double";
		else if (returnType == short.class)
			return "short";
		else if (returnType == char.class)
			return "char";
		else
			return returnType.getName();
	}

}
