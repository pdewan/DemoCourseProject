package counterIncrementer;

import java.util.Map;

public class SequentialCounterIncrementersExecutor implements CounterIncrementersExecutor {

//	public void execute(Map<String, CounterIncrementer> aLanguageToCounterIncrementer) {
//			for (CounterIncrementer aCounterIncrementer:aLanguageToCounterIncrementer.values()) {
//				aCounterIncrementer.countUp();
//			}
//	}

	@Override
	public void execute(CounterIncrementer[] aCounterIncrementers) {
		for (CounterIncrementer aCounterIncrementer:aCounterIncrementers) {
			aCounterIncrementer.countUp();
		}
	}

}
