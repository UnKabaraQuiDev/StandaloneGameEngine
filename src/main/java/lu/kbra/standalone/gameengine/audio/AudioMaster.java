package lu.kbra.standalone.gameengine.audio;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.util.List;
import java.util.Objects;

import org.joml.Vector3f;
import org.lwjgl.openal.AL;
import org.lwjgl.openal.AL11;
import org.lwjgl.openal.ALC;
import org.lwjgl.openal.ALC10;
import org.lwjgl.openal.ALC11;
import org.lwjgl.openal.ALCCapabilities;
import org.lwjgl.openal.ALCapabilities;
import org.lwjgl.openal.ALUtil;
import org.lwjgl.openal.EXTThreadLocalContext;
import org.lwjgl.system.MemoryUtil;

import lu.kbra.standalone.gameengine.impl.Cleanupable;
import lu.kbra.standalone.gameengine.utils.PDRLoggerUtils;
import lu.kbra.standalone.gameengine.utils.GameEngineUtils;
import lu.pcy113.pclib.logger.GlobalLogger;

public class AudioMaster implements Cleanupable {

	// https://github.com/LWJGL/lwjgl3/blob/master/modules/samples/src/test/java/org/lwjgl/demo/openal/ALCDemo.java

	private Thread thread;

	private boolean useTLC = false;
	private long device, alContext;
	private ALCCapabilities deviceCapabilities;;
	private ALCapabilities capabilities;

	public AudioMaster() {
		setup();

		// testPlayback();
	}

	private void setup() {
		this.thread = Thread.currentThread();

		device = ALC10.alcOpenDevice((ByteBuffer) null);
		if (device == MemoryUtil.NULL) {
			throw new RuntimeException("Could not open ALC device");
		}

		deviceCapabilities = ALC.createCapabilities(device);
		PDRLoggerUtils.log(deviceCapabilities);

		if (!deviceCapabilities.OpenALC10) {
			throw new RuntimeException("Could not open OpenAL device: OpenALC10 not supported");
		}

		GlobalLogger.info("Audio Output Devices: " + getDeviceNames());
		GlobalLogger.info("Default Audio Output Device: " + getDefaultDevice());
		GlobalLogger.info("Audio Output Device: " + getDeviceName());

		alContext = ALC10.alcCreateContext(device, (IntBuffer) null);
		GameEngineUtils.checkAlcError(device);

		useTLC = deviceCapabilities.ALC_EXT_thread_local_context && EXTThreadLocalContext.alcSetThreadContext(alContext);
		if (!useTLC) {
			if (!ALC11.alcMakeContextCurrent(alContext)) {
				throw new RuntimeException("Could not set context as thread context.");
			}
		}
		GameEngineUtils.checkAlcError(device);

		capabilities = AL.createCapabilities(deviceCapabilities, MemoryUtil::memCallocPointer);

		GlobalLogger.info("ALC_FREQUENCY: " + alcGetInteger(device, ALC11.ALC_FREQUENCY) + "Hz");
		GlobalLogger.info("ALC_REFRESH: " + alcGetInteger(device, ALC11.ALC_REFRESH) + "Hz");
		GlobalLogger.info("ALC_SYNC: " + alcGetBool(device, ALC11.ALC_SYNC));
		GlobalLogger.info("ALC_MONO_SOURCES: " + alcGetInteger(device, ALC11.ALC_MONO_SOURCES));
		GlobalLogger.info("ALC_STEREO_SOURCES: " + alcGetInteger(device, ALC11.ALC_STEREO_SOURCES));

		// System.out.println("Thread: "+Thread.currentThread().getName()+" al cap:
		// "+AL.getCapabilities());
	}

	public AudioMaster setDistanceModel(int model) {
		AL11.alDistanceModel(model);
		GameEngineUtils.checkAlError("DistanceModel()=" + model);
		return this;
	}

	public AudioMaster setPosition(Vector3f pos) {
		// System.err.println("sound cam pos: " + pos);
		AL11.alListener3f(AL11.AL_POSITION, pos.x, pos.y, pos.z);
		GameEngineUtils.checkAlError("Listener3f().POSITION=" + pos);
		return this;
	}

	public AudioMaster setVelocity(Vector3f vel) {
		AL11.alListener3f(AL11.AL_VELOCITY, vel.x, vel.y, vel.z);
		GameEngineUtils.checkAlError("Listener3f().VELOCITY=" + vel);
		return this;
	}

	public AudioMaster setVolume(float gain) {
		AL11.alListenerf(AL11.AL_GAIN, gain);
		GameEngineUtils.checkAlError("Listenerf().GAIN=" + gain);
		return this;
	}

	public AudioMaster setOrientation(Vector3f orientation, Vector3f up) {
		float[] orientationArr = { orientation.x, orientation.y, orientation.z, up.x, up.y, up.z };
		AL11.alListenerfv(AL11.AL_ORIENTATION, orientationArr);
		GameEngineUtils.checkAlError("Listenerfv().ORIENTATION=(" + orientation + ", " + up + ")");
		return this;
	}

	public AudioMaster setDopplerFactor(float factor) {
		AL11.alDopplerFactor(factor);
		GameEngineUtils.checkAlError("DopplerFactor()=" + factor);
		return this;
	}

	public AudioMaster setDopplerVelocity(float factor) {
		AL11.alDopplerVelocity(factor);
		GameEngineUtils.checkAlError("DopplerVelocity()=" + factor);
		return this;
	}

	public AudioMaster setSpeedOfSound(float speed) {
		AL11.alSpeedOfSound(speed);
		GameEngineUtils.checkAlError("SpeedOfSound()=" + speed);
		return this;
	}

	public boolean checkAccess() {
		return Objects.equals(Thread.currentThread(), thread);
	}

	public void checkAccessThrow() {
		if (!checkAccess()) {
			throw new IllegalAccessError(Thread.currentThread().getName() + " cannot access the audio context in " + getThreadName());
		}
	}

	public boolean alcGetBool(int param) {
		return alcGetBool(device, param);
	}

	public boolean alcGetBool(long device, int param) {
		return ALC11.alcGetInteger(device, param) == ALC11.ALC_TRUE;
	}

	public int alcGetInteger(long device, int param) {
		return ALC11.alcGetInteger(device, param);
	}

	public String alcGetString(int param, String str) {
		return GameEngineUtils.alcNullError(ALC11.alcGetString(MemoryUtil.NULL, param), str);
	}

	public String alcGetString(long addr, int param, String str) {
		return GameEngineUtils.alcNullError(ALC11.alcGetString(addr, param), str);
	}

	public String getDefaultDevice() {
		return GameEngineUtils.alcNullError(alcGetString(ALC11.ALC_DEFAULT_DEVICE_SPECIFIER, "Could not get default device."), "Default device is null");
	}

	public String getDeviceName() {
		return alcGetString(ALC11.ALC_DEVICE_SPECIFIER, "Could not get device.");
	}

	public List<String> getDeviceNames() {
		return GameEngineUtils.alcNullError(ALUtil.getStringList(MemoryUtil.NULL, ALC11.ALC_ALL_DEVICES_SPECIFIER), "Could not get devices.");
	}

	public long getDevice() {
		return device;
	}

	public Thread getThread() {
		return thread;
	}

	public String getThreadName() {
		return thread == null ? null : thread.getName();
	}

	@Override
	public void cleanup() {
		GlobalLogger.log("Cleaning up: "+getClass().getName()+" in "+thread.getName());
		
		if(device == -1)
			return;
		
		ALC10.alcDestroyContext(alContext);
		alContext = -1;
		// ALC11.alcMakeContextCurrent(MemoryUtil.NULL);
		if (useTLC) {
			AL.setCurrentThread(null);
		} else {
			AL.setCurrentProcess(null);
		}
		MemoryUtil.memFree(capabilities.getAddressBuffer());
		ALC10.alcCloseDevice(device);
		device = -1;
	}

}
