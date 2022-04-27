package graphics;

import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;

@StructurePattern(StructurePatternNames.BEAN_PATTERN)

public interface ElbowInterface {

	public RotatingLineInterface getTopLine();

	public RotatingLineInterface getBottomLine();

	public void raiseArm();

	public void lowerArmRight();

	public void lowerArmLeft();

	void move(int moveX, int moveY);

	public void animateArm();

	public void setElbowAngle(double newAngle);

}
