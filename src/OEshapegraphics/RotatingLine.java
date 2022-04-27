package OEshapegraphics;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Stroke;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;

import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;

@StructurePattern(StructurePatternNames.LINE_PATTERN)

public class RotatingLine extends Locatable implements RotatingLineInterface {

	int width, height;
	double radius, angle;
	RotatingLineInterface newLine;
	boolean used;
	Stroke strokie = new BasicStroke(1F);
	Color theColor = new Color(000000);

	final static int INIT_X = 100;
	final static int INIT_Y = 100;
	final static int INIT_WIDTH = 30;
	final static int INIT_RADIUS = 50;
	final static int INIT_ANGLE = 20;

	public RotatingLine(int initX, int initY, double initRadius, double initAngle) {
		super(initX, initY);
		radius = initRadius;
		angle = initAngle;
		used = false;

	}

	public RotatingLine(int initX, int initY) {
		super(initX, initY);
		newLine = new RotatingLine(INIT_X, INIT_X, INIT_RADIUS, INIT_ANGLE);
	}

	@Override
	public int getX() {
		return x;
	}

	@Override
	public void setX(int newX) {
		int oldX = getX();
		x = newX;
		propertySupport.notifyAllListeners(new PropertyChangeEvent(this, "X", oldX, newX));
	}

	@Override
	public void setY(int newY) {
		int oldY = getY();
		y = newY;
		propertySupport.notifyAllListeners(new PropertyChangeEvent(this, "Y", oldY, newY));
	}

	@Override
	public int getY() {
		return y;
	}

	@Override
	public int getWidth() {
		return (int) (getRadius() * Math.cos(getAngle()));

	}

	@Override
	public int getHeight() {
		return (int) (getRadius() * Math.sin(getAngle()));
	}


	@Override
	public double getRadius() {
		return radius;
	}

	@Override
	public void setRadius(double newRadius) {
		double oldHeight = getHeight();
		double oldWidth = getWidth();
		radius = newRadius;
		propertySupport.notifyAllListeners(new PropertyChangeEvent(this, "Height", oldHeight, getHeight()));
		propertySupport.notifyAllListeners(new PropertyChangeEvent(this, "Width", oldWidth, getWidth()));
	}

	@Override
	public double getAngle() {
		return angle;
	}

	@Override
	public void setAngle(double newAngle) {
		double oldHeight = getHeight();
		double oldWidth = getWidth();
		double oldAngle = getAngle();
		angle = newAngle;
		propertySupport.notifyAllListeners(new PropertyChangeEvent(this, "Height", oldHeight, getHeight()));
		propertySupport.notifyAllListeners(new PropertyChangeEvent(this, "Width", oldWidth, getWidth()));
	}

	@Override
	public boolean getUse() {
		return used;
	}

	@Override
	public void setUse(boolean use) {
		if (used == true) {
			used = false;
		} else {
			used = true;
		}
	}

	@Override
	public Stroke getStroke() {
		return strokie;
	}

	@Override
	public Color getColor() {
		return theColor;
	}

	@Override
	public void setColor(int color) {
		Color oldColor = getColor();
		theColor = new Color(color);
		propertySupport.notifyAllListeners(new PropertyChangeEvent(this, "Color", oldColor, getColor()));
	}

	@Override
	public void setStroke(float stroke) {
		Stroke oldStroke = getStroke();
		strokie = new BasicStroke(stroke);
		propertySupport.notifyAllListeners(new PropertyChangeEvent(this, "Stroke", oldStroke, getStroke()));
	}


	@Override
	public void rotate(int units) {
		double rotateFactor = (double) Math.PI / 32 * units;
		double newAngle = getAngle() + rotateFactor;
		this.setAngle(newAngle);
	}

	@Override
	public void addPropertyChangeListener(PropertyChangeListener newListen) {
		propertySupport.addListen(newListen);
	}

	@Override
	public List<PropertyChangeListener> getPropertyChangeListeners() {
		return propertySupport.generateList();
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		// TODO Auto-generated method stub

	}
}
