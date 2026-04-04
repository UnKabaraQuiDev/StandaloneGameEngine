package lu.kbra.standalone.gameengine.graph.window;

import java.util.Properties;

import org.joml.Vector2i;

import lu.kbra.pclib.PCUtils;
import lu.kbra.standalone.gameengine.utils.GameEngineUtils;
import lu.kbra.standalone.gameengine.utils.gl.consts.Consts;
import lu.kbra.standalone.gameengine.utils.gl.consts.WindowMode;

public class WindowOptions {

	public int fps = Consts.DEFAULT_FPS;
	public int ups = Consts.DEFAULT_UPS;
	public WindowMode windowMode = Consts.DEFAULT_FULLSCREEN;
	public boolean vsync = Consts.DEFAULT_VSYNC;
	public boolean resizable = Consts.DEFAULT_RESIZABLE;
	public Vector2i windowSize = Consts.DEFAULT_WINDOW_SIZE;
	public String title = Consts.DEFAULT_TITLE;
	public int windowMultisample = Consts.DEFAULT_WINDOW_MULTISAMPLE;
	public boolean gles = Consts.DEFAULT_GLES;
	public boolean logging = false;
	public boolean debug = false;
	public boolean visible = true;

	public WindowOptions(Properties props, String pathPrefix) {
		fps = PCUtils.parseInteger(props.getProperty(pathPrefix + ".fps"), Consts.DEFAULT_FPS);
		ups = PCUtils.parseInteger(props.getProperty(pathPrefix + ".fps"), Consts.DEFAULT_UPS);
		windowMode = WindowMode.valueOf(props.getProperty(pathPrefix + ".screenMode", Consts.DEFAULT_FULLSCREEN.name()).toUpperCase());
		vsync = PCUtils.parseBoolean(props.getProperty(pathPrefix + ".vsync"), Consts.DEFAULT_VSYNC);
		resizable = PCUtils.parseBoolean(props.getProperty(pathPrefix + ".resizable"), Consts.DEFAULT_RESIZABLE);
		windowSize = GameEngineUtils.parseVec2i(props.getProperty(pathPrefix + ".windowSize"), Consts.DEFAULT_WINDOW_SIZE);
		title = props.getProperty(pathPrefix + ".title", Consts.DEFAULT_TITLE);
		windowMultisample = PCUtils.parseInteger(props.getProperty(pathPrefix + ".windowMultisample"), Consts.DEFAULT_WINDOW_MULTISAMPLE);
		gles = PCUtils.parseBoolean(props.getProperty(pathPrefix + ".gles"), Consts.DEFAULT_GLES);
		logging = PCUtils.parseBoolean(props.getProperty(pathPrefix + ".logging"), false);
		debug = PCUtils.parseBoolean(props.getProperty(pathPrefix + ".debug"), false);
		visible = PCUtils.parseBoolean(props.getProperty(pathPrefix + ".visible"), true);
	}

}
