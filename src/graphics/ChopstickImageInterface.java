package graphics;

import java.beans.PropertyChangeListener;
import java.util.List;

import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.models.PropertyListenerRegisterer;

@StructurePattern(StructurePatternNames.IMAGE_PATTERN)

public interface ChopstickImageInterface extends PropertyListenerRegisterer {

	String getImageFileName();

	void setImageFileName(String newVal);

	public void addPropertyChangeListener(PropertyChangeListener newListen);

	public List<PropertyChangeListener> getPropertyChangeListeners();


}
