package pc.graphics;

import java.beans.PropertyChangeListener;

public interface Avatar {

	public Angle getArms();
	public Angle getLegs();
	public Line getTorso();
	public Line getNeck();
	public StringShape getText();
	public void setText(StringShape NewText);
	public Head getHead();
	public void setHead(Head NewHead);
	public void move(int X, int Y);
	void setArms(Angle NewArms);
	void setLegs(Angle NewLegs);
	void setNeck(Line newNeck);
	void setTorso(Line NewTorso);
	void scale(double ratio);
	void addPropertyChangeListener(Avatar avatarParameter, PropertyChangeListener aListener);
	void moveTo(int newX, int newY);
	Plate getPlate();
	void dropPlate(String imageName);
	void goBack(int X, int Y);
	void setPlate(Plate newPlate);

	
}
