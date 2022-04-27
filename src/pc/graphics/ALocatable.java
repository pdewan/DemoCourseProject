package pc.graphics;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.Tags;
import util.models.PropertyListenerRegisterer;


@PropertyNames({
	"x",
	"y",
	"ZIndex"
	})
@EditablePropertyNames({
	"x",
	"y",
	"ZIndex"
})
public class ALocatable implements Locatable, PropertyListenerRegisterer {
	int x, y;
	int ZIndex;
	
	PropertyListenerSupport propertySupport = new APropertyListenerSupport();
	
	//List<PropertyChangeListener> propertyChangeListeners = new ArrayList<PropertyChangeListener>();
	
	public ALocatable() {
	}
	
	@Override
	public void setX(int newX) {
		int oldX = x;
		x = newX;
		
		propertySupport.notifyAllListeners(new PropertyChangeEvent(this, "x", oldX, newX));
		
	}

	@Override
	public void setY(int newY) {
		int oldY = y;
		y = newY;
		
		propertySupport.notifyAllListeners(new PropertyChangeEvent(this, "x", oldY, newY));
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
	public int getZIndex() {
		return ZIndex;
		
	}
	
	@Override
	public void setZIndex(int newValue) {
		int oldZIndex = ZIndex;
		ZIndex = newValue;
		
		propertySupport.notifyAllListeners(new PropertyChangeEvent(this, "ZIndex", oldZIndex, ZIndex));
		
	}

	@Override
	public void addPropertyChangeListener(PropertyChangeListener arg0) {
		propertySupport.addPropertyChangeListener(arg0);
		System.out.print("inside property change listener" + this);
	}
	
	

}
