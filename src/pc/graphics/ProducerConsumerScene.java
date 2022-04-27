package pc.graphics;

import java.beans.PropertyChangeListener;
import java.util.List;

import util.models.PropertyListenerRegisterer;

public interface ProducerConsumerScene {
	List<APatron> getPatronList();
	List<AChef> getChefList();
	BoundedBufferView getBuffer();
	void addPropertyChangeListener(PropertyChangeListener arg0);
	//void approachBuffer(int bufferNumber);
	//void approachBuffer(Avatar avatar, int bufferNumber);
//	void chefApproachBuffer(Chef chef, int bufferNumber);
	//void moveToBuffer(Avatar avatar, int bufferNumber);
	//void chefApproachBuffer(int chef, int bufferNumber);
	//public void processHeads(Head aHead);
	void chefToTable(Head aHead);
	void reset();
	void cook(Head aHead);
	void animatePlate(int avatar);
}
