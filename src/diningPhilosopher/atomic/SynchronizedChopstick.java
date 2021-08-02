package diningPhilosopher.atomic;

import diningPhilosopher.chopstick.BasicChopstick;

public class SynchronizedChopstick extends BasicChopstick{

	public SynchronizedChopstick(int anId) {
		super(anId);
	}
	public synchronized void take() {
		super.take();		
	}

	@Override
	public synchronized void put() {
		super.put();
	}

}
