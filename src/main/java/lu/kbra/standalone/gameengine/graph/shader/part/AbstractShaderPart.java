package lu.kbra.standalone.gameengine.graph.shader.part;

import java.util.Map;
import java.util.Map.Entry;
import java.util.logging.Level;

import lu.kbra.pclib.PCUtils;
import lu.kbra.pclib.logger.GlobalLogger;
import lu.kbra.standalone.gameengine.generated.gl_wrapper.GL_W;
import lu.kbra.standalone.gameengine.impl.AutoCleanupable;
import lu.kbra.standalone.gameengine.impl.Cleanupable;
import lu.kbra.standalone.gameengine.impl.GLObject;
import lu.kbra.standalone.gameengine.impl.IdOwner;
import lu.kbra.standalone.gameengine.utils.GameEngineUtils;

public abstract class AbstractShaderPart extends AutoCleanupable implements IdOwner, Cleanupable, GLObject {

	public static final String DEBUG_PROPERTY = AbstractShaderPart.class.getSimpleName() + ".debug";
	public static boolean DEBUG = Boolean.getBoolean(DEBUG_PROPERTY);

	private final String file;
	private int sid;
	private final int type;
	private final Map<String, Object> replacements;

	public AbstractShaderPart(final String file, final int type) {
		this(file, type, null);
	}

	public AbstractShaderPart(final String file, final int type, final Map<String, Object> replacements) {
		this.file = file;
		this.type = type;
		this.replacements = replacements;

		if (type == -1) {
			GameEngineUtils.throwGLESError("Unknown shader type: " + file);
			sid = -1;
			return;
		}

		final String source = loadSource();

		sid = GL_W.glCreateShader(type);
		// TODO: add gl version
		GL_W.glShaderSource(sid, source);
		GL_W.glCompileShader(sid);

		if (GL_W.glGetShaderi(sid, GL_W.GL_COMPILE_STATUS) == GL_W.GL_FALSE) {
			final int logLen = GL_W.glGetShaderi(sid, GL_W.GL_INFO_LOG_LENGTH);
			GlobalLogger.log(Level.SEVERE, file + "> " + GL_W.glGetShaderInfoLog_String(sid, logLen));
			cleanup();
			throw new IllegalStateException(file + "(" + sid + "): Failed to compile shader!");
		}
		GlobalLogger.log(Level.INFO, "ShaderPart " + file + " (" + sid + ") (" + type + ") created successfully");
	}

	protected String loadSource() {
		String source;
		try {
			source = PCUtils.readStringSource(file).replace("{version}", GL_W.WRAPPER.isGL() ? "420 core" : "300 es");
		} catch (final Exception e) {
			throw new RuntimeException("Error when loading file `" + file + "`", e);
		}
		if (replacements != null)
			for (final Entry<String, Object> eso : replacements.entrySet()) {
				if (eso.getValue() == null)
					throw new IllegalArgumentException("Value is null for key: " + eso.getKey() + ", probably not intended");
				source = source.replace(eso.getKey(), eso.getValue().toString());
			}
		if (DEBUG)
			GlobalLogger.logRaw(Level.INFO, source);
		return source;
	}

	public static AbstractShaderPart load(final String file) {
		return load(file, null);
	}

	public static AbstractShaderPart load(final String file, final Map<String, Object> replacements) {
		final int type = shaderType(file.substring(file.lastIndexOf(".") + 1));
		if (type == GL_W.GL_VERTEX_SHADER)
			return new VertexShaderPart(file, replacements);
		if (type == GL_W.GL_FRAGMENT_SHADER)
			return new FragmentShaderPart(file, replacements);
		if (type == GL_W.GL_COMPUTE_SHADER)
			return new ComputeShaderPart(file, replacements);
		GameEngineUtils.throwGLESError("Unknown shader part type: " + file);
		return null;
	}

	public boolean recompile() {
		final String source = loadSource();

		GL_W.glShaderSource(sid, source);
		GL_W.glCompileShader(sid);

		if (GL_W.glGetShaderi(sid, GL_W.GL_COMPILE_STATUS) == GL_W.GL_FALSE) {
			final int logLen = GL_W.glGetShaderi(sid, GL_W.GL_INFO_LOG_LENGTH);
			GlobalLogger.log(Level.SEVERE, file + "> " + GL_W.glGetShaderInfoLog_String(sid, logLen));
			return false;
		}
		GlobalLogger.log(Level.INFO, "ShaderPart " + file + " (" + sid + ") (" + type + ") recompiled successfully");
		return true;
	}

	@Override
	public void cleanup() {
		if (sid == -1)
			return;

		GlobalLogger.log("Cleaning up: " + file + " (" + sid + ")");

		GL_W.glDeleteShader(sid);
		sid = -1;
		super.cleanup();
	}

	@Override
	public String getId() {
		return file;
	}

	@Override
	public int getGlId() {
		return sid;
	}

	@Override
	public boolean isValid() {
		return sid != -1;
	}

	public String getFile() {
		return file;
	}

	public int getType() {
		return type;
	}

	public static int shaderType(final String type) {
		switch (type.toLowerCase()) {
		case "vert" -> {
			return GL_W.GL_VERTEX_SHADER;
		}
		case "frag" -> {
			return GL_W.GL_FRAGMENT_SHADER;
		}
		case "geo", "comp" -> {
			if (GL_W.isGLES())
				GameEngineUtils.throwGLESError("Cannot load Compute/Geometry shader using GLES");
			return GL_W.GL_COMPUTE_SHADER;
		}
		}
		GameEngineUtils.throwGLESError("Unknown shader type: " + type);
		return -1;
	}

}
