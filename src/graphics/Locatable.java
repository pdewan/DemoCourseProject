package graphics;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;

import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;

@PropertyNames({ "X", "Y", "PropertyChangeListeners" })
@EditablePropertyNames({ "X", "Y" })

public class Locatable implements LocatableInterface {

	PropertyListenerSupportInterface propertySupport = new PropertyListenerSupport();

	int x;
	int y;

	public Locatable(int initX, int initY) {
		x = initX;
		y = initY;
	}

	@Override
	public int getX() {
		return x;
	}

	@Override
	public int getY() {
		return y;
	}

	@Override
	public void setX(int newX) {
		// int oldX = getX();
		x = newX;
	}

	@Override
	public void setY(int newY) {
		// int oldY = getY();
		y = newY;
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
