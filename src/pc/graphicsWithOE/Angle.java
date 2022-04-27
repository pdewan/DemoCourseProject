package pc.graphicsWithOE;

import java.beans.PropertyChangeListener;

import pc.graphics.Line;
import util.annotations.Tags;

public interface Angle {

	public Line getLeftLine();
	public Line getRightLine();
	public void move(int MoveX, int MoveY);
//	void setX(int NewX);
//	void setY(int NewY);
	void moveX(int NewX);
	void moveY(int NewY);
	void moveTo(int newX, int newY);
	void removeArms();
	void addPropertyChangeListener(Angle angleParameter, PropertyChangeListener aListener);

	
}
