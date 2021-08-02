package diningPhilosopher.concurrent;

import diningPhilosopher.philosopher.Philosopher;

public class DineCourseRunnable implements Runnable {
	Philosopher philosopher;
	long timeToEat;
	public DineCourseRunnable(Philosopher aPhilosopher, long aTimeToEat) {
		philosopher = aPhilosopher;
		timeToEat = aTimeToEat;
	}
	public void run() {
		philosopher.dineCourse(timeToEat);
	}

}
