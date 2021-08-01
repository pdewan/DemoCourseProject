package coordination.joiner;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class BasicJoiner implements Joiner{
	PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);
	int numThreads;
	int numThreadsFinished=0;
	
//	public BasicJoiner(int aNumThreads) {
//		this.numThreads= aNumThreads;
//	}	
	@Override
	public synchronized void threadFinished() {
		numThreadsFinished++;
		if(isAllThreadsFinished()) {
			notify();
			propertyChangeSupport.firePropertyChange("AllThreadsFinished", false, true);
		}
	}
	@Override
	public synchronized void join() {
		while (!isAllThreadsFinished()) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public boolean isAllThreadsFinished() {
		return numThreads == numThreadsFinished;
	}
	@Override
	public void addPropertyChangeListener(PropertyChangeListener aListener) {
		propertyChangeSupport.addPropertyChangeListener(aListener);
	}
	@Override
	public void reset(int aNumThreads) {
		numThreads = aNumThreads;
		numThreadsFinished = 0;
	}	

}
