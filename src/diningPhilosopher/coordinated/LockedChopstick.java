package diningPhilosopher.coordinated;

import diningPhilosopher.concurrent.ExclusiveChopstick;

public class LockedChopstick extends ExclusiveChopstick{

	public LockedChopstick(int anId) {
		super(anId);
	}
	public synchronized boolean take() {
		while (isUsed()) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		return super.take();		
	}

	@Override
	public synchronized void put() {
		super.put();
		notify();
	}

}
