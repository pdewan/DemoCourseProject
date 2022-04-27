package pc.graphics;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;

public interface PropertyListenerSupport {

	void addPropertyChangeListener(PropertyChangeListener aListener);

	void notifyAllListeners(PropertyChangeEvent event);

	List<PropertyChangeListener> generateList();

}
