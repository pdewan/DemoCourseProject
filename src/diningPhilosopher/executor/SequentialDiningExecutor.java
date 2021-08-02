package diningPhilosopher.executor;

import java.util.Map;

import diningPhilosopher.philosopher.Philosopher;

public class SequentialDiningExecutor implements DiningExecutor {

	@Override
	public void dineCourse(Philosopher[] aPhilosophers, long aTimeToEat) {
		for (Philosopher aPhilosopher:aPhilosophers) {
			dineCourse(aPhilosopher, aTimeToEat);
		}
	}	
	protected void dineCourse(Philosopher aPhilosopher, long aTimeToEat) {
		aPhilosopher.dineCourse(aTimeToEat);
	}
}
