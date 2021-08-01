package diningPhilosopher.executor;

import java.util.Map;

import diningPhilosopher.philosopher.Philosopher;

public interface DiningExecutor {
//	void execute (Map<String, CounterIncrementer> aLanguageToCounterIncrementer);
	void dineCourse (Philosopher[] aPhilosophers, long aTimeToEat);

}
