package pc.graphics;

import util.annotations.Tags;
import util.models.PropertyListenerRegisterer;

public interface Locatable extends PropertyListenerRegisterer {

	public void setX(int NewX);
	public void setY(int NewY);
	public int getX();
	public int getY();
	int getZIndex();
	void setZIndex(int newValue);
}
