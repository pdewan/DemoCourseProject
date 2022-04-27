package pc.graphics;

import java.beans.PropertyChangeListener;

import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;

@StructurePattern(StructurePatternNames.OVAL_PATTERN)
public class ACircle extends ABoundedShape implements Circle {
	int x;
	int y;
	int radius;
	int height;
	int width;
	int INITIAL_X = 420;
	int INITIAL_Y = 175;
	int INITIAL_Width = 350;
	int INITIAL_Height = 350;
	
	PropertyListenerSupport propertySupport = new APropertyListenerSupport();

	public ACircle() {
		setX(INITIAL_X);
		setY(INITIAL_Y);
		setHeight(INITIAL_Height);
		setWidth(INITIAL_Width);	
	}

//
//	@Override
//	public int getHeight() {
//		return height;
//	}
//
//
//	@Override
//	public int getWidth() {
//		return width;
//	}
//
//	@Override
//	public void setHeight(int NewHeight) {
//		height = NewHeight;
//	}
//
//
//	@Override
//	public void setWidth(int NewWidth) {
//		width = NewWidth;
//	}
//
//
//	@Override
//	public void setX(int NewX) {
//		x = NewX;
//	}
//
//
//	@Override
//	public void setY(int NewY) {
//		y = NewY;
//	}
//
//
//	@Override
//	public int getX() {
//		return x;
//	}
//
//
//	@Override
//	public int getY() {
//		return y;
//	}


	@Override
	public void addPropertyChangeListener(PropertyChangeListener arg0) {
		propertySupport.addPropertyChangeListener(arg0);
	}	
	
}
