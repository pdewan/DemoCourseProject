package OEshapegraphics;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;

public interface PropertyListenerSupportInterface {

	public void addPropertyChangeListener(PropertyChangeListener aListener);

	public void addListen(PropertyChangeListener newListen);

	public void notifyAllListeners(PropertyChangeEvent event);

	public List<PropertyChangeListener> generateList();

}