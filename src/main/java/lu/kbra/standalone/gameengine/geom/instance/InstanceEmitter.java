package lu.kbra.standalone.gameengine.geom.instance;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.Supplier;
import java.util.logging.Level;
import java.util.stream.Collectors;

import org.joml.Matrix4f;
import org.joml.Vector3f;

import lu.kbra.pclib.logger.GlobalLogger;
import lu.kbra.standalone.gameengine.cache.attrib.Mat4fAttribArray;
import lu.kbra.standalone.gameengine.cache.attrib.impl.JavaAttribArray;
import lu.kbra.standalone.gameengine.cache.attrib.types.JavaTypeAttribArray;
import lu.kbra.standalone.gameengine.generated.gl_wrapper.GL_W;
import lu.kbra.standalone.gameengine.geom.Mesh;
import lu.kbra.standalone.gameengine.impl.AutoCleanupable;
import lu.kbra.standalone.gameengine.impl.Cleanupable;
import lu.kbra.standalone.gameengine.impl.GLObject;
import lu.kbra.standalone.gameengine.impl.Renderable;
import lu.kbra.standalone.gameengine.impl.UniqueID;
import lu.kbra.standalone.gameengine.impl.future.Dispatcher;
import lu.kbra.standalone.gameengine.impl.future.TaskFuture;
import lu.kbra.standalone.gameengine.utils.gl.consts.BufferType;
import lu.kbra.standalone.gameengine.utils.transform.Transform;
import lu.kbra.standalone.gameengine.utils.transform.Transform3D;

public class InstanceEmitter extends AutoCleanupable implements Renderable, Cleanupable, UniqueID, GLObject {

	public static final int TRANSFORM_BUFFER_INDEX = 5;
	public static final int FIRST_BUFFER_INDEX = TRANSFORM_BUFFER_INDEX + Mat4fAttribArray.ATTRIB_LENGTH;
	public static final String TRANSFORM_BUFFER_NAME = "transforms";

	protected final String name;

	protected Instance[] particles;

	protected Mat4fAttribArray instancesTransforms;
	protected JavaAttribArray[] instancesAttribs;
	protected int count;

	protected Mesh instanceMesh;

	public InstanceEmitter(
			final String name,
			final Mesh mesh,
			final int count,
			final Transform baseTransform,
			final JavaAttribArray... attribs) {
		this(name, mesh, count, i -> baseTransform.clone(), attribs);
	}

	public InstanceEmitter(
			final String name,
			final Mesh mesh,
			final int count,
			final Mat4fAttribArray baseTransform,
			final JavaAttribArray... attribs) {
		this.name = name;
		this.count = count;

		instancesAttribs = attribs;
		instanceMesh = mesh;

		particles = new Instance[count];

		for (int i = 0; i < count; i++) {
			final Object[] atts = new Object[instancesAttribs.length];

			int c = 0;
			for (final JavaAttribArray a : attribs)
				atts[c++] = a.get(i);

			particles[i] = new Instance(i, atts, new Transform3D(baseTransform.get(i)));
		}

		instancesTransforms = baseTransform;

		mesh.bind();

		mesh.addAttribArray(instancesTransforms);
		for (final JavaAttribArray a : instancesAttribs) {
			if (mesh.getVbo().containsKey(a.getIndex())) {
				GlobalLogger.log(Level.WARNING, "Duplicate of index: " + a.getIndex() + " from " + a.getName() + ", in Mesh: " + name);
				continue;
			}
			mesh.addAttribArray(a);
		}

		mesh.unbind();

		GlobalLogger.log(Level.INFO,
				"ParticleEmitter " + name + ": mesh:(" + mesh.getId() + " & " + mesh.getVbo() + "); count:" + count + "; attribs: "
						+ Arrays.toString(attribs));
	}

	public InstanceEmitter(
			final String name,
			final Mesh mesh,
			final int count,
			final IntFunction<Transform> baseTransform,
			final JavaAttribArray... attribs) {
		this.name = name;
		this.count = count;

		instancesAttribs = attribs;
		instanceMesh = mesh;

		particles = new Instance[count];

		for (int i = 0; i < count; i++) {
			final Object[] atts = new Object[instancesAttribs.length];

			int c = 0;
			for (final JavaAttribArray a : attribs)
				atts[c++] = a.get(i);

			particles[i] = new Instance(i, atts, baseTransform.apply(i));
		}

		instancesTransforms = new Mat4fAttribArray(TRANSFORM_BUFFER_NAME,
				TRANSFORM_BUFFER_INDEX,
				Arrays.stream(particles).map(c -> c.getTransform().getMatrix()).toArray(Matrix4f[]::new),
				BufferType.ARRAY,
				false,
				1);

		mesh.bind();

		mesh.addAttribArray(instancesTransforms);
		for (final JavaAttribArray a : instancesAttribs) {
			if (mesh.getVbo().containsKey(a.getIndex())) {
				GlobalLogger.log(Level.WARNING, "Duplicate of index: " + a.getIndex() + " from " + a.getName() + ", in Mesh: " + name);
				continue;
			}
			mesh.addAttribArray(a);
		}

		mesh.unbind();

		GlobalLogger.log(Level.INFO,
				"ParticleEmitter " + name + ": mesh:(" + mesh.getId() + " & " + mesh.getVbo() + "); count:" + count + "; attribs: "
						+ Arrays.toString(attribs));
	}

	/**
	 * <h3>DOES NOT CALL Transform#updateMatrix()</h3>
	 */
	public void update(final Consumer<Instance> update) {
		final Matrix4f[] transforms = new Matrix4f[count];
		final Object[] atts = new Object[instancesAttribs.length];

		for (int c = 0; c < instancesAttribs.length; c++) {
			final JavaTypeAttribArray a = instancesAttribs[c];
			atts[c] = Array.newInstance(a.getType(), count);
		}

		for (int i = 0; i < count; i++) {
			update.accept(particles[i]);

			transforms[i] = particles[i].getTransform().getMatrix();

			for (int c = 0; c < instancesAttribs.length; c++) {
				final JavaTypeAttribArray a = instancesAttribs[c];
				Array.set(atts[c], i, particles[i].getBuffers()[c]);
			}
		}

		instancesTransforms.update(transforms);

		for (int c = 0; c < instancesAttribs.length; c++)
			JavaAttribArray.update(instancesAttribs[c], atts[c]);
		GL_W.glBindBuffer(BufferType.ARRAY.getGlId(), 0);
	}

	public void updateDirect(final Matrix4f[] transforms, final Object[][] atts) {
		if (transforms.length != count || atts.length != instancesAttribs.length)
			throw new IllegalArgumentException();

		// update this.particles to the new values ?

		instancesTransforms.update(transforms);

		for (int c = 0; c < instancesAttribs.length; c++)
			JavaAttribArray.update(instancesAttribs[c], atts[c]);
		GL_W.glBindBuffer(BufferType.ARRAY.getGlId(), 0);
	}

	public void updateParticles() {
		final Matrix4f[] transforms = new Matrix4f[count];
		final Object[][] atts = new Object[instancesAttribs.length][count];

		for (int i = 0; i < count; i++) {
			transforms[i] = particles[i].getTransform().getMatrix();

			for (int c = 0; c < instancesAttribs.length; c++)
				atts[c][i] = particles[i].getBuffers()[c];
		}

		instancesTransforms.update(transforms);

		for (int c = 0; c < instancesAttribs.length; c++)
			JavaAttribArray.update(instancesAttribs[c], atts[c]);
		GL_W.glBindBuffer(BufferType.ARRAY.getGlId(), 0);
	}

	public void updateParticlesTransforms() {
		final Matrix4f[] transforms = new Matrix4f[count];

		for (int i = 0; i < count; i++)
			transforms[i] = particles[i].getTransform().getMatrix();

		instancesTransforms.update(transforms);

		GL_W.glBindBuffer(BufferType.ARRAY.getGlId(), 0);
	}

	public TaskFuture<?, Void> updateParticlesTransforms(
			final Set<Integer> indices,
			final Optional<Dispatcher> worker,
			final Dispatcher render) {
		if (worker.isPresent())
			return new TaskFuture<>(worker.get(), (Supplier<Map<Integer, Matrix4f[]>>) () -> computeUpdateGroups(indices)).then(render,
					(Consumer<Map<Integer, Matrix4f[]>>) (result) -> result.entrySet()
					.forEach(entry -> instancesTransforms.update(entry.getKey(), entry.getValue())));
		final Map<Integer, Matrix4f[]> result = computeUpdateGroups(indices);
		return new TaskFuture<>(render,
				(Runnable) () -> result.entrySet().forEach(entry -> instancesTransforms.update(entry.getKey(), entry.getValue())));
	}

	public TaskFuture<?, Void> updateParticlesTransforms(final Set<Integer> indices, final Dispatcher worker, final Dispatcher render) {
		return new TaskFuture<>(worker, (Supplier<Map<Integer, Matrix4f[]>>) () -> computeUpdateGroups(indices)).then(render,
				(Consumer<Map<Integer, Matrix4f[]>>) (result) -> result.entrySet()
				.forEach(entry -> instancesTransforms.update(entry.getKey(), entry.getValue())));
	}

	public TaskFuture<?, Void> updateParticlesTransforms(final Set<Integer> indices, final Dispatcher render) {
		final Map<Integer, Matrix4f[]> result = computeUpdateGroups(indices);
		return new TaskFuture<>(render,
				(Runnable) () -> result.entrySet().forEach(entry -> instancesTransforms.update(entry.getKey(), entry.getValue())));
	}

	protected Map<Integer, Matrix4f[]> computeUpdateGroups(final Set<Integer> indices) {
		final Map<Integer, Matrix4f[]> result = new LinkedHashMap<>();

		if (indices == null || indices.isEmpty())
			return result;

		final List<Integer> sorted = new ArrayList<>(indices);
		Collections.sort(sorted);

		int currentStart = -1;
		int previousIndex = -1;

		final List<Matrix4f> currentMatrices = new ArrayList<>();

		for (final int index : sorted) {
			if (index < 0 || index >= count)
				continue;

			final Matrix4f matrix = particles[index].getTransform().getMatrix();

			if (currentStart == -1) {
				currentStart = index;

				currentMatrices.add(matrix);
			} else if (index == previousIndex + 1)
				currentMatrices.add(matrix);
			else {
				result.put(currentStart, currentMatrices.toArray(new Matrix4f[0]));

				currentMatrices.clear();
				currentStart = index;
				currentMatrices.add(matrix);
			}

			previousIndex = index;
		}

		if (!currentMatrices.isEmpty())
			result.put(currentStart, currentMatrices.toArray(new Matrix4f[0]));

		System.err.println(result.entrySet()
				.stream()
				.map(c -> c.getKey() + " "
						+ Arrays.stream(c.getValue())
						.map(d -> d.getTranslation(new Vector3f()).toString())
						.collect(Collectors.joining(", ")))
				.collect(Collectors.joining(", ")));

		return result;
	}

	public void updateParticlesTransforms(final Set<Integer> indices) {
		if (indices == null || indices.isEmpty())
			return;

		computeUpdateGroups(indices).entrySet().forEach(entry -> instancesTransforms.update(entry.getKey(), entry.getValue()));

		GL_W.glBindBuffer(BufferType.ARRAY.getGlId(), 0);
	}

	public void bind() {
		instanceMesh.bind();
	}

	public void unbind() {
		instanceMesh.unbind();
	}

	public Matrix4f[] resize(final int newCount, final Transform baseTransform) {
		return this.resize(newCount, i -> baseTransform.clone());
	}

	public Matrix4f[] resize(final int newCount, final Function<Integer, Transform> baseTransform) {
		count = newCount;
		final Matrix4f[] transforms;

		if (particles != null && particles.length > count) { // reduce the array
			final Instance[] newParts = new Instance[count];
			System.arraycopy(particles, 0, newParts, 0, count);
			particles = newParts;

			transforms = Arrays.stream(particles).map(c -> c.getTransform().getMatrix()).toArray(Matrix4f[]::new);

			for (final JavaAttribArray arr : instancesAttribs) {
				final Object nData = Array.newInstance(arr.getData().getClass().getComponentType(), newCount);
				System.arraycopy(arr.getData(), 0, nData, 0, newCount);
				JavaAttribArray.resize(arr, nData);
			}

		} else { // add new ones

			final Instance[] newParts = new Instance[newCount];
			if (particles != null)
				System.arraycopy(particles, 0, newParts, 0, particles.length);

			for (int i = particles == null ? 0 : particles.length; i < count; i++) {
				final Object[] atts = new Object[instancesAttribs.length];

				newParts[i] = new Instance(i, baseTransform.apply(i), atts);
			}
			particles = newParts;

			transforms = Arrays.stream(particles).map(c -> c.getTransform().getMatrix()).toArray(Matrix4f[]::new);
		}

		if (instancesTransforms != null)
			instancesTransforms.resize(transforms);

		for (final JavaAttribArray arr : instancesAttribs) {
			final Object nData = Array.newInstance(arr.getData().getClass().getComponentType(), newCount);
			System.arraycopy(arr.getData(), 0, nData, 0, Math.min(Array.getLength(arr.getData()), newCount));
			JavaAttribArray.resize(arr, nData);
		}

		count = newCount;

		return transforms;
	}

	@Override
	public void cleanup() {
		if (instanceMesh == null)
			return;

		Arrays.stream(instancesAttribs).forEach(JavaAttribArray::cleanup);
		instancesAttribs = null;

		instancesTransforms.cleanup();
		instancesTransforms = null;

		instanceMesh.cleanup();
		instanceMesh = null;

		super.cleanup();
	}

	@Override
	public String getId() {
		return name;
	}

	@Override
	public int getGlId() {
		return instanceMesh.getGlId();
	}

	public int getParticleCount() {
		return count;
	}

	public Mesh getParticleMesh() {
		return instanceMesh;
	}

	public Instance[] getParticles() {
		return particles;
	}

	public JavaTypeAttribArray[] getParticleAttribs() {
		return instancesAttribs;
	}

	public Mat4fAttribArray getParticleTransforms() {
		return instancesTransforms;
	}

	@Override
	public boolean isValid() {
		return instanceMesh != null && instanceMesh.isValid() && instancesTransforms.isValid();
	}

	@Override
	public String toString() {
		if (instanceMesh == null)
			return "InstanceEmitter [name=" + name + ", particles=" + particles.length + ", instancesTransforms="
			+ instancesTransforms + ", instancesAttribs=" + Arrays.toString(instancesAttribs) + ", count=" + count
			+ ", instanceMesh=" + instanceMesh + ", isValid()=" + isValid() + ", instanceMesh=null]";
		return "InstanceEmitter [name=" + name + ", particles=" + particles.length + ", instancesTransforms="
		+ instancesTransforms + ", instancesAttribs=" + Arrays.toString(instancesAttribs) + ", count=" + count
		+ ", instanceMesh=" + instanceMesh + ", isValid()=" + isValid() + ", instanceMesh.getGlid()="
		+ instanceMesh.getGlId() + ", instanceMesh.getVbo()=" + instanceMesh.getVbo() + "]";
	}

}
