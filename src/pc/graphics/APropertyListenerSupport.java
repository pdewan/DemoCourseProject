package pc.graphics;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

public class APropertyListenerSupport implements PropertyListenerSupport{
	public static final int MAX_SIZE = 50;
	
	List<PropertyChangeListener> propertyChangeListeners = new ArrayList<PropertyChangeListener>();
	
	@Override
	public void addPropertyChangeListener(PropertyChangeListener aListener) {
		propertyChangeListeners.add(aListener);
	}
	
	@Override
	public void notifyAllListeners(PropertyChangeEvent event) {
		for (int i = 0; i < propertyChangeListeners.size(); i++) {
			propertyChangeListeners.get(i).propertyChange(event);
		}
	}
	
	@Override
	public List<PropertyChangeListener> generateList() {
		return propertyChangeListeners;
	}
	
}
