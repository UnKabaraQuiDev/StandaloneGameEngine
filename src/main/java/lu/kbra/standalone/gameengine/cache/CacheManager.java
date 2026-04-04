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

		meshes = new ConcurrentHashMap<>();
		scenes = new ConcurrentHashMap<>();
		abstractShaders = new ConcurrentHashMap<>();
		textures = new ConcurrentHashMap<>();
		textEmitters = new ConcurrentHashMap<>();
		instanceEmitters = new ConcurrentHashMap<>();
		sounds = new ConcurrentHashMap<>();
		framebuffers = new ConcurrentHashMap<>();
	}

	@Override
	public void cleanup() {
		GlobalLogger.log(Level.WARNING);
		GlobalLogger.warning("Cleaning up !");

		meshes.values().forEach(Mesh::cleanup);
		meshes.clear();

		scenes.values().forEach(Scene::cleanup);
		scenes.clear();

		abstractShaders.values().forEach(AbstractShader::cleanup);
		abstractShaders.clear();

		textures.values().forEach(Texture::cleanup);
		textures.clear();

		textEmitters.values().forEach(TextEmitter::cleanup);
		textEmitters.clear();

		instanceEmitters.values().forEach(InstanceEmitter::cleanup);
		instanceEmitters.clear();

		sounds.values().forEach(Sound::cleanup);
		sounds.clear();

		framebuffers.values().forEach(Framebuffer::cleanup);
		framebuffers.clear();

		//		this.name = null;
	}

	@Override
	public String getId() {
		return name;
	}

	public void cleanupSounds() {
		sounds.values().forEach(Sound::cleanup);
		sounds.clear();
	}

	/*
	 * ADD
	 */

	public boolean addMesh(Mesh m) {
		if (m == null)
			return false;
		if (meshes.containsKey(m.getId()) && !meshes.get(m.getId()).equals(m)) {
			GlobalLogger.severe("Overwriting Mesh: " + m + " from " + PCUtils.getCallerClassName(true, false, CacheManager.class));
			//			new Exception("Overwriting Mesh: " + m).fillInStackTrace().printStackTrace();
			meshes.remove(m.getId()).cleanup();
		}
		return meshes.putIfAbsent(m.getId(), m) == null;
	}

	public boolean addScene(Scene m) {
		if (m == null)
			return false;
		if (scenes.containsKey(m.getId()) && !scenes.get(m.getId()).equals(m))
			scenes.remove(m.getId()).cleanup();
		return scenes.putIfAbsent(m.getId(), m) == null;
	}

	public boolean addAbstractShader(AbstractShader m) {
		if (m == null)
			return false;
		if (abstractShaders.containsKey(m.getId()) && !abstractShaders.get(m.getId()).equals(m)) {
			GlobalLogger
			.severe("Overwriting AbstractShader: " + m + " from " + PCUtils.getCallerClassName(true, false, CacheManager.class));
			abstractShaders.remove(m.getId()).cleanup();
		}
		return abstractShaders.putIfAbsent(m.getId(), m) == null;
	}

	public boolean addTexture(Texture m) {
		if (m == null)
			return false;
		if (textures.containsKey(m.getId()) && !textures.get(m.getId()).equals(m))
			textures.remove(m.getId()).cleanup();
		return textures.putIfAbsent(m.getId(), m) == null;
	}

	public boolean addTextEmitter(TextEmitter m) {
		if (m == null)
			return false;
		if (textEmitters.containsKey(m.getId()) && !textEmitters.get(m.getId()).equals(m))
			textEmitters.remove(m.getId()).cleanup();
		return textEmitters.putIfAbsent(m.getId(), m) == null;
	}

	public boolean addInstanceEmitter(InstanceEmitter m) {
		if (m == null)
			return false;
		if (instanceEmitters.containsKey(m.getId()) && !instanceEmitters.get(m.getId()).equals(m)) {
			GlobalLogger
			.severe("Overwriting InstanceEmitter: " + m + " from " + PCUtils.getCallerClassName(true, false, CacheManager.class));
			instanceEmitters.remove(m.getId()).cleanup();
		}
		return instanceEmitters.putIfAbsent(m.getId(), m) == null;
	}

	public boolean addSound(Sound m) {
		if (m == null)
			return false;
		if (sounds.containsKey(m.getId()) && !sounds.get(m.getId()).equals(m))
			sounds.remove(m.getId()).cleanup();
		return sounds.putIfAbsent(m.getId(), m) == null;
	}

	public boolean addFramebuffer(Framebuffer m) {
		if (m == null)
			return false;
		if (framebuffers.containsKey(m.getId()) && !framebuffers.get(m.getId()).equals(m))
			framebuffers.remove(m.getId()).cleanup();
		return framebuffers.putIfAbsent(m.getId(), m) == null;
	}

	/*
	 * GET
	 */

	public Mesh getMesh(String name) {
		return meshes.getOrDefault(name, parent == null ? null : parent.getMesh(name));
	}

	public Scene getScene(String name) {
		return scenes.getOrDefault(name, parent == null ? null : parent.getScene(name));
	}

	public AbstractShader getAbstractShader(String name) {
		return abstractShaders.getOrDefault(name, parent == null ? null : parent.getAbstractShader(name));
	}

	public <T extends AbstractShader> T getAbstractShader(Class<T> clazz) {
		return (T) getAbstractShader(clazz.getName());
	}

	public <T extends AbstractShader> T getAbstractShader(Class<T> clazz, Supplier<T> supp) {
		return (T) abstractShaders.computeIfAbsent(clazz.getName(), (k) -> supp.get());
	}

	public Texture getTexture(String name) {
		return textures.getOrDefault(name, parent == null ? null : parent.getTexture(name));
	}

	public TextEmitter getTextEmitter(String name) {
		return textEmitters.getOrDefault(name, parent == null ? null : parent.getTextEmitter(name));
	}

	public InstanceEmitter getInstanceEmitter(String name) {
		return instanceEmitters.getOrDefault(name, parent == null ? null : parent.getInstanceEmitter(name));
	}

	public Sound getSound(String name) {
		return sounds.getOrDefault(name, parent == null ? null : parent.getSound(name));
	}

	public Framebuffer getFramebuffer(String name) {
		return framebuffers.getOrDefault(name, parent == null ? null : parent.getFramebuffer(name));
	}

	/*
	 * GLOBAL S/GETTERS
	 */

	public Map<String, Mesh> getMeshes() {
		return meshes;
	}

	public void setMeshes(Map<String, Mesh> meshes) {
		this.meshes = meshes;
	}

	public Map<String, Scene> getScenes() {
		return scenes;
	}

	public void setScenes(Map<String, Scene> scenes) {
		this.scenes = scenes;
	}

	public Map<String, AbstractShader> getRenderShaders() {
		return abstractShaders;
	}

	public void setRenderShaders(Map<String, AbstractShader> shaders) {
		abstractShaders = shaders;
	}

	public Map<String, Texture> getTextures() {
		return textures;
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
		return instanceEmitters;
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
		out.println(Mesh.class.getName() + ": " + meshes.size() + ": " + meshes);
		out.println(Scene.class.getName() + ": " + scenes.size() + ": " + scenes);
		out.println(RenderShader.class.getName() + ": " + abstractShaders.size() + ": " + abstractShaders);
		out.println(Texture.class.getName() + ": " + textures.size() + ": " + textures);
		out.println(TextEmitter.class.getName() + ": " + textEmitters.size() + ": " + textEmitters);
		out.println(Framebuffer.class.getName() + ": " + framebuffers.size() + ": " + framebuffers);
		out.println(Sound.class.getName() + ": " + sounds.size() + ": " + sounds);
		out.println("== PARENT ==");
		if (parent == null)
			out.println("null");
		else
			parent.dump(out);
		out.println("== DUMP:" + this.getClass().getName() + ":end ==");
	}

	public void dump(PrintWriter out) {
		out.println("== DUMP:" + this.getClass().getName() + " :==: " + getId() + " :start ==");
		out.println(Mesh.class.getName() + ": " + meshes.size() + ": " + meshes);
		out.println(Scene.class.getName() + ": " + scenes.size() + ": " + scenes);
		out.println(RenderShader.class.getName() + ": " + abstractShaders.size() + ": " + abstractShaders);
		out.println(Texture.class.getName() + ": " + textures.size() + ": " + textures);
		out.println(TextEmitter.class.getName() + ": " + textEmitters.size() + ": " + textEmitters);
		out.println(Framebuffer.class.getName() + ": " + framebuffers.size() + ": " + framebuffers);
		out.println(Sound.class.getName() + ": " + sounds.size() + ": " + sounds);
		out.println("== PARENT ==");
		if (parent == null)
			out.println("null (no parent attached)");
		else
			parent.dump(out);
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
