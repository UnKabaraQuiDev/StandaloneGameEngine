package lu.kbra.standalone.gameengine.graph.shader.part;

import java.util.Map;
import java.util.Map.Entry;
import java.util.logging.Level;

import lu.pcy113.pclib.PCUtils;
import lu.pcy113.pclib.logger.GlobalLogger;

import lu.kbra.standalone.gameengine.impl.Cleanupable;
import lu.kbra.standalone.gameengine.impl.GLObject;
import lu.kbra.standalone.gameengine.impl.UniqueID;
import lu.kbra.standalone.gameengine.utils.GameEngineUtils;
import lu.kbra.standalone.gameengine.utils.gl.wrapper.GL_W;

public abstract class AbstractShaderPart implements UniqueID, Cleanupable, GLObject {

	private final String file;
	private int sid;
	private final int type;
	private final Map<String, Object> replacements;

	public AbstractShaderPart(String file, int type) {
		this(file, type, null);
	}

	public AbstractShaderPart(String file, int type, Map<String, Object> replacements) {
		this.file = file;
		this.type = type;
		this.replacements = replacements;

		if (type == -1) {
			GameEngineUtils.throwGLESError("Unknown shader type: " + file);
			this.sid = -1;
			return;
		}

		final String source = loadSource();

		this.sid = GL_W.glCreateShader(type);
		assert GL_W.checkError("CreateShader(" + type + ") (" + file + ")");
		// TODO: add gl version
		GL_W.glShaderSource(sid, source);
		assert GL_W.checkError("ShaderSource(" + sid + ") (" + file + ")");
		GL_W.glCompileShader(sid);
		assert GL_W.checkError("CompileShader(" + sid + ") (" + file + ")");

		if (GL_W.glGetShaderi(sid, GL_W.GL_COMPILE_STATUS) == GL_W.GL_FALSE) {
			final int logLen = GL_W.glGetShaderi(this.sid, GL_W.GL_INFO_LOG_LENGTH);
			GlobalLogger.log(Level.SEVERE, file + "> " + GL_W.glGetShaderInfoLog_String(sid, logLen));
			cleanup();
			throw new IllegalStateException(file + "(" + sid + "): Failed to compile shader!");
		} else {
			GlobalLogger.log(Level.INFO, "ShaderPart " + file + " (" + sid + ") (" + type + ") created successfully");
		}
	}

	protected String loadSource() {
		String source;
		try {
			source = PCUtils.readStringSource(file).replace("{version}", GL_W.WRAPPER.isGL() ? "420 core" : "300 es");
		} catch (Exception e) {
			throw new RuntimeException("Error when loading file `" + file + "`", e);
		}
		if (replacements != null) {
			for (Entry<String, Object> eso : replacements.entrySet()) {
				if (eso.getValue() == null) {
					throw new IllegalArgumentException(
							"Value is null for key: " + eso.getKey() + ", probably not intended");
				}
				source = source.replace(eso.getKey(), eso.getValue().toString());
			}
		}
		return source;
	}

	public static AbstractShaderPart load(String file) {
		return load(file, null);
	}

	public static AbstractShaderPart load(String file, Map<String, Object> replacements) {
		final int type = shaderType(file.substring(file.lastIndexOf(".") + 1));
		if (type == GL_W.GL_VERTEX_SHADER) {
			return new VertexShaderPart(file, replacements);
		} else if (type == GL_W.GL_FRAGMENT_SHADER) {
			return new FragmentShaderPart(file, replacements);
		} else if (type == GL_W.GL_COMPUTE_SHADER) {
			return new ComputeShaderPart(file, replacements);
		} else {
			GameEngineUtils.throwGLESError("Unknown shader part type: " + file);
			return null;
		}
	}

	public boolean recompile() {
		final String source = loadSource();

		GL_W.glShaderSource(sid, source);
		assert GL_W.checkError("ShaderSource(" + sid + ") (" + file + ")");
		GL_W.glCompileShader(sid);
		assert GL_W.checkError("CompileShader(" + sid + ") (" + file + ")");

		if (GL_W.glGetShaderi(sid, GL_W.GL_COMPILE_STATUS) == GL_W.GL_FALSE) {
			final int logLen = GL_W.glGetShaderi(this.sid, GL_W.GL_INFO_LOG_LENGTH);
			GlobalLogger.log(Level.SEVERE, file + "> " + GL_W.glGetShaderInfoLog_String(sid, logLen));
			return false;
		} else {
			GlobalLogger.log(Level.INFO,
					"ShaderPart " + file + " (" + sid + ") (" + type + ") recompiled successfully");
			return true;
		}
	}

	@Override
	public void cleanup() {
		GlobalLogger.log("Cleaning up: " + file + " (" + sid + ")");

		if (sid == -1)
			return;

		GL_W.glDeleteShader(sid);
		assert GL_W.checkError("DeleteShader(" + file + ")");
		sid = -1;
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

	public static int shaderType(String type) {
		switch (type.toLowerCase()) {
		case "vert":
			return GL_W.GL_VERTEX_SHADER;
		case "frag":
			return GL_W.GL_FRAGMENT_SHADER;
		case "geo":
		case "comp":
			if (GL_W.isGLES()) {
				GameEngineUtils.throwGLESError("Cannot load Compute/Geometry shader using GLES");
			}
			return GL_W.GL_COMPUTE_SHADER;
		}
		GameEngineUtils.throwGLESError("Unknown shader type: " + type);
		return -1;
	}

}
