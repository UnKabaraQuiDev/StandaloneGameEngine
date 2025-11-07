package lu.kbra.standalone.gameengine.utils.gl.consts;

import javax.swing.GroupLayout.Alignment;

public enum TextAlignment {

	TEXT_LEFT, LEFT, TEXT_RIGHT, RIGHT, TEXT_CENTER, CENTER;

	public Alignment asSwingAlignment() {
		switch (this) {
		case CENTER:
			return Alignment.CENTER;
		case LEFT:
			return Alignment.LEADING;
		case RIGHT:
			return Alignment.TRAILING;
		case TEXT_CENTER:
			return Alignment.CENTER;
		case TEXT_LEFT:
			return Alignment.LEADING;
		case TEXT_RIGHT:
			return Alignment.TRAILING;
		}
		throw new NullPointerException();
	}

}
