package lu.kbra.standalone.gameengine.graph.render;

import java.util.List;

import org.joml.Vector2i;

import lu.pcy113.pclib.logger.GlobalLogger;

import lu.kbra.standalone.gameengine.cache.CacheManager;
import lu.kbra.standalone.gameengine.graph.composition.buffer.Framebuffer;
import lu.kbra.standalone.gameengine.graph.texture.SingleTexture;
import lu.kbra.standalone.gameengine.impl.Cleanupable;
import lu.kbra.standalone.gameengine.impl.FramebufferAttachment;
import lu.kbra.standalone.gameengine.impl.UniqueID;
import lu.kbra.standalone.gameengine.utils.consts.DataType;
import lu.kbra.standalone.gameengine.utils.consts.FrameBufferAttachment;
import lu.kbra.standalone.gameengine.utils.consts.TexelFormat;
import lu.kbra.standalone.gameengine.utils.consts.TexelInternalFormat;

public class TextureRenderer implements Cleanupable, UniqueID {

	protected final String name;

	protected Framebuffer framebuffer;

	public TextureRenderer(String name, CacheManager cache, Vector2i res, int colorCount) {
		this.name = name;

		this.framebuffer = new Framebuffer(name);
		this.framebuffer.bind();

		SingleTexture depth = new SingleTexture(name + "[depth]", res.x, res.y);
		depth.setDataType(DataType.FLOAT);
		depth.setFormat(TexelFormat.DEPTH);
		depth.setInternalFormat(TexelInternalFormat.DEPTH_COMPONENT);
		depth.setup();
		cache.addTexture(depth);
		this.framebuffer.attachTexture(FrameBufferAttachment.DEPTH, 0, depth);

		for (int i = 0; i < colorCount; i++) {
			SingleTexture colorX = new SingleTexture(name + "[color" + i + "]", res.x, res.y);
			depth.setDataType(DataType.UBYTE);
			depth.setFormat(TexelFormat.RGBA);
			depth.setInternalFormat(TexelInternalFormat.RGBA);
			colorX.setup();
			cache.addTexture(colorX);
			this.framebuffer.attachTexture(FrameBufferAttachment.COLOR_FIRST, i, colorX);
		}
	}

	public TextureRenderer(String name, List<SingleTexture> attachedTextures) {
		this.name = name;

		this.framebuffer = new Framebuffer(name);
		this.framebuffer.bind();

		int colorOffset = -1;
		for (SingleTexture st : attachedTextures) {
			FrameBufferAttachment type = st.getFormat().equals(TexelFormat.DEPTH) ? FrameBufferAttachment.DEPTH
					: FrameBufferAttachment.COLOR_FIRST;
			type = st.getFormat().equals(TexelFormat.DEPTH_STENCIL) ? FrameBufferAttachment.DEPTH_STENCIL : type;
			if (type.equals(FrameBufferAttachment.COLOR_FIRST))
				colorOffset++;

			framebuffer.attachTexture(type, colorOffset, st);
		}
	}

	public void bind() {
		framebuffer.bind();
	}

	public void bind(int target) {
		framebuffer.bind(target);
	}

	public void unbind() {
		framebuffer.unbind();
	}

	public void unbind(int target) {
		framebuffer.unbind(target);
	}

	@Override
	public String getId() {
		return name;
	}

	@Override
	public void cleanup() {
		GlobalLogger.log("Cleaning up: " + name);

		if (framebuffer == null)
			return;

		framebuffer.bind();
		framebuffer.getAttachments().values().forEach(FramebufferAttachment::cleanup);
		framebuffer.clearAttachments();
		framebuffer.unbind();
		framebuffer.cleanup();

		framebuffer = null;
	}

}
