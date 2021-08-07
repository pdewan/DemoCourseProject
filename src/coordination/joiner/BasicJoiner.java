package coordination.joiner;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import gradingTools.comp999.assignment2.DiningTestUtil;
import util.models.BasicPropertyNotificationSupport;
import util.models.PropertyNotificationSupport;

public class BasicJoiner implements Joiner{
	PropertyNotificationSupport propertyNotificationSupport = new BasicPropertyNotificationSupport();

//	PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);
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
			propertyNotificationSupport.firePropertyChange(
					new PropertyChangeEvent(this, 
							DiningTestUtil.ALL_THREADS_FINISHED, 
							false, 
							true));
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
		propertyNotificationSupport.addPropertyChangeListener(aListener);
	}
	@Override
	public void reset(int aNumThreads) {
		numThreads = aNumThreads;
		numThreadsFinished = 0;
	}	

	public String toString() {
		return "Joiner";
	}
}
