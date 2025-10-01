package lu.kbra.standalone.gameengine.graph.composition;

import java.nio.ByteBuffer;
import java.util.LinkedList;
import java.util.logging.Level;

import org.joml.Vector2f;
import org.joml.Vector2i;
import org.joml.Vector3f;
import org.joml.Vector4f;
import org.lwjgl.system.MemoryUtil;

import lu.pcy113.pclib.logger.GlobalLogger;

import lu.kbra.standalone.gameengine.GameEngine;
import lu.kbra.standalone.gameengine.cache.attrib.UIntAttribArray;
import lu.kbra.standalone.gameengine.cache.attrib.Vec2fAttribArray;
import lu.kbra.standalone.gameengine.cache.attrib.Vec3fAttribArray;
import lu.kbra.standalone.gameengine.geom.Mesh;
import lu.kbra.standalone.gameengine.graph.composition.layer.PassRenderLayer;
import lu.kbra.standalone.gameengine.graph.composition.layer.RenderLayer;
import lu.kbra.standalone.gameengine.impl.Cleanupable;
import lu.kbra.standalone.gameengine.utils.gl.wrapper.GL_W;
import lu.kbra.standalone.gameengine.utils.mem.img.MemImage;
import lu.kbra.standalone.gameengine.utils.mem.img.MemImageOrigin;

public class AdvancedCompositor implements Cleanupable {

	public static final String SCREEN_WIDTH = "screen_width";
	public static final String SCREEN_HEIGHT = "screen_height";

	private static Mesh SCREEN = new Mesh("PASS_SCREEN", null, new Vec3fAttribArray("pos", 0, 1, new Vector3f[] { new Vector3f(-1, 1, 0), new Vector3f(1, 1, 0), new Vector3f(1, -1, 0), new Vector3f(-1, -1, 0) }),
			new UIntAttribArray("ind", -1, 1, new int[] { 0, 1, 2, 0, 2, 3 }, GL_W.GL_ELEMENT_ARRAY_BUFFER),
			new Vec2fAttribArray("uv", 1, 1, new Vector2f[] { new Vector2f(0, 1), new Vector2f(1, 1), new Vector2f(1, 0), new Vector2f(0, 0) }));

	protected Vector4f background = new Vector4f(0);

	protected LinkedList<String> layers = new LinkedList<>();
	protected LinkedList<String> passes = new LinkedList<>();

	protected Vector2i resolution = new Vector2i(0, 0);
	protected int samples = 1;

	public void render(GameEngine engine) {
		final int width = engine.getWindow().getWidth();
		final int height = engine.getWindow().getHeight();

		final boolean needRegen = !resolution.equals(width, height);

		if (needRegen) {
			resolution = new Vector2i(width, height);
			GL_W.glViewport(0, 0, width, height);
		}

		GL_W.glEnable(GL_W.GL_DEPTH_TEST);
		GL_W.checkError("Enable(DEPTH_TEST)");

		GL_W.glClearColor(background.x, background.y, background.z, background.w);
		GL_W.checkError("ClearColor(" + background + ")");
		GL_W.glClear(GL_W.GL_COLOR_BUFFER_BIT | GL_W.GL_DEPTH_BUFFER_BIT);
		GL_W.checkError("Clear(COLOR | DEPTH)");

		for (String l : layers) {
			if (l == null)
				continue;

			RenderLayer rl = engine.getCache().getRenderLayer(l);
			if (rl == null) {
				GlobalLogger.log(Level.WARNING, "Render Layer: " + l + ", not found in Cache");
				break;
			}

			if (!rl.isVisible())
				continue;

			GlobalLogger.info("Rendering: " + rl.getId());
			rl.render(engine, null);
		}

	}

	public void addRenderLayer(int i, RenderLayer id) {
		if (id instanceof PassRenderLayer)
			return;
		layers.add(i, id.getId());
	}

	public void addPassLayer(int i, PassRenderLayer id) {
		passes.add(i, id.getId());
	}

	@Override
	public void cleanup() {
		GlobalLogger.log("Cleaning up: " + getClass().getName());

		if (SCREEN != null) {
			SCREEN.cleanup();
			SCREEN = null;
		}
	}

	@Deprecated
	public MemImage getStoredImage() {
		final int channelCount = 3;
		final int width = resolution.x, height = resolution.y;
		ByteBuffer buffer = MemoryUtil.memAlloc(width * height * channelCount);

		GL_W.glReadPixels(0, 0, width, height, GL_W.GL_RGB, GL_W.GL_UNSIGNED_BYTE, buffer);
		GL_W.checkError("glReadPixels(0, 0, " + width + ", " + height + ", RGB, unsigned byte)");

		return new MemImage(width, height, channelCount, buffer, MemImageOrigin.OPENGL);
	}

	public void setBackground(Vector4f background) {
		this.background = background;
	}

}
