package diningPhilosopher.coordinated;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;
import java.util.Scanner;

import coordination.joiner.JoinerFactory;
import counterIncrementer.CounterIncrementer;
import counterIncrementer.CounterIncrementersExecutor;
import counterIncrementer.CounterIncrementersExecutorFactory;
import diningPhilosopher.controller.BasicDiningPhilosopherController;
import diningPhilosopher.main.DiningPhilosopherUtil;
import stringCounter.main.StringCounterMain;
import stringCounter.main.CounterIncrementerUtil;

public class CoordinatedDiningPhilosopherController extends BasicDiningPhilosopherController {
    protected Long readTimeToEatNextCourse() {
		JoinerFactory.getSingleton().join();
		return super.readTimeToEatNextCourse();
	}
    
    
	
}
