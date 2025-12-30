package lu.kbra.standalone.gameengine.geom.instance;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.logging.Level;

import org.joml.Matrix4f;

import lu.pcy113.pclib.logger.GlobalLogger;

import lu.kbra.standalone.gameengine.cache.attrib.Mat4fAttribArray;
import lu.kbra.standalone.gameengine.cache.attrib.impl.AttribArray;
import lu.kbra.standalone.gameengine.cache.attrib.types.JavaTypeAttribArray;
import lu.kbra.standalone.gameengine.generated.gl_wrapper.GL_W;
import lu.kbra.standalone.gameengine.geom.Mesh;
import lu.kbra.standalone.gameengine.impl.Cleanupable;
import lu.kbra.standalone.gameengine.impl.GLObject;
import lu.kbra.standalone.gameengine.impl.Renderable;
import lu.kbra.standalone.gameengine.impl.UniqueID;
import lu.kbra.standalone.gameengine.utils.gl.consts.BufferType;
import lu.kbra.standalone.gameengine.utils.transform.Transform;

public class InstanceEmitter implements Renderable, Cleanupable, UniqueID, GLObject {

	public static final int TRANSFORM_BUFFER_INDEX = 5;
	public static final int FIRST_BUFFER_INDEX = TRANSFORM_BUFFER_INDEX + Mat4fAttribArray.ATTRIB_LENGTH;
	public static final String TRANSFORM_BUFFER_NAME = "transforms";

	protected final String name;

	protected Instance[] particles;

	protected Mat4fAttribArray instancesTransforms;
	protected AttribArray[] instancesAttribs;
	protected int count;

	protected Mesh instanceMesh;

	public InstanceEmitter(String name, Mesh mesh, int count, Transform baseTransform, AttribArray... attribs) {
		this(name, mesh, count, i -> baseTransform.clone(), attribs);
	}

	public InstanceEmitter(String name, Mesh mesh, int count, Function<Integer, Transform> baseTransform, AttribArray... attribs) {
		this.name = name;
		this.count = count;

		this.instancesAttribs = attribs;
		this.instanceMesh = mesh;

		this.particles = new Instance[count];

		for (int i = 0; i < count; i++) {
			final Object[] atts = new Object[this.instancesAttribs.length];

			int c = 0;
			for (AttribArray a : attribs) {
				atts[c++] = a.get(i);
			}

			particles[i] = new Instance(i, atts, baseTransform.apply(i));
		}

		this.instancesTransforms = new Mat4fAttribArray(TRANSFORM_BUFFER_NAME, TRANSFORM_BUFFER_INDEX, 1,
				Arrays.stream(particles).map(c -> c.getTransform().getMatrix()).toArray(Matrix4f[]::new), BufferType.ARRAY, false, 1);

		mesh.bind();

		mesh.addAttribArray(this.instancesTransforms);
		for (AttribArray a : this.instancesAttribs) {
			if (mesh.getVbo().containsKey(a.getIndex())) {
				GlobalLogger.log(Level.WARNING, "Duplicate of index: " + a.getIndex() + " from " + a.getName() + ", in Mesh: " + name);
				continue;
			}
			mesh.addAttribArray(a);
		}

		mesh.unbind();

		GlobalLogger
				.log(Level.INFO,
						"ParticleEmitter " + name + ": mesh:(" + mesh.getId() + " & " + mesh.getVbo() + "); count:" + count + "; attribs: "
								+ Arrays.toString(attribs));
	}

	/**
	 * <h3>DOES NOT CALL Transform#updateMatrix()</h3>
	 */
	public void update(Consumer<Instance> update) {
		final Matrix4f[] transforms = new Matrix4f[this.count];
		final Object[] atts = new Object[this.instancesAttribs.length];

		for (int c = 0; c < this.instancesAttribs.length; c++) {
			final JavaTypeAttribArray a = instancesAttribs[c];
			atts[c] = Array.newInstance(a.getType(), count);
		}

		for (int i = 0; i < this.count; i++) {
			update.accept(this.particles[i]);

			transforms[i] = this.particles[i].getTransform().getMatrix();

			for (int c = 0; c < this.instancesAttribs.length; c++) {
				final JavaTypeAttribArray a = instancesAttribs[c];
				((Object[]) atts[c])[i] = a.getType().cast(this.particles[i].getBuffers()[c]);
			}
		}

		instancesTransforms.update(transforms);

		for (int c = 0; c < this.instancesAttribs.length; c++) {
			AttribArray.update(this.instancesAttribs[c], atts[c]);
		}
		GL_W.glBindBuffer(BufferType.ARRAY.getGlId(), 0);
	}

	public void updateDirect(Matrix4f[] transforms, Object[][] atts) {
		if (transforms.length != this.count || atts.length != this.instancesAttribs.length) {
			throw new IllegalArgumentException();
		}

		// update this.particles to the new values ?

		instancesTransforms.update(transforms);

		for (int c = 0; c < this.instancesAttribs.length; c++) {
			AttribArray.update(this.instancesAttribs[c], atts[c]);
		}
		GL_W.glBindBuffer(BufferType.ARRAY.getGlId(), 0);
	}

	public void updateParticles() {
		final Matrix4f[] transforms = new Matrix4f[this.count];
		final Object[][] atts = new Object[this.instancesAttribs.length][this.count];

		for (int i = 0; i < this.count; i++) {
			transforms[i] = this.particles[i].getTransform().getMatrix();

			for (int c = 0; c < this.instancesAttribs.length; c++) {
				atts[c][i] = this.particles[i].getBuffers()[c];
			}
		}

		instancesTransforms.update(transforms);

		for (int c = 0; c < this.instancesAttribs.length; c++) {
			AttribArray.update(this.instancesAttribs[c], atts[c]);
		}
		GL_W.glBindBuffer(BufferType.ARRAY.getGlId(), 0);
	}

	public void updateParticlesTransforms() {
		final Matrix4f[] transforms = new Matrix4f[this.count];

		for (int i = 0; i < this.count; i++) {
			transforms[i] = this.particles[i].getTransform().getMatrix();
		}

		instancesTransforms.update(transforms);

		GL_W.glBindBuffer(BufferType.ARRAY.getGlId(), 0);
	}

	public void bind() {
		this.instanceMesh.bind();
	}

	public void unbind() {
		this.instanceMesh.unbind();
	}

	public Matrix4f[] resize(int newCount, Transform baseTransform) {
		return this.resize(newCount, i -> baseTransform.clone());
	}

	public Matrix4f[] resize(int newCount, Function<Integer, Transform> baseTransform) {
		this.count = newCount;
		final Matrix4f[] transforms;

		if (particles != null && particles.length > count) { // reduce the array
			final Instance[] newParts = new Instance[count];
			System.arraycopy(this.particles, 0, newParts, 0, count);
			this.particles = newParts;

			transforms = Arrays.stream(particles).map(c -> c.getTransform().getMatrix()).toArray(Matrix4f[]::new);

			for (AttribArray arr : instancesAttribs) {
				final Object nData = Array.newInstance(arr.getData().getClass().getComponentType(), newCount);
				System.arraycopy(arr.getData(), 0, nData, 0, newCount);
				AttribArray.resize(arr, nData);
			}

		} else { // add new ones

			final Instance[] newParts = new Instance[newCount];
			if (this.particles != null) {
				System.arraycopy(this.particles, 0, newParts, 0, this.particles.length);
			}

			for (int i = this.particles == null ? 0 : this.particles.length; i < count; i++) {
				final Object[] atts = new Object[this.instancesAttribs.length];

				newParts[i] = new Instance(i, baseTransform.apply(i), atts);
			}
			this.particles = newParts;

			transforms = Arrays.stream(particles).map(c -> c.getTransform().getMatrix()).toArray(Matrix4f[]::new);
		}

		if (instancesTransforms != null) {
			instancesTransforms.resize(transforms);
		}

		for (AttribArray arr : instancesAttribs) {
			final Object nData = Array.newInstance(arr.getData().getClass().getComponentType(), newCount);
			System.arraycopy(arr.getData(), 0, nData, 0, Math.min(Array.getLength(arr.getData()), newCount));
			AttribArray.resize(arr, nData);
		}

		this.count = newCount;

		return transforms;
	}

	@Override
	public void cleanup() {
		GlobalLogger.log();
		GlobalLogger.log("Cleaning up: " + name);

		if (instanceMesh == null) {
			return;
		}

		Arrays.stream(this.instancesAttribs).forEach(AttribArray::cleanup);
		this.instancesAttribs = null;

		this.instancesTransforms.cleanup();
		this.instancesTransforms = null;

		this.instanceMesh.cleanup();
		this.instanceMesh = null;
	}

	@Override
	public String getId() {
		return this.name;
	}

	@Override
	public int getGlId() {
		return instanceMesh.getGlId();
	}

	public int getParticleCount() {
		return this.count;
	}

	public Mesh getParticleMesh() {
		return this.instanceMesh;
	}

	public Instance[] getParticles() {
		return particles;
	}

	public JavaTypeAttribArray[] getParticleAttribs() {
		return this.instancesAttribs;
	}

	public JavaTypeAttribArray getParticleTransforms() {
		return this.instancesTransforms;
	}

	@Override
	public boolean isValid() {
		return instanceMesh != null && instanceMesh.isValid() && instancesTransforms.isValid();
	}

	@Override
	public String toString() {
		return "InstanceEmitter [name=" + name + ", particles=" + particles.length + ", instancesTransforms="
				+ instancesTransforms + ", instancesAttribs=" + Arrays.toString(instancesAttribs) + ", count=" + count + ", instanceMesh="
				+ instanceMesh + ", isValid()=" + isValid() + ", instanceMesh.getGlid()=" + instanceMesh.getGlId()
				+ ", instanceMesh.getVbo()=" + instanceMesh.getVbo() + "]";
	}

}
