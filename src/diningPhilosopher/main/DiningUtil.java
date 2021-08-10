package diningPhilosopher.main;

import java.beans.PropertyChangeListener;

import coordination.joiner.JoinerFactory;
import diningPhilosopher.chopstick.Chopstick;
import diningPhilosopher.executor.DiningExecutor;
import diningPhilosopher.factories.ChopstickFactory;
import diningPhilosopher.factories.DiningExecutorFactory;
import diningPhilosopher.factories.DiningViewFactory;
import diningPhilosopher.factories.PhilospherFactory;
import diningPhilosopher.philosopher.Philosopher;
import gradingTools.shared.testcases.concurrency.propertyChanges.ConcurrentPropertyChangeSupport;

public class DiningUtil {
   public static void setNumberOfPhilosophers(int aNumberOfPhilosophers) {
	   Chopstick[] aChopsticks = ChopstickFactory.createChopsticks(aNumberOfPhilosophers);
	   Philosopher[] aPhilosophers = PhilospherFactory.createPhilosophers(aChopsticks);
	   PropertyChangeListener aView = DiningViewFactory.getSingleton();
	   registerObserverWithObservables(aView);
//	   registerObserverWithJoiner(aView);
	  
	   
   }
   
   public static void waitForPhilosophersToFinish() {
	   JoinerFactory.getSingleton().join();
   }
   
   public static void registerObserverWithObservables (PropertyChangeListener aListener) {
	   registerObserverWithChopsticks(aListener);
	   registerObserverWithPhilosophers(aListener);
	   registerObserverWithJoiner(aListener);

   }

   
   static void registerObserverWithPhilosophers (PropertyChangeListener aListener) {
	   Philosopher[] aPhilosophers = PhilospherFactory.getPhilosophers();
	   for (Philosopher aPhilosopher:aPhilosophers) {
		   aPhilosopher.addPropertyChangeListener(aListener);
	   }	   
   }
   static void registerObserverWithChopsticks (PropertyChangeListener aListener) {
	   Chopstick[] aChopsticks = ChopstickFactory.getChopsticks();
	   for (Chopstick aChopstick:aChopsticks) {
		   aChopstick.addPropertyChangeListener(aListener);
	   }	   
   }
   static void registerObserverWithJoiner (PropertyChangeListener aListener) {
	  JoinerFactory.getSingleton().addPropertyChangeListener(aListener); 
   }
   
   public static void setNewCourseTime(long aTimeToEat) {
	  DiningExecutorFactory.getSingleton().dineCourse(PhilospherFactory.getPhilosophers(), aTimeToEat);
	   
   }
}
