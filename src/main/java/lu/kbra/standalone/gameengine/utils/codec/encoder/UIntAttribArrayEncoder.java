package lu.kbra.standalone.gameengine.utils.codec.encoder;

import java.nio.ByteBuffer;

import lu.pcy113.jbcodec.CodecManager;
import lu.pcy113.jbcodec.encoder.DefaultObjectEncoder;
import lu.pcy113.jbcodec.encoder.PlatformStringEncoder;
import lu.pcy113.pclib.PCUtils;
import lu.pcy113.pclib.logger.GlobalLogger;

import lu.kbra.standalone.gameengine.cache.attrib.UIntAttribArray;
import lu.kbra.standalone.gameengine.utils.codec.decoder.UIntAttribArrayDecoder;

/**
 * STRING name ; INT index ; INT dataSize ; INT bufferType ; BOOL _static ; INT divisor ; INT arrayLength ; INT[] data ; INT END
 */
public class UIntAttribArrayEncoder extends DefaultObjectEncoder<UIntAttribArray> {

	public UIntAttribArrayEncoder() {
		super(UIntAttribArray.class);
	}

	@Override
	public ByteBuffer encode(boolean head, UIntAttribArray obj) {
		String name = obj.getName();
		int dataSize = obj.getDataSize();
		int bufferType = obj.getBufferType();
		boolean _static = obj.isStatic();
		int divisor = obj.getDivisor();
		int index = obj.getIndex();
		int[] data = obj.getData();

		int bufferLength = estimateSize(head, obj);
		GlobalLogger.info("alloc size: " + bufferLength);
		GlobalLogger.info("name : " + obj.getName());
		GlobalLogger.info("index; " + obj.getIndex());
		GlobalLogger.info("dataSize: " + obj.getDataSize());
		GlobalLogger.info("bufferType: " + obj.getBufferType());
		GlobalLogger.info("static: " + obj.isStatic());
		GlobalLogger.info("divisor: " + obj.getDivisor());
		GlobalLogger.info("data: " + data.length);

		ByteBuffer bb = ByteBuffer.allocate(bufferLength);

		if (head) {
			bb.putShort(header);
		}

		ByteBuffer bbName = ((PlatformStringEncoder) cm.getEncoderByClass(String.class)).encode(false, name);
		bb.put(bbName);

		bb.putInt(index);
		bb.putInt(dataSize);
		bb.putInt(bufferType);
		bb.put((byte) (_static ? 1 : 0));
		bb.putInt(divisor);
		bb.putInt(data.length);

		ByteBuffer byteArray = PCUtils.intArrayToByteBuffer(data);
		bb.put(byteArray);

		bb.putShort(UIntAttribArrayDecoder.END);

		return (ByteBuffer) bb.flip();
	}

	@Override
	public int estimateSize(boolean head, UIntAttribArray obj) {
		return (head ? CodecManager.HEAD_SIZE : 0) + cm.estimateSize(false, obj.getName()) + 5 * Integer.BYTES + // index, dataSize, bufferType, divisor, dataLength
				1 + // isStatic
				Integer.BYTES * obj.getData().length + // data
				2; // end short
	}

}
