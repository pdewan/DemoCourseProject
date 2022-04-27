package pc.graphics;

import java.beans.PropertyChangeEvent;
import java.util.Scanner;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import bus.uigen.OEFrame;
import bus.uigen.ObjectEditor;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Visible;
import util.models.PropertyListenerRegisterer;

@StructurePattern(StructurePatternNames.IMAGE_PATTERN)
@PropertyNames({
	"x",
	"y",
	"height",
	"width",
	"imageFileName"
})
@EditablePropertyNames({
	"x",
	"y",
	"height",
	"width",
	"imageFileName"

})
public class AHead extends ABoundedShape implements Head, PropertyListenerRegisterer {
	int x;
	int y;
	int height, width;
	String imageFileName;
	private ImageIcon icon;
	
	public AHead() {
		icon = new ImageIcon(imageFileName);
//		setHeight(icon.getIconHeight());
//		setWidth(icon.getIconWidth());
	}
	
//	@Override
//	public void setX(int NewX) {
//		x = NewX;
//	}
//
//	@Override
//	public void setY(int NewY) {
//		y = NewY;
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

	public String getImageFileName() {
		return imageFileName;
	}

	@Override
	public void setImageFileName(String NewImage) {
		String oldImageFileName = imageFileName;
		imageFileName = NewImage;
		this.icon = new ImageIcon(imageFileName);
		
		propertySupport.notifyAllListeners(new PropertyChangeEvent (this, "ImageFileName", oldImageFileName, getImageFileName()));
	}

//	@Override
//	public int getHeight() {
//		return height;
//	}
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
//	@Override
//	public void setWidth(int NewWidth) {
//		width = NewWidth;
//	}

	@Override
	public void move(int X, int Y) {
		setX(getX()+X);
		setY(getY()+Y);
	}
	
	@Override
	public void moveTo(int newX, int newY) {
		setX(newX);
		setY(newY);
	}
	


}
