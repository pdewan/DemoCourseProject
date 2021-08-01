package diningPhilosopher.chopstick;

public class ChopstickFactory {
	static SmartChopstick[] chopsticks;

    static SmartChopstick createChopstick(int anId) {
		return new BasicChopstick(anId);
	}

	public static SmartChopstick[]  createChopsticks(int aNumChopsticks) {
		chopsticks = new SmartChopstick[aNumChopsticks];
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
	public static SmartChopstick[] getChopsticks() {
		return chopsticks;
	}

}
