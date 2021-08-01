package counterIncrementer.coordinated.old;

import counterIncrementer.SleepingCounterIncrementer;
import stringCounter.StringCounter;
import stringCounter.main.StringCounterMain;

public class CoordinatingCounterIncrementer extends SleepingCounterIncrementer {

	public CoordinatingCounterIncrementer(StringCounter aCounter, int aNumIncrements, long aPauseTime) {
		super(aCounter, aNumIncrements, aPauseTime);
	}
	@Override
	protected synchronized void postIncrementStep() {		
		super.postIncrementStep();
		CoordinatorFactory.getSingleton().synchronizedNotifyAll();	
	}
}
