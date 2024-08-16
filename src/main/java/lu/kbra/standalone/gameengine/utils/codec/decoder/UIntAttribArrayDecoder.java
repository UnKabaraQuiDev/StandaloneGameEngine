package lu.kbra.standalone.gameengine.utils.codec.decoder;

import java.nio.ByteBuffer;

import lu.kbra.standalone.gameengine.cache.attrib.UIntAttribArray;
import lu.kbra.standalone.gameengine.utils.GameEngineUtils;
import lu.pcy113.jbcodec.decoder.DefaultObjectDecoder;
import lu.pcy113.jbcodec.decoder.StringDecoder;
import lu.pcy113.pclib.PCUtils;

/**
 * STRING name ; INT index ; INT dataSize ; INT bufferType ; BOOL _static ; INT
 * divisor ; INT arrayLength ; INT[] data ; INT END
 */
public class UIntAttribArrayDecoder extends DefaultObjectDecoder<UIntAttribArray> {

	public static final short END = 32323;

	public UIntAttribArrayDecoder() {
		super(UIntAttribArray.class);
	}

	@Override
	public UIntAttribArray decode(boolean head, ByteBuffer bb) {
		verifyHeader(head, bb);

		String name = ((StringDecoder) cm.getDecoderByClass(String.class)).decode(false, bb);

		int index = bb.getInt();
		int dataSize = bb.getInt();
		int bufferType = bb.getInt();
		boolean _static = bb.get() != 0;
		int divisor = bb.getInt();
		int arrayLength = bb.getInt();
		int[] data = PCUtils.byteBufferToIntArray(bb, arrayLength);
		// PDRUtils.castInt(((ArrayDecoder)
		// cm.getDecoderByClass(Object[].class)).decode(false, bb));

		if (bb.getShort() != END) {
			throw new RuntimeException("Error happened while decoding UIntAttribArray.");
		}

		// String name, int index, int dataSize, int[] data, int bufferType, boolean
		// _static, int divisor
		return new UIntAttribArray(name, index, dataSize, data, bufferType, _static, divisor);
	}

}
