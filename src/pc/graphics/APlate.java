package pc.graphics;

import java.beans.PropertyChangeEvent;

import javax.swing.ImageIcon;

import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.models.PropertyListenerRegisterer;

@StructurePattern(StructurePatternNames.IMAGE_PATTERN)
@PropertyNames({
	"x",
	"y",
	"height",
	"width",
	"imageFileName",
	"ZIndex"
})
@EditablePropertyNames({
	"x",
	"y",
	"height",
	"width",
	"imageFileName",
	"ZIndex"
})
public class APlate extends ABoundedShape implements Plate, PropertyListenerRegisterer {
	
	int x;
	int y;
	int height, width;
	String imageFileName;
	private ImageIcon icon;
	
	public APlate() {
		icon = new ImageIcon(imageFileName);
	}

	@Override
	public String getImageFileName() {
		return imageFileName;
	}

	@Override
	public void setImageFileName(String newName) {
		String oldImageFileName = imageFileName;
		imageFileName = newName;
		this.icon = new ImageIcon(imageFileName);
		
		propertySupport.notifyAllListeners(new PropertyChangeEvent (this, "ImageFileName", oldImageFileName, getImageFileName()));
	}

	@Override
	public void move(int newX, int newY) {
		setX(getX() + newX);
		setY(getY() + newY);
	}

	@Override
	public void moveTo(int newX, int newY) {
		setX(newX);
		setY(newY);
	}
	
}
