package graphics;

import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;

@StructurePattern(StructurePatternNames.BEAN_PATTERN)

public class Elbow implements ElbowInterface {

	RotatingLineInterface topLine;
	RotatingLineInterface bottomLine;

	int rotateSetter = -70;

	final static int INITIAL_RADIUS = 40;
	final static int INITIAL_ANGLE1 = 0;
	final static int INITIAL_ANGLE2 = 0;
	final static int START_X = 100;
	final static int START_Y = 100;

	public Elbow() {
		topLine = new RotatingLine(START_X, START_Y, INITIAL_RADIUS, INITIAL_ANGLE1);
		bottomLine = new RotatingLine(START_X, START_Y, INITIAL_RADIUS, INITIAL_ANGLE2);
	}

	public Elbow(int x, int y, int radius, int angle) {
		topLine = new RotatingLine(x, y, radius / 2, angle);
		bottomLine = new RotatingLine(x + 20, y, radius / 2, angle);
	}

	public Elbow(RotatingLineInterface startLeft, RotatingLineInterface startRight) {
		topLine = startLeft;
		bottomLine = startRight;
	}

	@Override
	public RotatingLineInterface getTopLine() {
		return topLine;
	}

	@Override
	public RotatingLineInterface getBottomLine() {
		return bottomLine;
	}

	@Override
	public void setElbowAngle(double newAngle) {
		topLine.setAngle(newAngle);
		bottomLine.setAngle(newAngle);
	}

	@Override
	public void raiseArm() {
		bottomLine.setAngle(-70);
	}

	@Override
	public void lowerArmRight() {
		bottomLine.setAngle(0);
	}

	// need to fix
	@Override
	public void lowerArmLeft() {
		bottomLine.setAngle(0);
		topLine.setAngle(-120);
		((Locatable) topLine).setY(((Locatable) topLine).getY() + 3);
	}

	@Override
	public void animateArm() {
		for (int i = 0; i < 30; i++) {
		bottomLine.setAngle(rotateSetter);
		bottomLine.setAngle(rotateSetter+10);
	}
	}

	@Override
	public void move(int moveX, int moveY) {
		((Locatable) topLine).setX(((Locatable) topLine).getX() + moveX);
		((Locatable) bottomLine).setX(((Locatable) bottomLine).getX() + moveX);
		((Locatable) topLine).setY(((Locatable) topLine).getY() + moveY);
		((Locatable) bottomLine).setY(((Locatable) bottomLine).getY() + moveY);
	}

}
