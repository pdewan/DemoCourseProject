package pc.graphics;

import java.beans.PropertyChangeListener;

import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;

@StructurePattern(StructurePatternNames.BEAN_PATTERN)
public class APatron implements Patron {
	Avatar patron;
	Table table;
	
	public APatron() {
		patron = new AnAvatar();
		table = new ATable();
	}

	@Override
	public Avatar getPatron() {
		return patron;
	}

	@Override
	public Table getTable() {
		return table;
	}

	@Override
	public void setPatron(int X, int Y) {
		patron.move(X, Y);
	}

	@Override
	public void setTable(int X, int Y) {
		table.move(X, Y);
	}
	
	@Override
	public void move(int X, int Y) {
		patron.move(X, Y);
		table.move(X, Y);
	}
	
	@Override
	public void addPropertyChangeListener(Patron patronParameter, PropertyChangeListener aListener) {
		patronParameter.getPatron().addPropertyChangeListener(getPatron(), aListener);
		patronParameter.getTable().addPropertyChangeListener(aListener);
	}

	
	

}
