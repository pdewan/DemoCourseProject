package counterIncrementer.coordinated.old;

public class BasicCoordinator implements Coordinator {
	public synchronized void synchronizedWait() {
		try {
			wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public synchronized void synchronizedNotify() {
		notify();
	}
	public synchronized void synchronizedNotifyAll() {
		notifyAll();
	}

}
