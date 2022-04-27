package diningPhilosopher.factories;

import java.awt.Color;

import bus.uigen.OEFrame;
import graphics.DiningScene;
import graphics.DiningSceneInterface;

public class SceneFactory {

	static DiningSceneInterface scene;
	static OEFrame editor;

	public static DiningSceneInterface getSingleton() {
		if (scene == null) {
			scene = new DiningScene();
			// ObjectEditor.edit(scene);
			editor = bus.uigen.ObjectEditor.edit(scene);
			// can set color here
			editor.getDrawVirtualComponent().setBackground(Color.BLACK);
			editor.hideMainPanel();
			// need to move table+chars then
			editor.setSize(1000, 700);

		}
		return scene;
	}


}
