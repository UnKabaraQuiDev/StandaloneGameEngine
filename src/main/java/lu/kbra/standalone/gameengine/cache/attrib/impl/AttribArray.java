package lu.kbra.standalone.gameengine.cache.attrib.impl;

import org.joml.Vector2f;
import org.joml.Vector3f;
import org.joml.Vector3i;
import org.joml.Vector4f;
import org.joml.Vector4i;

import lu.kbra.pclib.PCUtils;
import lu.kbra.pclib.logger.GlobalLogger;
import lu.kbra.standalone.gameengine.cache.attrib.FloatAttribArray;
import lu.kbra.standalone.gameengine.cache.attrib.IntAttribArray;
import lu.kbra.standalone.gameengine.cache.attrib.Mat3x2fAttribArray;
import lu.kbra.standalone.gameengine.cache.attrib.Mat4fAttribArray;
import lu.kbra.standalone.gameengine.cache.attrib.UByteAttribArray;
import lu.kbra.standalone.gameengine.cache.attrib.UIntAttribArray;
import lu.kbra.standalone.gameengine.cache.attrib.Vec2fAttribArray;
import lu.kbra.standalone.gameengine.cache.attrib.Vec3fAttribArray;
import lu.kbra.standalone.gameengine.cache.attrib.Vec3iAttribArray;
import lu.kbra.standalone.gameengine.cache.attrib.Vec4fAttribArray;
import lu.kbra.standalone.gameengine.cache.attrib.Vec4iAttribArray;
import lu.kbra.standalone.gameengine.cache.attrib.types.JavaTypeAttribArray;
import lu.kbra.standalone.gameengine.generated.gl_wrapper.GL_W;
import lu.kbra.standalone.gameengine.impl.AutoCleanupable;
import lu.kbra.standalone.gameengine.impl.Cleanupable;
import lu.kbra.standalone.gameengine.impl.GLObject;
import lu.kbra.standalone.gameengine.utils.GameEngineUtils;
import lu.kbra.standalone.gameengine.utils.gl.consts.BufferType;

/**
 * element = raw type (float, int, ...)<br>
 * component = vectors/matrices number of elements
 */
public abstract class AttribArray extends AutoCleanupable implements Cleanupable, GLObject, JavaTypeAttribArray {

	public static final String GEN_FAIL_IF_EXISTS_PROPERTY = AttribArray.class.getSimpleName() + ".gen_fail_if_exists";
	public static final String GEN_SKIP_IF_EXISTS_PROPERTY = AttribArray.class.getSimpleName() + ".gen_skip_if_exists";
	public static final String GEN_LOG_IF_EXISTS_PROPERTY = AttribArray.class.getSimpleName() + ".gen_log_if_exists";
	public static boolean GEN_FAIL_IF_EXISTS = PCUtils.getBoolean(GEN_FAIL_IF_EXISTS_PROPERTY, true);
	public static boolean GEN_SKIP_IF_EXISTS = PCUtils.getBoolean(GEN_SKIP_IF_EXISTS_PROPERTY, false);
	public static boolean GEN_LOG_IF_EXISTS = PCUtils.getBoolean(GEN_LOG_IF_EXISTS_PROPERTY, false);

	protected int bid = -1;
	protected boolean iStatic = true;;
	protected BufferType bufferType;
	protected String name = null;
	protected int index = -1;
	protected final int divisor;
	protected int length = -1;

	public AttribArray(String name, int index) {
		this(name, index, BufferType.ARRAY, true);
	}

	public AttribArray(String name, int index, BufferType bufferType) {
		this(name, index, bufferType, true);
	}

	public AttribArray(String name, int index, boolean iStatic) {
		this(name, index, BufferType.ARRAY, iStatic);
	}

	public AttribArray(String name, int index, int divisor) {
		this(name, index, BufferType.ARRAY, false, divisor);
	}

	public AttribArray(String name, int index, boolean iStatic, int divisor) {
		this(name, index, BufferType.ARRAY, iStatic, divisor);
	}

	public AttribArray(String name, int index, BufferType bufferType, boolean iStatic) {
		this(name, index, bufferType, iStatic, 0);
	}

	public AttribArray(String name, int index, BufferType bufferType, int _divisor) {
		this(name, index, bufferType, false, _divisor);
	}

	public AttribArray(String name, int index, BufferType bufferType, boolean iStatic, int divisor) {
		this.name = name;
		this.index = index;
		this.bufferType = bufferType;
		this.iStatic = iStatic;
		this.divisor = divisor;
	}

	public abstract void init();

	public AttribArray genInit() {
		gen();
		init();
		return this;
	}

	public abstract Object get(int i);

	public abstract boolean isLoaded();

	public abstract Object getData();

	public abstract Object toFlatArray();

	public abstract void update();

	public int getElementCount() {
		return length;
	}

	@Override
	public int getTotalByteSize() {
		return getElementByteSize() * getElementCount();
	}

	@Override
	public int getTotalComponentCount() {
		return getElementComponentCount() * getElementCount();
	}

	public boolean isVertexArray() {
		return bufferType == BufferType.ARRAY;
	}

	public void enable() {
		bind();

		if (isVertexArray()) {
			GL_W.glEnableVertexAttribArray(index);
			GL_W.glVertexAttribDivisor(index, divisor);
		}
	}

	public void disable() {
		bind();

		if (isVertexArray()) {
			GL_W.glDisableVertexAttribArray(index);
		}
	}

	public int gen() {
		if (bid != -1 && GEN_FAIL_IF_EXISTS) {
			throw new IllegalStateException("Attrib array already initialized. (" + bid + ")");
		}
		if (bid != -1 && GEN_SKIP_IF_EXISTS) {
			return bid;
		}
		if (bid != -1 && GEN_LOG_IF_EXISTS) {
			GlobalLogger.severe("Attrib array already initilized. (" + bid + ")");
		}
		bid = GL_W.glGenBuffers();
		return bid;
	}

	public void bind() {
		GL_W.glBindBuffer(bufferType.getGlId(), bid);
	}

	public void unbind() {
		GL_W.glBindBuffer(bufferType.getGlId(), 0);
	}

	@Override
	public void cleanup() {
		if (bid == -1) {
			return;
		}

		GlobalLogger.log("Cleaning up: " + name + " (" + index + "=" + bid + ")");

		GL_W.glDeleteBuffers(bid);
		bid = -1;
		super.cleanup();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public BufferType getBufferType() {
		return bufferType;
	}

	public void setBufferType(BufferType bufferType) {
		this.bufferType = bufferType;
	}

	@Override
	public int getGlId() {
		return bid;
	}

	public boolean isStatic() {
		return iStatic;
	}

	public int getDivisor() {
		return divisor;
	}

	@Override
	public boolean isValid() {
		return bid != -1;
	}

	public int getLength() {
		return length;
	}

	@Override
	public String getId() {
		return name + "#" + bid + "@" + PCUtils.toSimpleIdentityString(this);
	}

	@Override
	public String toString() {
		return getGlId() + "|" + getIndex() + ") " + getName() + ": " + getLength() + " * " + getComponentByteSize() + "B = "
				+ getTotalByteSize() + "B";
	}

	public static void update(AttribArray arr, Object data) {
		if (arr == null) {
			GlobalLogger.log();
			throw new NullPointerException("AttribArray is null !");
		}

		arr.bind();

		if (arr instanceof IntAttribArray intArr) {
			intArr.update(PCUtils.toPrimitiveInt(data));
		} else if (arr instanceof UIntAttribArray uintArr) {
			uintArr.update(PCUtils.toPrimitiveInt(data));
		} else if (arr instanceof UByteAttribArray ubyteArr) {
			ubyteArr.update(PCUtils.toPrimitiveByte(data));

		} else if (arr instanceof FloatAttribArray floatArr) {
			floatArr.update(PCUtils.toPrimitiveFloat(data));

		} else if (arr instanceof Vec2fAttribArray vec2fArr) {
			vec2fArr.update((Vector2f[]) data);
		} else if (arr instanceof Vec3fAttribArray vec3fArr) {
			vec3fArr.update((Vector3f[]) data);
		} else if (arr instanceof Vec4fAttribArray vec4fArr) {
			vec4fArr.update((Vector4f[]) data);

		} else if (arr instanceof Vec3iAttribArray vec3iArr) {
			vec3iArr.update((Vector3i[]) data);
		} else if (arr instanceof Vec4iAttribArray vec4iArr) {
			vec4iArr.update((Vector4i[]) data);

		} else if (arr instanceof Mat3x2fAttribArray mat3x2fArr) {
			mat3x2fArr.update(GameEngineUtils.castArrayMat3x2f(data));
		} else if (arr instanceof Mat4fAttribArray mat4fArr) {
			mat4fArr.update(GameEngineUtils.castArrayMat4f(data));
		} else {
			PCUtils.throwUnsupported(arr.getClass().toString());
		}
	}

	public static void resize(JavaTypeAttribArray arr, Object data) {
		if (arr == null) {
			GlobalLogger.log();
			throw new NullPointerException("AttribArray is null !");
		}
		if (arr instanceof IntAttribArray intArr) {
			intArr.resize(PCUtils.toPrimitiveInt(data));
		} else if (arr instanceof UIntAttribArray uintArr) {
			uintArr.resize(PCUtils.toPrimitiveInt(data));
		} else if (arr instanceof UByteAttribArray ubyteArr) {
			ubyteArr.resize(PCUtils.toPrimitiveByte(data));

		} else if (arr instanceof FloatAttribArray floatArr) {
			floatArr.resize(PCUtils.toPrimitiveFloat(data));

		} else if (arr instanceof Vec2fAttribArray vec2fArr) {
			vec2fArr.resize((Vector2f[]) data);
		} else if (arr instanceof Vec3fAttribArray vec3fArr) {
			vec3fArr.resize((Vector3f[]) data);
		} else if (arr instanceof Vec4fAttribArray vec4fArr) {
			vec4fArr.resize((Vector4f[]) data);

		} else if (arr instanceof Vec3iAttribArray vec3iArr) {
			vec3iArr.resize((Vector3i[]) data);
		} else if (arr instanceof Vec4iAttribArray vec4iArr) {
			vec4iArr.resize((Vector4i[]) data);

		} else if (arr instanceof Mat3x2fAttribArray mat3x2fArr) {
			mat3x2fArr.resize(GameEngineUtils.castArrayMat3x2f(data));
		} else if (arr instanceof Mat4fAttribArray mat4fArr) {
			mat4fArr.resize(GameEngineUtils.castArrayMat4f(data));
		} else {
			PCUtils.throwUnsupported(arr.getClass().toString());
		}
	}

}
