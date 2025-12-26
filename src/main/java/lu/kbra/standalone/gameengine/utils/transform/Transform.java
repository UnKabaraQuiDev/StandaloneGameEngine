package lu.kbra.standalone.gameengine.utils.transform;

import org.joml.Matrix4f;

public abstract class Transform implements Cloneable {

	protected Matrix4f matrix;

	public Transform() {
	}

	protected Transform(boolean _noAction) {
		matrix = new Matrix4f();
	}

	public abstract Matrix4f updateMatrix();
	
	public abstract Matrix4f getBaseMatrix();

	public Transform update() {
		updateMatrix();
		return this;
	}

	public Matrix4f getMatrix() {
		return matrix;
	}

	public void setMatrix(Matrix4f matrix) {
		this.matrix = matrix;
	}

	@Override
	public abstract Transform clone();

	

}
