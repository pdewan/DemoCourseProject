package diningPhilosopher.view;

import java.beans.PropertyChangeListener;

public class DiningPhilosopherViewFactory {
	static PropertyChangeListener singleton;
	public static PropertyChangeListener  getSingleton() {
		if (singleton == null) {
			singleton = new BasicDiningPhilosopherView();
		}
		return singleton;
	}

}
