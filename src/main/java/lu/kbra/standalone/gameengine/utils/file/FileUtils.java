package lu.kbra.standalone.gameengine.utils.file;

import java.io.File;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;
import java.util.Objects;

import org.lwjgl.stb.STBImage;
import org.lwjgl.stb.STBImageWrite;

import lu.kbra.pclib.PCUtils;
import lu.kbra.standalone.gameengine.utils.mem.img.MemImage;
import lu.kbra.standalone.gameengine.utils.mem.img.MemImageContentOrientation;
import lu.kbra.standalone.gameengine.utils.mem.img.MemImageFormat;
import lu.kbra.standalone.gameengine.utils.mem.img.MemImageOrigin;

public final class FileUtils {

	public static final String RESOURCES = "./resources/";

	public static final String SHADERS = "shaders/";
	public static final String MODELS = "models/";
	public static final String TEXTURES = "textures/";

	public static MemImage STBILoad(final String filePath) {
		return STBILoadRGBA(filePath);
	}

	public static MemImage STBILoadRGBA(final String filePath) {
		return STBILoad(filePath, 4);
	}

	public static MemImage STBILoadRGB(final String filePath) {
		return STBILoad(filePath, 3);
	}

	public static MemImage STBILoad(final String location, final int desiredChannels) {
		byte[] data = PCUtils.readBytesSource(location);
		final ByteBuffer bb = ByteBuffer.allocateDirect(data.length).order(ByteOrder.nativeOrder());
		bb.put(data);
		bb.flip();
		data = null;

		return STBILoad(bb,
				desiredChannels,
				STBImage.stbi_is_hdr_from_memory(bb) ? MemImageFormat.FLOAT
						: STBImage.stbi_is_16_bit_from_memory(bb) ? MemImageFormat.USHORT
								: MemImageFormat.UBYTE);
	}

	public static MemImage STBILoad(ByteBuffer bb, final int desiredChannels, final MemImageFormat format) {
		final int[] w = new int[1];
		final int[] h = new int[1];
		final int[] c = new int[1];

		STBImage.stbi_set_flip_vertically_on_load(true);

		ByteBuffer buffer = null;

		switch (format) {
		case UBYTE -> buffer = STBImage.stbi_load_from_memory(bb, w, h, c, desiredChannels);
		case USHORT -> {
			final ShortBuffer shortBuf = STBImage.stbi_load_16_from_memory(bb, w, h, c, desiredChannels);
			if (shortBuf != null) {
				buffer = ByteBuffer.allocateDirect(shortBuf.capacity() * 2).order(ByteOrder.nativeOrder());
				buffer.asShortBuffer().put(shortBuf);
			}
		}
		case FLOAT -> {
			final FloatBuffer floatBuffer = STBImage.stbi_loadf_from_memory(bb, w, h, c, desiredChannels);
			if (floatBuffer != null) {
				buffer = ByteBuffer.allocateDirect(floatBuffer.capacity() * 4).order(ByteOrder.nativeOrder());
				buffer.asFloatBuffer().put(floatBuffer);
			}
		}
		case HALF_FLOAT -> {
			final ShortBuffer halfBuf = STBImage.stbi_load_16_from_memory(bb, w, h, c, desiredChannels);
			if (halfBuf != null) {
				buffer = ByteBuffer.allocateDirect(halfBuf.capacity() * 2).order(ByteOrder.nativeOrder());
				buffer.asShortBuffer().put(halfBuf);
			}
		}
		default -> throw new IllegalArgumentException("Unsupported: " + format);
		}

		bb = null;

		if (buffer == null)
			throw new RuntimeException(STBImage.stbi_failure_reason());

		buffer.flip();

		return new MemImage(w[0], h[0], c[0], buffer, format == MemImageFormat.UBYTE ? MemImageOrigin.STBI : MemImageOrigin.DIRECT, format);
	}

	public static MemImage STBILoad(final String location, final int desiredChannels, final MemImageFormat format) {
		byte[] data = PCUtils.readBytesSource(location);
		final ByteBuffer bb = ByteBuffer.allocateDirect(data.length);
		bb.put(data);
		bb.flip();
		data = null;

		return STBILoad(bb, desiredChannels, format);
	}

	public static boolean STBISaveIncremental(String filePath, final MemImage image) {
		filePath = PCUtils.getIncrement(filePath);
		return STBISave(filePath, image);
	}

	public static boolean STBISave(final String filePath, final MemImage image) {
		return STBISave(new File(filePath), image);
	}

	public static boolean STBISave(final File file, final MemImage image) {
		Objects.requireNonNull(image);
		Objects.requireNonNull(image.getBuffer());
		if (!image.getBuffer().isDirect())
			throw new IllegalArgumentException("The buffer: " + image + " isn't direct.");
		file.getParentFile().mkdirs();
		STBImageWrite.stbi_flip_vertically_on_write(image.getOrientation() == MemImageContentOrientation.BOTTOM_LEFT);

		return STBImageWrite.stbi_write_png(file.getAbsolutePath(),
				image.getWidth(),
				image.getHeight(),
				image.getChannels(),
				image.getBuffer(),
				image.getWidth() * image.getChannels());
	}

	public static void STBIFree(final ByteBuffer buffer) {
		STBImage.stbi_image_free(buffer);
	}

}
