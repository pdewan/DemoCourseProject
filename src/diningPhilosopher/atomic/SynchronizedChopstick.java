package diningPhilosopher.atomic;

import diningPhilosopher.concurrent.ExclusiveChopstick;

public class SynchronizedChopstick extends ExclusiveChopstick{

	public SynchronizedChopstick(int anId) {
		super(anId);
	}
//	protected boolean preconditionTake() {
//		return true;
//	}
	public synchronized boolean take() {
		return super.take();		
	}

	@Override
	public synchronized void put() {
		 super.put();
	}

}
