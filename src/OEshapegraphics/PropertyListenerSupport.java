package OEshapegraphics;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

	public class PropertyListenerSupport implements PropertyListenerSupportInterface {

		List<PropertyChangeListener> propertyChangeListeners = new ArrayList<PropertyChangeListener>();

		@Override
		public void addPropertyChangeListener(PropertyChangeListener aListener) {
			propertyChangeListeners.add(aListener);
		}

		@Override
		public void addListen(PropertyChangeListener newListen) {
			propertyChangeListeners.add(newListen);
		}

		@Override
		public void notifyAllListeners(PropertyChangeEvent event) {
			for (int index = 0; index < propertyChangeListeners.size(); index++) {
				propertyChangeListeners.get(index).propertyChange(event);
			}
		}
		
		@Override
		public List<PropertyChangeListener> generateList() {
			return propertyChangeListeners;
		}

}
