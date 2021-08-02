package diningPhilosopher.controller;

import java.beans.PropertyChangeListener;

import counterIncrementer.coordinated.CoordinatedStringCounterController;
import diningPhilosopher.coordinated.CoordinatedDiningPhilosopherController;

public class DiningPhilosopherControllerFactory {
	static ConsoleController singleton;
	public static ConsoleController  getSingleton() {
		if (singleton == null) {
			singleton = 
//				new BasicDiningPhilosopherController();
				new CoordinatedDiningPhilosopherController();

//			singleton = new BasicStringCounterController();
//			singleton = new CoordinatedStringCounterController();

		}
		return singleton;
	}

}
