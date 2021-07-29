package counterIncrementer;

import stringCounter.StringCounter;
import stringCounter.main.StringCounterMain;

public class SleepingCounterIncrementer extends AbstractCounterIncrementer implements CounterIncrementer {
//	StringCounter counter; 
//	int numIncrements; 
//	public static long SLEEP_TIME = 200;
////	long sleepTime;
	public SleepingCounterIncrementer(StringCounter aCounter, 
			int aNumIncrements 
//			long aSleepTime
			) {
		super(aCounter, aNumIncrements);
//		sleepTime = aSleepTime;
	}
	@Override
	protected void preIncrementStep() {
		
	}
	@Override
	protected void postIncrementStep() {
		try {
			long aPauseTime = StringCounterMain.getPauseTime();
			if (aPauseTime > 0) {
			Thread.sleep(StringCounterMain.getPauseTime());
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
