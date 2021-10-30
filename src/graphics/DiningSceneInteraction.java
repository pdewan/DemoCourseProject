package graphics;

import java.beans.PropertyChangeEvent;

import diningPhilosopher.factories.SceneFactory;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;

@StructurePattern(StructurePatternNames.BEAN_PATTERN)

public class DiningSceneInteraction implements DiningSceneInteractionInterface {

	DiningSceneInterface scene = SceneFactory.getSingleton();

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		if (evt.getSource() == "Philosopher 1") {
			scene.getPhilosopher1().setRaisedHand(false);
			scene.getPhilosopher1().getArms().lowerArm();
		}

		System.out.println(
				evt.getSource() + "." + evt.getPropertyName() + ":" + evt.getOldValue() + "->" + evt.getNewValue());

	}

}
