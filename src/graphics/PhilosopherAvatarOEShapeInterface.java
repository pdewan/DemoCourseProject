package graphics;

import java.beans.PropertyChangeListener;

import bus.uigen.shapes.OEShapeModel;
import shapes.FlexibleTextShape;
import util.models.PropertyListenerRegisterer;

public interface PhilosopherAvatarOEShapeInterface extends PropertyListenerRegisterer {

	public OEShapeModel getHead();

	public OEShapeModel getBody();

	public AngleInterface getArms();

	public boolean getWaiting();

	public void setWaiting(boolean waitStatus);

	public FlexibleTextShape getStringShape();

	public boolean getRaisedHand();

	public void setRaisedHand(boolean handStatus);

	public boolean getFed();

	public void setFed(boolean fedStatus);

	public OEShapeModel getVisionLine1();

	public OEShapeModel getVisionLine2();

	public void move(int x, int y);

	public void addPropertyChangeListener(RotatingLineInterface rotatingLine, PropertyChangeListener propertySupport);

	public void addPropertyChangeListener(AngleInterface angle, PropertyChangeListener propertySupport);

	public void addPropertyChangeListener(PropertyChangeListener arg0);

}
