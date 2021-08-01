package counterIncrementer.threads;

import counterIncrementer.CounterIncrementer;

public class CounterIncrementerRunnable implements Runnable {
	CounterIncrementer counterIncrementer;
	public CounterIncrementerRunnable(CounterIncrementer aCounterIncrementer) {
		counterIncrementer = aCounterIncrementer;
	}

	@Override
	public void run() {
		counterIncrementer.countUp();
	}

}
