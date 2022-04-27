package graphics;

import bus.uigen.shapes.OEShapeModel;

public interface AngleOEShapeInterface {

	public OEShapeModel getLeftLine();

	public OEShapeModel getRightLine();

	public void raiseArm();

	public void lowerArm();

	public void move(int moveX, int moveY);

	public void moveTo(int moveX, int moveY);

}
