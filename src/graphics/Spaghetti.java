package graphics;

import java.beans.PropertyChangeEvent;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;

@PropertyNames({ "ImageFileName", "X", "Y", "PropertyChangeListeners", "ZIndex", "Color", "Filled", "Stroke", "Width",
		"Height" })

@StructurePattern(StructurePatternNames.IMAGE_PATTERN)

public class Spaghetti extends Table implements SpaghettiInterface {

	String imageName;

	public Spaghetti(int initX, int initY, int initWidth, int initHeight, String initImageName) {
		super(initX, initY, initWidth, initHeight);
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
