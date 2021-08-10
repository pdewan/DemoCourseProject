package diningPhilosopher.factories;

import counterIncrementer.coordinated.CoordinatedCounterIncrementorsExecutor;
import counterIncrementer.threads.ConcurrentCounterIncrementersExecutor;
import diningPhilosopher.concurrent.ConcurrentDiningExecutor;
import diningPhilosopher.coordinated.ButlerCoordinatedDiningExecutor;
import diningPhilosopher.executor.DiningExecutor;
import diningPhilosopher.executor.SequentialDiningExecutor;

public class DiningExecutorFactory {
	static DiningExecutor singleton;
	public static DiningExecutor getSingleton() {
		if (singleton == null) {
			singleton = 
//					new SequentialDiningExecutor();
			        new ConcurrentDiningExecutor();
//					new ButlerCoordinatedDiningExecutor();

		}
		return singleton;
		
	}
}
