package pc.controls;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.ImageObserver;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JComponent;
import javax.swing.JPanel;

import pc.factories.AFactory;
import pc.graphics.Angle;
import pc.graphics.Avatar;
import pc.graphics.Chef;
import pc.graphics.Head;
import pc.graphics.Line;
import pc.graphics.Patron;
import pc.graphics.ProducerConsumerScene;
import pc.graphics.StringShape;
import pc.graphics.Table;
import util.annotations.Visible;

public class APainter extends JComponent implements Painter {
	int numberOfChefs;
	int numberOfPatrons;
	
	public APainter(int chefs, int patrons) {
		
		numberOfChefs = chefs;
		numberOfPatrons = patrons;
		ProducerConsumerScene scene = AFactory.arrayBasedSceneFactoryMethod();
		
		for (int i=0; i<chefs; i++) {
			scene.getChefList().get(i).getChef().getHead().addPropertyChangeListener(this);
			scene.getChefList().get(i).getChef().getTorso().addPropertyChangeListener(this);
			scene.getChefList().get(i).getChef().getNeck().addPropertyChangeListener(this);
			scene.getChefList().get(i).getChef().getText().addPropertyChangeListener(this);
			scene.getChefList().get(i).getChef().getArms().getLeftLine().addPropertyChangeListener(this);
			scene.getChefList().get(i).getChef().getArms().getRightLine().addPropertyChangeListener(this);
			scene.getChefList().get(i).getChef().getLegs().getRightLine().addPropertyChangeListener(this);
			scene.getChefList().get(i).getChef().getLegs().getLeftLine().addPropertyChangeListener(this);
		}
		
		for (int i=0; i<patrons; i++) {
			scene.getPatronList().get(i).getPatron().getHead().addPropertyChangeListener(this);
			scene.getPatronList().get(i).getPatron().getTorso().addPropertyChangeListener(this);
			scene.getPatronList().get(i).getPatron().getNeck().addPropertyChangeListener(this);
			scene.getPatronList().get(i).getPatron().getText().addPropertyChangeListener(this);
			scene.getPatronList().get(i).getPatron().getArms().getLeftLine().addPropertyChangeListener(this);
			scene.getPatronList().get(i).getPatron().getArms().getRightLine().addPropertyChangeListener(this);
			scene.getPatronList().get(i).getPatron().getLegs().getRightLine().addPropertyChangeListener(this);
			scene.getPatronList().get(i).getPatron().getLegs().getLeftLine().addPropertyChangeListener(this);
		}
		
		scene.addPropertyChangeListener(this);
		
		//scene.getBuffer().addPropertyChangeListener(this);
	}
	
	@Override
	public void paint(Graphics g) {
		ProducerConsumerScene scene = pc.factories.AFactory.arrayBasedSceneFactoryMethod();
		Graphics2D g2 = (Graphics2D) g;
		
		for (int i=0; i<numberOfChefs; i++) {
			draw(g2, scene.getChefList().get(i));
		}
		for (int i=0; i<numberOfPatrons; i++) {
			draw(g2, scene.getPatronList().get(i));
		}
	}
	
	@Override
	public void draw(Graphics g, Chef aChef) {
		draw(g, aChef.getChef());
		draw(g, aChef.getStove());
	}
	
	@Override
	public void draw(Graphics g, Patron aPatron) {
		draw(g, aPatron.getPatron());
		draw(g, aPatron.getTable());
	}
	
	@Override
	public void draw(Graphics g, Avatar avatar) {
		draw(g, avatar.getArms());
		draw(g, avatar.getLegs());
		draw(g, avatar.getHead());
		draw(g, avatar.getNeck());
		draw(g, avatar.getTorso());
		draw(g, avatar.getText());
	}
	
	@Override
	public void draw(Graphics g, Angle angle) {
		draw(g, angle.getLeftLine());
		draw(g, angle.getRightLine());
	}
	
	@Override
	public void draw(Graphics g, Line aLine) {
		g.drawLine(aLine.getX(), aLine.getY(), aLine.getX() + aLine.getWidth(), aLine.getY() + aLine.getHeight());
	}
	
	@Override
	public void draw(Graphics g, StringShape string) {
		g = (Graphics2D) g;
		String s = string.getText();
		g.drawString(s, string.getX(), string.getY());
	}
	
	@Override
	public void draw(Graphics g, Head aHead) {
		Image img = Toolkit.getDefaultToolkit().getImage(aHead.getImageFileName());
		//g.drawImage(img, aHead.getX(), aHead.getY(), (ImageObserver) ((Component)this));
	}
	
	@Override
	public void draw(Graphics g, Table aTable) {
		draw(g, aTable.getBottom());
		draw(g, aTable.getLeft());
		draw(g, aTable.getLeftDiagonal());
		draw(g, aTable.getRight());
		draw(g, aTable.getRightDiagonal());
		draw(g, aTable.getTableLeg());
		draw(g, aTable.getTop());
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		repaint();
	}

}
