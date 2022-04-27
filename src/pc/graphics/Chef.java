package pc.graphics;

import java.beans.PropertyChangeListener;

public interface Chef {
	public Avatar getChef();
	public void setChef(int X, int Y);
	public void move(int X, int Y);
	Table getStove();
	void addPropertyChangeListener(Chef chefParameter, PropertyChangeListener aListener);
}
