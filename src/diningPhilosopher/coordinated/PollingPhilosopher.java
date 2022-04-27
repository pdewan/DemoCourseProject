package diningPhilosopher.coordinated;

import diningPhilosopher.chopstick.Chopstick;
import diningPhilosopher.philosopher.BasicPhilosopher;

public class PollingPhilosopher extends BasicPhilosopher {
	public static int MAX_TRIES = 10;

	public PollingPhilosopher(int anId, Chopstick aLeftChopstick, Chopstick aRightChopstick) {
		super(anId, aLeftChopstick, aRightChopstick);
	}
	@Override
	protected boolean tryDineCourse(long aTimeToEat) {
		int aTryCount = 0;	
		while (true) {
			if (aTryCount >= MAX_TRIES) {
				return false;
			}
			if (super.tryDineCourse(aTimeToEat)) {
				return true;
			} else {
				aTryCount++;
			}			
		}

	}
	

	
}
