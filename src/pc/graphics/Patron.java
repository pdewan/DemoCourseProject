package pc.graphics;

import java.beans.PropertyChangeListener;

public interface Patron {
	public Avatar getPatron();
	public Table getTable();
	public void setPatron(int X, int Y);
	public void setTable(int X, int Y);
	public void move(int X, int Y);
	void addPropertyChangeListener(Patron patronParameter, PropertyChangeListener aListener);
}
