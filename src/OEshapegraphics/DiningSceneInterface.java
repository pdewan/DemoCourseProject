package OEshapegraphics;

import java.beans.PropertyChangeListener;

import bus.uigen.shapes.OEShapeModel;

public interface DiningSceneInterface extends PropertyChangeListener {

	public OEShapeModel getTable();

	public OEShapeModel getSpaghetti();

	public OEShapeModel getMiniSpag1();

	public OEShapeModel getMiniSpag2();

	public OEShapeModel getMiniSpag3();

	public OEShapeModel getMiniSpag4();

	public OEShapeModel getMiniSpag5();

	public OEShapeModel getChopstick1();

	public OEShapeModel getChopstick2();

	public OEShapeModel getChopstick4();

	public OEShapeModel getChopstick3();

	public OEShapeModel getChopstick5();

	public PhilosopherAvatarInterface getPhilosopher1();

	public PhilosopherAvatarInterface getPhilosopher2();

	public PhilosopherAvatarInterface getPhilosopher3();

	public PhilosopherAvatarInterface getPhilosopher4();

	public PhilosopherAvatarInterface getPhilosopher5();

	boolean preInitNumberOfPhilosophers();

	void initNumberOfPhilosophers(int aNumberOfPhilosophers);

	void nextCourseTime(int newVal);

	boolean preNextCourseTime();

	public OEShapeModel getVisionLine();

	public OEShapeModel getVisionLine2();

	public OEShapeModel getTableLeg1();

	public OEShapeModel getTableLeg2();

	OEShapeModel getEmptySpag1();

	OEShapeModel getEmptySpag2();

	OEShapeModel getEmptySpag3();

	OEShapeModel getEmptySpag4();

	OEShapeModel getEmptySpag5();

}
