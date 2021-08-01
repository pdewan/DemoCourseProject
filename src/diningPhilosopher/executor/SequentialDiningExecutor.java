package diningPhilosopher.executor;

import java.util.Map;

import diningPhilosopher.philosopher.Philosopher;

public class SequentialDiningExecutor implements DiningExecutor {

	@Override
	public void dineCourse(Philosopher[] aPhilosophers, long aTimeToEat) {
		for (Philosopher aPhilosopher:aPhilosophers) {
			aPhilosopher.dineCourse(aTimeToEat);
		}
	}


}
