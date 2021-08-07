package diningPhilosopher.chopstick;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import util.models.BasicPropertyNotificationSupport;
import util.models.PropertyNotificationSupport;

public class BasicChopstick implements Chopstick{
	boolean used = false;
	int id = -1;
	PropertyNotificationSupport propertyChangeSupport = new BasicPropertyNotificationSupport();

	public BasicChopstick(int anId) {
		id = anId;
	}
	@Override
	public boolean isUsed() {
		return used;
	}
	void usedPropertyChanged (boolean anOldValue) {
		propertyChangeSupport.firePropertyChange(
				new PropertyChangeEvent(this, "Used", anOldValue, isUsed()));
	}
	@Override
	public void take() {
		boolean oldUsed = isUsed();
		used = true;
		usedPropertyChanged(oldUsed);		
	}

	@Override
	public void put() {
		boolean oldUsed = isUsed();
		used = false;
		usedPropertyChanged(oldUsed);			
	}

	@Override
	public void addPropertyChangeListener(PropertyChangeListener aListener) {
		propertyChangeSupport.addPropertyChangeListener(aListener);
		
	}
	
	public String toString() {
		return "Chopstick " + id;
	}

//	@Override
//	public int getId() {
//		return id;
//	}

}
