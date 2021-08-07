package diningPhilosopher.coordinated;

import java.util.Map;

import coordination.joiner.JoinerFactory;
import diningPhilosopher.concurrent.ConcurrentDiningExecutor;
import diningPhilosopher.executor.DiningExecutor;
import diningPhilosopher.executor.SequentialDiningExecutor;
import diningPhilosopher.philosopher.Philosopher;

public class ButlerCoordinatedDiningExecutor extends ConcurrentDiningExecutor {
	
	public void dineCourse(Philosopher[] aPhilosophers, long aTimeToEat) {
		JoinerFactory.getSingleton().reset(aPhilosophers.length);
		super.dineCourse(aPhilosophers, aTimeToEat);
	}

//	@Override
//	protected void dineCourse(Philosopher aPhilosopher, long aTimeToEat) {
//		Runnable aRunnable  =DineCourseRunnableFactory.createDineCourseRunnable(aPhilosopher, aTimeToEat);
//		Thread aThread = new Thread(aRunnable);
//		aThread.setName("Thread " + aPhilosopher.toString());
//		aThread.start();
//	}


}
