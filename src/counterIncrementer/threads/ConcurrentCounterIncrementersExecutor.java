package counterIncrementer.threads;

import java.util.Map;

import counterIncrementer.CounterIncrementer;
import counterIncrementer.CounterIncrementersExecutor;
import stringCounter.main.StringCounterMain;

public class ConcurrentCounterIncrementersExecutor implements CounterIncrementersExecutor {

//	public void execute(Map<String, CounterIncrementer> aLanguageToCounterIncrementer) {
//			for (CounterIncrementer aCounterIncrementer:aLanguageToCounterIncrementer.values()) {
//				aCounterIncrementer.countUp();
//			}
//	}
	public static final String THREAD_NAME_PREFIX = "CountupRequest";

	@Override
	public void execute(CounterIncrementer[] aCounterIncrementers, long aPauseTime) {
		for (int anIndex = 0; anIndex <  aCounterIncrementers.length; anIndex++) {			
			Thread aThread = new Thread(new CounterIncrementerRunnable(aCounterIncrementers[anIndex]));
			aThread.setName(THREAD_NAME_PREFIX + anIndex);
			aThread.start();
			try {
				Thread.sleep(aPauseTime);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
