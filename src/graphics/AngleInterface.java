package graphics;

public interface AngleInterface {

	public RotatingLineInterface getLeftLine();

	public RotatingLineInterface getRightLine();

	public void move(int moveX, int moveY);

	public void moveTo(int moveX, int moveY);

	public void raiseArm();

	public void lowerArm();
}
