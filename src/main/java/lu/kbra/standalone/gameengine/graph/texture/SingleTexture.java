package lu.kbra.standalone.gameengine.graph.texture;

import java.io.File;
import java.nio.ByteBuffer;

import org.joml.Vector2f;
import org.joml.Vector2i;
import org.joml.Vector3i;
import org.lwjgl.system.MemoryUtil;

import lu.kbra.standalone.gameengine.cache.CacheManager;
import lu.kbra.standalone.gameengine.generated.gl_wrapper.GL_W;
import lu.kbra.standalone.gameengine.utils.GameEngineUtils;
import lu.kbra.standalone.gameengine.utils.file.FileUtils;
import lu.kbra.standalone.gameengine.utils.gl.consts.TextureFilter;
import lu.kbra.standalone.gameengine.utils.gl.consts.TextureType;
import lu.kbra.standalone.gameengine.utils.gl.consts.TextureWrap;
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

	public SingleTexture(String string, Vector2i outputResolution) {
		this(string, outputResolution.x, outputResolution.y);
	}

	/**
	 * GEN
	 */
	public SingleTexture(String name, int width, int height, int depth) {
		super(name, name, TextureOperation.GENERATE);
		setSize(width, height, depth);
		setTextureType(TextureType.TXT3D);
	}

	public SingleTexture(String string, Vector3i outputResolution) {
		this(string, outputResolution.x, outputResolution.y, outputResolution.z);
	}

	// BUFFER LOAD
	public SingleTexture(String name, MemImage buffer) {
		this(name, buffer.getWidth(), buffer.getHeight(), 0, buffer);
		setTextureType(TextureType.TXT2D);
	}

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
			GameEngineUtils.throwGLESError(
					"Invalid texture size: " + width + "x" + height + "x" + depth + ", max is " + MAX_TEXTURE_SIZE);
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
		buffer = FileUtils.STBILoad(path);

		final int wi = buffer.getWidth();
		final int he = buffer.getHeight();
		final int channels = buffer.getChannels();

		format = getFormatByChannels(channels);
		internalFormat = getInternalFormatByChannels(channels);
		if (format == null || internalFormat == null)
			throw new RuntimeException("Invalid channel count: " + channels + " to format:" + format
					+ " & internalFormat:" + internalFormat);

		if (buffer.getBuffer() == null)
			throw new RuntimeException("Failed to load texture buffer.");

		setSize(wi, he, 0);
		setTextureType(TextureType.TXT2D);
		setMemImage(buffer);

		generateBufferTexture();

		buffer.cleanup();
	}

	// BUFFER LOAD
	private void generateBufferTexture() {
		gen();
		bind();

		width = buffer.getWidth();
		height = buffer.getHeight();
		final int channels = buffer.getChannels();

		format = getFormatByChannels(channels);
		internalFormat = getInternalFormatByChannels(channels);
		if (format == null || internalFormat == null) {
			throw new RuntimeException("Invalid channel count: " + channels + " to format:" + format
					+ " & internalFormat:" + internalFormat);
		}

		if (buffer.getBuffer() == null) {
			throw new RuntimeException("Failed to load texture buffer.");
		}

		GL_W.glPixelStorei(GL_W.GL_UNPACK_ALIGNMENT, 1);
		if (TextureType.TXT2D.equals(txtType) || TextureType.ARRAY2D.equals(txtType)) {
			GL_W.glTexImage2D(txtType.getGlId(), 0, internalFormat.getGlId(), width, height, 0, format.getGlId(),
					dataType.getGlId(), buffer.getBuffer());
		} else if (TextureType.TXT3D.equals(txtType)) {
			GL_W.glTexImage3D(txtType.getGlId(), 0, internalFormat.getGlId(), width, height, depth, 0, format.getGlId(),
					dataType.getGlId(), buffer.getBuffer());
		}
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
		}

		unbind();
	}

	public void resize() {
		if (TextureType.TXT2D.equals(txtType) || TextureType.ARRAY2D.equals(txtType)) {
			GL_W.glTexImage2D(txtType.getGlId(), 0, internalFormat.getGlId(), width, height, 0, format.getGlId(),
					dataType.getGlId(), MemoryUtil.NULL);
		} else if (TextureType.TXT3D.equals(txtType)) {
			GL_W.glTexImage3D(txtType.getGlId(), 0, internalFormat.getGlId(), width, height, depth, 0, format.getGlId(),
					dataType.getGlId(), MemoryUtil.NULL);
		}
	}

	public MemImage getStoredImage() {
		bind();

		int channelCount = getChannelsByFormat(format.getGlId());
		final ByteBuffer buffer = MemoryUtil.memAlloc(width * height * channelCount);
		GL_W.glPixelStorei(GL_W.GL_PACK_ALIGNMENT, 1);
		GL_W.glGetTexImage(txtType.getGlId(), 0, format.getGlId(), dataType.getGlId(), buffer);
		assert GL_W.checkError(
				"ReadPixels(0, 0, " + width + ", " + height + ", " + internalFormat + ", " + dataType + ")");
		GL_W.glFlush();
		GL_W.glFinish();

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

	public void setSize(Vector2i resolution) {
		setSize(resolution.x, resolution.y, 0);
	}

	public void setSize(Vector3i resolution) {
		setSize(resolution.x, resolution.y, resolution.z);
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

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public int getDepth() {
		return depth;
	}

	public static SingleTexture loadSingleTexture(CacheManager cache, String name, String path, TextureFilter filter,
			TextureType type, TextureWrap wrap) {
		SingleTexture texture = new SingleTexture(name, path);
		texture.setFilters(filter);
		texture.setTextureType(type);
		texture.setWraps(wrap);
		texture.setup();
		cache.addTexture(texture);
		return texture;
	}

	public static SingleTexture loadSingleTexture(CacheManager cache, String name, String path, TextureFilter filter,
			TextureType type) {
		SingleTexture texture = new SingleTexture(name, path);
		texture.setFilters(filter);
		texture.setTextureType(type);
		texture.setup();
		cache.addTexture(texture);
		return texture;
	}

	public static SingleTexture loadSingleTexture(CacheManager cache, String name, String path, TextureFilter filter) {
		SingleTexture texture = new SingleTexture(name, path);
		texture.setFilters(filter);
		texture.setup();
		cache.addTexture(texture);
		return texture;
	}

	public static SingleTexture loadSingleTexture(CacheManager cache, String name, String path) {
		SingleTexture texture = new SingleTexture(name, path);
		texture.setup();
		cache.addTexture(texture);
		return texture;
	}

	public static SingleTexture loadSingleTexture(CacheManager cache, String path) {
		SingleTexture texture = new SingleTexture(path, path);
		texture.setup();
		cache.addTexture(texture);
		return texture;
	}

	@Override
	public String toString() {
		return "SingleTexture [width=" + width + ", height=" + height + ", depth=" + depth + ", buffer=" + buffer
				+ ", path=" + path + ", name=" + name + ", tid=" + glId + ", minFilter=" + minFilter + ", magFilter="
				+ magFilter + ", txtType=" + txtType + ", hWrap=" + hWrap + ", vWrap=" + vWrap + ", dWrap=" + dWrap
				+ ", dataType=" + dataType + ", format=" + format + ", internalFormat=" + internalFormat
				+ ", generateMipmaps=" + generateMipmaps + ", fixedSampleLocation=" + fixedSampleLocation
				+ ", sampleCount=" + sampleCount + ", textureOperation=" + textureOperation + ", isValid()=" + isValid()
				+ "]";
	}

}
