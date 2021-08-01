package diningPhilosopher.controller;

import java.beans.PropertyChangeListener;

import counterIncrementer.coordinated.CoordinatedStringCounterController;

public class DiningPhilosopherControllerFactory {
	static ConsoleController singleton;
	public static ConsoleController  getSingleton() {
		if (singleton == null) {
			singleton = new BasicDiningPhilosopherController();
//			singleton = new BasicStringCounterController();
//			singleton = new CoordinatedStringCounterController();

		}
		return singleton;
	}

}
