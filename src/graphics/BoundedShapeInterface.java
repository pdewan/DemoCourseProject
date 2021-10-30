package graphics;


import java.beans.PropertyChangeListener;
import java.util.List;

import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;

@PropertyNames({ "Width", "Height", "PropertyChangeListeners" })
@EditablePropertyNames({ "Width", "Height" })

public interface BoundedShapeInterface extends PropertyChangeListener {

	public int getWidth();

	public int getHeight();

	public void setWidth(int newWidth);

	public void setHeight(int newHeight);

	public void addPropertyChangeListener(PropertyChangeListener newListen);

	public List<PropertyChangeListener> getPropertyChangeListeners();

}
