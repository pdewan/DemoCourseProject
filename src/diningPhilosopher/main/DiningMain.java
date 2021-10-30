package diningPhilosopher.main;

import diningPhilosopher.factories.DiningControllerFactory;
import diningPhilosopher.factories.SceneFactory;

public class DiningMain {


	public static void main(String[] args) {
		SceneFactory.getSingleton();
		DiningControllerFactory.getSingleton().processInput();
	}
	
}
