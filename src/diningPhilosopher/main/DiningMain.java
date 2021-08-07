package diningPhilosopher.main;

import diningPhilosopher.controller.DiningControllerFactory;
import stringCounter.StringCounterControllerFactory;

public class DiningMain {


	public static void main(String[] args) {
		DiningControllerFactory.getSingleton().processInput();
	}
	

}
