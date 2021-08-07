package util.models;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;

public interface PropertyNotificationSupport extends PropertyListenerRegisterer {
	void setAnnounceOnlyChanges(boolean newValue);
	boolean getAnnounceOnlyChanges();
	void firePropertyChange(PropertyChangeEvent aPropertyChangeEvent);
	List<PropertyChangeListener> getPropertyChangeListeners();

}
