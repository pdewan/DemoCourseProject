package graphics;

import java.beans.PropertyChangeListener;

public interface DiningSceneInterfaceOld extends PropertyChangeListener {

	public TableInterface getTable();

	public SpaghettiInterface getSpaghetti();

	public SpaghettiInterface getMiniSpag1();

	public SpaghettiInterface getMiniSpag2();

	public SpaghettiInterface getMiniSpag3();

	public SpaghettiInterface getMiniSpag4();

	public SpaghettiInterface getMiniSpag5();

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

	void nextCourseTime(int newVal);

	boolean preNextCourseTime();

	public RotatingLineInterface getVisionLine();

	public RotatingLineInterface getVisionLine2();

	public RotatingLineInterface getTableLeg1();

	public RotatingLineInterface getTableLeg4();

}

