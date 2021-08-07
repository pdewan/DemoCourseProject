package diningPhilosopher.view;

import java.beans.PropertyChangeListener;

public class DiningViewFactory {
	static PropertyChangeListener singleton;
	public static PropertyChangeListener  getSingleton() {
		if (singleton == null) {
			singleton = new BasicDiningView();
		}
		return singleton;
	}

}
