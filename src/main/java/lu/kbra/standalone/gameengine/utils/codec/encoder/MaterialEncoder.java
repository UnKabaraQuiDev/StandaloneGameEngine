package lu.kbra.standalone.gameengine.utils.codec.encoder;

import java.nio.ByteBuffer;

import lu.pcy113.jbcodec.CodecManager;
import lu.pcy113.jbcodec.encoder.DefaultObjectEncoder;

import lu.kbra.standalone.gameengine.graph.material.Material;

public class MaterialEncoder extends DefaultObjectEncoder<Material> {

	public MaterialEncoder() {
		super(Material.class);
	}

	@Override
	public ByteBuffer encode(boolean head, Material obj) {
		ByteBuffer bb = ByteBuffer.allocate(estimateSize(head, obj));

		if (head) {
			bb.putShort(header());
		}

		bb.put(cm.encode(false, (String) obj.getClass().getName()));
		
		bb.flip();
		
		return bb;
	}

	@Override
	public int estimateSize(boolean head, Material obj) {
		int bufferLength = head ? CodecManager.HEAD_SIZE : 0;

		bufferLength += cm.estimateSize(false, obj.getClass().getName());

		return bufferLength;
	}

	@Override
	public boolean confirmClassType(Class<?> clazz) {
		return Material.class.isAssignableFrom(clazz);
	}
	
	@Override
	public boolean confirmType(Object obj) {
		return obj instanceof Material;
	}

}
