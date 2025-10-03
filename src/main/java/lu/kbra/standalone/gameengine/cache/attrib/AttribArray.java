package lu.kbra.standalone.gameengine.cache.attrib;

import org.joml.Vector3f;
import org.joml.Vector4f;

import lu.pcy113.pclib.PCUtils;
import lu.pcy113.pclib.logger.GlobalLogger;

import lu.kbra.standalone.gameengine.impl.Cleanupable;
import lu.kbra.standalone.gameengine.utils.GameEngineUtils;
import lu.kbra.standalone.gameengine.utils.gl.consts.BufferType;
import lu.kbra.standalone.gameengine.utils.gl.wrapper.GL_W;

public abstract class AttribArray implements Cleanupable {

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

	public void enable() {
		GL_W.glEnableVertexAttribArray(index);
		assert GL_W.checkError("EnableVertexAttribArray(" + index + ") (" + name + ")");
		GL_W.glVertexAttribDivisor(index, divisor);
		assert GL_W.checkError("VertexAttribDivisor(" + index + ", " + divisor + ") (" + name + ")");
	}

	public void disable() {
		GL_W.glDisableVertexAttribArray(index);
		assert GL_W.checkError("DisableVertexAttribArray(" + index + ") (" + name + ")");
	}

	public int gen() {
		bid = GL_W.glGenBuffers();
		assert GL_W.checkError("GenBuffers() (" + name + ")");
		return bid;
	}

	public void bind() {
		GL_W.glBindBuffer(bufferType.getGlId(), bid);
		assert GL_W.checkError("BindBuffer(" + bufferType + ", " + bid + ") (" + name + ")");
	}

	public void unbind() {
		GL_W.glBindBuffer(bufferType.getGlId(), 0);
		assert GL_W.checkError("BindBuffer(" + bufferType + ", 0) (" + name + ")");
	}

	@Override
	public void cleanup() {
		GlobalLogger.log("Cleaning up: " + name + " (" + index + "=" + bid + ")");

		if (bid == -1)
			return;

		GL_W.glDeleteBuffers(bid);
		assert GL_W.checkError("DeleteBuffers(" + bid + ") (" + name + ")");
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

	public int getBid() {
		return bid;
	}

	public boolean isStatic() {
		return iStatic;
	}

	public int getDivisor() {
		return divisor;
	}

	@Override
	public String toString() {
		return getBid() + "|" + getIndex() + ") " + getName() + ": " + getLength() + "/" + getDataSize() + "=" + getDataCount();
	}

	public static <T> boolean update(AttribArray arr, T[] data) {
		if (arr == null) {
			GlobalLogger.log();
			GlobalLogger.warning("AttribArray is null!");
			return false;
		}

		arr.bind();

		if (arr instanceof IntAttribArray)
			return ((IntAttribArray) arr).update(PCUtils.toPrimitiveInt(data));
		else if (arr instanceof UIntAttribArray)
			return ((UIntAttribArray) arr).update(PCUtils.toPrimitiveInt(data));
		else if (arr instanceof FloatAttribArray)
			return ((FloatAttribArray) arr).update(PCUtils.toPrimitiveFloat(data));
		else if (arr instanceof Mat4fAttribArray)
			return ((Mat4fAttribArray) arr).update(GameEngineUtils.castArrayMat4f(data));
		else if (arr instanceof Vec4fAttribArray)
			return ((Vec4fAttribArray) arr).update((Vector4f[]) data);
		else if (arr instanceof Vec3fAttribArray)
			return ((Vec3fAttribArray) arr).update((Vector3f[]) data);
		else if (arr instanceof Mat3x2fAttribArray)
			return ((Mat3x2fAttribArray) arr).update(GameEngineUtils.castArrayMat3x2f(data));
		return false;
	}

}
