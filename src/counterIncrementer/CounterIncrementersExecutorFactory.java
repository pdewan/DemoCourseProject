package counterIncrementer;

import counterIncrementer.concurrent.ConcurrentCounterIncrementersExecutor;

public class CounterIncrementersExecutorFactory {
	static CounterIncrementersExecutor singleton;
	public static CounterIncrementersExecutor getSingleton() {
		if (singleton == null) {
//			singleton = new SequentialCounterIncrementersExecutor();
			singleton = new ConcurrentCounterIncrementersExecutor();
		}
		return singleton;
		
	}
}
