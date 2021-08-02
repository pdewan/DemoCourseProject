package diningPhilosopher.concurrent;

import diningPhilosopher.philosopher.Philosopher;

public class DineCourseRunnableFactory {
	public static Runnable createDineCourseRunnable(Philosopher aPhilosopher, long aTimeToEat) {
		return new DineCourseRunnable(aPhilosopher, aTimeToEat);
	}
}
