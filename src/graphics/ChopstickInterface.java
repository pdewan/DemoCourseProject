package graphics;

import java.beans.PropertyChangeListener;

import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;

@StructurePattern(StructurePatternNames.BEAN_PATTERN)

public interface ChopstickInterface extends PropertyChangeListener {

	StringShapeInterface getStringShape();

	ChopstickImageInterface getChopstick();

	void moveTo(int x, int y);

}
