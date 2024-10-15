package lu.kbra.standalone.gameengine.utils.codec.decoder;

import java.nio.ByteBuffer;

import lu.pcy113.jbcodec.decoder.DefaultObjectDecoder;

import lu.kbra.standalone.gameengine.cache.attrib.AttribArray;
import lu.kbra.standalone.gameengine.cache.attrib.UIntAttribArray;
import lu.kbra.standalone.gameengine.cache.attrib.Vec3fAttribArray;
import lu.kbra.standalone.gameengine.geom.Mesh;
import lu.kbra.standalone.gameengine.graph.material.Material;

public class MeshDecoder extends DefaultObjectDecoder<Mesh> {

	public MeshDecoder() {
		super(Mesh.class);
	}

	@Override
	public Mesh decode(boolean head, ByteBuffer bb) {
		super.verifyHeader(head, bb);
		
		String name = cm.getDecoderByClass(String.class).decode(false, bb);
		Material material = cm.getDecoderByClass(Material.class).decode(false, bb);
		UIntAttribArray indices = cm.getDecoderByClass(UIntAttribArray.class).decode(false, bb);
		Vec3fAttribArray vertices = cm.getDecoderByClass(Vec3fAttribArray.class).decode(false, bb);
		
		int otherLength = bb.getInt();
		AttribArray[] others = new AttribArray[otherLength];
		
		for(int i = 0; i < otherLength; i++) {
			others[i] = (AttribArray) cm.decode(bb);
		}
		
		return new Mesh(name, material, vertices, indices, others);
	}

}
