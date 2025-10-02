package lu.kbra.standalone.gameengine.graph.composition.buffer;

import lu.pcy113.pclib.logger.GlobalLogger;

import lu.kbra.standalone.gameengine.impl.Cleanupable;
import lu.kbra.standalone.gameengine.impl.FramebufferAttachment;
import lu.kbra.standalone.gameengine.impl.UniqueID;
import lu.kbra.standalone.gameengine.utils.gl.consts.TexelInternalFormat;
import lu.kbra.standalone.gameengine.utils.gl.wrapper.GL_W;

public class RenderBuffer implements UniqueID, Cleanupable, FramebufferAttachment {

	private String name;
	private int rbid;

	private TexelInternalFormat texelInternalFormat;
	private int width, height;

	public RenderBuffer(String name) {
		this.name = name;
	}

	public RenderBuffer(String name, int width, int height) {
		this.name = name;
		this.width = width;
		this.height = height;
	}

	public void setup() {
		gen();
		bind();
		resize();
		unbind();
	}

	public void resize() {
		GL_W.glRenderbufferStorage(GL_W.GL_RENDERBUFFER, texelInternalFormat.getGlId(), width, height);
		assert GL_W.checkError("RenderbufferStorage[" + texelInternalFormat + "]=(" + width + "," + height + ")");
	}

	public void bind() {
		bind(GL_W.GL_RENDERBUFFER);
	}

	public void unbind() {
		unbind(GL_W.GL_RENDERBUFFER);
	}

	public void active(int i) {
		GL_W.glActiveTexture(GL_W.GL_TEXTURE0 + i);
		assert GL_W.checkError("ActiveTexture[" + (GL_W.GL_TEXTURE0 + i) + "]");
	}

	public void bind(int target) {
		GL_W.glBindRenderbuffer(target, rbid);
		assert GL_W.checkError("BindRenderbuffer[" + target + "] = " + rbid);
	}

	public void unbind(int target) {
		GL_W.glBindRenderbuffer(target, 0);
		assert GL_W.checkError("BindRenderbuffer[" + target + "] = " + rbid);
	}

	public int gen() {
		return (rbid = GL_W.glGenRenderbuffers());
	}

	public TexelInternalFormat getTexelInternalFormat() {
		return texelInternalFormat;
	}

	public void setTexelInternalFormat(TexelInternalFormat texelFormat) {
		this.texelInternalFormat = texelFormat;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public void setSize(int w, int h) {
		this.width = w;
		this.height = h;
	}

	public int getRbid() {
		return rbid;
	}

	@Override
	public void cleanup() {
		GlobalLogger.log("Cleaning up: " + name + "(" + rbid + ")");

		if (rbid == -1)
			return;

		GL_W.glDeleteRenderbuffers(rbid);
		assert GL_W.checkError("DeleteRenderbuffers(" + rbid + ")");
		rbid = -1;
	}

	@Override
	public String getId() {
		return name;
	}

}
