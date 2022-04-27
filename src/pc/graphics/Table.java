package pc.graphics;

import java.beans.PropertyChangeListener;

public interface Table {
	
	public Line getTop();
	public Line getBottom();
	public Line getRight();
	public Line getLeft();
	public Line getLeftDiagonal();
	public Line getRightDiagonal();
	public Line getTableLeg();
	public void move(int X, int Y);
	void addPropertyChangeListener(PropertyChangeListener arg0);

}
