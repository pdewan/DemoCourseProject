package counterIncrementer.coordinated;

import coordination.barrier.BarrierFactory;
import coordination.joiner.JoinerFactory;
import counterIncrementer.AbstractCounterIncrementer;
import counterIncrementer.SleepingCounterIncrementer;
import stringCounter.StringCounter;
import stringCounter.main.StringCounterMain;

public class CoordinatedCounterIncrementer extends SleepingCounterIncrementer {
//	int numThreads;

	public CoordinatedCounterIncrementer(StringCounter aCounter, int aNumIncrements, long aPauseTime) {
		super(aCounter, aNumIncrements, aPauseTime);
//		numThreads = aNumThreads;
	}
	@Override
	protected void preIncrementStep() {		
		BarrierFactory.getSingleton().barrier();

	}
	@Override
	public void countUp() {
		super.countUp();
		JoinerFactory.getSingleton().threadFinished();
	}
	
}
