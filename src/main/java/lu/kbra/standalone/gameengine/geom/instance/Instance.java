package lu.kbra.standalone.gameengine.geom.instance;

import lu.kbra.standalone.gameengine.utils.transform.Transform;

public class Instance {

	private final int index;
	private Transform transform;
	private Object[] buffers;

	public Instance(int index, Transform transform, Object... buffers) {
		this.index = index;
		this.transform = transform;
		this.buffers = buffers;
	}

	public int getIndex() {
		return this.index;
	}

	public Transform getTransform() {
		return this.transform;
	}

	public Object[] getBuffers() {
		return this.buffers;
	}

	public void setTransform(Transform transform) {
		this.transform = transform;
	}

	public void setBuffers(Object[] buffers) {
		if (this.buffers.length != buffers.length)
			return;
		this.buffers = buffers;
	}

}
