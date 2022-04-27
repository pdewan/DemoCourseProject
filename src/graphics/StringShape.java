package graphics;

import java.beans.PropertyChangeEvent;

import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;

@PropertyNames({ "X", "Y", "Text", "PropertyChangeListeners" })
@EditablePropertyNames({ "X", "Y", "Text" })

@StructurePattern(StructurePatternNames.STRING_PATTERN)

public class StringShape extends Locatable implements StringShapeInterface {
	String text;

	final static int SETTING_X = 100;
	final static int SETTING_Y = 100;

	public StringShape(int initX, int initY, String initText) {
		super(initX, initY);
		text = initText;

	}

	@Override
	public String getText() {
		return text;
	}

	@Override
	public void setText(String newVal) {
		String oldVal = getText();
		text = newVal;
		propertySupport.notifyAllListeners(new PropertyChangeEvent(this, "Text", oldVal, newVal));

	}

	/*
	 * @Override public void addPropertyChangeListener(PropertyChangeListener
	 * newListen) { propertySupport.addListen(newListen); }
	 * 
	 * @Override public List<PropertyChangeListener> getPropertyChangeListeners() {
	 * return propertySupport.generateList(); }
	 */

}
