package lu.kbra.standalone.gameengine.graph.material.text;

import java.util.HashMap;

import org.joml.Vector4f;

import lu.kbra.standalone.gameengine.cache.CacheManager;
import lu.kbra.standalone.gameengine.graph.material.TextureMaterial;
import lu.kbra.standalone.gameengine.graph.shader.RenderShader;
import lu.kbra.standalone.gameengine.graph.shader.part.AbstractShaderPart;
import lu.kbra.standalone.gameengine.graph.texture.SingleTexture;
import lu.kbra.standalone.gameengine.graph.texture.Texture;
import lu.kbra.standalone.gameengine.impl.Renderable;

public class TextShader extends RenderShader {

	public static final String TXT1 = "txt1";
	public static final String FG_COLOR = "fgColor";
	public static final String BG_COLOR = "bgColor";
	public static final String TXT_LENGTH = "len";
	public static final String TRANSPARENT = "transparent";
	public static final String THICKNESS = "thickness";

	public TextShader() {
		super(TextShader.class.getName(), true, AbstractShaderPart.load("./resources/shaders/text/text.vert"),
				AbstractShaderPart.load("./resources/shaders/text/text.frag"));
	}

	@Override
	public void createUniforms() {
		createSceneUniforms();

		createUniform(TXT1);

		createUniform(FG_COLOR);
		createUniform(BG_COLOR);
		createUniform(TRANSPARENT);
		createUniform(THICKNESS);

		createUniform(TXT_LENGTH);
	}

	public static class TextMaterial extends TextureMaterial {

		public static final String NAME = TextMaterial.class.getName();

		private Vector4f fgColor = new Vector4f(1, 1, 1, 1);
		private Vector4f bgColor = new Vector4f(0, 0, 0, 0);
		private boolean transparent = true;
		private float thickness = 0.35f;

		public TextMaterial(SingleTexture txt1) {
			super(NAME, new TextShader(), new HashMap<String, Texture>() {
				{
					put(TXT1, txt1);
				}
			});
		}

		public TextMaterial(RenderShader shader, Texture txt1) {
			super(NAME, shader, new HashMap<String, Texture>() {
				{
					put(TXT1, txt1);
				}
			});
		}

		public TextMaterial(String name, RenderShader shader, Texture txt1) {
			super(name, shader, new HashMap<String, Texture>() {
				{
					put(TXT1, txt1);
				}
			});
		}

		@Override
		public void bindProperties(CacheManager cache, Renderable scene) {
			setProperty(THICKNESS, thickness);
			setProperty(FG_COLOR, fgColor);
			setProperty(BG_COLOR, bgColor);
			setProperty(TRANSPARENT, transparent);

			super.bindProperties(cache, scene);
		}

		public float getThickness() {
			return thickness;
		}

		public void setThickness(float thickness) {
			this.thickness = thickness;
		}

		public void setFgColor(Vector4f fgColor) {
			this.fgColor = fgColor;
		}

		public Vector4f getFgColor() {
			return fgColor;
		}

		public void setBgColor(Vector4f bgColor) {
			this.bgColor = bgColor;
		}

		public Vector4f getBgColor() {
			return bgColor;
		}

		public boolean isTransparent() {
			return transparent;
		}

		public void setTransparent(boolean transparent) {
			this.transparent = transparent;
		}

	}

}
