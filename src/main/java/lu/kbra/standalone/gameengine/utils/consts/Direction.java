package lu.kbra.standalone.gameengine.utils.consts;

import org.joml.Quaternionf;
import org.joml.Vector2f;
import org.joml.Vector2i;
import org.lwjgl.glfw.GLFW;

public enum Direction {

	NORTH(new Vector2f(0, 1), 0),
	EAST(new Vector2f(1, 0), 1),
	SOUTH(new Vector2f(0, -1), 2),
	WEST(new Vector2f(-1, 0), 3),
	NONE(new Vector2f(0, 0), -1);

	private static final Direction[] DIRS = { NORTH, EAST, SOUTH, WEST };

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

	public static Direction getByIndexValid(int i) {
		i = Math.floorMod(i, DIRS.length);
		return DIRS[i];
	}

	public static Direction getByIndexAbsolute(int i) {
		return i < 0 || i > 3 ? NONE : DIRS[i];
	}

	public Direction getClockwise() {
		return this == NONE ? WEST : getByIndexValid(index + 1);
	}

	public Direction getCounterClockwise() {
		return this == NONE ? EAST : getByIndexValid(index - 1);
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
		return getByIndexAbsolute(dir);
	}

	public Quaternionf rotate(Quaternionf first) {
		return first.rotateY(getAngle());
	}

	public Quaternionf rotate(Quaternionf first, Quaternionf target) {
		return first.rotateY(getAngle(), target);
	}

	public Quaternionf rotation(Quaternionf first) {
		return first.rotationY(getAngle());
	}

	public Quaternionf rotation(Quaternionf first, Quaternionf target) {
		return target.set(first).rotationY(getAngle());
	}

	public Direction add(Direction rotation) {
		if (rotation == NONE) {
			rotation = DEFAULT();
		}
		return getByIndexValid(Math.floorMod(this.getIndex() + rotation.getIndex(), 4));
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

	public Vector2i rotated(final Vector2i v) {
		return switch (this) {
		case SOUTH, NONE -> new Vector2i(v.x, v.y);
		case NORTH -> new Vector2i(-v.x, -v.y);
		case EAST -> new Vector2i(v.y, -v.x);
		case WEST -> new Vector2i(-v.y, v.x);
		};
	}

	public Vector2f rotated(final Vector2f v) {
		return switch (this) {
		case SOUTH, NONE -> new Vector2f(v.x, v.y);
		case NORTH -> new Vector2f(-v.x, -v.y);
		case EAST -> new Vector2f(v.y, -v.x);
		case WEST -> new Vector2f(-v.y, v.x);
		};
	}

	public Vector2i rotate(final Vector2i v) {
		return switch (this) {
		case SOUTH, NONE -> v.set(v.x, v.y);
		case NORTH -> v.set(-v.x, -v.y);
		case EAST -> v.set(v.y, -v.x);
		case WEST -> v.set(-v.y, v.x);
		};
	}

	public Vector2f rotate(final Vector2f v) {
		return switch (this) {
		case SOUTH, NONE -> v.set(v.x, v.y);
		case NORTH -> v.set(-v.x, -v.y);
		case EAST -> v.set(v.y, -v.x);
		case WEST -> v.set(-v.y, v.x);
		};
	}

	public boolean isVertical() {
		return this == NORTH || this == SOUTH;
	}

	public boolean isHorizontal() {
		return this == EAST || this == WEST;
	}

}
