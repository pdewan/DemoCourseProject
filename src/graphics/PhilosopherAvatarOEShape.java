package graphics;


import java.awt.Color;
import java.beans.PropertyChangeListener;

import bus.uigen.shapes.ALineModel;
import bus.uigen.shapes.AStringModel;
import bus.uigen.shapes.AnImageModel;
import bus.uigen.shapes.OEShapeModel;
import shapes.FlexibleTextShape;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;

// @PropertyNames({ "Head", "Arms", "Body", "Waiting", "RaisedHand", "Fed", "StringShape", "VisionLine1", "VisionLine2" })
// @EditablePropertyNames({ "Waiting", "RaisedHand", "Fed" })

@StructurePattern(StructurePatternNames.BEAN_PATTERN)

public class PhilosopherAvatarOEShape implements PhilosopherAvatarOEShapeInterface {

	final static int OFFSET = 100;
	final static int MINOR_OFFSET = 10;
	final static int LEFT_ROTATE = 24;
	final static int RIGHT_ROTATE = 8;
	final static int BODY_ROTATE = 16;
	final static int BODY_RADIUS = 50;
	final static int BODY_ANGLE = 0;
	final static int DIVIDER = 2;

	final static int INITIAL_RADIUS = 40;
	final static int INITIAL_ANGLE1 = 0;
	final static int INITIAL_ANGLE2 = 0;
	final static int START_X = 100;
	final static int START_Y = 100;

	OEShapeModel head;
	AngleInterface arms;
	OEShapeModel body;
	FlexibleTextShape stringShape;

	boolean waiting;
	boolean raisedHand;
	boolean isFed;

	OEShapeModel visionLine1;
	OEShapeModel visionLine2;

	public PhilosopherAvatarOEShape(String avatarHead, int initX, int initY) {
		head = new AnImageModel(avatarHead);
		head.setX(initX);
		head.setY(initY);
		visionLine1 = new ALineModel();
		visionLine2 = new ALineModel();
		body = new ALineModel();
		stringShape = new AStringModel("Waiting to eat!");
		stringShape.setX(head.getX() + 70);
		stringShape.setY(head.getY() - MINOR_OFFSET);
		arms = new Angle();
		arms.getLeftLine().rotate(LEFT_ROTATE);
		arms.getRightLine().rotate(RIGHT_ROTATE);
		arms.moveTo(head.getX() + 33, head.getY() + 77);
		body.setX(head.getX() + 33);
		body.setY(head.getY() + 64);
		body.setRadius(BODY_RADIUS);
		body.setAngle(BODY_ROTATE);
		body.setColor(Color.WHITE);
		waiting = false;
		raisedHand = false;
		isFed = false;
	}

	@Override
	public OEShapeModel getHead() {
		return head;
	}

	@Override
	public OEShapeModel getBody() {
		return body;
	}

	@Override
	public AngleInterface getArms() {
		return arms;
	}

	@Override
	public boolean getWaiting() {
		return waiting;
	}

	@Override
	public void setWaiting(boolean waitStatus) {
		waiting = waitStatus;
	}
	
	@Override
	public FlexibleTextShape getStringShape() {
		return stringShape;
	}

	@Override
	public boolean getRaisedHand() {
		return waiting;
	}

	@Override
	public void setRaisedHand(boolean handStatus) {
		waiting = handStatus;
	}

	@Override
	public boolean getFed() {
		return isFed;
	}

	@Override
	public void setFed(boolean fedStatus) {
		isFed = fedStatus;
	}

	@Override
	public OEShapeModel getVisionLine1() {
		return visionLine1;
	}

	@Override
	public OEShapeModel getVisionLine2() {
		return visionLine2;
	}

	@Override
	public void move(int x, int y) {
		head.setX(head.getX() + x);
		head.setY(head.getY() + y);
		body.setX(body.getX() + x);
		body.setY(body.getY() + y);
	}

	@Override
	public void addPropertyChangeListener(RotatingLineInterface rotatingLine, PropertyChangeListener propertySupport) {
		rotatingLine.addPropertyChangeListener(propertySupport);
	}

	@Override
	public void addPropertyChangeListener(AngleInterface angle, PropertyChangeListener propertySupport) {
		addPropertyChangeListener(angle.getLeftLine(), propertySupport);
		addPropertyChangeListener(angle.getRightLine(), propertySupport);
	}

	@Override
	public void addPropertyChangeListener(PropertyChangeListener arg0) {
		// TODO Auto-generated method stub

	}


}
