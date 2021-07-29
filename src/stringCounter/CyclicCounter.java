package stringCounter;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Iterator;

public class CyclicCounter implements StringCounter {
	String[] cycledList;
	int nextListIndex = -1;
//	long delay;
	PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);
	String oldValue = "None";

	public CyclicCounter(String[] aCycledList) {
		cycledList = aCycledList;
//		delay = aDelay;
	}

	public String getValue() {
		return cycledList[nextListIndex];
	}

	PropertyChangeEvent valueChangeEvent(String oldValue, String newValue) {
		return (new PropertyChangeEvent(this, "Value", oldValue, newValue));
	}

	@Override
	public void increment() {
//		String newValue = getValue();
		nextListIndex = (nextListIndex + 1) % cycledList.length;
		String aNewValue = getValue();
		propertyChangeSupport.firePropertyChange(
				new PropertyChangeEvent(this, "Value", oldValue, aNewValue));
		oldValue = aNewValue;
		
	}

	@Override
	public void addPropertyChangeListener(PropertyChangeListener aListener) {
		propertyChangeSupport.addPropertyChangeListener(aListener);
//		aListener.propertyChange(valueChangeEvent(null, getValue()));
	}

	public void reset() {
		nextListIndex = -1;
	}

}
