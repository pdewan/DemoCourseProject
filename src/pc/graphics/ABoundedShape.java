package pc.graphics;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.models.PropertyListenerRegisterer;

@PropertyNames({
	"x",
	"y",
	"width",
	"height",
	"ZIndex"
	})
@EditablePropertyNames({
	"width",
	"height",
	"x",
	"y",
	"ZIndex"
})
public class ABoundedShape extends ALocatable implements BoundedShape, PropertyListenerRegisterer {

	int width, height;
	
	public ABoundedShape() {
		
	}
		
	@Override
	public int getHeight() {
		return height;
	}

	@Override
	public int getWidth() {
		return width;
	}

	@Override
	public void setHeight(int NewHeight) {
		int oldHeight = height;
		height = NewHeight;
		
		propertySupport.notifyAllListeners(new PropertyChangeEvent(this, "height", oldHeight, height));
		System.out.println("set height " + this + " " + Thread.currentThread());
		System.out.println("Height:" + getHeight());
	}

	@Override
	public void setWidth(int NewWidth) {
		int oldWidth = width;
		width = NewWidth;
		
		propertySupport.notifyAllListeners(new PropertyChangeEvent(this, "width", oldWidth, width));
	}
	
}
