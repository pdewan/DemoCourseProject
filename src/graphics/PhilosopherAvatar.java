package graphics;


import java.beans.PropertyChangeListener;

import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;

@PropertyNames({ "Head", "Arms", "Body", "Waiting", "RaisedHand", "Fed", "StringShape", "VisionLine1", "VisionLine2" })
@EditablePropertyNames({ "Waiting", "RaisedHand", "Fed" })

@StructurePattern(StructurePatternNames.BEAN_PATTERN)

public class PhilosopherAvatar implements PhilosopherAvatarInterface {

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

	PhilosopherHeadInterface head;
	AngleInterface arms;
	// ElbowInterface rightElbow;
	// ElbowInterface leftElbow;
	RotatingLineInterface body;
	StringShapeInterface stringShape;

	boolean waiting;
	boolean raisedHand;
	boolean isFed;

	RotatingLineInterface visionLine1;
	RotatingLineInterface visionLine2;

	public PhilosopherAvatar(PhilosopherHeadInterface avatarHead,  RotatingLineInterface line1,
			RotatingLineInterface line2) {
		head = avatarHead;
		visionLine1 = line1;
		visionLine2 = line2;
		// need offset because of start x, start y of angle!
		/*
		 * arms = new Angle(); arms.getLeftLine().rotate(LEFT_ROTATE);
		 * arms.getRightLine().rotate(RIGHT_ROTATE); // now fix arms
		 * arms.moveTo(((Locatable) head).getX() + 33, ((Locatable) head).getY() + 77);
		 * body = new RotatingLine(((Locatable) head).getX() + 33, ((Locatable)
		 * head).getY() + 64, BODY_RADIUS, BODY_ANGLE);
		 */

		// leftElbow = new Elbow(((Locatable) head).getX() - 7, ((Locatable)
		// head).getY() + 84, 40, 0);
		// rightElbow = new Elbow(((Locatable) head).getX() + 30, ((Locatable)
		// head).getY() + 84, 40, 0);
		stringShape = new StringShape(((Locatable) head).getX() + ((BoundedShape) head).getWidth() + 20,
				((Locatable) head).getY() - MINOR_OFFSET, "");
		arms = new Angle();
		arms.getLeftLine().rotate(LEFT_ROTATE);
		arms.getRightLine().rotate(RIGHT_ROTATE);
		// now fix arms
		arms.moveTo(((Locatable) head).getX() + 33, ((Locatable) head).getY() + 77);
		body = new RotatingLine(((Locatable) head).getX() + 33, ((Locatable) head).getY() + 64, BODY_RADIUS,
				BODY_ANGLE);
		// leftElbow = new Elbow();
		// leftElbow.move(((Locatable) head).getX(), ((Locatable) head).getY() + 77);
		body = new RotatingLine(((Locatable) head).getX() + 33, ((Locatable) head).getY() + 64, BODY_RADIUS,
				BODY_ANGLE);

		body.rotate(BODY_ROTATE);
		waiting = false;
		raisedHand = false;
		isFed = false;
	}


	@Override
	public PhilosopherHeadInterface getHead() {
		return head;
	}

	/*
	 * @Override public AngleInterface getArms() { return arms; }
	 */
	@Override
	public RotatingLineInterface getBody() {
		return body;
	}
	/*
	 * @Override public ElbowInterface getLeftElbow() { return leftElbow; }
	 * 
	 * @Override public ElbowInterface getRightElbow() { return rightElbow; }
	 */

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
	public StringShapeInterface getStringShape() {
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
	public void say(String speak) {
		this.getStringShape().setText(speak);
	}

	@Override
	public RotatingLineInterface getVisionLine1() {
		return visionLine1;
	}

	@Override
	public RotatingLineInterface getVisionLine2() {
		return visionLine2;
	}

	@Override
	public void move(int x, int y) {
		((Locatable) head).setX(((Locatable) head).getX() + x);
		((Locatable) head).setY(((Locatable) head).getY() + y);
		// ((Locatable) leftElbow.getTopLine()).setX(((Locatable)
		// leftElbow.getTopLine()).getX() + x);
		// ((Locatable) leftElbow.getTopLine()).setY(((Locatable)
		// leftElbow.getTopLine()).getY() + y);
		// ((Locatable) leftElbow.getBottomLine()).setX(((Locatable)
		// leftElbow.getBottomLine()).getX() + x);
		// ((Locatable) leftElbow.getBottomLine()).setY(((Locatable)
		// leftElbow.getBottomLine()).getY() + y);
		// ((Locatable) rightElbow.getTopLine()).setX(((Locatable)
		// rightElbow.getTopLine()).getX() + x);
		// ((Locatable) rightElbow.getTopLine()).setY(((Locatable)
		// rightElbow.getTopLine()).getY() + y);
		// ((Locatable) rightElbow.getBottomLine()).setX(((Locatable)
		// rightElbow.getBottomLine()).getX() + x);
		// ((Locatable) rightElbow.getBottomLine()).setY(((Locatable)
		// rightElbow.getBottomLine()).getY() + y);
		((Locatable) body).setX(((Locatable) body).getX() + x);
		((Locatable) body).setY(((Locatable) body).getY() + y);
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
