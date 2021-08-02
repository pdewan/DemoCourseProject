package diningPhilosopher.philosopher;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import diningPhilosopher.chopstick.Chopstick;

public class BasicPhilosopher implements Philosopher{
	protected int id;
	Chopstick leftChopstick, rightChopstick;
	boolean withLeftChopstick;
	boolean withRightChopstick;
	boolean fed = false;
	
	PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);
	public BasicPhilosopher(int anId, Chopstick aLeftChopstick, Chopstick aRightChopstick) {
		id = anId;
		leftChopstick = aLeftChopstick;
		rightChopstick = aRightChopstick;		
	}
	protected void propertyChanged (String aPropertyName, Object anOldValue, Object aNewValue) {
		propertyChangeSupport.firePropertyChange(
				new PropertyChangeEvent(this, aPropertyName, anOldValue, aNewValue));
	}
//	protected void withLeftChopstickPropertyChanged (Object anOldValue) {
//		propertyChangeSupport.firePropertyChange(
//				new PropertyChangeEvent(this, "WithLeftChopstick", anOldValue, isWithLeftChopstick()));
//	}
//	protected void withRightChopstickPropertyChanged (Object anOldValue) {
//		propertyChangeSupport.firePropertyChange(
//				new PropertyChangeEvent(this, "WithRightChopstick", anOldValue, isWithRightChopstick()));
//	}
//	protected void fedPropertyChanged (Object anOldValue) {
//		propertyChangeSupport.firePropertyChange(
//				new PropertyChangeEvent(this, "Fed", anOldValue, isFed()));
//	}
	protected void takeLeftChopstick() {		
		leftChopstick.take();
		setWithLeftChopstick(true);
//		boolean anOldValue = isWithLeftChopstick();
//		withLeftChopstick = true;
//		withLeftChopstickPropertyChanged(anOldValue);
	}
	
	protected void takeRightChopstick() {		
		rightChopstick.take();
		setWithRightChopstick(true);
//		boolean anOldValue = isWithRightChopstick();
//		withRightChopstick = true;
//		withRightChopstickPropertyChanged(anOldValue);
	}
	protected void putLeftChopstick() {		
		leftChopstick.put();
		setWithLeftChopstick(false);
//		boolean anOldValue = isWithLeftChopstick();
//		withLeftChopstick = false;
//		withLeftChopstickPropertyChanged(anOldValue);
	}
	protected void putRightChopstick() {		
		rightChopstick.put();
		setWithRightChopstick(false);

//		boolean anOldValue = isWithRightChopstick();
//		withRightChopstick = false;
//		withRightChopstickPropertyChanged(anOldValue);
	}
	protected void takeChopsticks () {
		takeLeftChopstick();
		takeRightChopstick();
		
	}
	protected void putChopsticks () {
		putLeftChopstick();
		putRightChopstick();
		
	}
	protected void thinkBeforeEating(long aTimeToEat)  {
		long aDelay = (long) Math.random()*aTimeToEat;
		try {
			Thread.sleep(aTimeToEat);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	protected void eat(long aTimeToEat) {
		try {
			Thread.sleep(aTimeToEat);
			setFed(true);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	protected void setFed(boolean newValue) {
		boolean anOldValue = isFed();
		fed = newValue;
		propertyChanged("Fed", anOldValue, isFed());
	}
	protected void setWithLeftChopstick(boolean newValue) {
		boolean anOldValue = isWithLeftChopstick();
		withLeftChopstick = newValue;
		propertyChanged("WithLeftChopstick", anOldValue, isWithLeftChopstick());
	}
	protected void setWithRightChopstick(boolean newValue) {
		boolean anOldValue = isWithRightChopstick();
		withRightChopstick = newValue;
		propertyChanged("WithRightChopstick", anOldValue, isWithRightChopstick());
	}
	@Override
	public void dineCourse(long aTimeToEat) {
		setFed (false);
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
	@Override
	public boolean isFed() {
		return fed;
	}
	
	public void addPropertyChangeListener(PropertyChangeListener aListener) {
		propertyChangeSupport.addPropertyChangeListener(aListener);
	}
	public String toString() {
		return "Philosopher " + id;
	}
	

}
