package lu.kbra.standalone.gameengine.scene.camera;

import java.io.PrintStream;

import org.joml.Matrix4f;
import org.joml.Quaternionf;
import org.joml.Vector2f;
import org.joml.Vector3f;

import lu.kbra.standalone.gameengine.GameEngine;
import lu.kbra.standalone.gameengine.utils.GameEngineUtils;
import lu.kbra.standalone.gameengine.utils.geo.GeoPlane;
import lu.kbra.standalone.gameengine.utils.geo.Ray;

public abstract class Camera {

	protected Projection projection;

	protected Matrix4f viewMatrix;

	public Camera(Projection proj) {
		this.projection = proj;
		this.viewMatrix = new Matrix4f();
	}

	public abstract Matrix4f updateMatrix();

	public abstract void dump(PrintStream out);

	public Vector3f projectPoint(Vector3f in, int[] viewport) {
		Matrix4f projView = projection.getProjectionMatrix().mul(viewMatrix, new Matrix4f());

		return projView.unproject(GameEngineUtils.getCoordinates(in, viewport), viewport, new Vector3f());
	}

	public Ray projectRay(Vector2f in, int[] viewport) {
		Matrix4f projView = projection.getProjectionMatrix().mul(viewMatrix, new Matrix4f());

		Vector3f origin = new Vector3f(), dir = new Vector3f();

		// in = in.mul(new Vector2f(1, -1), new Vector2f());

		projView.unprojectRay(GameEngineUtils.getCoordinates(in, viewport), viewport, origin, dir);

		// origin.y = -origin.y;
		// dir.y = -dir.y;

		return new Ray(origin, dir);
	}

	public Vector3f projectPlane(Ray ray, GeoPlane plane) {
		return projectPlane(ray, plane.getPoints()[0], plane.getPoints()[1], plane.getNormal());
	}

	public Vector3f projectPlane(Ray ray, Vector3f p1, Vector3f p2) {
		Vector3f normal = new Vector3f();
		p1.cross(p2, normal).normalize(); // Calculate plane normal

		return projectPlane(ray, p1, p2, normal);
	}

	public Vector3f projectPlane(Ray ray, Vector3f p1, Vector3f p2, Vector3f normal) {
		float d = -normal.dot(p1); // Calculate plane distance

		// Create plane equation: ax + by + cz + d = 0
		float a = normal.x;
		float b = normal.y;
		float c = normal.z;

		Vector3f origin = ray.getOrigin();
		Vector3f direction = ray.getDir();

		// Calculate intersection point
		float t = -(a * origin.x + b * origin.y + c * origin.z + d) / (a * direction.x + b * direction.y + c * direction.z);

		Vector3f intersectionPoint = new Vector3f(origin).add(direction.mul(t, new Vector3f()));

		return intersectionPoint;
	}

	public Matrix4f getViewMatrix() {
		return viewMatrix;
	}

	public Projection getProjection() {
		return projection;
	}

	public void setProjection(Projection projection) {
		this.projection = projection;
	}

	public static final Camera3D perspectiveCamera3D() {
		return new Camera3D(new Vector3f(0), new Quaternionf().identity().rotateTo(new Vector3f(-1, 0, 0), new Vector3f(1, 0, 0)), new Projection(720, 480, 0.1f, 1000f, (float) Math.toRadians(60), 100, true));
	}

	public static final Camera3D orthographicCamera3D() {
		return new Camera3D(new Vector3f(0), new Quaternionf().identity().rotateTo(GameEngine.FORWARD, GameEngine.BACK), new Projection(720, 480, 0.1f, 1000f, (float) Math.toRadians(60), 100, false));
	}

	public static Camera2D orthographicCamera2D() {
		return new Camera2D(new Vector2f(0), new Quaternionf().identity(), new Projection(720, 480, 0.1f, 1000f, (float) Math.toRadians(60), 100, false));
	}

}
