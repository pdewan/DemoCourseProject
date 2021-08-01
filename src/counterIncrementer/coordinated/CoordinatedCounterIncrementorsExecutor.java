package counterIncrementer.coordinated;

import coordination.barrier.BarrierFactory;
import coordination.joiner.JoinerFactory;
import counterIncrementer.CounterIncrementer;
import counterIncrementer.threads.ConcurrentCounterIncrementersExecutor;

public class CoordinatedCounterIncrementorsExecutor extends ConcurrentCounterIncrementersExecutor {
	@Override
	public void execute(CounterIncrementer[] aCounterIncrementers, long aPauseTime) {
		int aNumThreads = aCounterIncrementers.length;
		BarrierFactory.getSingleton().reset(aNumThreads);
		JoinerFactory.getSingleton().reset(aNumThreads);
		super.execute(aCounterIncrementers, aPauseTime);
	}

}
