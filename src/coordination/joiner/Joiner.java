package coordination.joiner;

import java.beans.PropertyChangeListener;

import util.models.PropertyListenerRegisterer;

public interface Joiner extends PropertyListenerRegisterer{
	 void threadFinished(); 
	 void join();
	 void reset(int aNumThreads);
	 boolean isAllThreadsFinished();
//	 void addPropertyChangeListener(PropertyChangeListener aListener);


}
