package counterIncrementer.coordinated;

import counterIncrementer.AbstractCounterIncrementer;
import stringCounter.StringCounter;
import stringCounter.main.StringCounterMain;

public class CoordinatedCounterIncrementer extends AbstractCounterIncrementer {

	public CoordinatedCounterIncrementer(StringCounter aCounter, int aNumIncrements) {
		super(aCounter, aNumIncrements);
	}
	@Override
	protected void preIncrementStep() {		
		CoordinatorFactory.getSingleton().synchronizedWait();

	}
	@Override
	protected void postIncrementStep() {
		
	}
}
