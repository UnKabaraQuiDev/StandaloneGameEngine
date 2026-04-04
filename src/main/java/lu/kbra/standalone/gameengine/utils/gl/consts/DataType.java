package lu.kbra.standalone.gameengine.utils.gl.consts;

import lu.kbra.standalone.gameengine.generated.gl_wrapper.GL_W;
import lu.kbra.standalone.gameengine.utils.mem.img.MemImageFormat;

public enum DataType implements GLConstant {

	// Base type
	BYTE(GL_W.GL_BYTE, null),
	SHORT(GL_W.GL_SHORT, null),
	INT(GL_W.GL_INT, null),
	HALF_FLOAT(GL_W.GL_HALF_FLOAT, null),
	FLOAT(GL_W.GL_FLOAT, null),

	// Unsigned base types
	UBYTE(GL_W.GL_UNSIGNED_BYTE, BYTE),
	USHORT(GL_W.GL_UNSIGNED_SHORT, SHORT),
	UINT(GL_W.GL_UNSIGNED_INT, INT),

	USHORT565(GL_W.GL_UNSIGNED_SHORT_5_6_5, USHORT),
	USHORT4444(GL_W.GL_UNSIGNED_SHORT_4_4_4_4, USHORT),
	USHORT5551(GL_W.GL_UNSIGNED_SHORT_5_5_5_1, USHORT),
	UINT2101010REV(GL_W.GL_UNSIGNED_INT_2_10_10_10_REV, UINT),
	UINT248(GL_W.GL_UNSIGNED_INT_24_8, UINT),
	UINT10F11F11FREV(GL_W.GL_UNSIGNED_INT_10F_11F_11F_REV, UINT),
	UINT5999REV(GL_W.GL_UNSIGNED_INT_5_9_9_9_REV, UINT),

	FLOAT32UINT248REV(GL_W.GL_FLOAT_32_UNSIGNED_INT_24_8_REV, null);

	private int glId;
	private DataType base;

	DataType(int glId, DataType base) {
		this.glId = glId;
	}

	@Override
	public int getGlId() {
		return glId;
	}

	public DataType getBase() {
		return base;
	}

	public boolean isBase() {
		return base == null;
	}

	public boolean isInteger() {
		return switch (this) {
		case BYTE, UBYTE, SHORT, INT, USHORT, UINT, USHORT4444, USHORT5551, USHORT565, UINT10F11F11FREV, UINT2101010REV, UINT248,
		UINT5999REV ->
		true;
		case FLOAT, HALF_FLOAT -> false;
		default -> throw new IllegalArgumentException("Weird data type: " + name());
		};
	}

	public boolean isFloat() {
		return !isInteger();
	}

	public int getByteSize() {
		return switch (this) {
		case BYTE, UBYTE -> 1;
		case SHORT, USHORT, HALF_FLOAT, USHORT565, USHORT4444, USHORT5551 -> 2;
		case INT, UINT, FLOAT, UINT2101010REV, UINT248, UINT10F11F11FREV -> 4;
		case FLOAT32UINT248REV, UINT5999REV -> throw new UnsupportedOperationException("Weird data type: " + this);
		};
	}

	public MemImageFormat getImageFormat() {
		return switch (this) {
		case UBYTE -> MemImageFormat.UBYTE;
		case USHORT -> MemImageFormat.USHORT;
		case HALF_FLOAT -> MemImageFormat.HALF_FLOAT;
		case UINT -> MemImageFormat.UINT;
		case FLOAT -> MemImageFormat.FLOAT;
		case BYTE, INT, SHORT -> throw new UnsupportedOperationException("Unsupported data type: " + this);
		case FLOAT32UINT248REV, UINT5999REV, UINT10F11F11FREV, UINT2101010REV, UINT248, USHORT4444, USHORT5551, USHORT565 ->
		throw new UnsupportedOperationException("Weird data type: " + this);
		};
	}

}
