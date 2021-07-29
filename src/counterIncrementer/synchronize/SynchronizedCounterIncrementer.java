package counterIncrementer.synchronize;

import counterIncrementer.CounterIncrementer;
import counterIncrementer.SleepingCounterIncrementer;
import stringCounter.StringCounter;

public class SynchronizedCounterIncrementer extends SleepingCounterIncrementer implements CounterIncrementer {
//	StringCounter counter; 
//	int numIncrements; 
//	public static long SLEEP_TIME = 200;
////	long sleepTime;
	public SynchronizedCounterIncrementer(StringCounter aCounter, 
			int aNumIncrements 
//			long aSleepTime
			) {
		super(aCounter, aNumIncrements);
//		sleepTime = aSleepTime;
	}
	
	public synchronized void countUp() {
		super.countUp();
	}


}
