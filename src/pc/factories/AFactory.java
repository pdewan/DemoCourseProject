package pc.factories;

import pc.controls.AConsoleSceneView;
import pc.controls.APainter;
import pc.controls.ConsoleSceneView;
import pc.controls.Painter;
import pc.graphics.AProducerConsumerScene;
import pc.graphics.ProducerConsumerScene;

public class AFactory {
	static ProducerConsumerScene scene;
	static ConsoleSceneView console;
	static Painter painter;
	
	public static ProducerConsumerScene arrayBasedSceneFactoryMethod() {
		if (scene == null) {
			scene = new AProducerConsumerScene();
		}
		return scene;
	}
	
	public static ConsoleSceneView ConsoleSceneViewFactoryMethod(int chefs, int patrons) {
		if (console == null) {
			console = new AConsoleSceneView(chefs, patrons);
		}
		return console;
	}
	
	public static Painter PainterFactoryMethod(int chefs, int patrons) {
		if (painter == null) {
			painter = new APainter(chefs, patrons);
		}
		return painter;
	}
}
