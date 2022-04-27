package pc.controls;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

import pc.factories.AFactory;
import pc.graphics.ProducerConsumerScene;

public class AController implements Controller {

	ProducerConsumerScene scene;
	JButton chefToBuffer;
	
	public AController(ConsoleSceneView view) {
		scene = AFactory.arrayBasedSceneFactoryMethod();
		//((Component) view).addMouseListener((MouseListener) this);
		
		chefToBuffer = new JButton("Chef To Buffer");
		
		chefToBuffer.setEnabled(true);	
	}
	
	@Override
	public JButton getChefToBuffer() {
		return chefToBuffer;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int buttonPressed = e.getButton();
		switch(buttonPressed) {
		case '0':
			scene.chefToTable(scene.getChefList().get(2).getChef().getHead());
		}
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
		
	}
	
	
}
