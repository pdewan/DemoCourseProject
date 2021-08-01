package diningPhilosopher.main;

import java.beans.PropertyChangeListener;

import diningPhilosopher.chopstick.ChopstickFactory;
import diningPhilosopher.chopstick.SmartChopstick;
import diningPhilosopher.executor.DiningExecutor;
import diningPhilosopher.executor.DiningExecutorFactory;
import diningPhilosopher.philosopher.Philosopher;
import diningPhilosopher.philosopher.PhilospherFactory;
import diningPhilosopher.view.DiningPhilosopherViewFactory;

public class DiningPhilosopherUtil {
   public static void setNumberOfPhilosphers(int aNumberOfPhilosophers) {
	   SmartChopstick[] aChopsticks = ChopstickFactory.createChopsticks(aNumberOfPhilosophers);
	   Philosopher[] aPhilosophers = PhilospherFactory.createPhilosophers(aChopsticks);
	   PropertyChangeListener aView = DiningPhilosopherViewFactory.getSingleton();
	   registerObserverWithObservables(aView);
	  
	   
   }
   
   static void registerObserverWithObservables (PropertyChangeListener aListener) {
	   registerObserverWithChopsticks(aListener);
	   registerObserverWithPhilosophers(aListener);
   }

   
   static void registerObserverWithPhilosophers (PropertyChangeListener aListener) {
	   Philosopher[] aPhilosophers = PhilospherFactory.getPhilosophers();
	   for (Philosopher aPhilosopher:aPhilosophers) {
		   aPhilosopher.addPropertyChangeListener(aListener);
	   }	   
   }
   static void registerObserverWithChopsticks (PropertyChangeListener aListener) {
	   SmartChopstick[] aChopsticks = ChopstickFactory.getChopsticks();
	   for (SmartChopstick aChopstick:aChopsticks) {
		   aChopstick.addPropertyChangeListener(aListener);
	   }	   
   }
   
   public static void setNewCourseTime(long aTimeToEat) {
	  DiningExecutorFactory.getSingleton().dineCourse(PhilospherFactory.getPhilosophers(), aTimeToEat);
	   
   }
}
