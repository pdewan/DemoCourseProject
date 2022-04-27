
package diningPhilosopher.philosopher;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import diningPhilosopher.chopstick.Chopstick;
import util.models.BasicPropertyNotificationSupport;
import util.models.PropertyNotificationSupport;

public class BasicPhilosopher implements Philosopher {
	protected int id;
	Chopstick leftChopstick, rightChopstick;
	boolean withLeftChopstick;
	boolean withRightChopstick;
	boolean fed = false;

	PropertyNotificationSupport propertyNotificationSupport = new BasicPropertyNotificationSupport();

	public BasicPhilosopher(int anId, Chopstick aLeftChopstick, Chopstick aRightChopstick) {
		id = anId;
		leftChopstick = aLeftChopstick;
		rightChopstick = aRightChopstick;
	}

	protected void propertyChanged(String aPropertyName, Object anOldValue, Object aNewValue) {
		propertyNotificationSupport
				.firePropertyChange(new PropertyChangeEvent(this, aPropertyName, anOldValue, aNewValue));
	}

//	protected boolean takeChopstick(Chopstick aChopstick) {
//		if (aChopstick.take()) {
//			setWithLeftChopstick(true);
////			System.out.println(this + " got left chopstick");
//
//			return true;
//		} else {
//			return false;
//		}
//	}

	protected boolean takeLeftChopstick() {
//		System.out.println(this + " trying to get left chopstick");
		if (leftChopstick.take()) {
			setWithLeftChopstick(true);
//			System.out.println(this + " got left chopstick");

			return true;
		} else {
//			System.out.println(this + "did got left chopstick");

			return false;
		}
//		boolean anOldValue = isWithLeftChopstick();
//		withLeftChopstick = true;
//		withLeftChopstickPropertyChanged(anOldValue);
	}

	protected boolean takeRightChopstick() {
//		System.out.println(this + " trying to get right chopstick");

		if (rightChopstick.take()) {
			setWithRightChopstick(true);
//			System.out.println(this + " got right chopstick");

			return true;
		} else {
//			System.out.println(this + " did got get right chopstick");
			return false;
		}
//		boolean anOldValue = isWithRightChopstick();
//		withRightChopstick = true;
//		withRightChopstickPropertyChanged(anOldValue);
	}

	protected void putLeftChopstick() {
		if (!isWithLeftChopstick()) {
			return;
		}
		leftChopstick.put();
		setWithLeftChopstick(false);
//		boolean anOldValue = isWithLeftChopstick();
//		withLeftChopstick = false;
//		withLeftChopstickPropertyChanged(anOldValue);
	}

	protected void putRightChopstick() {
		if (!isWithRightChopstick()) {
			return;
		}
		rightChopstick.put();
		setWithRightChopstick(false);

//		boolean anOldValue = isWithRightChopstick();
//		withRightChopstick = false;
//		withRightChopstickPropertyChanged(anOldValue);
	}

	protected boolean takeChopsticks() {
		if (takeLeftChopstick()) {
			return takeRightChopstick(); // need to undo this later
		} else {
//			System.out.println(this + " did not get chopsticks");
			return false;
		}

	}

	protected void putChopsticks() {
		putLeftChopstick();
		putRightChopstick();
	}

	protected void thinkBeforeEating(long aTimeToEat) {
		long aDelay = (long) Math.random() * aTimeToEat;
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
//			setFed(true);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void setFed(boolean newValue) {
		boolean anOldValue = isFed();
		fed = newValue;
		if (fed && anOldValue) {
			int i = 1;
		}
		propertyChanged("Fed", anOldValue, isFed());
	}
//	protected void setWithChopstick(Chopstick aChopstick, boolean newValue) {
//		Object anOldValue = isWithLeftChopstick();
//		String aPropertyName = "WithLeftChopstick";
//		if (aChopstick != leftChopstick) {
//			anOldValue = isWithRightChopstick();
//			aPropertyName = "WithRightChopstick";
//		}
//		
//		propertyChanged(aPropertyName, anOldValue, newValue);
//	}

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
	public boolean dineCourse(long aTimeToEat) {

		setFed(false);
		boolean retVal = tryDineCourse(aTimeToEat);
		if ( retVal) {
			setFed(true);
		};
		return retVal;

	}
	protected boolean tryDineCourse(long aTimeToEat) {
		boolean retValue = false;

//		setFed(false);
		thinkBeforeEating(aTimeToEat);
		if (takeChopsticks()) {
			eat(aTimeToEat);
			retValue = true;
		}
		putChopsticks();
//		setFed(true);
		return retValue;

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
//		System.out.println("Listener added:" + aListener);
		propertyNotificationSupport.addPropertyChangeListener(aListener);
	}

	public String toString() {
		return "Philosopher " + id;
	}

}