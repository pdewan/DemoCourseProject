package stringCounter;

import java.beans.PropertyChangeListener;

public class StringCounterViewFactory {
	static PropertyChangeListener singleton;
	public static PropertyChangeListener  getSingleton() {
		if (singleton == null) {
			singleton = new StringCounterView();
		}
		return singleton;
	}

}
