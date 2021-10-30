package diningPhilosopher.main;

import java.beans.PropertyChangeListener;

import coordination.joiner.JoinerFactory;
import diningPhilosopher.chopstick.Chopstick;
import diningPhilosopher.factories.ChopstickFactory;
import diningPhilosopher.factories.DiningExecutorFactory;
import diningPhilosopher.factories.DiningViewFactory;
import diningPhilosopher.factories.PhilospherFactory;
import diningPhilosopher.factories.SceneFactory;
import diningPhilosopher.philosopher.Philosopher;

public class DiningUtil {

	static int numberOfPhilosophers = 0;
	static final int MAX_PHILOSOPHERS = 5;

   public static void setNumberOfPhilosophers(int aNumberOfPhilosophers) {
		if (numberOfPhilosophers > 0) {
			System.err.println("The number of philosophers is already set to: " + numberOfPhilosophers);
			System.exit(-1);
		}
		if (aNumberOfPhilosophers <= 0 || aNumberOfPhilosophers > MAX_PHILOSOPHERS) {
			System.err
					.println("The number of philosophers should be between 1 and " + MAX_PHILOSOPHERS + " inclusive.");
			System.exit(-1);
		}
	   Chopstick[] aChopsticks = ChopstickFactory.createChopsticks(aNumberOfPhilosophers);
	   Philosopher[] aPhilosophers = PhilospherFactory.createPhilosophers(aChopsticks);
	   PropertyChangeListener aView = DiningViewFactory.getSingleton();
	   registerObserverWithObservables(aView);
		PropertyChangeListener aGraphicsView = SceneFactory.getSingleton();
		registerObserverWithObservables(aGraphicsView);
		// unsure if before is correct!
		// PropertyChangeListener aInteractionView = InteractionFactory.getSingleton();
		// registerObserverWithObservables(aInteractionView);

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
