package pc.graphics;

import util.models.PropertyListenerRegisterer;

public interface Line extends PropertyListenerRegisterer, BoundedShape  {

	public int getX();
	public int getY();
	public void setX(int NewX);
	public void setY(int NewY);
	public int getWidth();
	public void setWidth(int NewWidth);
	public int getHeight();
	public void setHeight(int NewHeight);
	public double getRadius();
	public void setRadius(double NewRadius);
	public void setAngle(double NewAngle);
	public void rotate(int units);
	public void move(int X, int Y);
	void moveTo(int newX, int newY);
}
