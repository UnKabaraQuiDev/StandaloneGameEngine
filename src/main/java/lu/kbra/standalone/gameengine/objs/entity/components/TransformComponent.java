package lu.kbra.standalone.gameengine.objs.entity.components;

import lu.kbra.standalone.gameengine.objs.entity.Component;
import lu.kbra.standalone.gameengine.utils.transform.Transform;

public abstract class TransformComponent extends Component {

	public abstract Transform getTransform();

}
