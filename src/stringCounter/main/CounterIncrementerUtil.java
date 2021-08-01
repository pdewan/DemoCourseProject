package stringCounter.main;

import java.beans.PropertyChangeListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import counterIncrementer.CounterIncrementer;
import counterIncrementer.CounterIncrementerFactory;
import counterIncrementer.CounterIncrementersExecutor;
import counterIncrementer.CounterIncrementersExecutorFactory;
import stringCounter.CyclicCounter;
import stringCounter.StringCounterViewFactory;
import stringCounter.StringCounter;
import stringCounter.StringCounterFactory;

public class CounterIncrementerUtil {
	static final String[] ENGLISH_COUNTS = { "one", "two", "three", "four", "five", "six", "seven", "eight", "nine",
			"ten" };
	static final String[] GERMAN_COUNTS = { "eins", "zwei", "drei", "vier", "fünf", "sechs", "sieben", "acht", "neun",
			"zehn" };
	static final String[] FRENCH_COUNTS = { "un", "deux", "trois", "quatre", "cinq", "six", "sept", "huit", "neuf",
			"dix" };
	static final String[] SPANISH_COUNTS = { "uno", "dos", "tres", "cuatro", "cinco", "seis", "siete", "ocho", "nueve",
			"dies" };
	static final int NUM_COUNTS = ENGLISH_COUNTS.length;
//	static final long SLEEP_TIME = 100;
//	static long pauseTime = 100;

	static Map<String, String[]> languageToCounts = new HashMap<>();
//	static Map<String, CounterIncrementer> languageToCounterIncrementer = new HashMap<>();
//	static Scanner scanner;
//	static PropertyChangeListener stringCountPrinter = StringCounterViewFactory.getSingleton();
	
	static {
		languageToCounts.put("english", ENGLISH_COUNTS);
		languageToCounts.put("german", GERMAN_COUNTS);
		languageToCounts.put("french", FRENCH_COUNTS);
		languageToCounts.put("spanish", SPANISH_COUNTS);
	}

//	public static String[] readLanguageRequests() {
//		System.out.println(
//				"Hit return to quit or input a series of language names (english, spanish, french, german)");
//		String anInputLine = scanner.nextLine();
//		return anInputLine.split(" ");
//	}
//	
//	public static long readPauseTime() {
//		System.out.println(
//				"Please input pause time in ms");
//		String anInputLine = scanner.nextLine();
//		return Long.parseLong(anInputLine);
//	}


	public static void processInput (String[] aLanguageRequests, long aPauseTime) {
		CounterIncrementer[] aCounterIncrementers = getCounterIncrementers(aLanguageRequests, aPauseTime);
		List<StringCounter> aCounters = StringCounterFactory.getCounters();
		for (StringCounter aCounter : aCounters) {
			aCounter.addPropertyChangeListener(StringCounterViewFactory.getSingleton());
		}
		CounterIncrementersExecutor aCounterIncrementersExecutor = CounterIncrementersExecutorFactory
				.getSingleton();
		aCounterIncrementersExecutor.execute(aCounterIncrementers, aPauseTime);
	}
	
	public static CounterIncrementer[] getCounterIncrementers(String[] aLanguageRequesters, long aPauseTime) {
		Map<String, CounterIncrementer> aLanguageToCounterIncrementer = new HashMap<>();

//		StringCounter[] aCounters = new StringCounter[aLanguageRequesters.length];
		CounterIncrementer[] aCounterIncrementers = new CounterIncrementer[aLanguageRequesters.length];

		for (int anIndex = 0; anIndex < aLanguageRequesters.length; anIndex++) {
			String aLanguage = aLanguageRequesters[anIndex];
			CounterIncrementer aCounterIncrementer = aLanguageToCounterIncrementer.get(aLanguage);
			if (aCounterIncrementer == null) {
				String aRequestedLanguage = aLanguageRequesters[anIndex];
				String[] aStringCounts = languageToCounts.get(aRequestedLanguage);
				StringCounter aCounter = StringCounterFactory.createStringCounter(aStringCounts);
//				StringCounter aCounter = new CyclicCounter(languageToCounts.get(aLanguageRequesters[anIndex]));
//				aCounter.addPropertyChangeListener(stringCountPrinter);
				aCounterIncrementer = CounterIncrementerFactory.createCounterIncrementer(aCounter, NUM_COUNTS, aPauseTime);
				aLanguageToCounterIncrementer.put(aLanguage, aCounterIncrementer);
			}
			aCounterIncrementers[anIndex] = aCounterIncrementer;
		}
		return aCounterIncrementers;
//		return aLanguageToCounterIncrementer;
//		return aCounters;
	}

//	public static long getPauseTime() {
//		return pauseTime;
//	}

//	public static void main(String[] args) {
////		scanner = new Scanner(System.in);
//		while (true) {
//		String[] aLanguageRequests = readLanguageRequests();
//		
//		if (aLanguageRequests.length == 0 || aLanguageRequests[0].isEmpty()) {
//			break;
//		}
//		pauseTime = readPauseTime();
//		CounterIncrementer[] aCounterIncrementers = getCounterIncrementers(aLanguageRequests);
//		List<StringCounter> aCounters = StringCounterFactory.getCounters();
//		for (StringCounter aCounter:aCounters) {
//			aCounter.addPropertyChangeListener(stringCountPrinter);
//		}
//		CounterIncrementersExecutor aCounterIncrementersExecutor = CounterIncrementersExecutorFactory.getSingleton();
//		aCounterIncrementersExecutor.execute(aCounterIncrementers);
////		int aTotalWaitTime = aLanguageRequests.length() + 
//		}
////		CounterIncrementersExecutorFactory.getSingleton().execute(
////					(createCounterIncrementers(
////						readLanguageRequests())));
//
//	}

}
