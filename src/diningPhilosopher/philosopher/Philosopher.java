package diningPhilosopher.philosopher;

import java.beans.PropertyChangeListener;

import util.models.PropertyListenerRegisterer;

/**
 * Smart Chopstick, knows it is being used
 *
 */
public interface Philosopher extends PropertyListenerRegisterer{
	boolean dineCourse(long aTimeToEat);
	boolean isWithLeftChopstick();
	boolean isWithRightChopstick();
//	void addPropertyChangeListener(PropertyChangeListener aListener);
	boolean isFed();

}
