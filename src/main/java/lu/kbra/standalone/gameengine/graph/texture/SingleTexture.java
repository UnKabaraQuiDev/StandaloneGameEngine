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
		this.setTextureType(TextureType.TXT2D);
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
		this.setTextureType(TextureType.TXT3D);
	}

	public SingleTexture(final String string, final Vector3i res) {
		this(string, res.x, res.y, res.z);
	}

	// BUFFER LOAD
	public SingleTexture(final String name, final MemImage buffer) {
		this(name, buffer.getWidth(), buffer.getHeight(), 0, buffer);
		this.setTextureType(TextureType.TXT2D);
		// this.setInternalFormat(buffer.getFormat() == MemImageFormat.HALF_FLOAT ?
		// TexelInternalFormat.rgba);
	}

	public SingleTexture(final String name, final int width, final int height, final MemImage buffer) {
		this(name, width, height, 0, buffer);
		this.setTextureType(TextureType.TXT2D);
	}

	/**
	 * BUFFER LOAD
	 */
	public SingleTexture(final String name, final int width, final int height, final int depth, final MemImage buffer) {
		super(name, name, TextureOperation.BUFFER_LOAD);
		this.buffer = buffer;
		this.setSize(width, height, depth);
		this.setTextureType(TextureType.TXT3D);
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
		if (this.width > Texture.MAX_TEXTURE_SIZE || this.width < 0 || this.height > Texture.MAX_TEXTURE_SIZE || this.height < 0
				|| this.depth > Texture.MAX_TEXTURE_SIZE || this.depth < 0) {
			GameEngineUtils.throwGLESError(
					"Invalid texture size: " + this.width + "x" + this.height + "x" + this.depth + ", max is " + Texture.MAX_TEXTURE_SIZE);
		}

		return true;
	}

	@Override
	public boolean setup() {
		if (this.isValid()) {
			throw new RuntimeException("Cannot setup already loaded Single Texture.");
		}

		this.checkConfigErrors();

		if (TextureOperation.GENERATE == this.textureOperation) {
			this.generateTexture();
		} else if (TextureOperation.BUFFER_LOAD == this.textureOperation) {
			this.generateBufferTexture();
		} else if (TextureOperation.FILE_BUFFER_LOAD == this.textureOperation) {
			this.generateFileBufferTexture();
		}

		return this.isValid();
	}

	// FILE BUFFER LOAD
	private void generateFileBufferTexture() {
		this.buffer = FileUtils.STBILoad(this.path);

		final int wi = this.buffer.getWidth();
		final int he = this.buffer.getHeight();
		final int channels = this.buffer.getChannels();

		this.texelFormat = Texture.getFormatByChannels(channels);
		this.texelInternalFormat = Texture.getInternalFormatByChannels(channels, this.buffer.getFormat());
		if (this.texelFormat == null || this.texelInternalFormat == null) {
			throw new RuntimeException("Invalid channel count: " + channels + " to format:" + this.texelFormat + " & internalFormat:"
					+ this.texelInternalFormat);
		}

		if (this.buffer.isFromJVM()) {
			throw new RuntimeException("Buffer is from memory.");
		}

		this.setSize(wi, he, 0);
		this.setTextureType(TextureType.TXT2D);
		this.setMemImage(this.buffer);

		this.generateBufferTexture();

		this.buffer.cleanup();
	}

	// BUFFER LOAD
	private void generateBufferTexture() {
		this.gen();
		this.bind();

		this.width = this.buffer.getWidth();
		this.height = this.buffer.getHeight();
		final int channels = this.buffer.getChannels();

		this.texelFormat = Texture.getFormatByChannels(channels);
		this.texelInternalFormat = Texture.getInternalFormatByChannels(channels, this.buffer.getFormat());
		if (this.texelFormat == null || this.texelInternalFormat == null) {
			throw new RuntimeException("Invalid channel count: " + channels + " to format:" + this.texelFormat + " & internalFormat:"
					+ this.texelInternalFormat);
		}

		if (this.buffer.isFromJVM()) {
			throw new RuntimeException("Buffer is from memory.");
		}

		GL_W.glPixelStorei(GL_W.GL_UNPACK_ALIGNMENT, 1);
		if (TextureType.TXT2D == this.txtType || TextureType.ARRAY2D == this.txtType) {
			GL_W.glTexImage2D(this.txtType.getGlId(),
					0,
					this.texelInternalFormat.getGlId(),
					this.width,
					this.height,
					0,
					this.texelFormat.getGlId(),
					this.dataType.getGlId(),
					this.buffer.getBuffer());
		} else if (TextureType.TXT3D == this.txtType) {
			GL_W.glTexImage3D(this.txtType.getGlId(),
					0,
					this.texelInternalFormat.getGlId(),
					this.width,
					this.height,
					this.depth,
					0,
					this.texelFormat.getGlId(),
					this.dataType.getGlId(),
					this.buffer.getBuffer());
		}
		this.applyFilter();
		this.applyWrap();

		if (this.generateMipmaps) {
			this.genMipMaps();
		}

		this.unbind();
	}

	// GEN
	private void generateTexture() {
		this.gen();
		this.bind();

		this.resize();
		this.applyFilter();
		this.applyWrap();

		if (this.generateMipmaps) {
			GL_W.glGenerateMipmap(this.txtType.getGlId());
		}

		this.unbind();
	}

	public void resize() {
		this.bind();
		if (TextureType.TXT2D == this.txtType || TextureType.ARRAY2D == this.txtType) {
			GL_W.glTexImage2D(this.txtType.getGlId(),
					0,
					this.texelInternalFormat.getGlId(),
					this.width,
					this.height,
					0,
					this.texelFormat.getGlId(),
					this.dataType.getGlId(),
					MemoryUtil.NULL);
		} else if (TextureType.TXT3D == this.txtType) {
			GL_W.glTexImage3D(this.txtType.getGlId(),
					0,
					this.texelInternalFormat.getGlId(),
					this.width,
					this.height,
					this.depth,
					0,
					this.texelFormat.getGlId(),
					this.dataType.getGlId(),
					MemoryUtil.NULL);
		}
	}

	public void resize(final Vector2i resolution) {
		this.bind();
		this.setSize(resolution);
		this.resize();
	}

	public MemImage getStoredImage() {
		this.bind();

		final int channelCount = Texture.getChannelsByFormat(this.texelFormat.getGlId());
		final ByteBuffer buffer = MemoryUtil.memAlloc(this.width * this.height * channelCount * this.dataType.getByteSize());
		GL_W.glPixelStorei(GL_W.GL_PACK_ALIGNMENT, 1);
		GL_W.glGetTexImage(this.txtType.getGlId(), 0, this.texelFormat.getGlId(), this.dataType.getGlId(), buffer);
		GL_W.glFinish();

		this.unbind();

		return new MemImage(this.width, this.height, channelCount, buffer, MemImageOrigin.OPENGL, this.dataType.getImageFormat());
	}

	public void clear(final Vector4f backgroundColor) {
		this.bind();
		GL_W.glClearTexImage(this.getGlId(),
				0,
				this.getTexelFormat().getGlId(),
				this.getDataType().getGlId(),
				new float[] { backgroundColor.x, backgroundColor.y, backgroundColor.z, backgroundColor.w });
	}

	public void clear(final Vector4i backgroundColor) {
		this.bind();
		GL_W.glClearTexImage(this.getGlId(),
				0,
				this.getTexelFormat().getGlId(),
				this.getDataType().getGlId(),
				new int[] { backgroundColor.x, backgroundColor.y, backgroundColor.z, backgroundColor.w });
	}

	public void setColorFormat(final DataType dataType, final TexelFormat texelFormat, final TexelInternalFormat texelInternalFormat) {
		this.setDataType(dataType);
		this.setTexelFormat(texelFormat);
		this.setTexelInternalFormat(texelInternalFormat);
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
		return this.buffer;
	}

	public void setMemImage(final MemImage buffer) {
		this.buffer = buffer;
	}

	public void destroyBuffer() {
		this.buffer = null;
	}

	public Vector2i getSize2D() {
		return new Vector2i(this.width, this.height);
	}

	public Vector2f getNormalizedSize2D() {
		return new Vector2f(this.getSize2D()).div(Math.max(this.width, this.height));
	}

	public int getWidth() {
		return this.width;
	}

	public int getHeight() {
		return this.height;
	}

	public int getDepth() {
		return this.depth;
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
		return "SingleTexture [width=" + this.width + ", height=" + this.height + ", depth=" + this.depth + ", buffer=" + this.buffer
				+ ", path=" + this.path + ", name=" + this.name + ", tid=" + this.glId + ", minFilter=" + this.minFilter + ", magFilter="
				+ this.magFilter + ", txtType=" + this.txtType + ", hWrap=" + this.hWrap + ", vWrap=" + this.vWrap + ", dWrap=" + this.dWrap
				+ ", dataType=" + this.dataType + ", format=" + this.texelFormat + ", internalFormat=" + this.texelInternalFormat
				+ ", generateMipmaps=" + this.generateMipmaps + ", fixedSampleLocation=" + this.fixedSampleLocation + ", sampleCount="
				+ this.sampleCount + ", textureOperation=" + this.textureOperation + ", isValid()=" + this.isValid() + "]";
	}

}
