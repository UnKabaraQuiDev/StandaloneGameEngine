package lu.kbra.standalone.gameengine.utils.file;

import java.io.File;
import java.nio.ByteBuffer;
import java.util.Objects;

import org.lwjgl.stb.STBImage;
import org.lwjgl.stb.STBImageWrite;

import lu.kbra.pclib.PCUtils;
import lu.kbra.standalone.gameengine.utils.mem.img.MemImage;
import lu.kbra.standalone.gameengine.utils.mem.img.MemImageOrigin;

public final class FileUtils {

	public static final String RESOURCES = "./resources/";

	public static final String SHADERS = "shaders/";
	public static final String MODELS = "models/";
	public static final String TEXTURES = "textures/";

	public static MemImage STBILoad(String filePath) {
		return STBILoadRGBA(filePath);
	}

	public static MemImage STBILoadRGBA(String filePath) {
		return STBILoad(filePath, 4);
	}

	public static MemImage STBILoadRGB(String filePath) {
		return STBILoad(filePath, 3);
	}

	public static MemImage STBILoad(String location, int desiredChannels) {
		int[] w = new int[1], h = new int[1], c = new int[1];

		byte[] data = PCUtils.readBytesSource(location);
		ByteBuffer bb = ByteBuffer.allocateDirect(data.length);
		bb.put(data);
		bb.flip();
		data = null;

		STBImage.stbi_set_flip_vertically_on_load(true);
		final ByteBuffer buffer = STBImage.stbi_load_from_memory(bb, w, h, c, desiredChannels);

		bb = null;

		if (buffer == null) {
			throw new RuntimeException(STBImage.stbi_failure_reason());
		}

		return new MemImage(w[0], h[0], c[0], buffer, MemImageOrigin.STBI);
	}

	public static boolean STBISaveIncremental(String filePath, MemImage image) {
		filePath = PCUtils.getIncrement(filePath);
		return STBISave(filePath, image);
	}

	public static boolean STBISave(String filePath, MemImage image) {
		return STBISave(new File(filePath), image);
	}

	public static boolean STBISave(File file, MemImage image) {
		file.getParentFile().mkdirs();
		Objects.requireNonNull(image);
		Objects.requireNonNull(image.getBuffer());
		if (!image.getBuffer().isDirect()) {
			throw new IllegalArgumentException("The buffer: " + image + " isn't direct.");
		}
		STBImageWrite.stbi_flip_vertically_on_write(image.isFromOGL());
		return STBImageWrite.stbi_write_png(file.getAbsolutePath(), image.getWidth(), image.getHeight(),
				image.getChannels(), image.getBuffer(), image.getWidth() * image.getChannels());
	}

	public static void STBIFree(ByteBuffer buffer) {
		STBImage.stbi_image_free(buffer);
	}

}
