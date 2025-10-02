package lu.kbra.standalone.gameengine.graph.shader.part;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;

import org.joml.Matrix3f;
import org.joml.Matrix3x2f;
import org.joml.Matrix4f;
import org.joml.Vector2f;
import org.joml.Vector2i;
import org.joml.Vector3f;
import org.joml.Vector3i;
import org.joml.Vector4f;
import org.lwjgl.system.MemoryStack;

import lu.pcy113.pclib.datastructure.pair.Pair;
import lu.pcy113.pclib.logger.GlobalLogger;

import lu.kbra.standalone.gameengine.impl.Cleanupable;
import lu.kbra.standalone.gameengine.impl.UniqueID;
import lu.kbra.standalone.gameengine.utils.GameEngineUtils;
import lu.kbra.standalone.gameengine.utils.Property;
import lu.kbra.standalone.gameengine.utils.gl.wrapper.GL_W;

public abstract class AbstractShader implements UniqueID, Cleanupable {

	protected final String name;
	protected int spid = -1;
	protected Map<Integer, AbstractShaderPart> parts;
	protected Map<String, Pair<Property<Object>, Integer>> uniforms;

	public AbstractShader(String name_, AbstractShaderPart... parts) {
		this.name = name_ == null ? this.getClass().getName() : name_;

		this.spid = GL_W.glCreateProgram();
		GL_W.checkError("CreateProgram() (" + name + ")");
		if (this.spid == -1) {
			GameEngineUtils.throwGLError(name + ": Failed to create shader program!");
		}
		this.parts = new HashMap<>();
		for (AbstractShaderPart sp : parts) {
			this.parts.put(sp.getType(), sp);
			GL_W.glAttachShader(this.spid, sp.getSid());
			GL_W.checkError("AttachShader(" + this.spid + ")");
		}
		GL_W.glLinkProgram(this.spid);
		GL_W.checkError("LinkProgram(" + this.spid + ")");

		final int logLen = GL_W.glGetProgrami(this.spid, GL_W.GL_INFO_LOG_LENGTH);
		if (logLen > 1) {
			final String log = GL_W.glGetProgramInfoLog_String(this.spid, logLen);
			GlobalLogger.severe("Link log:\n" + log);
		}

		if (GL_W.glGetProgrami(this.spid, GL_W.GL_LINK_STATUS) == GL_W.GL_FALSE) {
			GlobalLogger.log(Level.SEVERE, name + "(" + spid + "): " + GL_W.glGetProgramInfoLog_String(this.spid, 1024));
			this.cleanup();
			throw new IllegalStateException(name + "(" + spid + "): Failed to link shader program!");
		} else if (!GL_W.glIsProgram(spid)) {
			this.cleanup();
			throw new IllegalStateException(name + "(" + spid + "): Is not a GL Shader Program!");
		} else {
			GlobalLogger.log(Level.INFO, "ShaderProgram " + name + " (" + spid + ") created successfully");
		}

		this.bind();
		this.uniforms = new HashMap<>();

		this.createUniforms();
		this.unbind();
	}

	public boolean recompile() {
		for (AbstractShaderPart part : parts.values()) {
			if (!part.recompile())
				return false;
		}
		GL_W.glLinkProgram(this.spid);
		GL_W.checkError("LinkProgram(" + this.spid + ")");
		return true;
	}

	public abstract void createUniforms();

	public void setUniform(String key, Object value) {
		if (!uniforms.containsKey(key)) {
			return;
		}

		final Pair<Property<Object>, Integer> unif = uniforms.get(key);
		if (unif == null) {
			return;
		}
		final Property<Object> prop = unif.hasKey() ? unif.getKey() : new Property<Object>();
		prop.setValue(value);
		if (!prop.isChanged()) {
			return;
		}

		if (value instanceof Integer) {
			GL_W.glUniform1i(unif.getValue(), (int) value);
		} else if (value instanceof Float) {
			GL_W.glUniform1f(unif.getValue(), (float) value);
		} else if (value instanceof Matrix4f) {
			try (MemoryStack stack = MemoryStack.stackPush()) {
				GL_W.glUniformMatrix4fv(unif.getValue(), false, ((Matrix4f) value).get(stack.mallocFloat(16)));
			}
		} else if (value instanceof Vector3f) {
			GL_W.glUniform3f(unif.getValue(), ((Vector3f) value).x, ((Vector3f) value).y, ((Vector3f) value).z);
		} else if (value instanceof Vector3i) {
			GL_W.glUniform3i(unif.getValue(), ((Vector3i) value).x, ((Vector3i) value).y, ((Vector3i) value).z);
		} else if (value instanceof Vector4f) {
			GL_W.glUniform4f(unif.getValue(), ((Vector4f) value).x, ((Vector4f) value).y, ((Vector4f) value).z, ((Vector4f) value).w);
		} else if (value instanceof Double) {
			GameEngineUtils.throwGLESError("Cannot set Double uniform");
			// GL_W.glUniform1d(unif.getValue(), (double) value);
		} else if (value instanceof Character) {
			// System.out.println("is char: " + value + " > " + ((char) value) + " > " +
			// (Integer.valueOf((char) value)));
			assert value instanceof Character : "Trying to set char uniform";
			this.setUniform(key, Integer.valueOf((char) value));
		} else if (value instanceof Vector2f) {
			GL_W.glUniform2f(unif.getValue(), ((Vector2f) value).x, ((Vector2f) value).y);
		} else if (value instanceof Vector2i) {
			GL_W.glUniform2i(unif.getValue(), ((Vector2i) value).x, ((Vector2i) value).y);
		} else if (value instanceof Matrix3f) {
			try (MemoryStack stack = MemoryStack.stackPush()) {
				GL_W.glUniformMatrix3fv(unif.getValue(), false, ((Matrix3f) value).get(stack.mallocFloat(9)));
			}
		} else if (value instanceof Matrix3x2f) {
			try (MemoryStack stack = MemoryStack.stackPush()) {
				GL_W.glUniformMatrix3x2fv(unif.getValue(), false, ((Matrix3x2f) value).get(stack.mallocFloat(6)));
			}
		} else if (value instanceof Boolean) {
			GL_W.glUniform1i(unif.getValue(), (boolean) value ? 1 : 0);
		}
	}

	public int getUniformLocation(String name) {
		if (!this.hasUniform(name) && !this.createUniform(name)) {
			return -1;
		}

		return this.uniforms.get(name).getValue();
	}

	public boolean hasUniform(String name) {
		return this.uniforms.containsKey(name);
	}

	public boolean createUniform(String name) {
		final int loc = GL_W.glGetUniformLocation(this.spid, name);
		GL_W.checkError("GetUniformLocation(" + this.spid + ", " + name + ")");

		if (loc != -1) {
			this.uniforms.put(name, new Pair<>(new Property<>(), loc));
			return true;
		} else {
			GlobalLogger
					.log(Level.WARNING,
							"Could not get Uniform location for: " + name + " in program " + this.name + " (" + this.spid + ") ("
									+ GL_W.glGetError() + ")");
		}

		return false;
	}

	public void bind() {
		if (this.spid == -1) {
			GlobalLogger.warning("Shader program is invalid (" + name + ").");
			return;
		}
		GL_W.glUseProgram(this.spid);
		GL_W.checkError("UseProgram(" + spid + ") (" + name + ").");
	}

	public void unbind() {
		GL_W.glUseProgram(0);
		GL_W.checkError("UseProgram(0) (" + name + ").");
	}

	@Override
	public void cleanup() {
		GlobalLogger.log();
		GlobalLogger.warning("Cleaning up: " + name);

		if (this.spid == -1)
			return;

		this.parts.values().forEach(AbstractShaderPart::cleanup);
		this.parts = null;
		GL_W.glDeleteProgram(this.spid);
		GL_W.checkError("DeleteProgram(" + spid + ") (" + name + ")");
		this.spid = -1;
	}

	@Override
	public String getId() {
		return this.name;
	}

	public int getSpid() {
		return spid;
	}

	public Map<Integer, AbstractShaderPart> getParts() {
		return this.parts;
	}

	public Map<String, Pair<Property<Object>, Integer>> getUniforms() {
		return uniforms;
	}

}
