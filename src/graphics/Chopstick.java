package graphics;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;

@StructurePattern(StructurePatternNames.IMAGE_PATTERN)

public class Chopstick extends BoundedShape implements ChopstickInterface {

	String imageName;

	ChopstickInterface chopstick;

	public Chopstick(int initX, int initY, String initImageFileName) {
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

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		// TODO Auto-generated method stub

	}

}
