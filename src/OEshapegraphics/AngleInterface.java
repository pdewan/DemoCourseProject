package OEshapegraphics;

public interface AngleInterface {

	public RotatingLineInterface getLeftLine();

	public RotatingLineInterface getRightLine();

	// public void setAngleLeft(double newAngle);

	// public void setAngleRight(double newAngle);

	public void move(int moveX, int moveY);

	public void moveTo(int moveX, int moveY);

	public void raiseArm();

	public void lowerArm();
}
