package diningPhilosopher.factories;

import java.beans.PropertyChangeListener;

import diningPhilosopher.view.BasicDiningView;

public class DiningViewFactory {
	static PropertyChangeListener singleton;
	public static PropertyChangeListener  getSingleton() {
		if (singleton == null) {
			singleton = new BasicDiningView();
		}
		return singleton;
	}

}
