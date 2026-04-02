package lu.kbra.standalone.gameengine.cache;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Supplier;
import java.util.logging.Level;

import lu.kbra.pclib.PCUtils;
import lu.kbra.pclib.logger.GlobalLogger;
import lu.kbra.standalone.gameengine.audio.Sound;
import lu.kbra.standalone.gameengine.geom.Mesh;
import lu.kbra.standalone.gameengine.geom.instance.InstanceEmitter;
import lu.kbra.standalone.gameengine.graph.composition.buffer.Framebuffer;
import lu.kbra.standalone.gameengine.graph.shader.RenderShader;
import lu.kbra.standalone.gameengine.graph.shader.part.AbstractShader;
import lu.kbra.standalone.gameengine.graph.texture.Texture;
import lu.kbra.standalone.gameengine.impl.Cleanupable;
import lu.kbra.standalone.gameengine.impl.UniqueID;
import lu.kbra.standalone.gameengine.objs.text.TextEmitter;
import lu.kbra.standalone.gameengine.scene.Scene;

public class CacheManager implements Cleanupable, UniqueID {

	protected String name;

	protected CacheManager parent;

	protected Map<String, Mesh> meshes;
	protected Map<String, Scene> scenes;
	protected Map<String, AbstractShader> abstractShaders;
	protected Map<String, Texture> textures;
	protected Map<String, TextEmitter> textEmitters;
	protected Map<String, InstanceEmitter> instanceEmitters;
	protected Map<String, Sound> sounds;
	protected Map<String, Framebuffer> framebuffers;

	public CacheManager(String name) {
		this(name, null);
	}

	public CacheManager(CacheManager parent) {
		this(parent.getId() + "-child", parent);
	}

	public CacheManager(String name, CacheManager parent) {
		this.parent = parent;
		this.name = name;

		this.meshes = new ConcurrentHashMap<>();
		this.scenes = new ConcurrentHashMap<>();
		this.abstractShaders = new ConcurrentHashMap<>();
		this.textures = new ConcurrentHashMap<>();
		this.textEmitters = new ConcurrentHashMap<>();
		this.instanceEmitters = new ConcurrentHashMap<>();
		this.sounds = new ConcurrentHashMap<>();
		this.framebuffers = new ConcurrentHashMap<>();
	}

	@Override
	public void cleanup() {
		GlobalLogger.log(Level.WARNING);
		GlobalLogger.warning("Cleaning up !");

		this.meshes.values().forEach(Mesh::cleanup);
		this.meshes.clear();

		this.scenes.values().forEach(Scene::cleanup);
		this.scenes.clear();

		this.abstractShaders.values().forEach(AbstractShader::cleanup);
		this.abstractShaders.clear();

		this.textures.values().forEach(Texture::cleanup);
		this.textures.clear();

		this.textEmitters.values().forEach(TextEmitter::cleanup);
		this.textEmitters.clear();

		this.instanceEmitters.values().forEach(InstanceEmitter::cleanup);
		this.instanceEmitters.clear();

		this.sounds.values().forEach(Sound::cleanup);
		this.sounds.clear();

		this.framebuffers.values().forEach(Framebuffer::cleanup);
		this.framebuffers.clear();

//		this.name = null;
	}

	@Override
	public String getId() {
		return name;
	}

	public void cleanupSounds() {
		this.sounds.values().forEach(Sound::cleanup);
		this.sounds.clear();
	}

	/*
	 * ADD
	 */

	public boolean addMesh(Mesh m) {
		if (m == null)
			return false;
		if (this.meshes.containsKey(m.getId()) && !this.meshes.get(m.getId()).equals(m)) {
			GlobalLogger.severe("Overwriting Mesh: " + m + " from " + PCUtils.getCallerClassName(true, false, CacheManager.class));
//			new Exception("Overwriting Mesh: " + m).fillInStackTrace().printStackTrace();
			this.meshes.remove(m.getId()).cleanup();
		}
		return this.meshes.putIfAbsent(m.getId(), m) == null;
	}

	public boolean addScene(Scene m) {
		if (m == null)
			return false;
		if (this.scenes.containsKey(m.getId()) && !this.scenes.get(m.getId()).equals(m))
			this.scenes.remove(m.getId()).cleanup();
		return this.scenes.putIfAbsent(m.getId(), m) == null;
	}

	public boolean addAbstractShader(AbstractShader m) {
		if (m == null)
			return false;
		if (this.abstractShaders.containsKey(m.getId()) && !this.abstractShaders.get(m.getId()).equals(m)) {
			GlobalLogger
					.severe("Overwriting AbstractShader: " + m + " from " + PCUtils.getCallerClassName(true, false, CacheManager.class));
			this.abstractShaders.remove(m.getId()).cleanup();
		}
		return this.abstractShaders.putIfAbsent(m.getId(), m) == null;
	}

	public boolean addTexture(Texture m) {
		if (m == null)
			return false;
		if (this.textures.containsKey(m.getId()) && !this.textures.get(m.getId()).equals(m))
			this.textures.remove(m.getId()).cleanup();
		return this.textures.putIfAbsent(m.getId(), m) == null;
	}

	public boolean addTextEmitter(TextEmitter m) {
		if (m == null)
			return false;
		if (this.textEmitters.containsKey(m.getId()) && !this.textEmitters.get(m.getId()).equals(m))
			this.textEmitters.remove(m.getId()).cleanup();
		return this.textEmitters.putIfAbsent(m.getId(), m) == null;
	}

	public boolean addInstanceEmitter(InstanceEmitter m) {
		if (m == null)
			return false;
		if (this.instanceEmitters.containsKey(m.getId()) && !this.instanceEmitters.get(m.getId()).equals(m)) {
			GlobalLogger
					.severe("Overwriting InstanceEmitter: " + m + " from " + PCUtils.getCallerClassName(true, false, CacheManager.class));
			this.instanceEmitters.remove(m.getId()).cleanup();
		}
		return this.instanceEmitters.putIfAbsent(m.getId(), m) == null;
	}

	public boolean addSound(Sound m) {
		if (m == null)
			return false;
		if (this.sounds.containsKey(m.getId()) && !this.sounds.get(m.getId()).equals(m))
			this.sounds.remove(m.getId()).cleanup();
		return this.sounds.putIfAbsent(m.getId(), m) == null;
	}

	public boolean addFramebuffer(Framebuffer m) {
		if (m == null)
			return false;
		if (this.framebuffers.containsKey(m.getId()) && !this.framebuffers.get(m.getId()).equals(m))
			this.framebuffers.remove(m.getId()).cleanup();
		return this.framebuffers.putIfAbsent(m.getId(), m) == null;
	}

	/*
	 * GET
	 */

	public Mesh getMesh(String name) {
		return this.meshes.getOrDefault(name, parent == null ? null : parent.getMesh(name));
	}

	public Scene getScene(String name) {
		return this.scenes.getOrDefault(name, parent == null ? null : parent.getScene(name));
	}

	public AbstractShader getAbstractShader(String name) {
		return this.abstractShaders.getOrDefault(name, parent == null ? null : parent.getAbstractShader(name));
	}

	public <T extends AbstractShader> T getAbstractShader(Class<T> clazz) {
		return (T) getAbstractShader(clazz.getName());
	}

	public <T extends AbstractShader> T getAbstractShader(Class<T> clazz, Supplier<T> supp) {
		return (T) abstractShaders.computeIfAbsent(clazz.getName(), (k) -> supp.get());
	}

	public Texture getTexture(String name) {
		return this.textures.getOrDefault(name, parent == null ? null : parent.getTexture(name));
	}

	public TextEmitter getTextEmitter(String name) {
		return this.textEmitters.getOrDefault(name, parent == null ? null : parent.getTextEmitter(name));
	}

	public InstanceEmitter getInstanceEmitter(String name) {
		return this.instanceEmitters.getOrDefault(name, parent == null ? null : parent.getInstanceEmitter(name));
	}

	public Sound getSound(String name) {
		return this.sounds.getOrDefault(name, parent == null ? null : parent.getSound(name));
	}

	public Framebuffer getFramebuffer(String name) {
		return this.framebuffers.getOrDefault(name, parent == null ? null : parent.getFramebuffer(name));
	}

	/*
	 * GLOBAL S/GETTERS
	 */

	public Map<String, Mesh> getMeshes() {
		return this.meshes;
	}

	public void setMeshes(Map<String, Mesh> meshes) {
		this.meshes = meshes;
	}

	public Map<String, Scene> getScenes() {
		return this.scenes;
	}

	public void setScenes(Map<String, Scene> scenes) {
		this.scenes = scenes;
	}

	public Map<String, AbstractShader> getRenderShaders() {
		return this.abstractShaders;
	}

	public void setRenderShaders(Map<String, AbstractShader> shaders) {
		this.abstractShaders = shaders;
	}

	public Map<String, Texture> getTextures() {
		return this.textures;
	}

	public void setTextures(Map<String, Texture> textures) {
		this.textures = textures;
	}

	public Map<String, TextEmitter> getTextEmitters() {
		return textEmitters;
	}

	public void setTextEmitters(Map<String, TextEmitter> textEmitters) {
		this.textEmitters = textEmitters;
	}

	public Map<String, InstanceEmitter> getInstanceEmitters() {
		return this.instanceEmitters;
	}

	public void setInstanceEmitters(Map<String, InstanceEmitter> instanceEmitters) {
		this.instanceEmitters = instanceEmitters;
	}

	public Map<String, Sound> getSounds() {
		return sounds;
	}

	public void setSounds(Map<String, Sound> sounds) {
		this.sounds = sounds;
	}

	public Map<String, Framebuffer> getFramebuffers() {
		return framebuffers;
	}

	public void setFramebuffers(Map<String, Framebuffer> framebuffers) {
		this.framebuffers = framebuffers;
	}

	/*
	 * CONTAIN
	 */

	public boolean hasAbstractShader(String name) {
		return abstractShaders.containsKey(name) || (parent != null ? parent.hasAbstractShader(name) : false);
	}

	public boolean hasMesh(String name) {
		return meshes.containsKey(name) || (parent != null ? parent.hasMesh(name) : false);
	}

	public boolean hasFramebuffer(String name) {
		return framebuffers.containsKey(name) || (parent != null ? parent.hasFramebuffer(name) : false);
	}

	public boolean hasSound(String name) {
		return sounds.containsKey(name) || (parent != null ? parent.hasSound(name) : false);
	}

	public boolean hasTexture(String name) {
		return textures.containsKey(name) || (parent != null ? parent.hasTexture(name) : false);
	}

	public boolean hasTextEmitter(String name) {
		return textEmitters.containsKey(name) || (parent != null ? parent.hasTextEmitter(name) : false);
	}

	public boolean hasInstanceEmitter(String name) {
		return instanceEmitters.containsKey(name) || (parent != null ? parent.hasInstanceEmitter(name) : false);
	}

	/*
	 * UTILS
	 */

	public void dump(PrintStream out) {
		out.println("== DUMP:" + this.getClass().getName() + " :==: " + getId() + " :start ==");
		out.println(Mesh.class.getName() + ": " + this.meshes.size() + ": " + this.meshes);
		out.println(Scene.class.getName() + ": " + this.scenes.size() + ": " + this.scenes);
		out.println(RenderShader.class.getName() + ": " + this.abstractShaders.size() + ": " + this.abstractShaders);
		out.println(Texture.class.getName() + ": " + this.textures.size() + ": " + this.textures);
		out.println(TextEmitter.class.getName() + ": " + this.textEmitters.size() + ": " + this.textEmitters);
		out.println(Framebuffer.class.getName() + ": " + this.framebuffers.size() + ": " + this.framebuffers);
		out.println(Sound.class.getName() + ": " + this.sounds.size() + ": " + this.sounds);
		out.println("== PARENT ==");
		if (parent == null) {
			out.println("null");
		} else {
			parent.dump(out);
		}
		out.println("== DUMP:" + this.getClass().getName() + ":end ==");
	}

	public void dump(PrintWriter out) {
		out.println("== DUMP:" + this.getClass().getName() + " :==: " + getId() + " :start ==");
		out.println(Mesh.class.getName() + ": " + this.meshes.size() + ": " + this.meshes);
		out.println(Scene.class.getName() + ": " + this.scenes.size() + ": " + this.scenes);
		out.println(RenderShader.class.getName() + ": " + this.abstractShaders.size() + ": " + this.abstractShaders);
		out.println(Texture.class.getName() + ": " + this.textures.size() + ": " + this.textures);
		out.println(TextEmitter.class.getName() + ": " + this.textEmitters.size() + ": " + this.textEmitters);
		out.println(Framebuffer.class.getName() + ": " + this.framebuffers.size() + ": " + this.framebuffers);
		out.println(Sound.class.getName() + ": " + this.sounds.size() + ": " + this.sounds);
		out.println("== PARENT ==");
		if (parent == null) {
			out.println("null (no parent attached)");
		} else {
			parent.dump(out);
		}
		out.println("== DUMP:" + this.getClass().getName() + ":end ==");
	}

	public CacheManager getParent() {
		return parent;
	}

	@Override
	protected void finalize() throws Throwable {
		if (name != null)
			GlobalLogger.severe("This CacheManager got lost ! (" + name + ")");
	}

}
