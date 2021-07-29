package stringCounter;

import java.beans.PropertyChangeListener;
import java.util.Iterator;

import util.models.PropertyListenerRegisterer;

public interface StringCounter  {
	String getValue();
	void increment();
	void reset();
	void addPropertyChangeListener(PropertyChangeListener aListener);
}
