package OEshapegraphics;

import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;

@PropertyNames({ "LeftLine", "RightLine" })

@StructurePattern(StructurePatternNames.BEAN_PATTERN)

public class Angle implements AngleInterface {

	final static int INITIAL_RADIUS = 30;
	final static int INITIAL_ANGLE1 = 0;
	final static int INITIAL_ANGLE2 = 0;
	final static int START_X = 100;
	final static int START_Y = 100;
	final static int TIME = 300;
	final static int ANGLE_MOVE_RAISE = 50;
	final static int ANGLE_MOVE_LOWER = 70;

	RotatingLineInterface leftLine;
	RotatingLineInterface rightLine;

	public Angle() {
		leftLine = new RotatingLine(START_X, START_Y, INITIAL_RADIUS, INITIAL_ANGLE1);
		rightLine = new RotatingLine(START_X, START_Y, INITIAL_RADIUS, INITIAL_ANGLE2);
	}

	public Angle(RotatingLineInterface startLeft, RotatingLineInterface startRight) {
		leftLine = startLeft;
		rightLine = startRight;
	}

	@Override
	public RotatingLineInterface getLeftLine() {
		return leftLine;
	}

	@Override
	public RotatingLineInterface getRightLine() {
		return rightLine;
	}

	@Override
	public void raiseArm() {
		rightLine.setAngle(ANGLE_MOVE_RAISE);
	}

	@Override
	public void lowerArm() {
		rightLine.setAngle(ANGLE_MOVE_LOWER);
	}

	/*
	 * @Override public void setAngleLeft(double newAngle) { double oldVal =
	 * getLeftLine().getAngle(); leftLine.setAngle(newAngle); }
	 * 
	 * @Override public void setAngleRight(double newAngle) { double oldVal =
	 * getRightLine().getAngle(); rightLine.setAngle(newAngle); }
	 */

	@Override
	public void move(int moveX, int moveY) {
		((Locatable) leftLine).setX(((Locatable) leftLine).getX() + moveX);
		((Locatable) rightLine).setX(((Locatable) rightLine).getX() + moveX);
		((Locatable) leftLine).setY(((Locatable) rightLine).getY() + moveY);
		((Locatable) rightLine).setY(((Locatable) rightLine).getY() + moveY);
	}

	@Override
	public void moveTo(int moveX, int moveY) {
		((Locatable) leftLine).setX(moveX);
		((Locatable) rightLine).setX(moveX);
		((Locatable) leftLine).setY(moveY);
		((Locatable) rightLine).setY(moveY);
	}

}
