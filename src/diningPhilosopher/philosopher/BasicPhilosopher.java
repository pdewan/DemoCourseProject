package diningPhilosopher.philosopher;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import diningPhilosopher.chopstick.SmartChopstick;

public class BasicPhilosopher implements Philosopher{
	int id;
	SmartChopstick leftChopstick, rightChopstick;
	boolean withLeftChopstick;
	boolean withRightChopstick;
	PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);
	public BasicPhilosopher(int anId, SmartChopstick aLeftChopstick, SmartChopstick aRightChopstick) {
		id = anId;
		leftChopstick = aLeftChopstick;
		rightChopstick = aRightChopstick;		
	}
	void propertyChanged (String aPropertyName, Object anOldValue, Object aNewValue) {
		propertyChangeSupport.firePropertyChange(
				new PropertyChangeEvent(this, aPropertyName, anOldValue, aNewValue));
	}
	void withLeftChopstickPropertyChanged (Object anOldValue) {
		propertyChangeSupport.firePropertyChange(
				new PropertyChangeEvent(this, "WithLeftChopstick", anOldValue, isWithLeftChopstick()));
	}
	void withRightChopstickPropertyChanged (Object anOldValue) {
		propertyChangeSupport.firePropertyChange(
				new PropertyChangeEvent(this, "WithRightChopstick", anOldValue, isWithRightChopstick()));
	}
	void takeLeftChopstick() {		
		leftChopstick.take();
		boolean anOldValue = isWithLeftChopstick();
		withLeftChopstick = true;
		withLeftChopstickPropertyChanged(anOldValue);
	}
	
	void takeRightChopstick() {		
		rightChopstick.take();
		boolean anOldValue = isWithRightChopstick();
		withRightChopstick = true;
		withRightChopstickPropertyChanged(anOldValue);
	}
	void putLeftChopstick() {		
		leftChopstick.put();
		boolean anOldValue = isWithLeftChopstick();
		withLeftChopstick = false;
		withLeftChopstickPropertyChanged(anOldValue);
	}
	void putRightChopstick() {		
		rightChopstick.put();
		boolean anOldValue = isWithRightChopstick();
		withRightChopstick = false;
		withRightChopstickPropertyChanged(anOldValue);
	}
	void takeChopsticks () {
		takeLeftChopstick();
		takeRightChopstick();
		
	}
	void putChopsticks () {
		putLeftChopstick();
		putRightChopstick();
		
	}
	void thinkBeforeEating(long aTimeToEat)  {
		long aDelay = (long) Math.random()*aTimeToEat;
		try {
			Thread.sleep(aTimeToEat);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	void eat(long aTimeToEat) {
		try {
			Thread.sleep(aTimeToEat);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void dineCourse(long aTimeToEat) {
		thinkBeforeEating(aTimeToEat);
		takeChopsticks();
		eat(aTimeToEat);
		putChopsticks();
		
	}
	@Override
	public boolean isWithLeftChopstick() {
		return withLeftChopstick;
	}
	@Override
	public boolean isWithRightChopstick() {
		return withRightChopstick;
	}
	
	public void addPropertyChangeListener(PropertyChangeListener aListener) {
		propertyChangeSupport.addPropertyChangeListener(aListener);
	}
	public String toString() {
		return "Philosopher " + id;
	}
	

}
