package lu.kbra.standalone.gameengine.objs.text;

import java.util.Arrays;

import org.joml.Matrix4f;
import org.joml.Vector2f;
import org.joml.Vector4f;

import lu.pcy113.pclib.PCUtils;
import lu.pcy113.pclib.logger.GlobalLogger;

import lu.kbra.standalone.gameengine.cache.attrib.Mat4fAttribArray;
import lu.kbra.standalone.gameengine.cache.attrib.UIntAttribArray;
import lu.kbra.standalone.gameengine.geom.LoadedQuadMesh;
import lu.kbra.standalone.gameengine.geom.instance.InstanceEmitter;
import lu.kbra.standalone.gameengine.graph.material.text.TextShader;
import lu.kbra.standalone.gameengine.graph.material.text.TextShader.TextMaterial;
import lu.kbra.standalone.gameengine.impl.Cleanupable;
import lu.kbra.standalone.gameengine.impl.GLObject;
import lu.kbra.standalone.gameengine.impl.Renderable;
import lu.kbra.standalone.gameengine.impl.UniqueID;
import lu.kbra.standalone.gameengine.utils.gl.consts.TextAlignment;
import lu.kbra.standalone.gameengine.utils.transform.Transform3D;

public class TextEmitter implements Cleanupable, UniqueID, GLObject, Renderable {

	private static record SetupData(TextMaterial material, int bufferSize) {
	}

	public static final int CHAR_BUFFER_INDEX = 9;
	public static final String CHAR_BUFFER_NAME = "char";

	public static final String STRING = " !\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~";

	public static final Vector4f DEFAULT_FG_COLOR = new Vector4f(1);
	public static final Vector4f DEFAULT_BG_COLOR = new Vector4f(0, 0, 0, 1);
	public static final boolean DEFAULT_TRANSPARENT = true;

	public static int TAB_SIZE = 4;
	public static String TAB_CHARS = PCUtils.repeatString(" ", TAB_SIZE);

	private final String name;

	private final Vector2f charSize;
	private String text;

	private SetupData setupData;
	private UIntAttribArray charBuffer;
	private InstanceEmitter instances;

	private TextAlignment alignment = TextAlignment.CENTER;
	private boolean justify = false;
	private boolean boxed = false;
	private boolean correctTransform = false; // swaps the y axis for opengl
	private Vector2f boxSize = new Vector2f(1); // the size of the bounding box if using boxed = true
	private Vector2f charOffset = new Vector2f(0);

	private Vector4f fgColor;
	private Vector4f bgColor;
	private Boolean transparent;

	public TextEmitter(String name, TextMaterial material, int bufferSize, String text, Vector2f charSize) {
		this.name = name;

		this.text = text;
		this.charSize = charSize;

		this.setupData = new SetupData(material, bufferSize);
	}

	public void setup() {
		if (setupData == null) {
			throw new IllegalStateException("TextEmitter already initialized.");
		}

		this.charBuffer = new UIntAttribArray(CHAR_BUFFER_NAME, CHAR_BUFFER_INDEX, 1, new int[setupData.bufferSize],
				false, 1);
		// quad mesh ownership goes to the InstanceEmitter
		this.instances = new InstanceEmitter(name, new LoadedQuadMesh(name, setupData.material, charSize),
				setupData.bufferSize, new Transform3D(), charBuffer);

		updateText();

		setupData = null;
	}

	public boolean updateText() {
		if (charBuffer.getLength() < text.length()) {
			GlobalLogger.warning("Char buffer too small to hold text. ('" + text + "' (" + text.length()
					+ ") for length: " + charBuffer.getLength() + ")");
		}

		text = text.substring(0, getStringLength());

		final TextMaterial material = (TextMaterial) instances.getParticleMesh().getMaterial();
		if (material != null) {
			material.setProperty(TextShader.TXT_LENGTH, text.length());
		}

		final Matrix4f[] transforms = ((Mat4fAttribArray) instances.getParticleTransforms()).isLoaded()
				? ((Mat4fAttribArray) instances.getParticleTransforms()).getData()
				: new Matrix4f[instances.getParticleCount()];
		final Integer[] chars = new Integer[instances.getParticleCount()];
		Arrays.fill(chars, 0);

		updateTextContent(transforms, chars);

		instances.updateDirect(transforms, new Object[][] { chars });

		return true;
	}

	private void updateTextContent(Matrix4f[] transforms, Integer[] chars) {
		if (TextAlignment.LEFT == alignment) {
			updateTextContentLeft(transforms, chars);
		} else if (TextAlignment.TEXT_LEFT == alignment) { // same as LEFT
			updateTextContentLeft(transforms, chars);
		} else if (TextAlignment.RIGHT == alignment) {
			updateTextContentRight(transforms, chars);
		} else if (TextAlignment.TEXT_RIGHT == alignment) {
			updateTextContentAbsRight(transforms, chars);
		} else if (TextAlignment.CENTER == alignment) {
			updateTextContentCenter(transforms, chars);
		} else if (TextAlignment.TEXT_CENTER == alignment) {
			updateTextContentAbsCenter(transforms, chars);
		}
	}

	private void updateTextContentAbsCenter(Matrix4f[] transforms, Integer[] chars) {
		final int[] widthCount = computeWidthCounts();

		int line = 0;
		int character = 0;

		int charIndex = 0;
		for (int i = 0; i < text.length(); i++) {
			final char currentChar = text.charAt(i);

			switch (currentChar) {
			case '\n' -> {
				line++;
				character = 0;
			}
			case '\t' -> character += TAB_SIZE;
			case ' ' -> character++;
			default -> {
				character++;
				chars[charIndex] = (int) currentChar;

				final float translationX = (character - (float) (widthCount[line] - 1) / 2)
						* (charSize.x + charOffset.x) - charSize.x;
				final float translationY = line * (charSize.y + charOffset.y) + charSize.y / 2 + charOffset.y;

				transforms[charIndex] = (transforms[charIndex] == null ? new Matrix4f() : transforms[charIndex])
						.identity().translate(translationX, (correctTransform ? -1 : 1) * translationY, 0);

				charIndex++;
			}
			}
		}
	}

	private void updateTextContentCenter(Matrix4f[] transforms, Integer[] chars) {
		final int[] widthCount = computeWidthCounts();
		final float widthMax = boxed ? boxSize.x : Arrays.stream(widthCount).max().getAsInt() * charSize.x;

		int line = 0;
		int character = 0;

		int charIndex = 0;
		for (int i = 0; i < text.length(); i++) {
			char currentChar = text.charAt(i);

			switch (currentChar) {
			case '\n' -> {
				line++;
				character = 0;
			}
			case '\t' -> character += TAB_SIZE;
			case ' ' -> character++;
			default -> {
				character++;
				chars[charIndex] = (int) currentChar;
				float translationX = (character - widthCount[line] / 2) * (charSize.x + charOffset.x) + widthMax / 2
						- charSize.x;
				float translationY = line * (charSize.y + charOffset.y) + charSize.y / 2;
				transforms[charIndex] = (transforms[charIndex] == null ? new Matrix4f() : transforms[charIndex])
						.identity().translate(translationX, (correctTransform ? -1 : 1) * translationY, 0);
				charIndex++;
			}
			}
		}
	}

	private void updateTextContentRight(Matrix4f[] transforms, Integer[] chars) {
		final int[] widthCount = computeWidthCounts();
		final int widthMax = Arrays.stream(widthCount).max().getAsInt();

		int line = 0;
		int character = 0;

		int charIndex = 0;
		for (int i = 0; i < text.length(); i++) {
			char currentChar = text.charAt(i);

			switch (currentChar) {
			case '\n' -> {
				line++;
				character = 0;
			}
			case '\t' -> character += TAB_SIZE;
			case ' ' -> character++;
			default -> {
				character++;
				chars[charIndex] = (int) currentChar;
				final float translationX = ((widthMax - widthCount[line]) + character) * (charSize.x + charOffset.x)
						- charSize.x;
				final float translationY = line * (charSize.y + charOffset.y) + charSize.y / 2;
				transforms[charIndex] = (transforms[charIndex] == null ? new Matrix4f() : transforms[charIndex])
						.identity().translate(translationX, (correctTransform ? -1 : 1) * translationY, 0);
				charIndex++;
			}
			}
		}
	}

	private void updateTextContentAbsRight(Matrix4f[] transforms, Integer[] chars) {
		final int[] widthCount = computeWidthCounts();
		final int widthMax = Arrays.stream(widthCount).max().getAsInt();

		int line = 0;
		int character = 0;

		int charIndex = 0;
		for (int i = 0; i < text.length(); i++) {
			char currentChar = text.charAt(i);

			switch (currentChar) {
			case '\n' -> {
				line++;
				character = 0;
			}
			case '\t' -> character += TAB_SIZE;
			case ' ' -> character++;
			default -> {
				character++;
				chars[charIndex] = (int) currentChar;
				float translationX = (character - widthCount[line]) * (charSize.x + charOffset.x) - charSize.x / 2;
				float translationY = line * (charSize.y + charOffset.y) + charSize.y / 2;
				transforms[charIndex] = (transforms[charIndex] == null ? new Matrix4f() : transforms[charIndex])
						.identity().translate(translationX, (correctTransform ? -1 : 1) * translationY, 0);
				charIndex++;
			}
			}
		}
	}

	private void updateTextContentLeft(Matrix4f[] transforms, Integer[] chars) {
		int line = 0;
		int character = 0;

		int charIndex = 0;
		for (int i = 0; i < text.length(); i++) {
			char currentChar = text.charAt(i);

			switch (currentChar) {
			case '\n' -> {
				line++;
				character = 0;
			}
			case '\t' -> character += TAB_SIZE;
			case ' ' -> character++;
			default -> {
				character++;
				chars[charIndex] = (int) currentChar;
				float translationX = character * (charSize.x + charOffset.x) - charSize.x / 2;
				float translationY = line * (charSize.y + charOffset.y) + charSize.y / 2;
				transforms[charIndex] = (transforms[charIndex] == null ? new Matrix4f() : transforms[charIndex])
						.identity().translate(translationX, (correctTransform ? -1 : 1) * translationY, 0);
				charIndex++;
			}
			}
		}
	}

	public int computeMaxWidthCount() {
		int max = Integer.MIN_VALUE;

		for (String s : text.split("\n")) {
			max = Math.max(max, s.length());
		}

		return max;
	}

	public int[] computeWidthCounts() {
		return Arrays.stream(getDisplayedText().split("\n")).mapToInt(String::length).toArray();
	}

	public Vector2f getTextBounds() {
		return charSize.mul(getColumnsCount(), getLineCount(), new Vector2f());
	}

	public int getColumnsCount() {
		return Arrays.stream(getDisplayedText().split("\n")).mapToInt(String::length).max().orElse(0);
	}

	public String getDisplayedText() {
		if (boxed) {
			throw new UnsupportedOperationException();
		} else {
			return text.replace("\t", TAB_CHARS);
		}
	}

	public int getLineCount() {
		final String text = getDisplayedText();
		return text.length() - text.replace("\n", "").length() + 1;
	}

	public String getText() {
		return text;
	}

	public int getCharCount() {
		return getText().length();
	}

	public TextEmitter setText(String text) {
		this.text = text;
		return this;
	}

	public InstanceEmitter getInstances() {
		return instances;
	}

	public TextAlignment getTextAlignment() {
		return alignment;
	}

	public void setTextAlignment(TextAlignment alignment) {
		this.alignment = alignment;
	}

	public boolean isJustify() {
		return justify;
	}

	public void setJustify(boolean justify) {
		this.justify = justify;
	}

	public boolean isBoxed() {
		return boxed;
	}

	public void setBoxed(boolean boxed) {
		this.boxed = boxed;
	}

	public Vector2f getBoxSize() {
		return boxSize;
	}

	public void setBoxSize(Vector2f boxSize) {
		this.boxSize = boxSize;
	}

	public Vector2f getCharoffset() {
		return charOffset;
	}

	public void setCharOffset(Vector2f charSpace) {
		this.charOffset = charSpace;
	}

	public void setCorrectTransform(boolean correctTransform) {
		this.correctTransform = correctTransform;
	}

	public Vector4f getForegroundColor() {
		return fgColor;
	}

	public Vector4f getBackgroundColor() {
		return bgColor;
	}

	public Boolean isTransparent() {
		return transparent;
	}

	public void setForegroundColor(Vector4f fgColor) {
		this.fgColor = fgColor;
	}

	public void setBackgroundColor(Vector4f bgColor) {
		this.bgColor = bgColor;
	}

	public void setTransparent(Boolean transparent) {
		this.transparent = transparent;
	}

	@Override
	public void cleanup() {
		GlobalLogger.log("Cleaning up: " + name);

		if (instances == null) {
			return;
		}

		instances.cleanup();
		instances = null;
		// owned by InstanceEmitter
		charBuffer = null;
	}

	public int getStringLength() {
		return Math.min(text.length(), charBuffer.getLength());
	}

	
	public int getBufferLength() {
		return charBuffer.getLength();
	}

	@Override
	public String getId() {
		return name;
	}

	@Override
	public int getGlId() {
		return instances.getGlId();
	}

	@Override
	public boolean isValid() {
		return instances.isValid();
	}

	@Override
	public String toString() {
		return "TextEmitter [name=" + name + ", charSize=" + charSize + ", text=" + text + ", charBuffer=" + charBuffer
				+ ", instances=" + instances + ", alignment=" + alignment + ", justify=" + justify + ", boxed=" + boxed
				+ ", correctTransform=" + correctTransform + ", boxSize=" + boxSize + ", charOffset=" + charOffset
				+ ", isValid()=" + isValid() + "]";
	}

}
