package coordination.joiner;

import java.beans.PropertyChangeListener;

public interface Joiner {
	 void threadFinished(); 
	 void join();
	 void reset(int aNumThreads);
	 boolean isAllThreadsFinished();
	 void addPropertyChangeListener(PropertyChangeListener aListener);


}
