package lu.kbra.standalone.gameengine.objs.entity.components;

import lu.kbra.standalone.gameengine.cache.CacheManager;
import lu.kbra.standalone.gameengine.geom.Mesh;
import lu.kbra.standalone.gameengine.impl.Renderable;
import lu.kbra.standalone.gameengine.objs.entity.Component;

public class MeshComponent extends Component implements Renderable {

	private String meshId;

	public MeshComponent(Mesh mesh) {
		this.meshId = mesh.getId();
	}

	public MeshComponent(String meshId) {
		this.meshId = meshId;
	}

	public String getMeshId() {
		return this.meshId;
	}

	public void setMeshId(String meshId) {
		this.meshId = meshId;
	}

	public Mesh getMesh(CacheManager cache) {
		return cache.getMesh(this.meshId);
	}

	public void setMesh(Mesh mesh) {
		this.meshId = mesh.getId();
	}

}
