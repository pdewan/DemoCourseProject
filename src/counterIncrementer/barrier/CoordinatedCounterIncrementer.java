package counterIncrementer.barrier;

import counterIncrementer.AbstractCounterIncrementer;
import counterIncrementer.SleepingCounterIncrementer;
import stringCounter.StringCounter;
import stringCounter.main.StringCounterMain;

public class CoordinatedCounterIncrementer extends SleepingCounterIncrementer {
	int numThreads;

	public CoordinatedCounterIncrementer(StringCounter aCounter, int aNumIncrements, int aNumThreads) {
		super(aCounter, aNumIncrements);
		numThreads = aNumThreads;
	}
	@Override
	protected void preIncrementStep() {		
		BarrierFactory.getSingleton(numThreads).barrier();

	}
	@Override
	protected void postIncrementStep() {
		
	}
}
