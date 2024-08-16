package lu.kbra.standalone.gameengine.graph.window;

import java.util.Properties;

import org.joml.Vector2i;

import lu.kbra.standalone.gameengine.utils.GameEngineUtils;
import lu.kbra.standalone.gameengine.utils.consts.Consts;
import lu.pcy113.pclib.PCUtils;

public class WindowOptions {

	public int fps = Consts.DEFAULT_FPS;
	public int ups = Consts.DEFAULT_UPS;
	public boolean fullscreen = Consts.DEFAULT_FULLSCREEN;
	public boolean vsync = Consts.DEFAULT_VSYNC;
	public boolean resizable = Consts.DEFAULT_RESIZABLE;
	public Vector2i windowSize = Consts.DEFAULT_WINDOW_SIZE;
	public String title = Consts.DEFAULT_TITLE;
	public int windowMultisample = Consts.DEFAULT_WINDOW_MULTISAMPLE;
	public boolean gles = Consts.DEFAULT_GLES;

	public WindowOptions(Properties props, String pathPrefix) {
		this.fps = PCUtils.parseInteger(props.getProperty(pathPrefix+".fps"), Consts.DEFAULT_FPS);
		this.ups = PCUtils.parseInteger(props.getProperty(pathPrefix+".fps"), Consts.DEFAULT_UPS);
		this.fullscreen = PCUtils.parseBoolean(props.getProperty(pathPrefix+".fullscreen"), Consts.DEFAULT_FULLSCREEN);
		this.vsync = PCUtils.parseBoolean(props.getProperty(pathPrefix+".vsync"), Consts.DEFAULT_VSYNC);
		this.resizable = PCUtils.parseBoolean(props.getProperty(pathPrefix+".resizable"), Consts.DEFAULT_RESIZABLE);
		this.windowSize = GameEngineUtils.parseVec2i(props.getProperty(pathPrefix+".windowSize"), Consts.DEFAULT_WINDOW_SIZE);
		this.title = props.getProperty(pathPrefix+".title", Consts.DEFAULT_TITLE);
		this.windowMultisample = PCUtils.parseInteger(props.getProperty(pathPrefix+".windowMultisample"), Consts.DEFAULT_WINDOW_MULTISAMPLE);
		this.gles = PCUtils.parseBoolean(props.getProperty(pathPrefix+".gles"), Consts.DEFAULT_GLES);
	}

}
