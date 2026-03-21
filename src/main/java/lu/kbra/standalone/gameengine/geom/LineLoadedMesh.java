package lu.kbra.standalone.gameengine.geom;

import lu.kbra.standalone.gameengine.cache.attrib.UIntAttribArray;
import lu.kbra.standalone.gameengine.cache.attrib.Vec3fAttribArray;
import lu.kbra.standalone.gameengine.cache.attrib.impl.JavaAttribArray;
import lu.kbra.standalone.gameengine.graph.material.Material;

public class LineLoadedMesh extends LoadedMesh implements LineMesh {

	private float lineWidth;

	public LineLoadedMesh(String name, Material material, float lineWidth, Vec3fAttribArray vertices,
			UIntAttribArray indices, JavaAttribArray... attribs) {
		super(name, material, vertices, indices, attribs);
		this.lineWidth = lineWidth;
	}

	@Override
	public float getLineWidth() {
		return lineWidth;
	}

}
