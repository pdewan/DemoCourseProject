package pc.graphics;

import util.models.PropertyListenerRegisterer;

public interface Plate extends BoundedShape, PropertyListenerRegisterer {

	String getImageFileName();
	void setImageFileName(String newName);
	void move(int newX, int newY);
	void moveTo(int newX, int newY);
}
