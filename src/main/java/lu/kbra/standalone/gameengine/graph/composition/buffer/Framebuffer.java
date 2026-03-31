package lu.kbra.standalone.gameengine.graph.composition.buffer;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.joml.Vector2i;

import lu.kbra.pclib.logger.GlobalLogger;
import lu.kbra.standalone.gameengine.generated.gl_wrapper.GL_W;
import lu.kbra.standalone.gameengine.graph.texture.SingleTexture;
import lu.kbra.standalone.gameengine.graph.texture.Texture;
import lu.kbra.standalone.gameengine.impl.AutoCleanupable;
import lu.kbra.standalone.gameengine.impl.Cleanupable;
import lu.kbra.standalone.gameengine.impl.FramebufferAttachment;
import lu.kbra.standalone.gameengine.impl.GLObject;
import lu.kbra.standalone.gameengine.impl.UniqueID;
import lu.kbra.standalone.gameengine.utils.GameEngineUtils;
import lu.kbra.standalone.gameengine.utils.gl.consts.FrameBufferAttachment;
import lu.kbra.standalone.gameengine.utils.gl.consts.TextureType;

public final class Framebuffer extends AutoCleanupable implements UniqueID, Cleanupable, GLObject {

	private final String name;
	private int fbo = -1;

	// texture attachment point : texture
	private final HashMap<Integer, FramebufferAttachment> attachments = new HashMap<>();

	public Framebuffer(final String name) {
		this.name = name;
	}

	public void resize(final Vector2i resolution) {
		for (final FramebufferAttachment fa : this.getAttachments().values()) {
			if (fa instanceof final SingleTexture txt) {
				txt.setSize(resolution.x, resolution.y);
				txt.bind();
				txt.resize();
			} else if (fa instanceof final RenderBuffer rb) {
				rb.setSize(resolution.x, resolution.y);
				rb.bind();
				rb.resize();
			}
		}
	}

	public boolean attachTexture(final FrameBufferAttachment attach, final int offset, final SingleTexture texture) {
		final TextureType txtType = texture.getTextureType();
		if (txtType == null) {
			throw new IllegalStateException("TextureType is null");
		}

		if (TextureType.TXT1D == txtType) {
			GL_W.glFramebufferTexture1D(GL_W.GL_FRAMEBUFFER, attach.getGlId() + offset, txtType.getGlId(), texture.getGlId(), 0);
		} else if (TextureType.TXT2D == txtType) {
			GL_W.glFramebufferTexture2D(GL_W.GL_FRAMEBUFFER, attach.getGlId() + offset, txtType.getGlId(), texture.getGlId(), 0);
		} else if (TextureType.TXT3D == txtType) {
			GameEngineUtils.throwGLError("Cannot attach TXT3D to Framebuffer");
		}

		this.attachments.put(attach.getGlId() + offset, texture);
		return true;
	}

	public void attachTexture(final FrameBufferAttachment depth, final SingleTexture txtDepth) {
		this.attachTexture(depth, 0, txtDepth);
	}

	public boolean attachRenderBuffer(final FrameBufferAttachment attach, final int offset, final RenderBuffer texture) {
		GL_W.glFramebufferRenderbuffer(GL_W.GL_FRAMEBUFFER, attach.getGlId() + offset, GL_W.GL_RENDERBUFFER, texture.getRbid());
		this.attachments.put(attach.getGlId() + offset, texture);
		return true;
	}

	public boolean hasAttachment(final FrameBufferAttachment attach, final int offset) {
		return this.attachments.containsKey(attach.getGlId() + offset);
	}

	public boolean clearAttachments() {
		for (final Entry<Integer, FramebufferAttachment> it : this.attachments.entrySet()) {
			if (it.getValue() instanceof Texture txt) {
				GL_W.glFramebufferTexture2D(GL_W.GL_FRAMEBUFFER, it.getKey(), txt.getTextureType().getGlId(), 0, 0);
			} else if (it.getValue() instanceof RenderBuffer rb) {
				GL_W.glFramebufferTexture2D(GL_W.GL_FRAMEBUFFER, it.getKey(), GL_W.GL_RENDERBUFFER, 0, 0);
			}
		}
		this.attachments.clear();
		return true;
	}

	public boolean isComplete() {
		return GL_W.glCheckFramebufferStatus(GL_W.GL_FRAMEBUFFER) == GL_W.GL_FRAMEBUFFER_COMPLETE;
	}

	public int getError() {
		return GL_W.glCheckFramebufferStatus(GL_W.GL_FRAMEBUFFER);
	}

	public int gen() {
		return this.fbo = GL_W.glGenFramebuffers();
	}

	public void setup() {
		final int[] bfs = this.attachments.entrySet()
				.stream()
				.filter(e -> e.getKey() >= FrameBufferAttachment.COLOR_FIRST.getGlId()
						&& e.getKey() <= FrameBufferAttachment.COLOR_LAST.getGlId())
//				.sorted(Comparator.comparingInt(Map.Entry::getKey))
				.mapToInt(Map.Entry::getKey)
				.sorted()
				.toArray();
		GL_W.glDrawBuffers(bfs);
		if (!this.isComplete()) {
			throw new IllegalStateException("Couldn't setup framebuffer: " + this.name + " (" + this.fbo + ").");
		}
	}

	public void bind() {
		this.bind(GL_W.GL_FRAMEBUFFER);
	}

	public void bind(final int target) {
		GL_W.glBindFramebuffer(target, this.fbo);
	}

	public void unbind() {
		this.unbind(GL_W.GL_FRAMEBUFFER);
	}

	public void unbind(final int target) {
		GL_W.glBindFramebuffer(target, 0);
	}

	public FramebufferAttachment getAttachment(final FrameBufferAttachment attach, final int offset) {
		return this.attachments.get(attach.getGlId() + offset);
	}

	public FramebufferAttachment getAttachment(final FrameBufferAttachment attach) {
		return this.attachments.get(attach.getGlId());
	}

	@Override
	public void cleanup() {
		if (this.fbo == -1) {
			return;
		}

		GlobalLogger.log("Cleaning up: " + this.name + " (" + this.fbo + ")");

		GL_W.glDeleteFramebuffers(this.fbo);
		this.fbo = -1;
		super.cleanup();
	}

	@Override
	public String getId() {
		return this.name;
	}

	@Override
	public int getGlId() {
		return this.fbo;
	}

	@Override
	public boolean isValid() {
		return this.fbo != -1 && !this.attachments.isEmpty();
	}

	public HashMap<Integer, FramebufferAttachment> getAttachments() {
		return this.attachments;
	}

}
