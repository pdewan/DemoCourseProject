package diningPhilosopher.concurrent;

import java.util.Map;

import diningPhilosopher.executor.DiningExecutor;
import diningPhilosopher.executor.SequentialDiningExecutor;
import diningPhilosopher.philosopher.Philosopher;

public class ConcurrentDiningExecutor extends SequentialDiningExecutor {

	@Override
	protected void dineCourse(Philosopher aPhilosopher, long aTimeToEat) {
		Runnable aRunnable  =DineCourseRunnableFactory.createDineCourseRunnable(aPhilosopher, aTimeToEat);
		Thread aThread = new Thread(aRunnable);
		aThread.setName("Thread " + aPhilosopher.toString());
		aThread.start();
	}


}
