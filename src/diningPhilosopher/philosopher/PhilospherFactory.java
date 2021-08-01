package diningPhilosopher.philosopher;

import diningPhilosopher.chopstick.ChopstickFactory;
import diningPhilosopher.chopstick.SmartChopstick;

public class PhilospherFactory {
	static Philosopher[] philosophers;

	static Philosopher createPhilosopher(int anId, SmartChopstick aLeftChopstick, SmartChopstick aRightChopstick) {
		return new BasicPhilosopher(anId, aLeftChopstick, aRightChopstick);
	}

	public static Philosopher[] createPhilosophers(SmartChopstick[] aChopsticks) {
		philosophers = new Philosopher[aChopsticks.length];		
		for (int anId = 0; anId < philosophers.length; anId++) {			
			philosophers[anId] = createPhilosopher(anId, aChopsticks[anId], aChopsticks[(anId + 1) % aChopsticks.length]);
		}
		return philosophers;
	}
	public static Philosopher[] getPhilosophers() {
		return philosophers;
	}

}
