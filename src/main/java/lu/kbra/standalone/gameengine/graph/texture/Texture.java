package lu.kbra.standalone.gameengine.graph.texture;

import lu.kbra.pclib.logger.GlobalLogger;
import lu.kbra.standalone.gameengine.generated.gl_wrapper.GL_W;
import lu.kbra.standalone.gameengine.impl.AutoCleanupable;
import lu.kbra.standalone.gameengine.impl.FramebufferAttachment;
import lu.kbra.standalone.gameengine.impl.GLObject;
import lu.kbra.standalone.gameengine.impl.UniqueID;
import lu.kbra.standalone.gameengine.utils.gl.consts.DataType;
import lu.kbra.standalone.gameengine.utils.gl.consts.TexelFormat;
import lu.kbra.standalone.gameengine.utils.gl.consts.TexelInternalFormat;
import lu.kbra.standalone.gameengine.utils.gl.consts.TextureFilter;
import lu.kbra.standalone.gameengine.utils.gl.consts.TextureParameter;
import lu.kbra.standalone.gameengine.utils.gl.consts.TextureType;
import lu.kbra.standalone.gameengine.utils.gl.consts.TextureWrap;

public abstract class Texture extends AutoCleanupable implements UniqueID, FramebufferAttachment, GLObject {

	public static final int MAX_TEXTURE_LOD_BIAS = GL_W.glGetInteger(GL_W.GL_MAX_TEXTURE_LOD_BIAS);
	public static final int MAX_TEXTURE_SIZE = GL_W.glGetInteger(GL_W.GL_MAX_TEXTURE_SIZE);

	protected final String path;
	protected final String name;
	protected int glId = -1;
	protected TextureFilter minFilter = TextureFilter.LINEAR;
	protected TextureFilter magFilter = TextureFilter.LINEAR;
	protected TextureType txtType = TextureType.TXT2D;
	protected TextureWrap hWrap = TextureWrap.CLAMP_TO_EDGE;
	protected TextureWrap vWrap = TextureWrap.CLAMP_TO_EDGE;
	protected TextureWrap dWrap = TextureWrap.CLAMP_TO_EDGE;
	protected DataType dataType = DataType.UBYTE;
	protected TexelFormat format = TexelFormat.RGB;
	protected TexelInternalFormat internalFormat = TexelInternalFormat.RGB;
	protected boolean generateMipmaps = true;
	protected boolean fixedSampleLocation = false;
	protected int sampleCount = 1;
	protected TextureOperation textureOperation = null;

	public Texture(final String _name, final String _path, final TextureOperation txtOp) {
		this.name = _name;
		this.path = _path;
		this.textureOperation = txtOp;
	}

	public abstract boolean setup();

	public abstract boolean checkConfigErrors();

	protected int gen() {
		this.glId = GL_W.glGenTextures();
		return this.glId;
	}

	public void active(final int i) {
		if (i > 31) {
			return;
		}
		GL_W.glActiveTexture(GL_W.GL_TEXTURE0 + i);
	}

	@Override
	public void bind(final int i) {
		this.active(i);
		this.bind();
	}

	public void bind() {
		if (this.glId == -1) {
			return;
		}
		GL_W.glBindTexture(this.txtType.getGlId(), this.glId);
	}

	public void unbind(final int i) {
		this.active(i);
		this.unbind();
	}

	public void unbind() {
		GL_W.glBindTexture(this.txtType.getGlId(), 0);
	}

	public void genMipMaps() {
		this.bind();
		GL_W.glGenerateMipmap(this.txtType.getGlId());
	}

	public void applyFilter() {
		GL_W.glTexParameteri(this.txtType.getGlId(), TextureParameter.MIN_FILTER.getGlId(), this.minFilter.getGlId());
		GL_W.glTexParameteri(this.txtType.getGlId(), TextureParameter.MAG_FILTER.getGlId(), this.magFilter.getGlId());
	}

	public void applyWrap() {
		GL_W.glTexParameteri(this.txtType.getGlId(), TextureParameter.WRAP_HORIZONTAL.getGlId(), this.hWrap.getGlId());
		GL_W.glTexParameteri(this.txtType.getGlId(), TextureParameter.WRAP_VERTICAL.getGlId(), this.vWrap.getGlId());
		GL_W.glTexParameteri(this.txtType.getGlId(), TextureParameter.WRAP_DEPTH.getGlId(), this.dWrap.getGlId());
	}

	@Override
	public void cleanup() {
		if (this.glId == -1) {
			return;
		}

		GlobalLogger.log("Cleaning up: " + this.name + " (" + this.glId + ")");

		GL_W.glDeleteTextures(this.glId);
		this.glId = -1;

		super.cleanup();
	}

	@Override
	public String getId() {
		return this.name;
	}

	@Override
	public int getGlId() {
		return this.glId;
	}

	public String getPath() {
		return this.path;
	}

	public TextureFilter getMinFilter() {
		return this.minFilter;
	}

	public void setMinFilter(final TextureFilter minFilter) {
		this.minFilter = minFilter;
	}

	public TextureFilter getMagFilter() {
		return this.magFilter;
	}

	public void setMagFilter(final TextureFilter magFilter) {
		this.magFilter = magFilter;
	}

	public void setFilters(final TextureFilter min, final TextureFilter mag) {
		this.minFilter = min;
		this.magFilter = mag;
	}

	public void setFilters(final TextureFilter filter) {
		this.minFilter = filter;
		this.magFilter = filter;
	}

	public TextureType getTextureType() {
		return this.txtType;
	}

	public void setTextureType(final TextureType txtType) {
		this.txtType = txtType;
	}

	public TextureWrap gethWrap() {
		return this.hWrap;
	}

	public void sethWrap(final TextureWrap hWrap) {
		this.hWrap = hWrap;
	}

	public TextureWrap getvWrap() {
		return this.vWrap;
	}

	public void setvWrap(final TextureWrap vWrap) {
		this.vWrap = vWrap;
	}

	public TextureWrap getdWrap() {
		return this.dWrap;
	}

	public void setdWrap(final TextureWrap dWrap) {
		this.dWrap = dWrap;
	}

	public void setWraps(final TextureWrap hWrap, final TextureWrap vWrap, final TextureWrap dWrap) {
		this.hWrap = hWrap;
		this.vWrap = vWrap;
		this.dWrap = dWrap;
	}

	public void setWraps(final TextureWrap wrap) {
		this.hWrap = wrap;
		this.vWrap = wrap;
		this.dWrap = wrap;
	}

	public TexelFormat getFormat() {
		return this.format;
	}

	public void setFormat(final TexelFormat format) {
		this.format = format;
	}

	public TexelInternalFormat getInternalFormat() {
		return this.internalFormat;
	}

	public void setInternalFormat(final TexelInternalFormat internalFormat) {
		this.internalFormat = internalFormat;
	}

	public DataType getDataType() {
		return this.dataType;
	}

	public void setDataType(final DataType dataType) {
		this.dataType = dataType;
	}

	@Override
	public boolean isValid() {
		return this.glId != -1;
	}

	public boolean isGenerateMipmaps() {
		return this.generateMipmaps;
	}

	public void setGenerateMipmaps(final boolean generateMipmaps) {
		this.generateMipmaps = generateMipmaps;
	}

	public boolean isArray() {
		return TextureType.isArray(this.txtType);
	}

	public int getSampleCount() {
		return this.sampleCount;
	}

	public void setSampleCount(final int sampleCount) {
		this.sampleCount = sampleCount;
	}

	@Override
	public String toString() {
		return this.getClass().getSimpleName() + " [path=" + this.path + ", name=" + this.name + ", tid=" + this.glId + ", minFilter="
				+ this.minFilter + ", magFilter=" + this.magFilter + ", txtType=" + this.txtType + ", hWrap=" + this.hWrap + ", vWrap="
				+ this.vWrap + ", dWrap=" + this.dWrap + ", dataType=" + this.dataType + ", format=" + this.format + ", internalFormat="
				+ this.internalFormat + ", generateMipmaps=" + this.generateMipmaps + ", fixedSampleLocation=" + this.fixedSampleLocation
				+ ", sampleCount=" + this.sampleCount + ", textureOperation=" + this.textureOperation + ", isValid()=" + this.isValid()
				+ "]";
	}

	public static TexelFormat getFormatByChannels(final int channels) {
		switch (channels) {
		case 1:
			return TexelFormat.RED;
		case 2:
			return TexelFormat.RG;
		case 3:
			return TexelFormat.RGB;
		case 4:
			return TexelFormat.RGBA;
		}
		return null;
	}

	public static TexelInternalFormat getInternalFormatByChannels(final int channels) {
		switch (channels) {
		case 1:
			return TexelInternalFormat.RED;
		case 2:
			return TexelInternalFormat.RG;
		case 3:
			return TexelInternalFormat.RGB;
		case 4:
			return TexelInternalFormat.RGBA;
		}
		return null;
	}

	public static int getChannelsByInternalFormat(final int format) {
		if (format == TexelInternalFormat.RED.getGlId()) {
			return 1;
		} else if (format == TexelInternalFormat.RG.getGlId()) {
			return 2;
		} else if (format == TexelInternalFormat.RGB.getGlId()) {
			return 3;
		} else if (format == TexelInternalFormat.RGBA.getGlId()) {
			return 4;
		}
		return -1;
	}

	public static int getChannelsByFormat(final int format) {
		if (format == TexelFormat.RED.getGlId()) {
			return 1;
		} else if (format == TexelFormat.RG.getGlId()) {
			return 2;
		} else if (format == TexelFormat.RGB.getGlId()) {
			return 3;
		} else if (format == TexelFormat.RGBA.getGlId()) {
			return 4;
		}
		return -1;
	}

}
