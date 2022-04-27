package diningPhilosopher.coordinated;

import diningPhilosopher.chopstick.Chopstick;
import diningPhilosopher.philosopher.BasicPhilosopher;

public class NoDeadlockCoordinatedPhilosopher extends BasicPhilosopher {

	public NoDeadlockCoordinatedPhilosopher(int anId, Chopstick aLeftChopstick, Chopstick aRightChopstick) {
		super(anId, aLeftChopstick, aRightChopstick);
	}
	@Override
	protected boolean takeChopsticks () {
		if (id != 0) {
			return super.takeChopsticks();
			
		} else {
			if (takeRightChopstick() ) {
				return takeLeftChopstick();
			} else {
				return true;
			}
		}
		
	}
	
//	public void dineCourse(long aTimeToEat) {
//		super.dineCourse(aTimeToEat);
//		JoinerFactory.getSingleton().threadFinished();
//		
//	}

}
