package diningPhilosopher.controller;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;
import java.util.Scanner;

import counterIncrementer.CounterIncrementer;
import counterIncrementer.CounterIncrementersExecutor;
import counterIncrementer.CounterIncrementersExecutorFactory;
import diningPhilosopher.main.DiningUtil;
import stringCounter.main.StringCounterMain;
import stringCounter.main.CounterIncrementerUtil;

public class BasicDiningController implements ConsoleController {
	 Scanner scanner;

	 protected Integer readNumberOfPhilosphers() {
			System.out.println("Please enter the number of philosphers/chopsticks");
			String anInputLine = scanner.nextLine();
			if (anInputLine.isEmpty()) {
				return null;
			}
			return Integer.parseInt(anInputLine);
		}
    protected Long readTimeToEatNextCourse() {
		System.out.println("Hit return to quit or input time to eat the next course:");
		String anInputLine = scanner.nextLine();
		if (anInputLine.isEmpty()) {
			return null;
		}
		return Long.parseLong(anInputLine);
	}

	
	
	protected void processInput (String[] aLanguageRequests, long aPauseTime) {
		CounterIncrementerUtil.processInput(aLanguageRequests, aPauseTime);
	}

	public void processInput() {
		scanner = new Scanner(System.in);
		Integer aNumberOfPhilosophers = readNumberOfPhilosphers();
		
		DiningUtil.setNumberOfPhilosophers(aNumberOfPhilosophers);
		while (true) {
			
			Long aTimeToEat = readTimeToEatNextCourse();
			if (aTimeToEat == null) {
				break;
			}
			DiningUtil.setNewCourseTime(aTimeToEat);			
		}
	}

}
