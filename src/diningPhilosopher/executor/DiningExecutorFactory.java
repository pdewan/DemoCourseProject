package diningPhilosopher.executor;

import counterIncrementer.coordinated.CoordinatedCounterIncrementorsExecutor;
import counterIncrementer.threads.ConcurrentCounterIncrementersExecutor;

public class DiningExecutorFactory {
	static DiningExecutor singleton;
	public static DiningExecutor getSingleton() {
		if (singleton == null) {
			singleton = new SequentialDiningExecutor();
		}
		return singleton;
		
	}
}
