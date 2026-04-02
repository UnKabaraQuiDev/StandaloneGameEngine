package lu.kbra.standalone.gameengine.utils.mem.img;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.function.Consumer;

import org.lwjgl.BufferUtils;
import org.lwjgl.stb.STBImage;
import org.lwjgl.system.MemoryUtil;

import lu.kbra.standalone.gameengine.impl.Cleanupable;
import lu.kbra.standalone.gameengine.utils.GameEngineUtils;

public class MemImage implements Cleanupable {

	private final int width;
	private final int height;
	private final int channels;
	private ByteBuffer buffer;
	private final MemImageOrigin origin;
	private final MemImageFormat format;
	private final MemImageContentOrientation orientation;

	public MemImage(
			int width,
			int height,
			int channels,
			ByteBuffer buffer,
			MemImageOrigin origin,
			MemImageFormat format,
			MemImageContentOrientation orientation) {
		this.width = width;
		this.height = height;
		this.channels = channels;
		this.buffer = buffer;
		this.origin = origin;
		this.format = format;
		this.orientation = orientation;
	}

	public MemImage(int width, int height, int channels, ByteBuffer buffer, MemImageOrigin origin, MemImageFormat format) {
		this.width = width;
		this.height = height;
		this.channels = channels;
		this.buffer = buffer;
		this.origin = origin;
		this.format = format;
		this.orientation = origin == MemImageOrigin.OPENGL ? MemImageContentOrientation.BOTTOM_LEFT : MemImageContentOrientation.TOP_LEFT;
	}

	public MemImage toRGBA8() {
		if (this.channels != 4) {
			throw new IllegalStateException("Expected 4 channels, got " + this.channels);
		}
		if (this.format != MemImageFormat.HALF_FLOAT) {
			throw new IllegalStateException("Expected HALF_FLOAT, got " + this.format);
		}

		final ByteBuffer src = this.buffer.duplicate().order(ByteOrder.LITTLE_ENDIAN);
		final ByteBuffer dst = BufferUtils.createByteBuffer(this.width * this.height * 4);

		for (int i = 0; i < this.width * this.height; i++) {
			final float r = halfToFloat(src.getShort());
			final float g = halfToFloat(src.getShort());
			final float b = halfToFloat(src.getShort());
			final float a = halfToFloat(src.getShort());

			dst.put(floatToUNorm8(r));
			dst.put(floatToUNorm8(g));
			dst.put(floatToUNorm8(b));
			dst.put(floatToUNorm8(a));
		}

		dst.flip();
		return new MemImage(this.width, this.height, 4, dst, MemImageOrigin.DIRECT, MemImageFormat.UBYTE, orientation);
	}

	public static ByteBuffer fromOGL(int size) {
		return MemoryUtil.memAlloc(size);
	}

	public static MemImage fromOGL(int width, int height, int channels, MemImageFormat format) {
		return new MemImage(width, height, channels, fromOGL(width * height * channels), MemImageOrigin.OPENGL, format);
	}

	public static MemImage fromOGL(int width, int height, int channels, Consumer<ByteBuffer> bbs, MemImageFormat format) {
		final ByteBuffer bb = fromOGL(width * height * channels);
		bbs.accept(bb);
		return new MemImage(width, height, channels, bb, MemImageOrigin.OPENGL, format);
	}

	public static ByteBuffer fromDirect(int size) {
		return BufferUtils.createByteBuffer(size);
	}

	public static MemImage fromDirect(int width, int height, int channels, MemImageFormat format) {
		return new MemImage(width, height, channels, fromDirect(width * height * channels), MemImageOrigin.DIRECT, format);
	}

	public static MemImage fromDirect(int width, int height, int channels, Consumer<ByteBuffer> bbs, MemImageFormat format) {
		final ByteBuffer bb = fromDirect(width * height * channels);
		bbs.accept(bb);
		return new MemImage(width, height, channels, bb, MemImageOrigin.DIRECT, format);
	}

	public boolean isFromOGL() {
		return MemImageOrigin.OPENGL == origin;
	}

	public boolean isFromSTBI() {
		return MemImageOrigin.STBI == origin;
	}

	public boolean isFromJVM() {
		return MemImageOrigin.MEMORY == origin;
	}

	public boolean isDirect() {
		return MemImageOrigin.DIRECT == origin;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public int getChannels() {
		return channels;
	}

	public ByteBuffer getBuffer() {
		return buffer;
	}

	public MemImageOrigin getOrigin() {
		return origin;
	}

	public MemImageFormat getFormat() {
		return format;
	}

	public MemImageContentOrientation getOrientation() {
		return orientation;
	}

	@Override
	public void cleanup() {
		if (buffer == null) {
			return;
		}

		if (MemImageOrigin.STBI == origin) {
			STBImage.stbi_image_free(buffer);
		} else if (MemImageOrigin.OPENGL == origin) {
			MemoryUtil.memFree(buffer);
		}

		buffer = null;
	}

	@Override
	public String toString() {
		return "MemImage@" + System.identityHashCode(this) + " [width=" + width + ", height=" + height + ", channels=" + channels
				+ ", buffer=" + buffer + ", origin=" + origin + ", format=" + format + ", orientation=" + orientation + "]";
	}

	private static byte floatToUNorm8(final float v) {
		final float clamped = Math.max(0.0f, Math.min(1.0f, v));
		return (byte) Math.round(clamped * 255.0f);
	}

	private static float halfToFloat(final short h) {
		return GameEngineUtils.halfFloatToFloat(h);
	}

}
