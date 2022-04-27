package pc.controls;

import java.beans.PropertyChangeEvent;

import pc.factories.AFactory;
import pc.graphics.ProducerConsumerScene;

public class AConsoleSceneView implements ConsoleSceneView {

	public AConsoleSceneView(int chefs, int patrons) {
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
	public void propertyChange(PropertyChangeEvent evt) {
		System.out.println(evt);
	}
}
