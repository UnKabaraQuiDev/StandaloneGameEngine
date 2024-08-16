package lu.kbra.standalone.gameengine.objs.entity.components;

import java.util.List;

import lu.kbra.standalone.gameengine.cache.CacheManager;
import lu.kbra.standalone.gameengine.graph.material.Material;
import lu.kbra.standalone.gameengine.graph.material.components.PointLightMaterialComponent;
import lu.kbra.standalone.gameengine.objs.entity.Component;

public class PointLightSurfaceComponent extends Component {

	public void bindLights(CacheManager cache, List<LightComponent> lights, Material mat) {
		PointLightMaterialComponent plm;
		if ((plm = mat.getComponent(PointLightMaterialComponent.class)) == null)
			return;

		int i = 0;
		for (LightComponent lc : lights) {
			if (lc instanceof PointLightComponent) {
				((PointLightComponent) lc).getPointLight(cache).bind(mat, plm.getLightName(), i++);
			} else {
				continue;
			}
			if (i >= plm.getMaxLights())
				break;
		}

		mat.setProperty(plm.getLightCountName(), i);
	}

}
