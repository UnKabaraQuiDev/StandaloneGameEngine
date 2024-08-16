package lu.kbra.standalone.gameengine.graph.material.wireframe;

import lu.kbra.standalone.gameengine.graph.material.Material;

public class WireframeMaterial extends Material {

	public static final String NAME = WireframeMaterial.class.getName();

	public WireframeMaterial(WireframeShader shader) {
		super(NAME, shader);
	}

}
