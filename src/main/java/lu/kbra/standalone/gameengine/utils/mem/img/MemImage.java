package lu.kbra.standalone.gameengine.utils.mem.img;

import java.nio.ByteBuffer;
import java.util.function.Consumer;

import org.lwjgl.BufferUtils;
import org.lwjgl.stb.STBImage;
import org.lwjgl.system.MemoryUtil;

import lu.pcy113.pclib.PCUtils;
import lu.pcy113.pclib.logger.GlobalLogger;

import lu.kbra.standalone.gameengine.impl.Cleanupable;

public class MemImage implements Cleanupable {

	private final int width;
	private final int height;
	private final int channels;
	private ByteBuffer buffer;
	private final MemImageOrigin origin;

	public MemImage(int width, int height, int channels, ByteBuffer buffer, MemImageOrigin origin) {
		this.width = width;
		this.height = height;
		this.channels = channels;
		this.buffer = buffer;
		this.origin = origin;
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
	protected void finalize() throws Throwable {
		if (buffer == null) {
			return;
		}

		GlobalLogger.severe(
				"Buffer " + PCUtils.toSimpleIdentityString(this) + " went OOB but wasn't cleaned up properly !");
		cleanup();
	}

	public static ByteBuffer fromOGL(int size) {
		return MemoryUtil.memAlloc(size);
	}

	public static MemImage fromOGL(int width, int height, int channels) {
		return new MemImage(width, height, channels, fromOGL(width * height * channels), MemImageOrigin.OPENGL);
	}

	public static MemImage fromOGL(int width, int height, int channels, Consumer<ByteBuffer> bbs) {
		final ByteBuffer bb = fromOGL(width * height * channels);
		bbs.accept(bb);
		return new MemImage(width, height, channels, bb, MemImageOrigin.OPENGL);
	}

	public static ByteBuffer fromDirect(int size) {
		return BufferUtils.createByteBuffer(size);
	}

	public static MemImage fromDirect(int width, int height, int channels) {
		return new MemImage(width, height, channels, fromDirect(width * height * channels), MemImageOrigin.DIRECT);
	}

	public static MemImage fromDirect(int width, int height, int channels, Consumer<ByteBuffer> bbs) {
		final ByteBuffer bb = fromDirect(width * height * channels);
		bbs.accept(bb);
		return new MemImage(width, height, channels, bb, MemImageOrigin.DIRECT);
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

	@Override
	public String toString() {
		return "MemImage [width=" + width + ", height=" + height + ", channels=" + channels + ", buffer=" + buffer
				+ ", origin=" + origin + ", direct=" + (buffer != null ? buffer.isDirect() : false) + "]";
	}

}
