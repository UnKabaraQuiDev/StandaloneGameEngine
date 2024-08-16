package lu.kbra.standalone.gameengine.utils.mem.buffer;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.nio.ShortBuffer;

import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.libc.LibCStdlib;

import lu.kbra.standalone.gameengine.impl.Cleanupable;

public class MemBuffer<T extends Buffer> implements Cleanupable {

	private T buffer;
	private MemBufferOrigin origin;

	public MemBuffer(T buffer, MemBufferOrigin origin) {
		this.buffer = buffer;
		this.origin = origin;
	}

	@Override
	public void cleanup() {
		if(buffer == null)
			return;
		
		if (MemBufferOrigin.STBV.equals(origin)) {
			if(buffer instanceof ShortBuffer) {
				LibCStdlib.free((ShortBuffer) buffer);
			}else if(buffer instanceof ByteBuffer) {
				LibCStdlib.free((ByteBuffer) buffer);
			}else if(buffer instanceof IntBuffer) {
				LibCStdlib.free((IntBuffer) buffer);
			}else if(buffer instanceof DoubleBuffer) {
				LibCStdlib.free((DoubleBuffer) buffer);
			}else if(buffer instanceof FloatBuffer) {
				LibCStdlib.free((FloatBuffer) buffer);
			}else if(buffer instanceof LongBuffer) {
				LibCStdlib.free((LongBuffer) buffer);
			}
			buffer = null;
		} else if (MemBufferOrigin.OPENAL.equals(origin)) {
			MemoryUtil.memFree(buffer);
			buffer = null;
		}
	}

	public boolean isFromOAL() {
		return MemBufferOrigin.OPENAL.equals(origin);
	}

	public boolean isFromStbv() {
		return MemBufferOrigin.STBV.equals(origin);
	}

	public T getBuffer() {
		return buffer;
	}

}
