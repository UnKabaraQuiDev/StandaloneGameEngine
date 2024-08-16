package lu.kbra.standalone.gameengine.graph.shader.part;

import lu.kbra.standalone.gameengine.impl.shader.AbstractShaderPart;
import lu.kbra.standalone.gameengine.utils.gl.wrapper.GL_W;

public class FragmentShaderPart extends AbstractShaderPart {

	public FragmentShaderPart(String file) {
		super(file, GL_W.GL_FRAGMENT_SHADER);
	}

}
