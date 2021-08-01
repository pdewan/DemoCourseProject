package stringCounter;

import java.beans.PropertyChangeListener;

import counterIncrementer.coordinated.CoordinatedStringCounterController;

public class StringCounterControllerFactory {
	static ConsoleController singleton;
	public static ConsoleController  getSingleton() {
		if (singleton == null) {
//			singleton = new BasicStringCounterController();
			singleton = new CoordinatedStringCounterController();

		}
		return singleton;
	}

}
