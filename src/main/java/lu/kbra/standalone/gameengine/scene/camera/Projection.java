package lu.kbra.standalone.gameengine.scene.camera;

import java.io.PrintStream;

import org.joml.Matrix4f;
import org.joml.Vector2i;

public class Projection {

	private Matrix4f projectionMatrix = new Matrix4f();
	private float nearPlane;
	private float farPlane;
	private boolean perspective;
	private int width;
	private int height;
	private float fov;
	private float size = 100f;

	public Projection(int width, int height, float nearPlane, float farPlane, float fov, float size, boolean perspective) {
		this.width = width;
		this.height = height;
		this.nearPlane = nearPlane;
		this.farPlane = farPlane;
		this.fov = fov;
		this.perspective = perspective;
		this.size = size;

		update();
	}

	public Projection update(int w, int h) {
		width = w;
		height = h;
		return update();
	}

	public Projection update(Vector2i resolution) {
		width = resolution.x;
		height = resolution.y;
		return update();
	}

	public Projection update() {
		final float aspectRatio = getAspectRatio();

		if (perspective)
			projectionMatrix.identity().perspective(fov, aspectRatio, nearPlane, farPlane);
		else {
			final float halfHeight = 1f;
			final float halfWidth = halfHeight * aspectRatio;

			projectionMatrix.identity()
			.ortho(-halfWidth / size, halfWidth / size, -halfHeight / size, halfHeight / size, nearPlane, farPlane);
		}
		return this;
	}

	public float getAspectRatio() {
		return (float) width / height;
	}

	public Matrix4f getProjectionMatrix() {
		return projectionMatrix;
	}

	public Projection setPerspective(boolean perspective) {
		this.perspective = perspective;
		return this;
	}

	public Projection setNearPlane(float nearPlane) {
		this.nearPlane = nearPlane;
		return this;
	}

	public Projection setFarPlane(float farPlane) {
		this.farPlane = farPlane;
		return this;
	}

	public Projection setFov(float fov) {
		this.fov = fov;
		return this;
	}

	public Projection setSize(Vector2i size) {
		width = size.x;
		width = size.y;
		return this;
	}

	public Projection setSize(int width, int height) {
		this.width = width;
		this.height = height;
		return this;
	}

	public Projection setSize(float size) {
		this.size = size;
		return this;
	}

	public float getFov() {
		return fov;
	}

	public float getSize() {
		return size;
	}

	public float getNearPlane() {
		return nearPlane;
	}

	public float getFarPlane() {
		return farPlane;
	}

	public boolean isPerspective() {
		return perspective;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	@Override
	public String toString() {
		return "Projection [projectionMatrix=" + projectionMatrix + ", nearPlane=" + nearPlane + ", farPlane=" + farPlane + ", perspective="
				+ perspective + ", width=" + width + ", height=" + height + ", fov=" + fov + ", size=" + size + "]";
	}

	public void dump(PrintStream out) {
		out.println("Planes: " + nearPlane + " <> " + farPlane);
		out.println("Perspective: " + perspective);
		out.println("Resolution: " + width + ":" + height);
		out.println("Fov: " + fov + ", size: " + size);
	}

}
