package lu.kbra.standalone.gameengine.utils.consts;

import org.joml.Quaternionf;
import org.joml.Vector2f;
import org.lwjgl.glfw.GLFW;

public enum Direction {

	NORTH(new Vector2f(0, 1), 0), EAST(new Vector2f(1, 0), 1), SOUTH(new Vector2f(0, -1), 2),
	WEST(new Vector2f(-1, 0), 3), NONE(new Vector2f(0, 0), -1);

	private Vector2f dir;
	private int index;

	Direction(Vector2f v, int index) {
		this.dir = v;
		this.index = index;
	}

	public Vector2f getDirection() {
		return dir;
	}

	public int getIndex() {
		return index;
	}

	public static Direction DEFAULT() {
		return SOUTH;
	}

	public static Direction getByIndex(int i) {
		for (Direction d : values()) {
			if (d.getIndex() == i) {
				return d;
			}
		}
		return NONE;
	}

	public Direction getClockwise() {
		return getByIndex((index + 1) % 4);
	}

	public Direction getCounterClockwise() {
		return getByIndex(index - 1 == -1 ? 3 : index - 1);
	}

	public static Direction getGLFW(int dir, float leftX, float leftY) {
		switch (dir) {
		case GLFW.GLFW_GAMEPAD_AXIS_LEFT_X -> {
			if (Math.signum(leftX) == -1) {
				return Direction.WEST;
			} else if (Math.signum(leftX) == 1) {
				return Direction.EAST;
			}
		}
		case GLFW.GLFW_GAMEPAD_AXIS_LEFT_Y -> {
			if (Math.signum(leftY) == -1) {
				return Direction.NORTH;
			} else if (Math.signum(leftY) == 1) {
				return Direction.SOUTH;
			}
		}
		}

		return NONE;
	}

	public static Direction getGLFWCross(int dir, byte up, byte right, byte down, byte left) {
		return getByIndex(dir);
	}

	public Quaternionf rotate(Quaternionf first) {
		return first.rotateY(getAngle());
	}

	public Quaternionf rotate(Quaternionf first, Quaternionf target) {
		return first.rotateY(getAngle(), target);
	}

	public float getAngle() {
		return switch (this) {
		case NORTH -> (float) Math.toRadians(180);
		case SOUTH -> 0f;
		case EAST -> (float) Math.toRadians(90);
		case WEST -> (float) Math.toRadians(-90);
		default -> 0f;
		};
	}

	public boolean isVertical() {
		return this == NORTH || this == SOUTH;
	}

	public boolean isHorizontal() {
		return this == EAST || this == WEST;
	}

}
