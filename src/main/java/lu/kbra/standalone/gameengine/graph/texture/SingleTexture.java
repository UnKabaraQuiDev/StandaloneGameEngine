package lu.kbra.standalone.gameengine.graph.texture;

import java.io.File;
import java.nio.ByteBuffer;

import org.joml.Vector2f;
import org.joml.Vector2i;
import org.joml.Vector3i;
import org.joml.Vector4f;
import org.joml.Vector4i;
import org.lwjgl.system.MemoryUtil;

import lu.kbra.standalone.gameengine.cache.CacheManager;
import lu.kbra.standalone.gameengine.generated.gl_wrapper.GL_W;
import lu.kbra.standalone.gameengine.utils.GameEngineUtils;
import lu.kbra.standalone.gameengine.utils.file.FileUtils;
import lu.kbra.standalone.gameengine.utils.gl.consts.DataType;
import lu.kbra.standalone.gameengine.utils.gl.consts.TexelFormat;
import lu.kbra.standalone.gameengine.utils.gl.consts.TexelInternalFormat;
import lu.kbra.standalone.gameengine.utils.gl.consts.TextureFilter;
import lu.kbra.standalone.gameengine.utils.gl.consts.TextureType;
import lu.kbra.standalone.gameengine.utils.gl.consts.TextureWrap;
import lu.kbra.standalone.gameengine.utils.mem.img.MemImage;
import lu.kbra.standalone.gameengine.utils.mem.img.MemImageOrigin;

public class SingleTexture extends Texture {

	protected int width;
	protected int height;
	protected int depth;
	protected MemImage buffer;

	// GEN
	public SingleTexture(final String name, final int width, final int height) {
		this(name, width, height, 0);
		setTextureType(TextureType.TXT2D);
	}

	public SingleTexture(final String string, final Vector2i res) {
		this(string, res.x, res.y);
	}

	/**
	 * GEN
	 */
	public SingleTexture(final String name, final int width, final int height, final int depth) {
		super(name, name, TextureOperation.GENERATE);
		this.setSize(width, height, depth);
		setTextureType(TextureType.TXT3D);
	}

	public SingleTexture(final String string, final Vector3i res) {
		this(string, res.x, res.y, res.z);
	}

	// BUFFER LOAD
	public SingleTexture(final String name, final MemImage buffer) {
		this(name, buffer.getWidth(), buffer.getHeight(), 0, buffer);
		setTextureType(TextureType.TXT2D);
		//		this.setInternalFormat(buffer.getFormat() == MemImageFormat.HALF_FLOAT ? TexelInternalFormat.rgba);
	}

	public SingleTexture(final String name, final int width, final int height, final MemImage buffer) {
		this(name, width, height, 0, buffer);
		setTextureType(TextureType.TXT2D);
	}

	/**
	 * BUFFER LOAD
	 */
	public SingleTexture(final String name, final int width, final int height, final int depth, final MemImage buffer) {
		super(name, name, TextureOperation.BUFFER_LOAD);
		this.buffer = buffer;
		this.setSize(width, height, depth);
		setTextureType(TextureType.TXT3D);
	}

	/**
	 * FILE BUFFER LOAD
	 */
	public SingleTexture(final String name, final String path) {
		super(name, path, TextureOperation.FILE_BUFFER_LOAD);
	}

	/**
	 * FILE BUFFER LOAD
	 */
	public SingleTexture(final String name, final File path) {
		super(name, path.getAbsolutePath(), TextureOperation.FILE_BUFFER_LOAD);
	}

	@Override
	public boolean checkConfigErrors() {
		// Invalid value (glTexImage2DMultisample)
		if ((width > MAX_TEXTURE_SIZE || width < 0) || (height > MAX_TEXTURE_SIZE || height < 0)
				|| (depth > MAX_TEXTURE_SIZE || depth < 0))
			GameEngineUtils.throwGLESError(
					"Invalid texture size: " + width + "x" + height + "x" + depth + ", max is " + MAX_TEXTURE_SIZE);

		return true;
	}

	@Override
	public boolean setup() {
		if (isValid())
			throw new RuntimeException("Cannot setup already loaded Single Texture.");

		checkConfigErrors();

		if (TextureOperation.GENERATE == textureOperation)
			generateTexture();
		else if (TextureOperation.BUFFER_LOAD == textureOperation)
			generateBufferTexture();
		else if (TextureOperation.FILE_BUFFER_LOAD == textureOperation)
			generateFileBufferTexture();

		return isValid();
	}

	// FILE BUFFER LOAD
	private void generateFileBufferTexture() {
		buffer = FileUtils.STBILoad(path);

		final int wi = buffer.getWidth();
		final int he = buffer.getHeight();
		final int channels = buffer.getChannels();

		texelFormat = getFormatByChannels(channels);
		texelInternalFormat = getInternalFormatByChannels(channels, buffer.getFormat());
		if (texelFormat == null || texelInternalFormat == null)
			throw new RuntimeException("Invalid channel count: " + channels + " to format:" + texelFormat + " & internalFormat:"
					+ texelInternalFormat);

		if (buffer.isFromJVM())
			throw new RuntimeException("Buffer is from memory.");

		this.setSize(wi, he, 0);
		setTextureType(TextureType.TXT2D);
		setMemImage(buffer);

		generateBufferTexture();

		buffer.cleanup();
	}

	// BUFFER LOAD
	private void generateBufferTexture() {
		gen();
		this.bind();

		width = buffer.getWidth();
		height = buffer.getHeight();
		final int channels = buffer.getChannels();

		texelFormat = getFormatByChannels(channels);
		texelInternalFormat = getInternalFormatByChannels(channels, buffer.getFormat());
		System.err.println(texelFormat + " " + texelInternalFormat + " " + buffer.getFormat());
		if (texelFormat == null || texelInternalFormat == null)
			throw new RuntimeException("Invalid channel count: " + channels + " to format:" + texelFormat + " & internalFormat:"
					+ texelInternalFormat);

		if (buffer.isFromJVM())
			throw new RuntimeException("Buffer is from memory.");

		GL_W.glPixelStorei(GL_W.GL_UNPACK_ALIGNMENT, 1);
		if (TextureType.TXT2D == txtType || TextureType.ARRAY2D == txtType)
			GL_W.glTexImage2D(txtType.getGlId(),
					0,
					texelInternalFormat.getGlId(),
					width,
					height,
					0,
					texelFormat.getGlId(),
					dataType.getGlId(),
					buffer.getBuffer());
		else if (TextureType.TXT3D == txtType)
			GL_W.glTexImage3D(txtType.getGlId(),
					0,
					texelInternalFormat.getGlId(),
					width,
					height,
					depth,
					0,
					texelFormat.getGlId(),
					dataType.getGlId(),
					buffer.getBuffer());
		applyFilter();
		applyWrap();

		if (generateMipmaps)
			genMipMaps();

		this.unbind();
	}

	// GEN
	private void generateTexture() {
		gen();
		this.bind();

		this.resize();
		applyFilter();
		applyWrap();

		if (generateMipmaps)
			GL_W.glGenerateMipmap(txtType.getGlId());

		this.unbind();
	}

	public void resize() {
		bind();
		if (TextureType.TXT2D == txtType || TextureType.ARRAY2D == txtType)
			GL_W.glTexImage2D(txtType.getGlId(),
					0,
					texelInternalFormat.getGlId(),
					width,
					height,
					0,
					texelFormat.getGlId(),
					dataType.getGlId(),
					MemoryUtil.NULL);
		else if (TextureType.TXT3D == txtType)
			GL_W.glTexImage3D(txtType.getGlId(),
					0,
					texelInternalFormat.getGlId(),
					width,
					height,
					depth,
					0,
					texelFormat.getGlId(),
					dataType.getGlId(),
					MemoryUtil.NULL);
	}

	public void resize(Vector2i resolution) {
		bind();
		setSize(resolution);
		resize();
	}

	public MemImage getStoredImage() {
		this.bind();

		final int channelCount = getChannelsByFormat(texelFormat.getGlId());
		final ByteBuffer buffer = MemoryUtil.memAlloc(width * height * channelCount * dataType.getByteSize());
		GL_W.glPixelStorei(GL_W.GL_PACK_ALIGNMENT, 1);
		GL_W.glGetTexImage(txtType.getGlId(), 0, texelFormat.getGlId(), dataType.getGlId(), buffer);
		GL_W.glFinish();

		this.unbind();

		return new MemImage(width, height, channelCount, buffer, MemImageOrigin.OPENGL, dataType.getImageFormat());
	}

	public void clear(Vector4f backgroundColor) {
		bind();
		GL_W.glClearTexImage(getGlId(),
				0,
				getTexelFormat().getGlId(),
				getDataType().getGlId(),
				new float[] { backgroundColor.x, backgroundColor.y, backgroundColor.z, backgroundColor.w });
	}

	public void clear(Vector4i backgroundColor) {
		bind();
		GL_W.glClearTexImage(getGlId(),
				0,
				getTexelFormat().getGlId(),
				getDataType().getGlId(),
				new int[] { backgroundColor.x, backgroundColor.y, backgroundColor.z, backgroundColor.w });
	}

	public void setColorFormat(DataType dataType, TexelFormat texelFormat, TexelInternalFormat texelInternalFormat) {
		setDataType(dataType);
		setTexelFormat(texelFormat);
		setTexelInternalFormat(texelInternalFormat);
	}

	public void setSize(final int width) {
		this.setSize(width, 0, 0);
	}

	public void setSize(final int width, final int height) {
		this.setSize(width, height, 0);
	}

	public void setSize(final int width, final int height, final int depth) {
		this.width = width;
		this.height = height;
		this.depth = depth;
	}

	public void setSize(final Vector2i resolution) {
		this.setSize(resolution.x, resolution.y, 0);
	}

	public void setSize(final Vector3i resolution) {
		this.setSize(resolution.x, resolution.y, resolution.z);
	}

	public MemImage getMemImage() {
		return buffer;
	}

	public void setMemImage(final MemImage buffer) {
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

	public static SingleTexture loadSingleTexture(
			final CacheManager cache,
			final String name,
			final String path,
			final TextureFilter filter,
			final TextureType type,
			final TextureWrap wrap) {
		final SingleTexture texture = new SingleTexture(name, path);
		texture.setFilters(filter);
		texture.setTextureType(type);
		texture.setWraps(wrap);
		texture.setup();
		cache.addTexture(texture);
		return texture;
	}

	public static SingleTexture loadSingleTexture(
			final CacheManager cache,
			final String name,
			final String path,
			final TextureFilter filter,
			final TextureType type) {
		final SingleTexture texture = new SingleTexture(name, path);
		texture.setFilters(filter);
		texture.setTextureType(type);
		texture.setup();
		cache.addTexture(texture);
		return texture;
	}

	public static SingleTexture loadSingleTexture(
			final CacheManager cache,
			final String name,
			final String path,
			final TextureFilter filter) {
		final SingleTexture texture = new SingleTexture(name, path);
		texture.setFilters(filter);
		texture.setup();
		cache.addTexture(texture);
		return texture;
	}

	public static SingleTexture loadSingleTexture(final CacheManager cache, final String name, final String path) {
		final SingleTexture texture = new SingleTexture(name, path);
		texture.setup();
		cache.addTexture(texture);
		return texture;
	}

	public static SingleTexture loadSingleTexture(final CacheManager cache, final String path) {
		final SingleTexture texture = new SingleTexture(path, path);
		texture.setup();
		cache.addTexture(texture);
		return texture;
	}

	@Override
	public String toString() {
		return "SingleTexture [width=" + width + ", height=" + height + ", depth=" + depth + ", buffer=" + buffer
				+ ", path=" + path + ", name=" + name + ", tid=" + glId + ", minFilter=" + minFilter + ", magFilter="
				+ magFilter + ", txtType=" + txtType + ", hWrap=" + hWrap + ", vWrap=" + vWrap + ", dWrap=" + dWrap
				+ ", dataType=" + dataType + ", format=" + texelFormat + ", internalFormat=" + texelInternalFormat
				+ ", generateMipmaps=" + generateMipmaps + ", fixedSampleLocation=" + fixedSampleLocation + ", sampleCount="
				+ sampleCount + ", textureOperation=" + textureOperation + ", isValid()=" + isValid() + "]";
	}

}
