package graphics;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Visible;

@PropertyNames({ "X", "Y", "Width", "Height", "ImageFileName", "PropertyChangeListeners", "ZIndex" })
@EditablePropertyNames({ "X", "Y", "Width", "Height", "ImageFileName", "ZIndex" })

@StructurePattern(StructurePatternNames.IMAGE_PATTERN)

public class ChopstickImage extends BoundedShape implements ChopstickImageInterface {

	String imageName;

	PhilosopherHeadInterface head;

	public ChopstickImage(int initX, int initY, String initImageFileName) {
		// 0 is placeholder
		super(initX, initY, 0, 0);
		imageName = initImageFileName;
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

	@Override
	public void addPropertyChangeListener(PropertyChangeListener newListen) {
		propertySupport.addListen(newListen);
	}

	@Override
	@Visible(false)
	public List<PropertyChangeListener> getPropertyChangeListeners() {
		return propertySupport.generateList();
	}

}

