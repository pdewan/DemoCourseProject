package counterIncrementer;

import stringCounter.StringCounter;

public abstract class AbstractCounterIncrementer implements CounterIncrementer {
	StringCounter counter; 
	int numIncrements; 
//	public static long SLEEP_TIME = 500;
//	long sleepTime;
	public AbstractCounterIncrementer(StringCounter aCounter, 
			int aNumIncrements 
			) {
		counter = aCounter;
//		if (counter == null) {
//			int i = 4;
//		}
		numIncrements = aNumIncrements;
//		sleepTime = aSleepTime;
	}
	protected abstract void preIncrementStep();
	protected abstract void postIncrementStep();
	public void countUp() {
		for (int anIndex = 0; anIndex < numIncrements; anIndex++) {
			preIncrementStep();
			counter.increment();
			postIncrementStep();
			
		}
	}


}
