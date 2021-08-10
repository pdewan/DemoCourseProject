package diningPhilosopher.factories;

import java.beans.PropertyChangeListener;

import counterIncrementer.coordinated.CoordinatedStringCounterController;
import diningPhilosopher.controller.BasicDiningController;
import diningPhilosopher.controller.ConsoleController;
import diningPhilosopher.coordinated.ButlerCoordinatedDiningController;

public class DiningControllerFactory {
	static ConsoleController singleton;
	public static ConsoleController  getSingleton() {
		if (singleton == null) {
			singleton = 
				new BasicDiningController();
//				new ButlerCoordinatedDiningController();

//			singleton = new BasicStringCounterController();
//			singleton = new CoordinatedStringCounterController();

		}
		return singleton;
	}

}
