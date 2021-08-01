package coordination.barrier;


public class BasicBarrier implements Barrier{

	int numThreads;
	int numBlocked=0;
	
	public BasicBarrier() {
	}
	
	public void reset (int aNumThreads) {
		numThreads=aNumThreads;
		numBlocked = 0;
	}
	
	@Override
	public synchronized void barrier() {
		numBlocked++;
		if(numBlocked >= numThreads) {
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
