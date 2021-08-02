package diningPhilosopher.coordinated;

import diningPhilosopher.chopstick.BasicChopstick;

public class CoordinatedChopstick extends BasicChopstick{

	public CoordinatedChopstick(int anId) {
		super(anId);
	}
	public synchronized void take() {
		while (isUsed()) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		super.take();		
	}

	@Override
	public synchronized void put() {
		super.put();
		notify();
	}

}
