package counterIncrementer;

import java.util.Map;

public interface CounterIncrementersExecutor {
//	void execute (Map<String, CounterIncrementer> aLanguageToCounterIncrementer);
	void execute (CounterIncrementer[] aCounterIncrementers);

}
