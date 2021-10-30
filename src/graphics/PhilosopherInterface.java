package graphics;

import java.beans.PropertyChangeListener;
import java.util.List;

public interface PhilosopherInterface {

	public int getWidth();

	public int getHeight();

	boolean getWaiting();

	public void setWaiting(boolean waitStatus);

	public void addPropertyChangeListener(PropertyChangeListener newListen);

	List<PropertyChangeListener> getPropertyChangeListeners();
}
