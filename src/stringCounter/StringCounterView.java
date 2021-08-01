package stringCounter;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

public class StringCounterView implements PropertyChangeListener{

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		System.out.println(evt.getNewValue());
	}
	
}
