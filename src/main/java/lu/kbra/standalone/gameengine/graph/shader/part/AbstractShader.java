package lu.kbra.standalone.gameengine.graph.shader.part;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.logging.Level;

import org.joml.Matrix3fc;
import org.joml.Matrix3x2fc;
import org.joml.Matrix4fc;
import org.joml.Vector2f;
import org.joml.Vector2fc;
import org.joml.Vector2i;
import org.joml.Vector2ic;
import org.joml.Vector3f;
import org.joml.Vector3fc;
import org.joml.Vector3i;
import org.joml.Vector3ic;
import org.joml.Vector4f;
import org.joml.Vector4fc;
import org.joml.Vector4i;
import org.joml.Vector4ic;
import org.lwjgl.system.MemoryStack;

import lu.kbra.pclib.PCUtils;
import lu.kbra.pclib.datastructure.pair.Pair;
import lu.kbra.pclib.logger.GlobalLogger;
import lu.kbra.standalone.gameengine.generated.gl_wrapper.GL_W;
import lu.kbra.standalone.gameengine.impl.AutoCleanupable;
import lu.kbra.standalone.gameengine.impl.Cleanupable;
import lu.kbra.standalone.gameengine.impl.GLObject;
import lu.kbra.standalone.gameengine.impl.UniqueID;
import lu.kbra.standalone.gameengine.utils.GameEngineUtils;
import lu.kbra.standalone.gameengine.utils.Property;

public abstract class AbstractShader extends AutoCleanupable implements UniqueID, Cleanupable, GLObject {

	public static final String DEBUG_PROPERTY = AbstractShader.class.getSimpleName() + ".debug";
	public static boolean DEBUG = Boolean.getBoolean(DEBUG_PROPERTY);

	protected final String name;
	protected int spid = -1;
	protected Map<Integer, AbstractShaderPart> parts;
	// TODO: Remove properties
	protected Map<String, Pair<Property<Object>, Integer>> uniforms = new HashMap<>();
	protected List<String> knownNotExistsUniforms = new ArrayList<>();

	public AbstractShader(String name_, AbstractShaderPart... parts) {
		this.name = name_ == null ? this.getClass().getName() : name_;

		this.spid = GL_W.glCreateProgram();
		if (this.spid == -1) {
			GameEngineUtils.throwGLError(name + ": Failed to create shader program!");
		}
		this.parts = new HashMap<>();
		for (AbstractShaderPart sp : parts) {
			this.parts.put(sp.getType(), sp);
			GL_W.glAttachShader(this.spid, sp.getGlId());
		}
		GL_W.glLinkProgram(this.spid);

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
		this.createUniforms();
		this.unbind();
	}

	public boolean recompile() {
		for (AbstractShaderPart part : parts.values()) {
			if (!part.recompile())
				return false;
		}
		GL_W.glLinkProgram(this.spid);

		knownNotExistsUniforms.clear();
		uniforms.clear();

		return true;
	}

	public abstract void createUniforms();

	public void setUniform(String key, Object value) {
		if (getUniformLocation(key) == -1) {
			return;
		}

		if (DEBUG) {
			GlobalLogger.info("[" + name + "] " + key + " = " + value);
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

		final int unifLoc = unif.getValue();

		storeUniform(unifLoc, value, key);
	}

	private void storeUniform(int unifLoc, Object value, String key) {
		if (value instanceof Float val) {
			GL_W.glUniform1f(unifLoc, val);
		} else if (value instanceof Vector2fc val) {
			GL_W.glUniform2f(unifLoc, val.x(), val.y());
		} else if (value instanceof Vector3fc val) {
			GL_W.glUniform3f(unifLoc, val.x(), val.y(), val.z());
		} else if (value instanceof Vector4fc val) {
			GL_W.glUniform4f(unifLoc, val.x(), val.y(), val.z(), val.w());
		} else if (value instanceof Vector2fc[] val) {
			GL_W.glUniform2fv(unifLoc, GameEngineUtils.toFlatArray(val));
		} else if (value instanceof Vector3fc[] val) {
			GL_W.glUniform3fv(unifLoc, GameEngineUtils.toFlatArray(val));
		} else if (value instanceof Vector4fc[] val) {
			GL_W.glUniform4fv(unifLoc, GameEngineUtils.toFlatArray(val));
		} else if (value instanceof Vector2f[] val) {
			GL_W.glUniform2fv(unifLoc, GameEngineUtils.toFlatArray(val));
		} else if (value instanceof Vector3f[] val) {
			GL_W.glUniform3fv(unifLoc, GameEngineUtils.toFlatArray(val));
		} else if (value instanceof Vector4f[] val) {
			GL_W.glUniform4fv(unifLoc, GameEngineUtils.toFlatArray(val));
		} else if (value instanceof Integer val) {
			GL_W.glUniform1i(unifLoc, val);
		} else if (value instanceof Vector2ic val) {
			GL_W.glUniform2i(unifLoc, val.x(), val.y());
		} else if (value instanceof Vector3ic val) {
			GL_W.glUniform3i(unifLoc, val.x(), val.y(), val.z());
		} else if (value instanceof Vector4ic val) {
			GL_W.glUniform4i(unifLoc, val.x(), val.y(), val.z(), val.w());
		} else if (value instanceof Vector2ic[] val) {
			GL_W.glUniform2iv(unifLoc, GameEngineUtils.toFlatArray(val));
		} else if (value instanceof Vector3ic[] val) {
			GL_W.glUniform3iv(unifLoc, GameEngineUtils.toFlatArray(val));
		} else if (value instanceof Vector4ic[] val) {
			GL_W.glUniform4iv(unifLoc, GameEngineUtils.toFlatArray(val));
		} else if (value instanceof Vector2i[] val) {
			GL_W.glUniform2iv(unifLoc, GameEngineUtils.toFlatArray(val));
		} else if (value instanceof Vector3i[] val) {
			GL_W.glUniform3iv(unifLoc, GameEngineUtils.toFlatArray(val));
		} else if (value instanceof Vector4i[] val) {
			GL_W.glUniform4iv(unifLoc, GameEngineUtils.toFlatArray(val));
		} else if (value instanceof Matrix4fc val) {
			try (MemoryStack stack = MemoryStack.stackPush()) {
				GL_W.glUniformMatrix4fv(unifLoc, false, val.get(stack.mallocFloat(16)));
			}
		} else if (value instanceof Matrix3fc val) {
			try (MemoryStack stack = MemoryStack.stackPush()) {
				GL_W.glUniformMatrix3fv(unifLoc, false, val.get(stack.mallocFloat(9)));
			}
		} else if (value instanceof Matrix3x2fc val) {
			try (MemoryStack stack = MemoryStack.stackPush()) {
				GL_W.glUniformMatrix3x2fv(unifLoc, false, val.get(stack.mallocFloat(6)));
			}
		} else if (value instanceof Boolean val) {
			GL_W.glUniform1i(unifLoc, val ? 1 : 0);
		} else if (value instanceof int[] ints) {
			GL_W.glUniform1iv(unifLoc, ints);
		} else if (value instanceof Integer[] ints) {
			GL_W.glUniform1iv(unifLoc, PCUtils.toPrimitiveInt(ints));
		} else if (value instanceof float[] floats) {
			GL_W.glUniform1fv(unifLoc, floats);
		} else if (value instanceof Float[] floats) {
			GL_W.glUniform1fv(unifLoc, PCUtils.toPrimitiveFloat(floats));
		} else if (value instanceof Double val) {
			throw new UnsupportedOperationException("Double not supported.");
		} else if (value instanceof Character val) {
			throw new UnsupportedOperationException("Character not supported.");
		} else {
			throw new UnsupportedOperationException(value.getClass().getName() + " not supported.");
		}
	}

	public void setUniformUnsigned(String key, Object value) {
		if (getUniformLocation(key) == -1) {
			return;
		}

		if (DEBUG) {
			GlobalLogger.info("[" + name + "] (u) " + key + " = " + value);
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

		final int unifLoc = unif.getValue();

		storeUniformUnsigned(unifLoc, value, key);
	}

	private void storeUniformUnsigned(int unifLoc, Object value, String key) {
		if (value instanceof Integer val) {
			GL_W.glUniform1ui(unifLoc, val);
		} else if (value instanceof Vector2ic val) {
			GL_W.glUniform2ui(unifLoc, val.x(), val.y());
		} else if (value instanceof Vector3ic val) {
			GL_W.glUniform3ui(unifLoc, val.x(), val.y(), val.z());
		} else if (value instanceof Vector4ic val) {
			GL_W.glUniform4ui(unifLoc, val.x(), val.y(), val.z(), val.w());
		} else if (value instanceof Vector2ic[] val) {
			GL_W.glUniform2uiv(unifLoc, GameEngineUtils.toFlatArray(val));
		} else if (value instanceof Vector3ic[] val) {
			GL_W.glUniform3uiv(unifLoc, GameEngineUtils.toFlatArray(val));
		} else if (value instanceof Vector4ic[] val) {
			GL_W.glUniform4uiv(unifLoc, GameEngineUtils.toFlatArray(val));
		} else if (value instanceof Vector2i[] val) {
			GL_W.glUniform2uiv(unifLoc, GameEngineUtils.toFlatArray(val));
		} else if (value instanceof Vector3i[] val) {
			GL_W.glUniform3uiv(unifLoc, GameEngineUtils.toFlatArray(val));
		} else if (value instanceof Vector4i[] val) {
			GL_W.glUniform4uiv(unifLoc, GameEngineUtils.toFlatArray(val));
		} else if (value instanceof Boolean val) {
			GL_W.glUniform1ui(unifLoc, val ? 1 : 0);
		} else {
			throw new UnsupportedOperationException(value.getClass().getName() + " not supported.");
		}
	}

	public void storeUniform(int unifLoc, Object value) {
		this.storeUniform(unifLoc, value, null);
	}

	public void storeUniformUnsigned(int unifLoc, Object value) {
		this.storeUniformUnsigned(unifLoc, value, null);
	}

	public void storeUniform(int unifLoc, Object value, boolean signed) {
		if (signed) {
			storeUniform(unifLoc, value);
		} else {
			storeUniformUnsigned(unifLoc, value);
		}
	}

	public void setUniform(String key, Object value, boolean signed) {
		if (signed) {
			setUniform(key, value);
		} else {
			setUniformUnsigned(key, value);
		}
	}

	public int getUniformLocation(String name) {
		if (!this.createUniform(name)) {
			return -1;
		}

		return this.uniforms.get(name).getValue();
	}

	public boolean hasUniform(String name) {
		return this.uniforms.containsKey(name);
	}

	public boolean createUniform(String name) {
		if (knownNotExistsUniforms.contains(name)) {
			return false;
		}

		if (uniforms.containsKey(name)) {
			return true;
		}

		Objects.requireNonNull(name, "Name cannot be null.");

		final int loc = GL_W.glGetUniformLocation(this.spid, name);

		if (loc != -1) {
			this.uniforms.put(name, new Pair<>(new Property<>(), loc));
			return true;
		} else {
			GlobalLogger.log(Level.WARNING,
					"Could not get Uniform location for: " + name + " in program " + this.name + " (" + this.spid + ") ("
							+ GL_W.glGetError() + ")");
			knownNotExistsUniforms.add(name);
			return false;
		}
	}

	public void bind() {
		if (this.spid == -1) {
			GlobalLogger.warning("Shader program is invalid (" + name + ").");
			return;
		}
		GL_W.glUseProgram(this.spid);
	}

	public void unbind() {
		GL_W.glUseProgram(0);
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
		this.spid = -1;
		
		super.cleanup();
	}

	@Override
	public String getId() {
		return this.name;
	}

	@Override
	public int getGlId() {
		return spid;
	}

	@Override
	public boolean isValid() {
		return spid != -1;
	}

	public Map<Integer, AbstractShaderPart> getParts() {
		return this.parts;
	}

	public Map<String, Pair<Property<Object>, Integer>> getUniforms() {
		return uniforms;
	}

}
