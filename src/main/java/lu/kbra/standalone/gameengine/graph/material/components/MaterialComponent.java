package lu.kbra.standalone.gameengine.graph.material.components;

import lu.kbra.standalone.gameengine.graph.material.Material;

public class MaterialComponent {

	private Material parent;

	public boolean attach(Material parent) {
		if (this.parent != null)
			return false;
		this.parent = parent;
		return true;
	}

	public Material getParent() {
		return parent;
	}

}
