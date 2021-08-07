package diningPhilosopher.coordinated;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;
import java.util.Scanner;

import coordination.joiner.JoinerFactory;
import counterIncrementer.CounterIncrementer;
import counterIncrementer.CounterIncrementersExecutor;
import counterIncrementer.CounterIncrementersExecutorFactory;
import diningPhilosopher.controller.BasicDiningController;
import diningPhilosopher.main.DiningUtil;
import stringCounter.main.StringCounterMain;
import stringCounter.main.CounterIncrementerUtil;

public class ButlerCoordinatedDiningController extends BasicDiningController {
    protected Long readTimeToEatNextCourse() {
		JoinerFactory.getSingleton().join();
		return super.readTimeToEatNextCourse();
	}
    
    
	
}
