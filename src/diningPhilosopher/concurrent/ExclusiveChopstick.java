package diningPhilosopher.concurrent;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import diningPhilosopher.chopstick.SharedChopstick;
import util.models.BasicPropertyNotificationSupport;
import util.models.PropertyNotificationSupport;

public class ExclusiveChopstick extends SharedChopstick{
//	boolean used = false;
//	int id = -1;
//	PropertyNotificationSupport propertyChangeSupport = new BasicPropertyNotificationSupport();

	public ExclusiveChopstick(int anId) {
		super(anId);
	}
	
	protected boolean preconditionTake() {
		return !isUsed();
	}
	
	@Override
	public boolean take() {
		if (!preconditionTake()) {
			return false;
		}
		return super.take();
	}
}
