package diningPhilosopher.coordinated;

import coordination.joiner.JoinerFactory;
import diningPhilosopher.chopstick.Chopstick;
import diningPhilosopher.philosopher.BasicPhilosopher;

public class CoordinatedPhilosopher extends BasicPhilosopher {

	public CoordinatedPhilosopher(int anId, Chopstick aLeftChopstick, Chopstick aRightChopstick) {
		super(anId, aLeftChopstick, aRightChopstick);
	}
	@Override
	protected void takeChopsticks () {
		if (id != 0) {
			super.takeChopsticks();
			
		} else {
			takeRightChopstick();
			takeLeftChopstick();
		}
		
	}
	
	public void dineCourse(long aTimeToEat) {
		super.dineCourse(aTimeToEat);
		JoinerFactory.getSingleton().threadFinished();
		
	}

}
