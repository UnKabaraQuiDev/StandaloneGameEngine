package lu.kbra.standalone.gameengine.geom.utils;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.joml.Matrix4f;
import org.joml.Quaternionf;
import org.joml.Vector3f;

import lu.kbra.standalone.gameengine.anim.skeletal.Animation;
import lu.kbra.standalone.gameengine.anim.skeletal.ArmatureAnimation;
import lu.kbra.standalone.gameengine.anim.skeletal.Bone;
import lu.kbra.standalone.gameengine.anim.skeletal.BoneTransform;
import lu.kbra.standalone.gameengine.anim.skeletal.KeyFrame;
import lu.kbra.standalone.gameengine.cache.attrib.UIntAttribArray;
import lu.kbra.standalone.gameengine.cache.attrib.Vec2fAttribArray;
import lu.kbra.standalone.gameengine.cache.attrib.Vec3fAttribArray;
import lu.kbra.standalone.gameengine.geom.Mesh;
import lu.kbra.standalone.gameengine.geom.utils.colladaLoader.DeepColladaLoader;
import lu.kbra.standalone.gameengine.geom.utils.dataStructures.AnimatedModelData;
import lu.kbra.standalone.gameengine.geom.utils.dataStructures.AnimationData;
import lu.kbra.standalone.gameengine.geom.utils.dataStructures.JointData;
import lu.kbra.standalone.gameengine.geom.utils.dataStructures.JointTransformData;
import lu.kbra.standalone.gameengine.geom.utils.dataStructures.KeyFrameData;
import lu.kbra.standalone.gameengine.geom.utils.dataStructures.MeshData;
import lu.kbra.standalone.gameengine.geom.utils.dataStructures.SkeletonData;
import lu.kbra.standalone.gameengine.graph.material.Material;
import lu.kbra.standalone.gameengine.utils.GameEngineUtils;
import lu.kbra.standalone.gameengine.utils.gl.wrapper.GL_W;
import lu.pcy113.pclib.datastructure.pair.Pair;

public class ColladaeLoader {

	@Deprecated
	public static Mesh loadMesh(String name, Material material, String path) {
		AnimatedModelData amd = DeepColladaLoader.loadColladaModel(new File(path));

		MeshData ms = amd.getMeshData();

		Vec3fAttribArray vertices = new Vec3fAttribArray("pos", 0, 1, GameEngineUtils.floatArrayToVec3f(ms.getNormals()), GL_W.GL_ARRAY_BUFFER);
		UIntAttribArray indices = new UIntAttribArray("ind", -1, 1, ms.getIndices(), GL_W.GL_ELEMENT_ARRAY_BUFFER);
		Vec3fAttribArray normal = new Vec3fAttribArray("norm", 1, 1, GameEngineUtils.floatArrayToVec3f(ms.getNormals()), GL_W.GL_ARRAY_BUFFER);
		Vec2fAttribArray uv = new Vec2fAttribArray("uv", 2, 1, GameEngineUtils.floatArrayToVec2f(ms.getTextureCoords()), GL_W.GL_ARRAY_BUFFER);
		Vec3fAttribArray joints = new Vec3fAttribArray("joints", 3, 1, GameEngineUtils.intArrayToVec3f(ms.getJointIds()), GL_W.GL_ARRAY_BUFFER);
		Vec3fAttribArray weights = new Vec3fAttribArray("weights", 4, 1, GameEngineUtils.floatArrayToVec3f(ms.getVertexWeights()), GL_W.GL_ARRAY_BUFFER);

		Mesh mesh = new Mesh(name, material, vertices, indices, normal, uv, joints, weights);

		return mesh;
	}

	public static Pair<Mesh, ArmatureAnimation> loadMeshArmature(String name, Material material, String path) {
		AnimatedModelData amd = DeepColladaLoader.loadColladaModelArmature(new File(path), ArmatureAnimation.MAX_WEIGHTS);

		MeshData ms = amd.getMeshData();
		SkeletonData sd = amd.getJointsData();

		Vec3fAttribArray vertices = new Vec3fAttribArray("pos", 0, 1, GameEngineUtils.floatArrayToVec3f(ms.getNormals()), GL_W.GL_ARRAY_BUFFER);
		UIntAttribArray indices = new UIntAttribArray("ind", -1, 1, ms.getIndices(), GL_W.GL_ELEMENT_ARRAY_BUFFER);
		Vec3fAttribArray normal = new Vec3fAttribArray("norm", 1, 1, GameEngineUtils.floatArrayToVec3f(ms.getNormals()), GL_W.GL_ARRAY_BUFFER);
		Vec2fAttribArray uv = new Vec2fAttribArray("uv", 2, 1, GameEngineUtils.floatArrayToVec2f(ms.getTextureCoords()), GL_W.GL_ARRAY_BUFFER);
		Vec3fAttribArray joints = new Vec3fAttribArray("joints", 3, 1, GameEngineUtils.intArrayToVec3f(ms.getJointIds()), GL_W.GL_ARRAY_BUFFER);
		Vec3fAttribArray weights = new Vec3fAttribArray("weights", 4, 1, GameEngineUtils.floatArrayToVec3f(ms.getVertexWeights()), GL_W.GL_ARRAY_BUFFER);

		Mesh mesh = new Mesh(name, material, vertices, indices, normal, uv, joints, weights);

		Bone root = createBone(sd.headJoint);

		ArmatureAnimation anim = new ArmatureAnimation(root, sd.jointCount);

		return new Pair<>(mesh, anim);
	}

	private static Bone createBone(JointData data) {
		Bone joint = new Bone(data.index, data.nameId, data.bindLocalTransform);
		for (JointData child : data.children) {
			joint.addChild(createBone(child));
		}
		return joint;
	}

	public static Animation loadAnimation(String path) {
		AnimationData animationData = DeepColladaLoader.loadColladaAnimation(new File(path));
		KeyFrame[] frames = new KeyFrame[animationData.keyFrames.length];
		for (int i = 0; i < frames.length; i++) {
			frames[i] = createKeyFrame(animationData.keyFrames[i]);
		}
		return new Animation(animationData.lengthSeconds, frames);
	}

	private static KeyFrame createKeyFrame(KeyFrameData data) {
		Map<String, BoneTransform> map = new HashMap<String, BoneTransform>();
		for (JointTransformData jointData : data.jointTransforms) {
			BoneTransform BoneTransform = createTransform(jointData);
			map.put(jointData.jointNameId, BoneTransform);
		}
		return new KeyFrame(data.time, map);
	}

	private static BoneTransform createTransform(JointTransformData data) {
		Matrix4f mat = data.jointLocalTransform;
		Vector3f translation = new Vector3f(mat.m30(), mat.m31(), mat.m32());
		Quaternionf rotation = mat.getNormalizedRotation(new Quaternionf());
		return new BoneTransform(translation, rotation);
	}

}
