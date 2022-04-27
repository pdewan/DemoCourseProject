package OEshapegraphics;

import java.beans.PropertyChangeEvent;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;

@PropertyNames({ "ImageFileName", "X", "Y", "PropertyChangeListeners" })

@StructurePattern(StructurePatternNames.IMAGE_PATTERN)

public class PhilosopherBody extends Locatable implements PhilosopherBodyInterface {

	String imageName;
	int width;
	int height;

	public PhilosopherBody(int initX, int initY, String initImageName) {
		super(initX, initY);
		imageName = initImageName;
		Icon icon = new ImageIcon(imageName);
		width = icon.getIconWidth();
		height = icon.getIconHeight();
	}

	@Override
	public String getImageFileName() {
		return imageName;
	}

	@Override
	public void setImageFileName(String newVal) {
		String oldVal = getImageFileName();
		imageName = newVal;
		propertySupport.notifyAllListeners(new PropertyChangeEvent(this, "ImageFileName", oldVal, newVal));

	}

}
