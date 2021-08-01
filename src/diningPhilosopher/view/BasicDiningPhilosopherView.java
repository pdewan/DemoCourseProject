package diningPhilosopher.view;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

public class BasicDiningPhilosopherView implements PropertyChangeListener{

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		System.out.println(
				evt.getSource() + "." +
				evt.getPropertyName() + ":" + 
				evt.getOldValue() + "->" +
				evt.getNewValue() );
	}
	
}
