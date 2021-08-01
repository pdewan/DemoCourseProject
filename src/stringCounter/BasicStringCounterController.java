package stringCounter;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;
import java.util.Scanner;

import counterIncrementer.CounterIncrementer;
import counterIncrementer.CounterIncrementersExecutor;
import counterIncrementer.CounterIncrementersExecutorFactory;
import stringCounter.main.StringCounterMain;
import stringCounter.main.CounterIncrementerUtil;

public class BasicStringCounterController implements ConsoleController {
	 Scanner scanner;

    protected String[] readLanguageRequests() {
		System.out.println("Hit return to quit or input a series of language names (english, spanish, french, german)");
		String anInputLine = scanner.nextLine();
		return anInputLine.split(" ");
	}

	protected long readPauseTime() {
		System.out.println("Please input pause time in ms");
		String anInputLine = scanner.nextLine();
		return Long.parseLong(anInputLine);
	}
	
	protected void processInput (String[] aLanguageRequests, long aPauseTime) {
		CounterIncrementerUtil.processInput(aLanguageRequests, aPauseTime);
	}

	public void processInput() {
		scanner = new Scanner(System.in);
		while (true) {
			String[] aLanguageRequests = readLanguageRequests();

			if (aLanguageRequests.length == 0 || aLanguageRequests[0].isEmpty()) {
				break;
			}
			long aPauseTime = readPauseTime();
			processInput(aLanguageRequests, aPauseTime);
//			CounterIncrementer[] aCounterIncrementers = CounterIncrementerUtil.getCounterIncrementers(aLanguageRequests);
//			List<StringCounter> aCounters = StringCounterFactory.getCounters();
//			for (StringCounter aCounter : aCounters) {
//				aCounter.addPropertyChangeListener(StringCounterViewFactory.getSingleton());
//			}
//			CounterIncrementersExecutor aCounterIncrementersExecutor = CounterIncrementersExecutorFactory
//					.getSingleton();
//			aCounterIncrementersExecutor.execute(aCounterIncrementers, aPauseTime);
//			int aTotalWaitTime = aLanguageRequests.length() + 
		}
//			CounterIncrementersExecutorFactory.getSingleton().execute(
//						(createCounterIncrementers(
//							readLanguageRequests())));

	}

}
