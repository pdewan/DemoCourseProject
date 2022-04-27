package pc.graphics;

import bus.uigen.shapes.AnImageModel;
import bus.uigen.shapes.OEShapeModel;

public class AnOEShapeModel {
	
	OEShapeModel head = new AnImageModel("images/0.png");
	
	public AnOEShapeModel() {
		
	}
	
	public void move(int newX, int newY) {
		head.setX(head.getX()+newX);
		head.setY(head.getY()+newY);
	}
	
	public void moveTo(int newX, int newY) {
		head.setX(newX);
		head.setY(newY);
	}

}
