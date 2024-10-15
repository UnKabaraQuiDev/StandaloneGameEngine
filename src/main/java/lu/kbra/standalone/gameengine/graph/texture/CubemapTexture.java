package lu.kbra.standalone.gameengine.graph.texture;

import java.nio.file.Files;
import java.nio.file.Paths;

import lu.pcy113.pclib.PCUtils;

import lu.kbra.standalone.gameengine.utils.consts.TextureType;
import lu.kbra.standalone.gameengine.utils.file.FileUtils;
import lu.kbra.standalone.gameengine.utils.gl.wrapper.GL_W;
import lu.kbra.standalone.gameengine.utils.mem.img.MemImage;

public class CubemapTexture extends Texture {

	private static final String[] FACES = "top;bottom;left;right;front;back".split(";");
	private static final int FACE_COUNT = 6;

	private MemImage[] images;

	public CubemapTexture(String path) {
		super(path, path, TextureOperation.FILE_BUFFER_LOAD);
		txtType = TextureType.CUBE_MAP;
	}

	public CubemapTexture(String name, String path) {
		super(name, path, TextureOperation.FILE_BUFFER_LOAD);
		txtType = TextureType.CUBE_MAP;
	}

	public CubemapTexture(String name, MemImage[] images) {
		super(name, name, TextureOperation.BUFFER_LOAD);
		txtType = TextureType.CUBE_MAP;
		this.images = images;
	}

	@Override
	public boolean checkConfigErrors() {
		// TODO: add cubemap checks
		return false;
	}

	@Override
	public boolean setup() {
		if (isValid()) {
			throw new RuntimeException("Cannot setup already loaded Cubemap Texture");
		}

		if (TextureOperation.FILE_BUFFER_LOAD.equals(textureOperation)) {
			generateFileBufferCubeMapTexture();
		} else if (TextureOperation.BUFFER_LOAD.equals(textureOperation)) {
			generateBufferCubeMapTexture();
		}

		return isValid();
	}

	private void generateBufferCubeMapTexture() {
		gen();
		bind();
		// GL_W.glPixelStorei(GL_W.GL_UNPACK_ALIGNMENT, 1);
		for (int i = 0; i < FACE_COUNT; i++) {
			MemImage image = images[i];

			format = getFormatByChannels(image.getChannels());
			internalFormat = getInternalFormatByChannels(image.getChannels());
			if (format == null) {
				cleanup();
				throw new RuntimeException("Invalid channel count: " + image.getChannels());
			}

			// if (image != null) {
			GL_W.glTexImage2D(TextureType.CM_PX.getGlId() + i, 0, internalFormat.getGlId(), image.getWidth(), image.getHeight(), 0, format.getGlId(), dataType.getGlId(), image.getBuffer());
			GL_W.checkError("TexImage2D[" + (TextureType.values()[TextureType.CM_PX.ordinal() + i]) + "]");
			// image.free();
			/*
			 * } else { cleanup(); throw new RuntimeException("Failed to load texture"); }
			 */
		}

		applyFilter();
		applyWrap();

		unbind();
	}

	private void generateFileBufferCubeMapTexture() {
		String[] faces = new String[6];
		for (int i = 0; i < 6; i++) {
			faces[i] = PCUtils.appendFileName(path, FACES[i]);
			if (!Files.exists(Paths.get(faces[i]))) {
				throw new RuntimeException("Texture does not exist: " + faces[i]);
			}
		}
		// GlobalLogger.log(Arrays.toString(faces));

		gen();
		bind();
		// GL_W.glPixelStorei(GL_W.GL_UNPACK_ALIGNMENT, 1);
		for (int i = 0; i < faces.length; i++) {
			MemImage image = FileUtils.STBILoad(path);

			/*
			 * ByteBuffer imageBuffer; int width, height, channels; int[] w = new int[1];
			 * int[] h = new int[1]; int[] c = new int[1];
			 * 
			 * // Load image data using STB Image imageBuffer = STBImage.stbi_load(faces[i],
			 * w, h, c, 0);
			 * 
			 * width = w[0]; height = h[0]; channels = c[0];
			 */

			format = getFormatByChannels(image.getChannels());
			internalFormat = getInternalFormatByChannels(image.getChannels());
			if (format == null) {
				cleanup();
				throw new RuntimeException("Invalid channel count: " + image.getChannels());
			}

			// if (image != null) {
			GL_W.glTexImage2D(TextureType.CM_PX.getGlId() + i, 0, internalFormat.getGlId(), image.getWidth(), image.getHeight(), 0, format.getGlId(), dataType.getGlId(), image.getBuffer());
			GL_W.checkError("TexImage2D[" + (TextureType.values()[TextureType.CM_PX.ordinal() + i]) + "]");
			image.cleanup();
			/*
			 * } else { cleanup(); throw new RuntimeException("Failed to load texture"); }
			 */
		}

		applyFilter();
		applyWrap();

		unbind();
	}

}
