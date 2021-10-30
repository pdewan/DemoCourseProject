package diningPhilosopher.factories;

import bus.uigen.ObjectEditor;
import graphics.DiningSceneInteraction;
import graphics.DiningSceneInteractionInterface;

public class InteractionFactory {

	static DiningSceneInteractionInterface interact;

	public static DiningSceneInteractionInterface getSingleton() {
		if (interact == null) {
			interact = new DiningSceneInteraction();
			ObjectEditor.edit(interact);
		}
		return interact;
	}

}
