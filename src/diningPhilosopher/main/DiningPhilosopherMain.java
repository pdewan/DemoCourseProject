package diningPhilosopher.main;

import diningPhilosopher.controller.DiningPhilosopherControllerFactory;
import stringCounter.StringCounterControllerFactory;

public class DiningPhilosopherMain {


	public static void main(String[] args) {
		DiningPhilosopherControllerFactory.getSingleton().processInput();
	}
	

}
