package graphics;

import java.beans.PropertyChangeListener;

public interface DiningSceneInterface extends PropertyChangeListener {

	public TableInterface getTable();

	public SpaghettiInterface getSpaghetti();

	public ChopstickInterface getChopstick1();

	public ChopstickInterface getChopstick2();

	public ChopstickInterface getChopstick4();

	public ChopstickInterface getChopstick3();

	public ChopstickInterface getChopstick5();

	public PhilosopherAvatarInterface getPhilosopher1();

	public PhilosopherAvatarInterface getPhilosopher2();

	public PhilosopherAvatarInterface getPhilosopher3();

	public PhilosopherAvatarInterface getPhilosopher4();

	public PhilosopherAvatarInterface getPhilosopher5();

	boolean preInitNumberOfPhilosophers();

	void initNumberOfPhilosophers(int aNumberOfPhilosophers);

	void nextCourseTime(long newVal);

	boolean preNextCourseTime();
}
