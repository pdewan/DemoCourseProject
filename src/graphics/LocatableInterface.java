package graphics;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;

import util.models.PropertyListenerRegisterer;

public interface LocatableInterface extends PropertyListenerRegisterer {

	public int getX();

	public int getY();

	public void setX(int newX);

	public void setY(int newY);

	public void addPropertyChangeListener(PropertyChangeListener newListen);

	List<PropertyChangeListener> getPropertyChangeListeners();

	void propertyChange(PropertyChangeEvent evt);
}
