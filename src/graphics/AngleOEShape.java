package graphics;

import bus.uigen.shapes.ALineModel;
import bus.uigen.shapes.OEShapeModel;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;

// @PropertyNames({ "LeftLine", "RightLine" })

@StructurePattern(StructurePatternNames.BEAN_PATTERN)

public class AngleOEShape implements AngleOEShapeInterface {

	final static int INITIAL_RADIUS = 30;
	final static int INITIAL_ANGLE1 = 0;
	final static int INITIAL_ANGLE2 = 0;
	final static int START_X = 100;
	final static int START_Y = 100;
	final static int TIME = 300;
	final static int ANGLE_MOVE_RAISE = 50;
	final static int ANGLE_MOVE_LOWER = 70;

	OEShapeModel leftLine;
	OEShapeModel rightLine;

	public AngleOEShape() {
		leftLine = new ALineModel();
		leftLine.setX(START_X);
		leftLine.setY(START_Y);
		leftLine.setRadius(INITIAL_RADIUS);
		leftLine.setAngle(INITIAL_ANGLE1);
		rightLine = new ALineModel();
		rightLine.setX(START_X);
		rightLine.setY(START_Y);
		rightLine.setRadius(INITIAL_RADIUS);
		rightLine.setAngle(INITIAL_ANGLE2);
	}

	public AngleOEShape(OEShapeModel startLeft, OEShapeModel startRight) {
		leftLine = startLeft;
		rightLine = startRight;
	}

	@Override
	public OEShapeModel getLeftLine() {
		return leftLine;
	}

	@Override
	public OEShapeModel getRightLine() {
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

	@Override
	public void move(int moveX, int moveY) {
		leftLine.setX(leftLine.getX() + moveX);
		rightLine.setX(rightLine.getX() + moveX);
		leftLine.setY(leftLine.getY() + moveY);
		rightLine.setY(rightLine.getY() + moveY);
	}

	@Override
	public void moveTo(int moveX, int moveY) {
		leftLine.setX(moveX);
		rightLine.setX(moveX);
		leftLine.setY(moveY);
		rightLine.setY(moveY);
	}

}
