package counterIncrementer;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class StringCountPrinter implements PropertyChangeListener {

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		System.out.println(evt.getNewValue());
	}

}
