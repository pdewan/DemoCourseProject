package counterIncrementer.coordinated;

import counterIncrementer.SleepingCounterIncrementer;
import stringCounter.StringCounter;
import stringCounter.main.StringCounterMain;

public class CoordinatingCounterIncrementer extends SleepingCounterIncrementer {

	public CoordinatingCounterIncrementer(StringCounter aCounter, int aNumIncrements) {
		super(aCounter, aNumIncrements);
	}
	@Override
	protected synchronized void postIncrementStep() {		
		super.postIncrementStep();
		CoordinatorFactory.getSingleton().synchronizedNotifyAll();	
	}
}
