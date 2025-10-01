package lu.kbra.standalone.gameengine.utils.consts;

import java.io.File;

import org.joml.Vector2i;

public final class Consts {

	public static final String DEFAULT_TITLE = "PDR Engine";
	public static final int DEFAULT_UPS = 30;
	public static final int DEFAULT_FPS = 60;
	public static final boolean DEFAULT_FULLSCREEN = false;
	public static final boolean DEFAULT_VSYNC = true;
	public static final boolean DEFAULT_RESIZABLE = true;
	public static final Vector2i DEFAULT_WINDOW_SIZE = new Vector2i(800, 600);
	public static final int DEFAULT_WINDOW_MULTISAMPLE = 4;
	public static final boolean DEFAULT_GLES = false;

	public static final File RES_DIR = new File("./resources/");
	public static final File MODEL_RES_DIR = new File(RES_DIR, "models/");
	public static final File AUDIO_RES_DIR = new File(RES_DIR, "audio/");
	public static final File BAKES_RES_DIR = new File(RES_DIR, "bakes/");
	public static final File FONTS_BAKES_RES_DIR = new File(BAKES_RES_DIR, "fonts/");
	public static final File SHADERS_RES_DIR = new File(RES_DIR, "shaders/");
	public static final File TEXTURES_RES_DIR = new File(RES_DIR, "textures/");
	public static final File FONTS_RES_DIR = new File(RES_DIR, "fonts/");
	public static final File FONTS_TEXTURES_RES_DIR = new File(TEXTURES_RES_DIR, "fonts/");
	public static final File MONOSPACED_30_FONTS_TEXTURES_RES_DIR = new File(FONTS_TEXTURES_RES_DIR, "monospaced-30.png");
	public static final File UI_TEXTURES_RES_DIR = new File(TEXTURES_RES_DIR, "ui/");

}
