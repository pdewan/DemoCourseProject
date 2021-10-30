package diningPhilosopher.factories;

import bus.uigen.OEFrame;
import bus.uigen.ObjectEditor;
import graphics.DiningScene;
import graphics.DiningSceneInterface;

public class SceneFactory {

	static DiningSceneInterface scene;
	static OEFrame editor;

	public static DiningSceneInterface getSingleton() {
		if (scene == null) {
			scene = new DiningScene();
			ObjectEditor.edit(scene);
			// editor = bus.uigen.ObjectEditor.edit(scene);

		}
		return scene;
	}


}
