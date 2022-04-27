package OEshapegraphics;

import java.beans.PropertyChangeListener;

import util.models.PropertyListenerRegisterer;

public interface PhilosopherAvatarInterface extends PropertyListenerRegisterer {

	public PhilosopherHeadInterface getHead();

	public RotatingLineInterface getBody();

	public boolean getWaiting();

	public void setWaiting(boolean waitStatus);

	public boolean getRaisedHand();

	public void setRaisedHand(boolean handStatus);

	public boolean getFed();

	public void setFed(boolean fedStatus);

	public void move(int x, int y);

	public void addPropertyChangeListener(RotatingLineInterface rotatingLine, PropertyChangeListener propertySupport);

	public void addPropertyChangeListener(AngleInterface angle, PropertyChangeListener propertySupport);

	public void say(String speak);

	public RotatingLineInterface getVisionLine1();

	public RotatingLineInterface getVisionLine2();

	// ElbowInterface getRightElbow();

	// ElbowInterface getLeftElbow();

	AngleInterface getArms();

	StringShapeInterface getStringShape();

}
