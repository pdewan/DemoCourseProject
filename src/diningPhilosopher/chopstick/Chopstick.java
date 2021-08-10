package diningPhilosopher.chopstick;

import java.beans.PropertyChangeListener;

import util.models.PropertyListenerRegisterer;

/**
 * Smart Chopstick, knows it is being used
 *
 */
public interface Chopstick extends PropertyListenerRegisterer{
//	int getId();
	boolean isUsed();
	boolean take();
	void put();
//	void addPropertyChangeListener(PropertyChangeListener aListener);
}
