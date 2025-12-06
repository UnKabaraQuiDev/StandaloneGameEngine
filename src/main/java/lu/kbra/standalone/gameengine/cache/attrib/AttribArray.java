package lu.kbra.standalone.gameengine.cache.attrib;

import org.joml.Vector2f;
import org.joml.Vector3f;
import org.joml.Vector3i;
import org.joml.Vector4f;
import org.joml.Vector4i;

import lu.pcy113.pclib.PCUtils;
import lu.pcy113.pclib.logger.GlobalLogger;

import lu.kbra.standalone.gameengine.generated.gl_wrapper.GL_W;
import lu.kbra.standalone.gameengine.impl.Cleanupable;
import lu.kbra.standalone.gameengine.impl.GLObject;
import lu.kbra.standalone.gameengine.utils.GameEngineUtils;
import lu.kbra.standalone.gameengine.utils.gl.consts.BufferType;

public abstract class AttribArray implements Cleanupable, GLObject {

	protected int bid = -1;
	protected boolean iStatic = true;;
	protected BufferType bufferType;
	protected String name = null;
	protected int index = -1;
	protected final int dataSize, divisor;

	public AttribArray(String name, int index, int dataSize) {
		this(name, index, dataSize, BufferType.ARRAY, true);
	}

	public AttribArray(String name, int index, int dataSize, BufferType bufferType) {
		this(name, index, dataSize, bufferType, true);
	}

	public AttribArray(String name, int index, int dataSize, boolean iStatic) {
		this(name, index, dataSize, BufferType.ARRAY, iStatic);
	}

	public AttribArray(String name, int index, int dataSize, int divisor) {
		this(name, index, dataSize, BufferType.ARRAY, false, divisor);
	}

	public AttribArray(String name, int index, int dataSize, boolean iStatic, int divisor) {
		this(name, index, dataSize, BufferType.ARRAY, iStatic, divisor);
	}

	public AttribArray(String name, int index, int dataSize, BufferType bufferType, boolean iStatic) {
		this(name, index, dataSize, bufferType, iStatic, 0);
	}

	public AttribArray(String name, int index, int dataSize, BufferType bufferType, int _divisor) {
		this(name, index, dataSize, bufferType, false, _divisor);
	}

	public AttribArray(String name, int index, int dataSize, BufferType bufferType, boolean iStatic, int divisor) {
		this.name = name;
		this.index = index;
		this.dataSize = dataSize;
		this.bufferType = bufferType;
		this.iStatic = iStatic;
		this.divisor = divisor;
	}

	public int getDataCount() {
		return getLength() / getDataSize();
	}

	public abstract int getLength();

	public abstract void init();

	public abstract Object get(int i);

	public abstract boolean isLoaded();

	public abstract Object getData();

	public abstract void update();

	public void enable() {
		bind();

		GL_W.glEnableVertexAttribArray(index);
		GL_W.glVertexAttribDivisor(index, divisor);
	}

	public void disable() {
		bind();

		GL_W.glDisableVertexAttribArray(index);
	}

	public int gen() {
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
		GlobalLogger.log("Cleaning up: " + name + " (" + index + "=" + bid + ")");

		if (bid == -1)
			return;

		GL_W.glDeleteBuffers(bid);
		bid = -1;
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

	public int getDataSize() {
		return dataSize;
	}

	public boolean isiStatic() {
		return iStatic;
	}

	public void setiStatic(boolean iStatic) {
		this.iStatic = iStatic;
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

	@Override
	public String getId() {
		return name + "#" + bid + "@" + PCUtils.toSimpleIdentityString(this);
	}

	@Override
	public String toString() {
		return getGlId() + "|" + getIndex() + ") " + getName() + ": " + getLength() + "/" + getDataSize() + "="
				+ getDataCount();
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

	public static void resize(AttribArray arr, Object data) {
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
