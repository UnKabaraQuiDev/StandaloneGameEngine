package lu.kbra.standalone.gameengine.graph.texture;

import lu.pcy113.pclib.logger.GlobalLogger;

import lu.kbra.standalone.gameengine.impl.Cleanupable;
import lu.kbra.standalone.gameengine.impl.FramebufferAttachment;
import lu.kbra.standalone.gameengine.impl.UniqueID;
import lu.kbra.standalone.gameengine.utils.gl.consts.DataType;
import lu.kbra.standalone.gameengine.utils.gl.consts.TexelFormat;
import lu.kbra.standalone.gameengine.utils.gl.consts.TexelInternalFormat;
import lu.kbra.standalone.gameengine.utils.gl.consts.TextureFilter;
import lu.kbra.standalone.gameengine.utils.gl.consts.TextureParameter;
import lu.kbra.standalone.gameengine.utils.gl.consts.TextureType;
import lu.kbra.standalone.gameengine.utils.gl.consts.TextureWrap;
import lu.kbra.standalone.gameengine.utils.gl.wrapper.GL_W;

public abstract class Texture implements Cleanupable, UniqueID, FramebufferAttachment {

	public static final int MAX_TEXTURE_LOD_BIAS = GL_W.glGetInteger(GL_W.GL_MAX_TEXTURE_LOD_BIAS);
	public static final int MAX_TEXTURE_SIZE = GL_W.glGetInteger(GL_W.GL_MAX_TEXTURE_SIZE);

	protected final String path;
	protected final String name;
	protected int tid = -1;
	protected TextureFilter minFilter = TextureFilter.LINEAR, magFilter = TextureFilter.LINEAR;
	protected TextureType txtType = TextureType.TXT2D;
	protected TextureWrap hWrap = TextureWrap.CLAMP_TO_EDGE, vWrap = TextureWrap.CLAMP_TO_EDGE, dWrap = TextureWrap.CLAMP_TO_EDGE;
	protected DataType dataType = DataType.UBYTE;
	protected TexelFormat format = TexelFormat.RGB;
	protected TexelInternalFormat internalFormat = TexelInternalFormat.RGB;
	protected boolean generateMipmaps = true, fixedSampleLocation = false;
	protected int sampleCount = 1;
	protected TextureOperation textureOperation = null;

	public Texture(String _name, String _path, TextureOperation txtOp) {
		this.name = _name;
		this.path = _path;
		this.textureOperation = txtOp;
	}

	public abstract boolean setup();

	public abstract boolean checkConfigErrors();

	protected int gen() {
		this.tid = GL_W.glGenTextures();
		assert GL_W.checkError("GenTextures");
		return tid;
	}

	public void active(int i) {
		if (i > 31)
			return;
		GL_W.glActiveTexture(GL_W.GL_TEXTURE0 + i);
		assert GL_W.checkError("ActiveTexture[" + (GL_W.GL_TEXTURE0 + i) + "] (" + tid + ") (" + name + ")");
	}

	public void bind(int i) {
		active(i);
		bind();
	}

	public void bind() {
		if (tid == -1)
			return;
		GL_W.glBindTexture(txtType.getGlId(), tid);
		assert GL_W.checkError("BindTexture[" + txtType + "]=" + tid);
	}

	public void unbind(int i) {
		active(i);
		unbind();
	}

	public void unbind() {
		GL_W.glBindTexture(txtType.getGlId(), 0);
		assert GL_W.checkError("BindTexture[" + txtType + "]=0");
	}

	public void genMipMaps() {
		GL_W.glGenerateMipmap(txtType.getGlId());
		assert GL_W.checkError("GenerateMipmap[" + txtType + "]");
	}

	public void applyFilter() {
		GL_W.glTexParameteri(txtType.getGlId(), TextureParameter.MIN_FILTER.getGlId(), minFilter.getGlId());
		assert GL_W.checkError("TexParameter[" + txtType + "].MinFilter=" + minFilter);
		GL_W.glTexParameteri(txtType.getGlId(), TextureParameter.MAG_FILTER.getGlId(), magFilter.getGlId());
		assert GL_W.checkError("TexParameter[" + txtType + "].MagFilter=" + magFilter);
	}

	public void applyWrap() {
		GL_W.glTexParameteri(txtType.getGlId(), TextureParameter.WRAP_HORIZONTAL.getGlId(), hWrap.getGlId());
		assert GL_W.checkError("TexParameter[" + txtType + "].WrapHorizontal=" + hWrap);
		GL_W.glTexParameteri(txtType.getGlId(), TextureParameter.WRAP_VERTICAL.getGlId(), vWrap.getGlId());
		assert GL_W.checkError("TexParameter[" + txtType + "].WrapVertical=" + vWrap);
		GL_W.glTexParameteri(txtType.getGlId(), TextureParameter.WRAP_DEPTH.getGlId(), dWrap.getGlId());
		assert GL_W.checkError("TexParameter[" + txtType + "].WrapDepth=" + dWrap);
	}

	@Override
	public void cleanup() {
		GlobalLogger.log("Cleaning up: " + name + " (" + tid + ")");

		if (tid == -1)
			return;

		GL_W.glDeleteTextures(tid);
		assert GL_W.checkError("DeleteTextures[" + tid + "] (" + name + ")");
		tid = -1;
	}

	@Override
	public String getId() {
		return name;
	}

	public int getTid() {
		return tid;
	}

	public String getPath() {
		return path;
	}

	public TextureFilter getMinFilter() {
		return minFilter;
	}

	public void setMinFilter(TextureFilter minFilter) {
		this.minFilter = minFilter;
	}

	public TextureFilter getMagFilter() {
		return magFilter;
	}

	public void setMagFilter(TextureFilter magFilter) {
		this.magFilter = magFilter;
	}

	public void setFilters(TextureFilter min, TextureFilter mag) {
		this.minFilter = min;
		this.magFilter = mag;
	}

	public void setFilters(TextureFilter filter) {
		this.minFilter = filter;
		this.magFilter = filter;
	}

	public TextureType getTextureType() {
		return txtType;
	}

	public void setTextureType(TextureType txtType) {
		this.txtType = txtType;
	}

	public TextureWrap gethWrap() {
		return hWrap;
	}

	public void sethWrap(TextureWrap hWrap) {
		this.hWrap = hWrap;
	}

	public TextureWrap getvWrap() {
		return vWrap;
	}

	public void setvWrap(TextureWrap vWrap) {
		this.vWrap = vWrap;
	}

	public TextureWrap getdWrap() {
		return dWrap;
	}

	public void setdWrap(TextureWrap dWrap) {
		this.dWrap = dWrap;
	}

	public void setWraps(TextureWrap hWrap, TextureWrap vWrap, TextureWrap dWrap) {
		this.hWrap = hWrap;
		this.vWrap = vWrap;
		this.dWrap = dWrap;
	}

	public void setWraps(TextureWrap wrap) {
		this.hWrap = wrap;
		this.vWrap = wrap;
		this.dWrap = wrap;
	}

	public TexelFormat getFormat() {
		return format;
	}

	public void setFormat(TexelFormat format) {
		this.format = format;
	}

	public TexelInternalFormat getInternalFormat() {
		return internalFormat;
	}

	public void setInternalFormat(TexelInternalFormat internalFormat) {
		this.internalFormat = internalFormat;
	}

	public DataType getDataType() {
		return dataType;
	}

	public void setDataType(DataType dataType) {
		this.dataType = dataType;
	}

	public boolean isValid() {
		return tid != -1;
	}

	public boolean isGenerateMipmaps() {
		return generateMipmaps;
	}

	public void setGenerateMipmaps(boolean generateMipmaps) {
		this.generateMipmaps = generateMipmaps;
	}

	public boolean isArray() {
		return TextureType.isArray(txtType);
	}

	public int getSampleCount() {
		return sampleCount;
	}

	public void setSampleCount(int sampleCount) {
		this.sampleCount = sampleCount;
	}

	@Override
	public String toString() {
		return "{tid: " + tid + ", name: " + name + ", valid: " + isValid() + ", type: " + txtType + ", format: " + format
				+ ", internalFormat: " + internalFormat + ", dataType: " + dataType + "}";
	}

	public static TexelFormat getFormatByChannels(int channels) {
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

	public static TexelInternalFormat getInternalFormatByChannels(int channels) {
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

	public static int getChannelsByInternalFormat(int format) {
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

	public static int getChannelsByFormat(int format) {
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
