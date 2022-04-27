package pc.graphics;

import java.beans.PropertyChangeListener;

import bus.uigen.OEFrame;
import bus.uigen.ObjectEditor;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;

@StructurePattern(StructurePatternNames.BEAN_PATTERN)
public class AChef implements Chef {
	Table stove;
	Avatar chef;
	
	public AChef() {
		stove = new ATable();
		chef = new AnAvatar();
		
		stove.move(-80, 0);
	}

	@Override
	public Avatar getChef() {
		return chef;
	}
	
	@Override
	public Table getStove() {
		return stove;
	}

	@Override
	public void setChef(int X, int Y) {
		chef.move(X, Y);
	}

	@Override
	public void move(int X, int Y) {
		chef.move(X, Y);
		stove.move(X, Y);
	}
	
	@Override
	public void addPropertyChangeListener(Chef chefParameter, PropertyChangeListener aListener) {
		chefParameter.getChef().addPropertyChangeListener(getChef(), aListener);
		chefParameter.getStove().addPropertyChangeListener(aListener);
	}

	
	
}
