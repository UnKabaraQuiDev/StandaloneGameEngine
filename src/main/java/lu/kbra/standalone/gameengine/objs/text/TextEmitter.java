package lu.kbra.standalone.gameengine.objs.text;

import java.util.Arrays;

import org.joml.Matrix4f;
import org.joml.Vector2f;

import lu.pcy113.pclib.PCUtils;
import lu.pcy113.pclib.logger.GlobalLogger;

import lu.kbra.standalone.gameengine.cache.attrib.UIntAttribArray;
import lu.kbra.standalone.gameengine.geom.Mesh;
import lu.kbra.standalone.gameengine.geom.instance.InstanceEmitter;
import lu.kbra.standalone.gameengine.graph.material.text.TextShader;
import lu.kbra.standalone.gameengine.graph.material.text.TextShader.TextMaterial;
import lu.kbra.standalone.gameengine.impl.Cleanupable;
import lu.kbra.standalone.gameengine.impl.UniqueID;
import lu.kbra.standalone.gameengine.utils.consts.Alignment;
import lu.kbra.standalone.gameengine.utils.transform.Transform3D;

public class TextEmitter implements Cleanupable, UniqueID {

	public static final int CHAR_BUFFER_INDEX = 7;
	public static final String CHAR_BUFFER_NAME = "char";
	public static final String STRING = " !\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~";

	public static int TAB_SIZE = 4;

	private final String name;

	private final Vector2f charSize;
	private String text;

	private UIntAttribArray charBuffer;
	private InstanceEmitter instances;
	private Mesh quad;

	private Alignment alignment = Alignment.CENTER;
	private boolean justify = false;
	private boolean boxed = false;
	private boolean correctTransform = false; // swaps the y axis for opengl
	private Vector2f boxSize = new Vector2f(1); // the size of the bounding box if using boxed = true
	private Vector2f charOffset = new Vector2f(0);

	public TextEmitter(String name, TextMaterial material, int bufferSize, String text, Vector2f size) {
		this.name = name;

		this.text = text;
		this.charSize = size;

		final Integer[] chars = new Integer[bufferSize];
		Arrays.fill(chars, 0);
		updateTextContent(new Matrix4f[bufferSize], chars);
		// GlobalLogger.log(Level.FINEST, "SET: " + Arrays.toString(chars));

		this.charBuffer = new UIntAttribArray(CHAR_BUFFER_NAME, CHAR_BUFFER_INDEX, 1, PCUtils.toPrimitiveInt(chars), false, 1);
		// GlobalLogger.log(Level.FINEST, Arrays.toString(charBuffer.getData()));
		this.quad = Mesh.newQuad(name, material, size);

		this.instances = new InstanceEmitter(name, quad, bufferSize, new Transform3D(), charBuffer);
	}

	public boolean updateText() {
		if (charBuffer.getLength() < text.length()) {
			GlobalLogger
					.warning("Char buffer too small to hold text. ('" + text + "' (" + text.length() + ") for length: "
							+ charBuffer.getLength() + ")");
		}

		text = text.substring(0, Math.min(text.length(), charBuffer.getLength()));

		final TextMaterial material = (TextMaterial) quad.getMaterial();

		material.setProperty(TextShader.TXT_LENGTH, text.length());

		final Matrix4f[] transforms = new Matrix4f[instances.getParticleCount()];
		final Integer[] chars = new Integer[instances.getParticleCount()];
		Arrays.fill(chars, 0);

		updateTextContent(transforms, chars);

		instances.updateDirect(transforms, new Object[][] { chars });

		return true;
	}

	private void updateTextContent(Matrix4f[] transforms, Integer[] chars) {
		if (Alignment.LEFT.equals(alignment)) {
			updateTextContentLeft(transforms, chars);
		} else if (Alignment.TEXT_LEFT.equals(alignment)) { // same as LEFT
			updateTextContentLeft(transforms, chars);
		} else if (Alignment.RIGHT.equals(alignment)) {
			updateTextContentRight(transforms, chars);
		} else if (Alignment.TEXT_RIGHT.equals(alignment)) {
			updateTextContentAbsRight(transforms, chars);
		} else if (Alignment.CENTER.equals(alignment)) {
			updateTextContentCenter(transforms, chars);
		} else if (Alignment.TEXT_CENTER.equals(alignment)) {
			updateTextContentAbsCenter(transforms, chars);
		}

	}

	private void updateTextContentAbsCenter(Matrix4f[] transforms, Integer[] chars) {
		final int[] widthCount = computeWidthCounts();
		// final int widthMax = boxed ? (int) (boxSize.x / charSize.x) :
		// Arrays.stream(widthCount).max().getAsInt();

		int line = 0;
		int character = 0;

		int charIndex = 0;
		for (int i = 0; i < text.length(); i++) {
			char currentChar = text.charAt(i);

			if (currentChar == '\n') {
				line++;
				character = 0;
			} else if (currentChar == '\t') {
				character += TAB_SIZE;
			} else if (currentChar == ' ') {
				character++;
			} else {
				character++;
				chars[charIndex] = (int) currentChar;

				final float translationX = (character - widthCount[line] / 2) * (charSize.x + charOffset.x) - charSize.x;
				final float translationY = line * (charSize.y + charOffset.y) + charSize.y / 2 + charOffset.y;

				transforms[charIndex] = new Matrix4f().identity().translate(translationX, (correctTransform ? -1 : 1) * translationY, 0);

				charIndex++;
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

			if (currentChar == '\n') {
				line++;
				character = 0;
			} else if (currentChar == '\t') {
				character += TAB_SIZE;
			} else if (currentChar == ' ') {
				character++;
			} else {
				character++;
				chars[charIndex] = (int) currentChar;

				float translationX = (character - widthCount[line] / 2) * (charSize.x + charOffset.x) + widthMax / 2 - charSize.x;
				float translationY = line * (charSize.y + charOffset.y) + charSize.y / 2;

				transforms[charIndex] = new Matrix4f().identity().translate(translationX, (correctTransform ? -1 : 1) * translationY, 0);

				charIndex++;
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

			if (currentChar == '\n') {
				line++;
				character = 0;
			} else if (currentChar == '\t') {
				character += TAB_SIZE;
			} else if (currentChar == ' ') {
				character++;
			} else {
				character++;
				chars[charIndex] = (int) currentChar;

				final float translationX = ((widthMax - widthCount[line]) + character) * (charSize.x + charOffset.x) - charSize.x;
				final float translationY = line * (charSize.y + charOffset.y) + charSize.y / 2;

				transforms[charIndex] = new Matrix4f().identity().translate(translationX, (correctTransform ? -1 : 1) * translationY, 0);

				charIndex++;
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

			if (currentChar == '\n') {
				line++;
				character = 0;
			} else if (currentChar == '\t') {
				character += TAB_SIZE;
			} else if (currentChar == ' ') {
				character++;
			} else {
				character++;
				chars[charIndex] = (int) currentChar;

				float translationX = (character - widthCount[line]) * (charSize.x + charOffset.x) - charSize.x / 2;
				float translationY = line * (charSize.y + charOffset.y) + charSize.y / 2;

				transforms[charIndex] = new Matrix4f().identity().translate(translationX, (correctTransform ? -1 : 1) * translationY, 0);

				charIndex++;
			}
		}
	}

	private void updateTextContentLeft(Matrix4f[] transforms, Integer[] chars) {
		int line = 0;
		int character = 0;

		int charIndex = 0;
		for (int i = 0; i < text.length(); i++) {
			char currentChar = text.charAt(i);

			if (currentChar == '\n') {
				line++;
				character = 0;
			} else if (currentChar == '\t') {
				character += TAB_SIZE;
			} else if (currentChar == ' ') {
				character++;
			} else {
				character++;
				chars[charIndex] = (int) currentChar;

				float translationX = character * (charSize.x + charOffset.x) - charSize.x / 2;
				float translationY = line * (charSize.y + charOffset.y) + charSize.y / 2;

				transforms[charIndex] = new Matrix4f().identity().translate(translationX, (correctTransform ? -1 : 1) * translationY, 0);

				charIndex++;
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
		String[] lines = text.split("\n");
		int[] max = new int[lines.length];

		for (int i = 0; i < lines.length; i++) {
			max[i] = lines[i].length();
		}

		return max;
	}

	public int getLineCount() {
		return text.length() - text.replace("\n", "").length();
	}

	public String getText() {
		return text;
	}

	public TextEmitter setText(String text) {
		this.text = text;
		return this;
	}

	public InstanceEmitter getInstances() {
		return instances;
	}

	public Alignment getAlignment() {
		return alignment;
	}

	public void setAlignment(Alignment alignment) {
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

	public Mesh getMesh() {
		return quad;
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

	@Override
	public void cleanup() {
		GlobalLogger.log("Cleaning up: " + name);

		if (quad == null)
			return;

		instances.cleanup();
		instances = null;
		quad.cleanup();
		quad = null;
		charBuffer = null;
	}

	@Override
	public String getId() {
		return name;
	}

}
