package lu.kbra.standalone.gameengine.graph.shader;

import java.util.HashMap;
import java.util.Map;

import org.joml.Vector3i;
import org.joml.Vector3ic;

import lu.kbra.standalone.gameengine.graph.shader.part.AbstractShader;
import lu.kbra.standalone.gameengine.graph.shader.part.ComputeShaderPart;

public class ComputeShader extends AbstractShader {

	public static final String LOCAL_SIZE_X = "%LOCAL_SIZE_X%";
	public static final String LOCAL_SIZE_Y = "%LOCAL_SIZE_Y%";
	public static final String LOCAL_SIZE_Z = "%LOCAL_SIZE_Z%";

	public static final String INPUT_SIZE = "inputSize";
	public static final String OUTPUT_SIZE = "outputSize";

	protected final Vector3ic localSize;

	protected static Map<String, Object> getBaseBuildingDeps(Vector3ic localSize) {
		final Map<String, Object> objs = new HashMap<>();
		objs.put(LOCAL_SIZE_X, localSize.x());
		objs.put(LOCAL_SIZE_Y, localSize.y());
		objs.put(LOCAL_SIZE_Z, localSize.z());
		return objs;
	}

	public ComputeShader(ComputeShaderPart part, Vector3ic localSize) {
		super(null, part);
		this.localSize = localSize;
	}

	public ComputeShader(String name, ComputeShaderPart part, Vector3ic localSize) {
		super(name, part);
		this.localSize = localSize;
	}

	public Vector3ic getGlobalGroup(Vector3ic totalCount) {
		totalCount = new Vector3i(1, 1, 1).max(totalCount);
		final int groupX = (totalCount.x() + this.localSize.x() - 1) / this.localSize.x();
		final int groupY = (totalCount.y() + this.localSize.y() - 1) / this.localSize.y();
		final int groupZ = (totalCount.z() + this.localSize.z() - 1) / this.localSize.z();
		return new Vector3i(groupX, groupY, groupZ);
	}

	@Override
	public void createUniforms() {
		createUniform(INPUT_SIZE);
		createUniform(OUTPUT_SIZE);
	}

	public Vector3ic getLocalSize() {
		return localSize;
	}

}
