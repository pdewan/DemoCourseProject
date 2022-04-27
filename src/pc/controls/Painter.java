package pc.controls;

import java.awt.Graphics;
import java.beans.PropertyChangeListener;

import pc.graphics.Angle;
import pc.graphics.Avatar;
import pc.graphics.Chef;
import pc.graphics.Head;
import pc.graphics.Line;
import pc.graphics.Patron;
import pc.graphics.StringShape;
import pc.graphics.Table;

public interface Painter extends PropertyChangeListener {

	void paint(Graphics g);
	public void draw(Graphics g, Chef aChef);
	public void draw(Graphics g, Patron aPatron);
	public void draw(Graphics g, Avatar avatar);
	public void draw(Graphics g, Angle angle);
	public void draw(Graphics g, Line aLine);
	public void draw(Graphics g, StringShape string);
	public void draw(Graphics g, Head aHead);
	public void draw(Graphics g, Table aTable);
	
	

}
