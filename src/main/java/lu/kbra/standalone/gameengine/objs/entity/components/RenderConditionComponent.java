package lu.kbra.standalone.gameengine.objs.entity.components;

import java.util.function.Supplier;

import lu.kbra.standalone.gameengine.objs.entity.Component;

public class RenderConditionComponent extends Component implements Supplier<Boolean> {

	private Supplier<Boolean> supplier;

	/**
	 * is skipped if returns true
	 */
	public RenderConditionComponent(Supplier<Boolean> sup) {
		this.supplier = sup;
	}
	
	@Override
	public Boolean get() {
		return supplier.get();
	}

}
