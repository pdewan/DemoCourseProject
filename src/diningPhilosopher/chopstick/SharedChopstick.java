package diningPhilosopher.chopstick;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import util.models.BasicPropertyNotificationSupport;
import util.models.PropertyNotificationSupport;

public class SharedChopstick implements Chopstick{
	boolean used = false;
	int id = -1;
	PropertyNotificationSupport propertyChangeSupport = new BasicPropertyNotificationSupport();

	public SharedChopstick(int anId) {
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
//	protected void slowOperation() {
//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		};
//	}
	protected boolean preconditionTake() {
		return true;
	}
	@Override
	public boolean take() {
//		if (isUsed()) {
//			return false;
//		}
		boolean oldUsed = isUsed();
//		slowOperation();
		used = true;
		usedPropertyChanged(oldUsed);	
		return true;
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
