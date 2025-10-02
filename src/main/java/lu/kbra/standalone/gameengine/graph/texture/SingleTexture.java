package lu.kbra.standalone.gameengine.graph.texture;

import java.io.File;
import java.nio.ByteBuffer;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.joml.Vector2f;
import org.joml.Vector2i;
import org.lwjgl.system.MemoryUtil;

import lu.kbra.standalone.gameengine.utils.GameEngineUtils;
import lu.kbra.standalone.gameengine.utils.consts.TextureType;
import lu.kbra.standalone.gameengine.utils.file.FileUtils;
import lu.kbra.standalone.gameengine.utils.gl.wrapper.GL_W;
import lu.kbra.standalone.gameengine.utils.mem.img.MemImage;
import lu.kbra.standalone.gameengine.utils.mem.img.MemImageOrigin;

public class SingleTexture extends Texture {

	private int width, height, depth;
	private MemImage buffer;

	// GEN
	public SingleTexture(String name, int width, int height) {
		this(name, width, height, 0);
		setTextureType(TextureType.TXT2D);
	}

	/**
	 * GEN
	 */
	public SingleTexture(String name, int width, int height, int depth) {
		super(name, name, TextureOperation.GENERATE);
		setSize(width, height, depth);
		setTextureType(TextureType.TXT3D);
	}

	// BUFFER LOAD
	public SingleTexture(String name, int width, int height, MemImage buffer) {
		this(name, width, height, 0, buffer);
		setTextureType(TextureType.TXT2D);
	}

	/**
	 * BUFFER LOAD
	 */
	public SingleTexture(String name, int width, int height, int depth, MemImage buffer) {
		super(name, name, TextureOperation.BUFFER_LOAD);
		this.buffer = buffer;
		setSize(width, height, depth);
		setTextureType(TextureType.TXT3D);
	}

	/**
	 * FILE BUFFER LOAD
	 */
	public SingleTexture(String name, String path) {
		super(name, path, TextureOperation.FILE_BUFFER_LOAD);
	}

	/**
	 * FILE BUFFER LOAD
	 */
	public SingleTexture(String name, File path) {
		super(name, path.getAbsolutePath(), TextureOperation.FILE_BUFFER_LOAD);
	}

	@Override
	public boolean checkConfigErrors() {
		// Invalid value (glTexImage2DMultisample)
		if ((width > MAX_TEXTURE_SIZE || width < 0) || (height > MAX_TEXTURE_SIZE || height < 0)
				|| (depth > MAX_TEXTURE_SIZE || depth < 0)) {
			GameEngineUtils.throwGLESError("Invalid texture size: " + width + "x" + height + "x" + depth + ", max is " + MAX_TEXTURE_SIZE);
		}

		return true;
	}

	@Override
	public boolean setup() {
		if (isValid()) {
			throw new RuntimeException("Cannot setup already loaded Single Texture.");
		}

		checkConfigErrors();

		if (TextureOperation.GENERATE.equals(textureOperation)) {
			generateTexture();
		} else if (TextureOperation.BUFFER_LOAD.equals(textureOperation)) {
			generateBufferTexture();
		} else if (TextureOperation.FILE_BUFFER_LOAD.equals(textureOperation)) {
			generateFileBufferTexture();
		}
		return isValid();
	}

	// FILE BUFFER LOAD
	private void generateFileBufferTexture() {
		if (!Files.exists(Paths.get(path)))
			throw new RuntimeException("File '" + path + "' not found");

		MemImage image = FileUtils.STBILoad(path);

		int wi = image.getWidth();
		int he = image.getHeight();
		int channels = image.getChannels();

		format = getFormatByChannels(channels);
		internalFormat = getInternalFormatByChannels(channels);
		if (format == null || internalFormat == null)
			throw new RuntimeException(
					"Invalid channel count: " + channels + " to format:" + format + " & internalFormat:" + internalFormat);

		if (image.getBuffer() == null)
			throw new RuntimeException("Failed to load texture buffer.");

		setSize(wi, he, 0);
		setTextureType(TextureType.TXT2D);
		setMemImage(image);

		generateBufferTexture();

		image.cleanup();
	}

	// BUFFER LOAD
	private void generateBufferTexture() {
		gen();
		bind();

		GL_W.glPixelStorei(GL_W.GL_UNPACK_ALIGNMENT, 1);
		GL_W.checkError("PixelStoreI.UnpackAlignment=1");
		if (TextureType.TXT2D.equals(txtType) || TextureType.ARRAY2D.equals(txtType)) {
			GL_W
					.glTexImage2D(txtType.getGlId(),
							0,
							internalFormat.getGlId(),
							width,
							height,
							0,
							format.getGlId(),
							dataType.getGlId(),
							buffer.getBuffer());
		} else if (TextureType.TXT3D.equals(txtType)) {
			GL_W
					.glTexImage3D(txtType.getGlId(),
							0,
							internalFormat.getGlId(),
							width,
							height,
							depth,
							0,
							format.getGlId(),
							dataType.getGlId(),
							buffer.getBuffer());
		}
		GL_W.checkError("TexImage_" + txtType);
		applyFilter();
		applyWrap();

		if (generateMipmaps) {
			genMipMaps();
		}

		unbind();
	}

	// GEN
	private void generateTexture() {
		gen();
		bind();

		resize();
		applyFilter();
		applyWrap();

		if (generateMipmaps) {
			GL_W.glGenerateMipmap(txtType.getGlId());
			GL_W.checkError("GenerateMipmap[" + txtType + "]");
		}

		unbind();
	}

	public void resize() {
		if (TextureType.TXT2D.equals(txtType) || TextureType.ARRAY2D.equals(txtType)) {
			GL_W
					.glTexImage2D(txtType.getGlId(),
							0,
							internalFormat.getGlId(),
							width,
							height,
							0,
							format.getGlId(),
							dataType.getGlId(),
							MemoryUtil.NULL);
		} else if (TextureType.TXT3D.equals(txtType)) {
			GL_W
					.glTexImage3D(txtType.getGlId(),
							0,
							internalFormat.getGlId(),
							width,
							height,
							depth,
							0,
							format.getGlId(),
							dataType.getGlId(),
							MemoryUtil.NULL);
		}
		GL_W.checkError("TexImage_" + txtType);
	}

	public MemImage getStoredImage() {
		bind();

		int channelCount = getChannelsByFormat(format.getGlId());
		ByteBuffer buffer = MemoryUtil.memAlloc(width * height * channelCount); // BufferUtils.createByteBuffer(width *
																				// height * channelCount);
		// GL_W.glBindBuffer(GL_W.GL_PIXEL_PACK_BUFFER, 0);
		// GL_W.glBindFramebuffer(GL_W.GL_READ_FRAMEBUFFER_BINDING, 0);
		GL_W.glReadPixels(0, 0, width, height, format.getGlId(), dataType.getGlId(), buffer);
		GL_W.checkError("glReadPixels(0, 0, " + width + ", " + height + ", " + internalFormat + ", " + dataType + ")");

		unbind();

		return new MemImage(width, height, channelCount, buffer, MemImageOrigin.OPENGL);
	}

	public void setSize(int width) {
		setSize(width, 0, 0);
	}

	public void setSize(int width, int height) {
		setSize(width, height, 0);
	}

	public void setSize(int width, int height, int depth) {
		this.width = width;
		this.height = height;
		this.depth = depth;
	}

	public MemImage getMemImage() {
		return buffer;
	}

	public void setMemImage(MemImage buffer) {
		this.buffer = buffer;
	}

	public void destroyBuffer() {
		buffer = null;
	}

	public Vector2i getSize2D() {
		return new Vector2i(width, height);
	}

	public Vector2f getNormalizedSize2D() {
		return new Vector2f(getSize2D()).div(Math.max(width, height));
	}

}
