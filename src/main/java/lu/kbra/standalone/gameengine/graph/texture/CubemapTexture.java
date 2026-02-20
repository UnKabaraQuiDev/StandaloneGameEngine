package lu.kbra.standalone.gameengine.graph.texture;

import java.nio.file.Files;
import java.nio.file.Paths;

import lu.kbra.pclib.PCUtils;
import lu.kbra.standalone.gameengine.generated.gl_wrapper.GL_W;
import lu.kbra.standalone.gameengine.utils.file.FileUtils;
import lu.kbra.standalone.gameengine.utils.gl.consts.TextureType;
import lu.kbra.standalone.gameengine.utils.mem.img.MemImage;

@Deprecated
public class CubemapTexture extends Texture {

	@Deprecated
	protected static final String[] FACES = "top;bottom;left;right;front;back".split(";");
	@Deprecated
	protected static final int FACE_COUNT = 6;

	@Deprecated
	protected MemImage[] images;

	@Deprecated
	public CubemapTexture(final String path) {
		super(path, path, TextureOperation.FILE_BUFFER_LOAD);
		this.txtType = TextureType.CUBE_MAP;
	}

	@Deprecated
	public CubemapTexture(final String name, final String path) {
		super(name, path, TextureOperation.FILE_BUFFER_LOAD);
		this.txtType = TextureType.CUBE_MAP;
	}

	@Deprecated
	public CubemapTexture(final String name, final MemImage[] images) {
		super(name, name, TextureOperation.BUFFER_LOAD);
		this.txtType = TextureType.CUBE_MAP;
		this.images = images;
	}

	@Deprecated
	@Override
	public boolean checkConfigErrors() {
		// TODO: add cubemap checks
		return false;
	}

	@Deprecated
	@Override
	public boolean setup() {
		if (this.isValid()) {
			throw new RuntimeException("Cannot setup already loaded Cubemap Texture");
		}

		if (TextureOperation.FILE_BUFFER_LOAD == this.textureOperation) {
			this.generateFileBufferCubeMapTexture();
		} else if (TextureOperation.BUFFER_LOAD == this.textureOperation) {
			this.generateBufferCubeMapTexture();
		}

		return this.isValid();
	}

	private void generateBufferCubeMapTexture() {
		this.gen();
		this.bind();
		// GL_W.glPixelStorei(GL_W.GL_UNPACK_ALIGNMENT, 1);
		for (int i = 0; i < FACE_COUNT; i++) {
			final MemImage image = this.images[i];

			this.texelFormat = getFormatByChannels(image.getChannels());
			this.texelInternalFormat = getInternalFormatByChannels(image.getChannels(), image.getFormat());
			if (this.texelFormat == null) {
				this.cleanup();
				throw new RuntimeException("Invalid channel count: " + image.getChannels());
			}

			// if (image != null) {
			GL_W.glTexImage2D(TextureType.CM_PX.getGlId() + i,
					0,
					this.texelInternalFormat.getGlId(),
					image.getWidth(),
					image.getHeight(),
					0,
					this.texelFormat.getGlId(),
					this.dataType.getGlId(),
					image.getBuffer());
			// image.free();
			/*
			 * } else { cleanup(); throw new RuntimeException("Failed to load texture"); }
			 */
		}

		this.applyFilter();
		this.applyWrap();

		this.unbind();
	}

	private void generateFileBufferCubeMapTexture() {
		final String[] faces = new String[6];
		for (int i = 0; i < 6; i++) {
			faces[i] = PCUtils.appendFileName(this.path, FACES[i]);
			if (!Files.exists(Paths.get(faces[i]))) {
				throw new RuntimeException("Texture does not exist: " + faces[i]);
			}
		}
		// GlobalLogger.log(Arrays.toString(faces));

		this.gen();
		this.bind();
		// GL_W.glPixelStorei(GL_W.GL_UNPACK_ALIGNMENT, 1);
		for (int i = 0; i < faces.length; i++) {
			final MemImage image = FileUtils.STBILoad(this.path);

			/*
			 * ByteBuffer imageBuffer; int width, height, channels; int[] w = new int[1]; int[] h = new int[1];
			 * int[] c = new int[1];
			 *
			 * // Load image data using STB Image imageBuffer = STBImage.stbi_load(faces[i], w, h, c, 0);
			 *
			 * width = w[0]; height = h[0]; channels = c[0];
			 */

			this.texelFormat = getFormatByChannels(image.getChannels());
			this.texelInternalFormat = getInternalFormatByChannels(image.getChannels(), image.getFormat());
			if (this.texelFormat == null) {
				this.cleanup();
				throw new RuntimeException("Invalid channel count: " + image.getChannels());
			}

			// if (image != null) {
			GL_W.glTexImage2D(TextureType.CM_PX.getGlId() + i,
					0,
					this.texelInternalFormat.getGlId(),
					image.getWidth(),
					image.getHeight(),
					0,
					this.texelFormat.getGlId(),
					this.dataType.getGlId(),
					image.getBuffer());
			image.cleanup();
			/*
			 * } else { cleanup(); throw new RuntimeException("Failed to load texture"); }
			 */
		}

		this.applyFilter();
		this.applyWrap();

		this.unbind();
	}

}
