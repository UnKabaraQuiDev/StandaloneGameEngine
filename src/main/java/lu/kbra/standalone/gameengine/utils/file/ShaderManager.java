package lu.kbra.standalone.gameengine.utils.file;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.HashMap;

import lu.kbra.standalone.gameengine.cache.CacheManager;
import lu.kbra.standalone.gameengine.cache.SharedCacheManager;
import lu.kbra.standalone.gameengine.graph.shader.part.AbstractShader;
import lu.kbra.standalone.gameengine.graph.shader.part.AbstractShaderPart;
import lu.kbra.standalone.gameengine.impl.GameLogic;

public class ShaderManager extends Thread implements Runnable {

	private CacheManager cache;
	private Path root;

	private WatchService watchService;
	private HashMap<String, AbstractShader> shaders = new HashMap<>();

	public ShaderManager(SharedCacheManager cache, String dir) throws IOException {
		super("ShaderManager:" + dir);
		super.setDaemon(true);

		this.cache = cache;
		this.root = Paths.get(dir);

		try {
			watchService = FileSystems.getDefault().newWatchService();
			// root.register(watchService, StandardWatchEventKinds.ENTRY_MODIFY,
			// StandardWatchEventKinds.ENTRY_CREATE);
			Files.walkFileTree(root, new SimpleFileVisitor<Path>() {
				@Override
				public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
					dir.register(watchService, StandardWatchEventKinds.ENTRY_MODIFY, StandardWatchEventKinds.ENTRY_CREATE);
					return FileVisitResult.CONTINUE;
				}
			});
		} catch (IOException e) {
			throw e;
		}

		super.start();
	}

	public void monitorShader(AbstractShader shader) {
		for (AbstractShaderPart part : shader.getParts().values()) {
			System.err.println(root);
			final String name = root.resolve(part.getFile().replace("classpath:/", "")).toAbsolutePath().normalize().toString();
			System.err.println(name);
			shaders.put(name, shader);
		}
	}

	@Override
	public void run() {
		while (true) {
			WatchKey key;
			try {
				key = watchService.take();
			} catch (InterruptedException e) {
				return;
			}

			for (WatchEvent<?> event : key.pollEvents()) {
				if (event.kind() == StandardWatchEventKinds.OVERFLOW)
					continue;

				WatchEvent<Path> ev = (WatchEvent<Path>) event;
				Path filename = ev.context();
				Path child = ((Path) key.watchable()).resolve(filename).toAbsolutePath().normalize();

				if (shaders.containsKey(child.toString())) {
					System.err.println("Recompiling: " + child.toString());
					GameLogic.INSTANCE.RENDER_DISPATCHER.post(() -> shaders.get(child.toString()).recompile());
				} else {
					System.err.println("Shader not found: " + child.toString());
				}
			}

			key.reset();
		}
	}

}
