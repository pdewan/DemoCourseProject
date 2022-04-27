package pc.graphics;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;
import util.models.PropertyListenerRegisterer;

@StructurePattern(StructurePatternNames.LINE_PATTERN)
@PropertyNames({
	"x",
	"y",
	"width",
	"height",
	"radius",
	"angle",
	"ZIndex"
	})
@EditablePropertyNames({
	"radius",
	"angle",
	"x",
	"y",
	"height",
	"width",
	"ZIndex"
})

public class ALine extends ABoundedShape implements Line, PropertyListenerRegisterer, BoundedShape {
	int x, y, width, height;
	double radius, angle;
	
	int INIT_Angle = 45;
	int INIT_Radius = 40;
	int INIT_Rotate = 6;
	int INIT_XY = 50;

	public ALine() {
		setRadius(INIT_Radius);
		setAngle(INIT_Angle);
		rotate(INIT_Rotate);
		setX(INIT_XY);
		setY(INIT_XY);
	}
	
	public ALine(int INIT_X, int INIT_Y, double INIT_Radius, int INIT_Rotate) {
		setX(INIT_X);
		setY(INIT_Y);
		setRadius(INIT_Radius);
		setAngle(INIT_Angle);
		rotate(INIT_Rotate);
	}

	public ALine(double newRadius, double newAngle) {
		setRadius(newRadius);
		setAngle(newAngle);
	}
//	
//	@Override
//	public void setX(int newX) {
//		int oldX = x;
//		x = newX;
//		
//	}
//
//	@Override
//	public void setY(int newY) {
//		int oldY = y;
//		y = newY;
//	}
//
//	@Override
//	public int getX() {
//		return x;
//	}
//
//	@Override
//	public int getY() {
//		return y;
//	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double newRadius) {
		double oldRadius = radius;
		radius = newRadius;
		propertySupport.notifyAllListeners(new PropertyChangeEvent(this, "radius", oldRadius, radius));
		
	}

	public double getAngle() {
		return angle;	
	}

	public void setAngle(double newAngle) {
		double oldAngle = angle;
		angle = newAngle;
		height = (int) (getRadius()*Math.sin(angle));
		width = (int) (getRadius()*Math.cos(angle));
		
		setHeight(height);
		setWidth(width);

		propertySupport.notifyAllListeners(new PropertyChangeEvent(this, "angle", oldAngle, angle));
	}

	public void rotate(int units) {
		double rotate = units * Math.PI/32;
		setAngle(rotate + angle);
	}

	@Override
	public void move(int newX, int newY) {
		setX(getX()+newX);
		setY(getY()+newY);
	}
	
	@Override
	public void moveTo(int newX, int newY) {
		setX(newX);
		setY(newY);
	}
	
	public void addPropertyChangeListener(PropertyChangeListener arg0) {
		propertySupport.addPropertyChangeListener(arg0);
	}

}