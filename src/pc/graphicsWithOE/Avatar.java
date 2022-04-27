package pc.graphicsWithOE;

import java.beans.PropertyChangeListener;

import bus.uigen.shapes.OEShapeModel;
import pc.graphics.Line;
import pc.graphics.StringShape;

public interface Avatar {

	public Angle getArms();
	public Angle getLegs();
	public Line getTorso();
	public Line getNeck();
	public StringShape getText();
	public void setText(StringShape NewText);
	public OEShapeModel getHead();
	public void setHead(OEShapeModel NewHead);
	public void move(int X, int Y);
	void setArms(Angle NewArms);
	void setLegs(Angle NewLegs);
	void setNeck(Line newNeck);
	void setTorso(Line NewTorso);
	void scale(double ratio);
	void addPropertyChangeListener(Avatar avatarParameter, PropertyChangeListener aListener);
	void moveTo(int newX, int newY);
	OEShapeModel getPlate();
	void dropPlate(String imageName);
	void goBack(int X, int Y);
	void setPlate(OEShapeModel newPlate);

	
}
