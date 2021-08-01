package diningPhilosopher.chopstick;

import java.beans.PropertyChangeListener;

/**
 * Smart Chopstick, knows it is being used
 *
 */
public interface SmartChopstick {
//	int getId();
	boolean isUsed();
	void take();
	void put();
	void addPropertyChangeListener(PropertyChangeListener aListener);
}
