package pc.graphicsWithOE;
import java.beans.PropertyChangeListener;

import bus.uigen.OEFrame;
import bus.uigen.ObjectEditor;
import bus.uigen.shapes.AnImageModel;
import bus.uigen.shapes.OEShapeModel;
import pc.graphics.ALine;
import pc.graphics.AStringShape;
import pc.graphics.Line;
import pc.graphics.StringShape;
import pc.graphicsWithOE.Angle;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;
import util.misc.ThreadSupport;
import java.awt.Color;

@StructurePattern(StructurePatternNames.BEAN_PATTERN)
@PropertyNames({
	"Arms",
	"Legs",
	"Neck",
	"Torso",
	"head",
	"text",
	"plate"
})
@EditablePropertyNames({
	"Arms",
	"Legs",
	"Neck",
	"Torso",
	"head",
	"text"
})
public class AnAvatar implements pc.graphicsWithOE.Avatar {
	Angle Legs;
	Angle Arms;
	Line Torso;
	Line Neck;
	StringShape text;
	OEShapeModel head = new AnImageModel("images/1.png");
	//Head head;
	String headImage = "";
	String plateImage = "images/12.png";
	//Plate plate;
	OEShapeModel plate = new AnImageModel("images/13.png");
	
	int INIT_X = 50;
	int INIT_Y = 50;
	int INIT_Radius = 20;
	int INIT_Neck = 10;
	int INIT_Head = 99;

	
	public AnAvatar() {
		Legs = new AnAngle();
		Legs.moveX(INIT_X);
		Legs.moveY(INIT_Y+40);
		Legs.getLeftLine().setZIndex(400);
		Legs.getRightLine().setZIndex(400);
		Arms = new AnAngle();
		Arms.moveX(INIT_X);
		Arms.moveY(INIT_Y);
		Torso = new ALine();
		Torso.setX(INIT_X);
		Torso.setY(INIT_X);
		Neck = new ALine();
		Neck.setHeight(10);
		Neck.setWidth(0);
		Neck.setRadius(INIT_Radius);
		Neck.setX(INIT_X);
		Neck.setY(INIT_Y-INIT_Neck);
		//head = new AHead();
		text = new AStringShape();
		text.setText("");
		//head.setImageFileName(headImage);
		head.setX(13);
		head.setY(INIT_Y-INIT_Head);
		head.setHeight(90);
		head.setWidth(80);
		//plate = new APlate();
		//plate.setImageFileName(plateImage);
		plate.setHeight(40);
		plate.setWidth(40);
		plate.setX(INIT_X-20);
		plate.setY(INIT_Y+30);
		plate.setZIndex(1);
	}
	
	@Override
	public OEShapeModel getPlate() {
		return plate;
	}

	@Override
	public void setPlate(OEShapeModel newPlate) {
		plate = newPlate;
	}

	@Override
	public Angle getArms() {
		return Arms;
	}
	
	@Override
	public void setArms(Angle NewArms) {
		Arms = NewArms;
	}


	@Override
	public Angle getLegs() {
		return Legs;
	}
	
	@Override
	public void setLegs(Angle NewLegs) {
		Legs = NewLegs;
	}


	@Override
	public Line getTorso() {
		return Torso;
	}
	
	@Override
	public void setTorso(Line NewTorso) {
		Torso = NewTorso;
	}


	@Override
	public Line getNeck() {
		return Neck;
	}
	
	@Override
	public void setNeck(Line newNeck) {
		Neck = newNeck;
	}
	
	@Override
	public StringShape getText() {
		return text;
	}
	
	@Override
	public void setText(StringShape NewText) {
		text = NewText;
	}
	

	@Override
	public OEShapeModel getHead() {
		return head;
	}

	@Override
	public void setHead(OEShapeModel NewHead) {
		head = NewHead;
	}
	
	@Override
	public void dropPlate(String imageName) {
		//plate.setImageFileName(imageName);
		plate.setHeight(40);
		plate.setWidth(40);
		plate.setZIndex(1);
	}
	
	@Override
	public void goBack(int X, int Y) {
		Legs.move(X, Y);
		Arms.move(X, Y);
		Torso.move(X, Y);
		Neck.move(X, Y);
		//head.move(X, Y);
	}
	
	@Override
	public void move(int X, int Y) {
		Legs.move(X, Y);
		Arms.move(X, Y);
		Torso.move(X, Y);
		Neck.move(X, Y);
		//head.move(X, Y);
		//plate.move(X, Y);
	}
	
	@Override
	public void moveTo(int newX, int newY) {
		Legs.moveTo(newX, newY);
		Arms.moveTo(newX, newY);
		Torso.moveTo(newX, newY);
		Neck.moveTo(newX, newY);
		//head.moveTo(newX, newY);	
		//plate.moveTo(newX, newY);
	}
	
	@Override
	public void scale(double ratio) {
		Legs.getRightLine().setRadius(Legs.getRightLine().getRadius()*ratio);
		Legs.getLeftLine().setRadius(Legs.getLeftLine().getRadius()*ratio);
		Arms.getRightLine().setRadius(Arms.getRightLine().getRadius()*ratio);
		Arms.getLeftLine().setRadius(Arms.getLeftLine().getRadius()*ratio);
		Neck.setRadius(Neck.getRadius()*ratio);
		Torso.setRadius(Torso.getRadius()*ratio);
	}
	
	
	@Override
	public void addPropertyChangeListener(Avatar avatarParameter, PropertyChangeListener aListener) {
//		avatarParameter.getArms().addPropertyChangeListener(getArms(), aListener);
//		avatarParameter.getLegs().addPropertyChangeListener(getLegs(), aListener);
//		avatarParameter.getHead().addPropertyChangeListener(aListener);
//		avatarParameter.getNeck().addPropertyChangeListener(aListener);
//		avatarParameter.getTorso().addPropertyChangeListener(aListener);
//		avatarParameter.getText().addPropertyChangeListener(aListener);
	}
	
	public static void main(String[] args) {
		Avatar scene = new AnAvatar();
		//scene.getHead().setImageFileName("images/0.png");
		OEFrame editor = ObjectEditor.edit(scene);
		editor.showDrawPanel();
		editor.getDrawVirtualComponent().setBackground(Color.WHITE);
	}

}





	
