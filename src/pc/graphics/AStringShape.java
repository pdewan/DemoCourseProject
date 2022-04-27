package pc.graphics;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;

@StructurePattern(StructurePatternNames.STRING_PATTERN)
public class AStringShape implements StringShape {
	int x;
	int y;
	String text;
	
	PropertyListenerSupport propertySupport = new APropertyListenerSupport();
	
	public AStringShape() {
		
	}

	@Override
	public void setX(int NewX) {
		x = NewX;
	}

	@Override
	public void setY(int NewY) {
		y = NewY;
	}

	@Override
	public int getX() {
		return x;
	}

	@Override
	public int getY() {
		return y;
	}
	
	@Override
	public void setText(String NewText) {
		String oldText = text;
		text = NewText;
		propertySupport.notifyAllListeners(new PropertyChangeEvent (this, "text", oldText, getText()));
		
	}
	
	@Override
	public String getText() {
		return text;
	}

	@Override
	public void addPropertyChangeListener(PropertyChangeListener arg0) {
		propertySupport.addPropertyChangeListener(arg0);
	}

	@Override
	public int getZIndex() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setZIndex(int newValue) {
		// TODO Auto-generated method stub
		
	}

}
