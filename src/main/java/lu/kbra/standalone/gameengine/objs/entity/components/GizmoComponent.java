package lu.kbra.standalone.gameengine.objs.entity.components;

import lu.kbra.standalone.gameengine.cache.CacheManager;
import lu.kbra.standalone.gameengine.geom.Gizmo;
import lu.kbra.standalone.gameengine.impl.Renderable;
import lu.kbra.standalone.gameengine.objs.entity.Component;

public class GizmoComponent extends Component implements Renderable {

	private String gizmoId;

	public GizmoComponent(Gizmo gizmo) {
		this.gizmoId = gizmo.getId();
	}

	public GizmoComponent(String gizmoId) {
		this.gizmoId = gizmoId;
	}

	public String getGizmoId() {
		return this.gizmoId;
	}

	public void setGizmoId(String gizmoId) {
		this.gizmoId = gizmoId;
	}

	public Gizmo getGizmo(CacheManager cache) {
		return cache.getGizmo(this.gizmoId);
	}

	public void setGizmo(Gizmo gizmo) {
		this.gizmoId = gizmo.getId();
	}

}
