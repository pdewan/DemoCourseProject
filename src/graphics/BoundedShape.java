package graphics;

import java.beans.PropertyChangeListener;
import java.util.List;

import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;

@PropertyNames({ "Width", "Height", "PropertyChangeListeners", "X", "Y" })
@EditablePropertyNames({ "Width", "Height", "X", "Y" })

public class BoundedShape extends Locatable implements BoundedShapeInterface {

	int width;
	int height;

	public BoundedShape(int initX, int initY, int initWidth, int initHeight) {
		super(initX, initY);
		width = initWidth;
		height = initHeight;
	}

	@Override
	public int getWidth() {
		return width;
	}

	@Override
	public int getHeight() {
		return height;
	}

	@Override
	public void setWidth(int newWidth) {
		// int oldWidth = getWidth();
		width = newWidth;
		// propertySupport.notifyAllListeners(new PropertyChangeEvent(this, "Width",
		// oldWidth, newWidth));
	}

	@Override
	public void setHeight(int newHeight) {
		// int oldHeight = getHeight();
		height = newHeight;
		// propertySupport.notifyAllListeners(new PropertyChangeEvent(this, "Height",
		// oldHeight, newHeight));
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
