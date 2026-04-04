package lu.kbra.standalone.gameengine.audio;

import java.util.ArrayList;
import java.util.List;

import lu.kbra.standalone.gameengine.exceptions.openal.ALRuntimeException;

public class ALSourcePool {

	private AudioMaster audio;

	private int maxSources;
	private int sourceCount = 0;
	private List<ALSource> availableSources;
	private List<ALSource> usedSources;

	public ALSourcePool(AudioMaster audio, int maxSources) {
		this.audio = audio;
		this.maxSources = maxSources;
		availableSources = new ArrayList<>();
		usedSources = new ArrayList<>();

		if (!audio.checkAccess())
			throw new ALRuntimeException("Could not create ALSourcePool in thread: " + Thread.currentThread().getName()
					+ ", should be in Audio thread: " + audio.getThreadName());
	}

	public ALSource getFreeSource() {
		for (ALSource source : availableSources)
			if (source.isFree())
				return source;
			else
				usedSources.add(source);

		if (sourceCount >= maxSources)
			return null;

		final ALSource newSource = new ALSource(this);
		newSource.gen();
		availableSources.add(newSource);
		sourceCount++;
		return newSource;
	}

	public int genSources(int count) {
		for (int i = 0; i < count; i++) {
			try {
				final ALSource newSource = new ALSource(this);
				newSource.gen();
				availableSources.add(newSource);
				sourceCount++;
			} catch (ALRuntimeException e) {
				throw e;
				//				return i;
			}

			if (sourceCount <= maxSources)
				continue;
		}
		return count;
	}

	public void update(ALSource source) {
		if (source.isFree()) {
			availableSources.add(source);
			usedSources.remove(source);
		} else {
			availableSources.remove(source);
			usedSources.add(source);
		}
	}

	public void remove(ALSource source) {
		availableSources.remove(source);
		usedSources.remove(source);
		sourceCount--;
	}

}
