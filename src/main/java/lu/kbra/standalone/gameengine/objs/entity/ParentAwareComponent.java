package lu.kbra.standalone.gameengine.objs.entity;

import lu.kbra.pclib.logger.GlobalLogger;

sealed public interface ParentAwareComponent permits ParentAwareNode, ParentAwareRoot {

	static void checkHierarchy(ParentAwareComponent obj, ParentAwareNode child) {
		if (!(obj instanceof ParentAwareNode) && !(obj instanceof ParentAwareRoot))
			GlobalLogger.warning("Parent hierarchy broken: " + obj.getClass().getName() + " (" + obj + ") when adding "
					+ child.getClass().getName() + " (" + child + ")");
		else if (obj instanceof ParentAwareNode pa && pa.getParent() == null)
			GlobalLogger.warning("Parent hierarchy invalid: " + obj.getClass().getName() + " has null parent (" + obj + ") when adding "
					+ child.getClass().getName() + " (" + child + ")");
	}

}
