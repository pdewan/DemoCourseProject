package counterIncrementer;

import stringCounter.StringCounter;
import stringCounter.main.StringCounterMain;

public class SleepingCounterIncrementer extends AbstractCounterIncrementer implements CounterIncrementer {
//	StringCounter counter; 
//	int numIncrements; 
//	public static long SLEEP_TIME = 200;
////	long sleepTime;
	long pauseTime;

	public SleepingCounterIncrementer(StringCounter aCounter, int aNumIncrements, long aPauseTime) {
		super(aCounter, aNumIncrements);
		pauseTime = aPauseTime;
//		sleepTime = aSleepTime;
	}

	@Override
	protected void preIncrementStep() {

	}

	@Override
	protected void postIncrementStep() {
		try {
			if (pauseTime > 0) {
				Thread.sleep(pauseTime);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
//	public void countUp() {
//		counter.reset();
//		for (int anIndex = 0; anIndex < numIncrements; anIndex++) {
//			preIncrementStep();
//			counter.increment();
//			postIncrementStep();
//			
//		}
//	}

}
