package graphics;

import java.beans.PropertyChangeEvent;

import diningPhilosopher.main.DiningUtil;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;

@StructurePattern(StructurePatternNames.BEAN_PATTERN)

public class DiningScene implements DiningSceneInterface {


	TableInterface table;
	SpaghettiInterface spaghetti;
	ChopstickInterface chopstick1;
	ChopstickInterface chopstick2;
	ChopstickInterface chopstick3;
	ChopstickInterface chopstick4;
	ChopstickInterface chopstick5;
	PhilosopherAvatarInterface philosopher1;
	PhilosopherAvatarInterface philosopher2;
	PhilosopherAvatarInterface philosopher3;
	PhilosopherAvatarInterface philosopher4;
	PhilosopherAvatarInterface philosopher5;
	protected int numberOfPhilosophers = -1;
	// DiningSceneInterface scene = SceneFactory.getSingleton();

	// create the scene
	public DiningScene() {
		// not sure if right

		philosopher1 = new PhilosopherAvatar(new PhilosopherHead(300, 300, "images/socrates.png"));
		philosopher2 = new PhilosopherAvatar(new PhilosopherHead(450, 470, "images/plato.png"));
		philosopher5 = new PhilosopherAvatar(new PhilosopherHead(400, 100, "images/hippocrates.png"));
		philosopher3 = new PhilosopherAvatar(new PhilosopherHead(670, 380, "images/archimedes.png"));
		philosopher4 = new PhilosopherAvatar(new PhilosopherHead(630, 130, "images/aristotle.png"));
		philosopher1.setRaisedHand(true);
		philosopher1.getArms().raiseArm();
		philosopher2.setRaisedHand(true);
		philosopher2.getArms().raiseArm();
		philosopher3.setRaisedHand(true);
		philosopher3.getArms().raiseArm();
		philosopher4.setRaisedHand(true);
		philosopher4.getArms().raiseArm();
		philosopher5.setRaisedHand(true);
		philosopher5.getArms().raiseArm();

		table = new Table(400, 200, 300, 300);
		spaghetti = new Spaghetti(500, 300, 0, 0, "images/spag.png");
		chopstick1 = new Chopstick(420, 390, "images/chopsticks.png");
		chopstick2 = new Chopstick(550, 450, "images/chopsticks.png");
		chopstick3 = new Chopstick(610, 300, "images/chopsticks.png");
		chopstick4 = new Chopstick(540, 220, "images/chopsticks.png");
		chopstick5 = new Chopstick(420, 300, "images/chopsticks.png");

		// between philosopher 1 and 2
		// chopstick1 = new RotatingLine(420, 390, 40, 20);
		// between philosopher 2 and 3
		// chopstick2 = new RotatingLine(550, 480, 40, 20);
		// between philosopher 3 and 4
		// chopstick3 = new RotatingLine(610, 300, 40, 20);
		// between philosopher 4 and 5
		// chopstick4 = new RotatingLine(540, 220, 40, 20);
		// between philosopher 5 and 1
		// chopstick5 = new RotatingLine(420, 300, 40, 20);

	}

	@Override
	public TableInterface getTable() {
		return table;
	}

	@Override
	public SpaghettiInterface getSpaghetti() {
		return spaghetti;
	}

	@Override
	public ChopstickInterface getChopstick1() {
		return chopstick1;
	}

	@Override
	public ChopstickInterface getChopstick2() {
		return chopstick2;
	}

	@Override
	public ChopstickInterface getChopstick4() {
		return chopstick4;
	}

	@Override
	public ChopstickInterface getChopstick3() {
		return chopstick3;
	}

	@Override
	public ChopstickInterface getChopstick5() {
		return chopstick5;
	}

	@Override
	public PhilosopherAvatarInterface getPhilosopher1() {
		return philosopher1;
	}

	@Override
	public PhilosopherAvatarInterface getPhilosopher2() {
		return philosopher2;
	}

	@Override
	public PhilosopherAvatarInterface getPhilosopher3() {
		return philosopher3;
	}

	@Override
	public PhilosopherAvatarInterface getPhilosopher4() {
		return philosopher4;
	}

	@Override
	public PhilosopherAvatarInterface getPhilosopher5() {
		return philosopher5;
	}

	@Override
	public boolean getWaiting(PhilosopherAvatarInterface philosopher) {
		return philosopher.getWaiting();
	}

	@Override
	public boolean getRaisedHand(PhilosopherAvatarInterface philosopher) {
		return philosopher.getRaisedHand();
	}

	public void initNumberOfPhilosophers(int aNumberOfPhilosophers) {
		DiningUtil.setNumberOfPhilosophers(aNumberOfPhilosophers);
	}

	@Override
	public boolean preInitNumberOfPhilosophers() {
		return numberOfPhilosophers == -1;
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		// doesn't work!
		if (evt.getSource().toString().equals("Philosopher 1") & evt.getPropertyName().toString().equals("Fed")
				& evt.getNewValue().toString().equals("true")) {
			// make philo 1 the observer of the og philosopher 1 object
			philosopher1.getArms().lowerArm();
			philosopher1.setRaisedHand(false);
		} else if (evt.getSource().toString().equals("Philosopher 2")
				& evt.getPropertyName().toString().equals("Fed")) {
			philosopher2.getArms().lowerArm();
			philosopher2.setRaisedHand(false);
		}
	}
}



