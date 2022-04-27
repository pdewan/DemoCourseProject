package graphics;

import java.beans.PropertyChangeEvent;

import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;

@StructurePattern(StructurePatternNames.BEAN_PATTERN)

@PropertyNames({ "StringShape", "Chopstick", "ZIndex", "Width", "Height", "X", "Y", "PropertyChangeListeners" })
@EditablePropertyNames({ "ZIndex", "Width", "Height", "X", "Y" })

public class Chopstick extends BoundedShape implements ChopstickInterface {

	StringShapeInterface stringShape;
	ChopstickImageInterface chopstick;
	// int zIndex;

	public Chopstick(ChopstickImage chopstickImage) {
		super(0, 0, 0, 0);
		chopstick = chopstickImage;
		stringShape = new StringShape(chopstickImage.getX() + 20, chopstickImage.getY(), "");

	}

	@Override
	public ChopstickImageInterface getChopstick() {
		return chopstick;
	}

	@Override
	public StringShapeInterface getStringShape() {
		return stringShape;
	}

	@Override
	public void moveTo(int x, int y) {
		((Locatable) chopstick).setX(x);
		((Locatable) chopstick).setY(y);
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		// TODO Auto-generated method stub

	}

}
