package counterIncrementer.coordinated;

import coordination.barrier.BarrierFactory;
import coordination.joiner.JoinerFactory;
import stringCounter.BasicStringCounterController;
import stringCounter.main.CounterIncrementerUtil;

public class CoordinatedStringCounterController extends BasicStringCounterController {
//	protected void processInput (String[] aLanguageRequests, long aPauseTime) {
////		BarrierFactory.getSingleton().reset(aLanguageRequests.length);
//		super.processInput(aLanguageRequests, aPauseTime);
//	}
	protected String[] readLanguageRequests() {
		JoinerFactory.getSingleton().join();
		return super.readLanguageRequests();
	}
}
