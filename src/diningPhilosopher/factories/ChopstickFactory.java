package diningPhilosopher.factories;

import diningPhilosopher.atomic.SynchronizedChopstick;
import diningPhilosopher.chopstick.Chopstick;
import diningPhilosopher.chopstick.SharedChopstick;
import diningPhilosopher.concurrent.ExclusiveChopstick;
import diningPhilosopher.coordinated.LockedChopstick;

public class ChopstickFactory {
	static Chopstick[] chopsticks;

    static Chopstick createChopstick(int anId) {
		return new 
//				SharedChopstick(anId);
//				ExclusiveChopstick(anId);
				SynchronizedChopstick(anId);
//				LockedChopstick(anId);
	}

	public static Chopstick[]  createChopsticks(int aNumChopsticks) {
		chopsticks = new Chopstick[aNumChopsticks];
		for (int anId = 0; anId < chopsticks.length; anId++) {
			chopsticks[anId] = createChopstick(anId);
		}
		return chopsticks;

	}

//	public static SmartChopstick getChopstick(int anId) {
//		if (chopsticks == null || anId > chopsticks.length - 1) {
//			return null;
//		}
//		return chopsticks[anId];
//	}
//	
	public static Chopstick[] getChopsticks() {
		return chopsticks;
	}

}
