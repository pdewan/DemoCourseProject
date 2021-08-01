package diningPhilosopher.philosopher;

import java.beans.PropertyChangeListener;

/**
 * Smart Chopstick, knows it is being used
 *
 */
public interface Philosopher {
	void dineCourse(long aTimeToEat);
	boolean isWithLeftChopstick();
	boolean isWithRightChopstick();
	void addPropertyChangeListener(PropertyChangeListener aListener);

}
