package counterIncrementer;

import counterIncrementer.coordinated.CoordinatedCounterIncrementorsExecutor;
import counterIncrementer.threads.ConcurrentCounterIncrementersExecutor;

public class CounterIncrementersExecutorFactory {
	static CounterIncrementersExecutor singleton;
	public static CounterIncrementersExecutor getSingleton() {
		if (singleton == null) {
//			singleton = new SequentialCounterIncrementersExecutor();
//			singleton = new ConcurrentCounterIncrementersExecutor();
			singleton = new CoordinatedCounterIncrementorsExecutor();

		}
		return singleton;
		
	}
}
