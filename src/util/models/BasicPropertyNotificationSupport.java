package util.models;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

public class BasicPropertyNotificationSupport implements PropertyNotificationSupport {
protected boolean announceOnlyChanges = false;
protected List<PropertyChangeListener> propertyChangeListeners = new ArrayList();



@Override
public synchronized void addPropertyChangeListener(PropertyChangeListener aListener) {
	if (propertyChangeListeners.contains(aListener)) {
		return;
	}
	propertyChangeListeners.add(aListener);
}
@Override
public void setAnnounceOnlyChanges(boolean newValue) {
	announceOnlyChanges = newValue;	
}
@Override
public boolean getAnnounceOnlyChanges() {
	return announceOnlyChanges;
}
protected boolean noChange (PropertyChangeEvent aPropertyChangeEvent) {
	Object anOldValue = aPropertyChangeEvent.getOldValue();
	Object aNewValue = aPropertyChangeEvent.getNewValue();
	return anOldValue == aNewValue ||
			aNewValue != null && aNewValue.equals(anOldValue);
			
}
@Override
public synchronized void firePropertyChange(PropertyChangeEvent aPropertyChangeEvent) {
	if (getAnnounceOnlyChanges() && noChange(aPropertyChangeEvent)) {
		return;
	}
	for (PropertyChangeListener aPropertyChangeListener:propertyChangeListeners) {
		aPropertyChangeListener.propertyChange(aPropertyChangeEvent);
	}
	
}
@Override
public List<PropertyChangeListener> getPropertyChangeListeners() {
	return propertyChangeListeners;
}}
