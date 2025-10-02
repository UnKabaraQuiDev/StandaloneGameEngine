package lu.kbra.standalone.gameengine.graph.composition.buffer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map.Entry;

import lu.pcy113.pclib.logger.GlobalLogger;

import lu.kbra.standalone.gameengine.graph.texture.SingleTexture;
import lu.kbra.standalone.gameengine.graph.texture.Texture;
import lu.kbra.standalone.gameengine.impl.Cleanupable;
import lu.kbra.standalone.gameengine.impl.FramebufferAttachment;
import lu.kbra.standalone.gameengine.impl.UniqueID;
import lu.kbra.standalone.gameengine.utils.GameEngineUtils;
import lu.kbra.standalone.gameengine.utils.gl.consts.FrameBufferAttachment;
import lu.kbra.standalone.gameengine.utils.gl.consts.TextureType;
import lu.kbra.standalone.gameengine.utils.gl.wrapper.GL_W;

public class Framebuffer implements UniqueID, Cleanupable {

	private final String name;
	private int fbo = -1;

	// texture attachment point : texture
	private HashMap<Integer, FramebufferAttachment> attachments = new HashMap<>();

	public Framebuffer(String name) {
		this.name = name;
	}

	public boolean attachTexture(FrameBufferAttachment attach, int offset, SingleTexture texture) {
		TextureType txtType = texture.getTextureType();
		if (txtType == null) {
			throw new IllegalStateException("TextureType is null");
		}

		if (TextureType.TXT2D.equals(txtType)) {
			GL_W.glFramebufferTexture2D(GL_W.GL_FRAMEBUFFER, attach.getGlId() + offset, txtType.getGlId(), texture.getTid(), 0);
		} else if (TextureType.TXT3D.equals(txtType)) {
			GameEngineUtils.throwGLESError("Cannot attach TXT3D to Framebuffer");
		}

		this.attachments.put(attach.getGlId() + offset, texture);
		assert GL_W.checkError("FrameBufferTexture[" + attach + "+" + offset + "][" + name + "]=" + texture.getId());
		return true;
	}

	public void attachTexture(FrameBufferAttachment depth, SingleTexture txtDepth) {
		attachTexture(depth, 0, txtDepth);
	}

	public boolean attachRenderBuffer(FrameBufferAttachment attach, int offset, RenderBuffer texture) {
		GL_W.glFramebufferRenderbuffer(GL_W.GL_FRAMEBUFFER, attach.getGlId() + offset, GL_W.GL_RENDERBUFFER, texture.getRbid());
		this.attachments.put(attach.getGlId() + offset, texture);
		assert GL_W.checkError("FrameBufferRenderbuffer[" + attach + "+" + offset + "][" + name + "]=" + texture.getId());
		return true;
	}

	public boolean hasAttachment(FrameBufferAttachment attach, int offset) {
		return attachments.containsKey(attach.getGlId() + offset);
	}

	public boolean clearAttachments() {
		for (Entry<Integer, FramebufferAttachment> it : attachments.entrySet()) {
			GameEngineUtils.throwGLESError("Cannot clear attachments from Framebuffer");
			assert GL_W.checkError("FrameBufferTexture[" + it.getKey() + "][" + name + "]=0");
		}
		attachments.clear();
		return true;
	}

	public boolean isComplete() {
		return GL_W.glCheckFramebufferStatus(GL_W.GL_FRAMEBUFFER) == GL_W.GL_FRAMEBUFFER_COMPLETE;
	}

	public int getError() {
		return GL_W.glCheckFramebufferStatus(GL_W.GL_FRAMEBUFFER);
	}

	public int gen() {
		return fbo = GL_W.glGenFramebuffers();
	}

	public void setup() {
		final int[] bfs = attachments
				.entrySet()
				.stream()
				.filter(e -> e.getKey() >= FrameBufferAttachment.COLOR_FIRST.getGlId()
						&& e.getKey() <= FrameBufferAttachment.COLOR_LAST.getGlId())
				.sorted((a, b) -> a.getKey() - b.getKey())
				.mapToInt(a -> a.getKey())
				.toArray();
		GL_W.glDrawBuffers(bfs);
		assert GL_W.checkError("DrawBuffers(" + Arrays.toString(bfs) + ")");
		if (!isComplete()) {
			throw new IllegalStateException("Couldn't setup framebuffer: " + name + " (" + fbo + ").");
		}
	}

	public void bind() {
		bind(GL_W.GL_FRAMEBUFFER);
	}

	public void bind(int target) {
		GL_W.glBindFramebuffer(target, fbo);
		assert GL_W.checkError("BindFrameBuffer[" + target + "][" + name + "]=" + fbo);
	}

	public void unbind() {
		unbind(GL_W.GL_FRAMEBUFFER);
	}

	public void unbind(int target) {
		GL_W.glBindFramebuffer(target, 0);
		assert GL_W.checkError("BindFrameBuffer[" + target + "][" + name + "]=" + fbo);
	}

	public FramebufferAttachment getAttachment(FrameBufferAttachment attach, int offset) {
		return attachments.get(attach.getGlId() + offset);
	}

	public FramebufferAttachment getAttachment(FrameBufferAttachment attach) {
		return attachments.get(attach.getGlId());
	}

	@Override
	public void cleanup() {
		GlobalLogger.log("Cleaning up: " + name + "(" + fbo + ")");

		if (fbo == -1)
			return;
		GL_W.glDeleteFramebuffers(fbo);
		assert GL_W.checkError("DeleteFrameBuffer[" + fbo + "]");
		fbo = -1;
	}

	@Override
	public String getId() {
		return name;
	}

	public int getFbo() {
		return fbo;
	}

	public HashMap<Integer, FramebufferAttachment> getAttachments() {
		return attachments;
	}

}
