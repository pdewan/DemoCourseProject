package counterIncrementer.barrier;


public class BasicBarrier implements Barrier{

	int numThreads;
	int numBlocked=0;
	
	public BasicBarrier(int numThreads) {
		this.numThreads=numThreads;
	}
	
	@Override
	public synchronized void barrier() {
		numBlocked++;
		if(numBlocked==numThreads) {
			numBlocked=0;
			notifyAll();
		} else {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	

}
