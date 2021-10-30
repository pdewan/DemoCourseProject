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

@PropertyNames({ "X", "Y", "Width", "Height", "ImageFileName", "PropertyChangeListeners" })
@EditablePropertyNames({ "X", "Y", "Width", "Height", "ImageFileName" })

@StructurePattern(StructurePatternNames.IMAGE_PATTERN)

public class PhilosopherHead extends BoundedShape implements PhilosopherHeadInterface {

	String imageName;

	PhilosopherHeadInterface head;

	public PhilosopherHead(int initX, int initY, String initImageFileName) {
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
	public List<PropertyChangeListener> getPropertyChangeListeners() {
		return propertySupport.generateList();
	}
}
