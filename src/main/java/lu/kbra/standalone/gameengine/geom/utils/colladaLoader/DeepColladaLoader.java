package lu.kbra.standalone.gameengine.geom.utils.colladaLoader;

import java.io.File;

import lu.kbra.standalone.gameengine.geom.utils.dataStructures.AnimatedModelData;
import lu.kbra.standalone.gameengine.geom.utils.dataStructures.AnimationData;
import lu.kbra.standalone.gameengine.geom.utils.dataStructures.MeshData;
import lu.kbra.standalone.gameengine.geom.utils.dataStructures.SkeletonData;
import lu.kbra.standalone.gameengine.geom.utils.dataStructures.SkinningData;
import lu.kbra.standalone.gameengine.geom.utils.xmlParser.XmlNode;
import lu.kbra.standalone.gameengine.geom.utils.xmlParser.XmlParser;

public class DeepColladaLoader {

	public static AnimatedModelData loadColladaModel(File colladaFile) {
		XmlNode node = XmlParser.loadXmlFile(colladaFile);

		GeometryLoader g = new GeometryLoader(node.getChild("library_geometries"), null);
		MeshData meshData = g.extractModelData();

		return new AnimatedModelData(meshData, null);
	}

	public static AnimatedModelData loadColladaModelArmature(File colladaFile, int maxWeights) {
		XmlNode node = XmlParser.loadXmlFile(colladaFile);

		SkinLoader skinLoader = new SkinLoader(node.getChild("library_controllers"), maxWeights);
		SkinningData skinningData = skinLoader.extractSkinData();

		SkeletonLoader jointsLoader = new SkeletonLoader(node.getChild("library_visual_scenes"), skinningData.jointOrder);
		SkeletonData jointsData = jointsLoader.extractBoneData();

		GeometryLoader g = new GeometryLoader(node.getChild("library_geometries"), skinningData.verticesSkinData);
		MeshData meshData = g.extractModelData();

		return new AnimatedModelData(meshData, jointsData);
	}

	public static AnimationData loadColladaAnimation(File colladaFile) {
		XmlNode node = XmlParser.loadXmlFile(colladaFile);
		XmlNode animNode = node.getChild("library_animations");
		XmlNode jointsNode = node.getChild("library_visual_scenes");
		AnimationLoader loader = new AnimationLoader(animNode, jointsNode);
		AnimationData animData = loader.extractAnimation();
		return animData;
	}

}
