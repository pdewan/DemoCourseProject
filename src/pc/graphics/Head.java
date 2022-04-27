package pc.graphics;

import util.models.PropertyListenerRegisterer;

public interface Head extends BoundedShape, PropertyListenerRegisterer {
	
	
	public String getImageFileName();
	public void setImageFileName(String newImage);
	public void move(int X, int Y);
	void moveTo(int newX, int newY);
}
