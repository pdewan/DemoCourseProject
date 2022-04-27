package graphics;

import java.beans.PropertyChangeEvent;

import diningPhilosopher.main.DiningUtil;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;

@StructurePattern(StructurePatternNames.BEAN_PATTERN)

public class DiningSceneOld implements DiningSceneInterfaceOld {

	TableInterface table;

	SpaghettiInterface spaghetti;
	SpaghettiInterface miniSpag1;
	SpaghettiInterface miniSpag2;
	SpaghettiInterface miniSpag3;
	SpaghettiInterface miniSpag4;
	SpaghettiInterface miniSpag5;

	ChopstickInterface chopstick1;
	ChopstickInterface chopstick2;
	ChopstickInterface chopstick3;
	ChopstickInterface chopstick4;
	ChopstickInterface chopstick5;
	RotatingLineInterface visionLine;
	RotatingLineInterface visionLine2;

	RotatingLineInterface tableLeg1;
	RotatingLineInterface tableLeg4;

	PhilosopherAvatarInterface philosopher1;
	PhilosopherAvatarInterface philosopher2;
	PhilosopherAvatarInterface philosopher3;
	PhilosopherAvatarInterface philosopher4;
	PhilosopherAvatarInterface philosopher5;

	final static int CHOPSTICK1_X = 460 + 20;
	final static int CHOPSTICK1_Y = 400;
	final static int CHOPSTICK2_X = 590 + 60;
	final static int CHOPSTICK2_Y = 425;
	final static int CHOPSTICK3_X = 610 + 120;
	final static int CHOPSTICK3_Y = 300 - 10;
	final static int CHOPSTICK4_X = 540 + 30;
	final static int CHOPSTICK4_Y = 220;
	final static int CHOPSTICK5_X = 425;
	final static int CHOPSTICK5_Y = 290;

	final static int SPAG_X = 550;
	final static int SPAG_Y = 300;
	final static int MINISPAG1_X = 425;
	final static int MINISPAG1_Y = 350;
	final static int MINISPAG2_X = 550;
	final static int MINISPAG2_Y = 440;
	final static int MINISPAG3_X = 720;
	final static int MINISPAG3_Y = 360;
	final static int MINISPAG4_X = 660;
	final static int MINISPAG4_Y = 245;
	final static int MINISPAG5_X = 475;
	final static int MINISPAG5_Y = 240;

	final static int PHILOSOPHER1_X = 345;
	final static int PHILOSOPHER1_Y = 340;
	final static int PHILOSOPHER2_X = 540;
	final static int PHILOSOPHER2_Y = 500;


	final static int PHILOSOPHER3_X = 798;
	final static int PHILOSOPHER3_Y = 380;
	final static int PHILOSOPHER4_X = 720;
	final static int PHILOSOPHER4_Y = 130;
	final static int PHILOSOPHER5_X = 420;
	final static int PHILOSOPHER5_Y = 115;


	protected int numberOfPhilosophers = -1;

	boolean philOneLeft = false;
	boolean philOneRight = false;
	boolean philTwoLeft = false;
	boolean philTwoRight = false;
	boolean philThreeLeft = false;
	boolean philThreeRight = false;
	boolean philFourLeft = false;
	boolean philFourRight = false;
	boolean philFiveLeft = false;
	boolean philFiveRight = false;

	boolean philOneFed = false;
	boolean philTwoFed = false;
	boolean philThreeFed = false;
	boolean philFourFed = false;
	boolean philFiveFed;


	public DiningSceneOld() {
		visionLine = new RotatingLine(10, 10, 0, 10);
		visionLine2 = new RotatingLine(10, 10, 0, 10);

		// chopstick 5, phil 1 left, phil 5 right
		System.out.println("vision line");
		philosopher1 = new PhilosopherAvatar(
				new PhilosopherHead(PHILOSOPHER1_X, PHILOSOPHER1_Y, "images/socrates.png"),
				new RotatingLine(CHOPSTICK1_X, CHOPSTICK1_Y, -80, (0.100) * Math.PI),
				new RotatingLine(PHILOSOPHER1_X + 40, PHILOSOPHER1_Y + 20,
						60,
						-0.223 * Math.PI));
		philosopher2 = new PhilosopherAvatar(
				new PhilosopherHead(PHILOSOPHER2_X, PHILOSOPHER2_Y, "images/backheadphil1.png"),
				new RotatingLine(PHILOSOPHER2_X, PHILOSOPHER2_Y,
						-60,
						(0.243) * Math.PI),
				new RotatingLine(CHOPSTICK2_X, CHOPSTICK2_Y + 50,
						60,
						0.737 * Math.PI));
		// moved 10 <--
		philosopher3 = new PhilosopherAvatar(
				new PhilosopherHead(PHILOSOPHER3_X, PHILOSOPHER3_Y, "images/archimedes.png"),
				new RotatingLine(PHILOSOPHER3_X - 10, PHILOSOPHER3_Y + 10,
						100,
						0.780 * Math.PI),
				new RotatingLine(CHOPSTICK3_X + 50, CHOPSTICK3_Y,
						80, Math.PI * 0.450));
		// moved 10 -->
		philosopher4 = new PhilosopherAvatar(
				new PhilosopherHead(PHILOSOPHER4_X, PHILOSOPHER4_Y, "images/aristotle.png"),
				new RotatingLine(PHILOSOPHER4_X + 60, PHILOSOPHER4_Y + 50,
						110,
						Math.PI * 0.603),
				new RotatingLine(PHILOSOPHER4_X, PHILOSOPHER4_Y + 35,
						140,
						Math.PI * 0.780));
		philosopher5 = new PhilosopherAvatar(
				new PhilosopherHead(PHILOSOPHER5_X, PHILOSOPHER5_Y, "images/hippocrates2.png"),
				new RotatingLine(PHILOSOPHER5_X - 02, PHILOSOPHER5_Y + 50,
						140, Math.PI / 2),
				new RotatingLine(CHOPSTICK4_X, CHOPSTICK4_Y,
						110,
						Math.PI - angleBtwnTwoPoints(PHILOSOPHER5_X, CHOPSTICK4_X, PHILOSOPHER5_Y, CHOPSTICK4_Y)));


		// removed raise hand logic, see disc
		// was 300 and 300 width, height
		table = new Table(400, 200, 400, 300);
		tableLeg1 = new RotatingLine(450, 450, 70, 0);
		// tableLeg2 = new RotatingLine(450, 250, 50, 0);
		// tableLeg3 = new RotatingLine(750, 250, 50, 0);
		tableLeg4 = new RotatingLine(750, 450, 70, 0);
		tableLeg1.rotate(16);
		// tableLeg2.rotate(16);
		// tableLeg3..rotate(16);
		tableLeg4.rotate(16);
		tableLeg1.setStroke(10f);
		tableLeg4.setStroke(10f);
		philosopher2.getArms().getLeftLine().setAngle(110);
		philosopher2.getArms().getRightLine().setAngle(50);
		philosopher1.getArms().getLeftLine().setAngle(100);
		philosopher3.getArms().getRightLine().setAngle(280);

		spaghetti = new Spaghetti(SPAG_X, SPAG_Y, 0, 0, "images/spag.png");
		miniSpag1 = new Spaghetti(MINISPAG1_X, MINISPAG1_Y, 0, 0, "images/minispag.png");
		miniSpag2 = new Spaghetti(MINISPAG2_X, MINISPAG2_Y, 0, 0, "images/minispag.png");
		miniSpag3 = new Spaghetti(MINISPAG3_X, MINISPAG3_Y, 0, 0, "images/minispag.png");
		miniSpag4 = new Spaghetti(MINISPAG4_X, MINISPAG4_Y, 0, 0, "images/minispag.png");
		miniSpag5 = new Spaghetti(MINISPAG5_X, MINISPAG5_Y, 0, 0, "images/minispag.png");
		chopstick1 = new Chopstick(new ChopstickImage(CHOPSTICK1_X, CHOPSTICK1_Y, "images/chopsticks.png"));
		chopstick2 = new Chopstick(new ChopstickImage(CHOPSTICK2_X, CHOPSTICK2_Y, "images/chopsticks.png"));
		chopstick3 = new Chopstick(new ChopstickImage(CHOPSTICK3_X, CHOPSTICK3_Y, "images/chopsticks.png"));
		chopstick4 = new Chopstick(new ChopstickImage(CHOPSTICK4_X, CHOPSTICK4_Y, "images/chopsticks.png"));
		chopstick5 = new Chopstick(new ChopstickImage(CHOPSTICK5_X, CHOPSTICK5_Y, "images/chopsticks.png"));
		((BoundedShape) chopstick1).setZIndex(1);
		((BoundedShape) chopstick2).setZIndex(2);
		((BoundedShape) chopstick3).setZIndex(3);
		((BoundedShape) chopstick4).setZIndex(4);
		((BoundedShape) chopstick5).setZIndex(5);
		((BoundedShape) spaghetti).setZIndex(6);
		((BoundedShape) miniSpag1).setZIndex(7);
		((BoundedShape) miniSpag2).setZIndex(8);
		((BoundedShape) miniSpag3).setZIndex(9);
		((BoundedShape) miniSpag4).setZIndex(10);
		((BoundedShape) miniSpag5).setZIndex(11);
		((BoundedShape) table).setZIndex(12);

		philosopher1.getVisionLine1().setRadius(0);
		philosopher1.getVisionLine2().setRadius(0);
		philosopher2.getVisionLine1().setRadius(0);
		philosopher2.getVisionLine2().setRadius(0);
		philosopher3.getVisionLine1().setRadius(0);
		philosopher3.getVisionLine2().setRadius(0);
		philosopher4.getVisionLine1().setRadius(0);
		philosopher4.getVisionLine2().setRadius(0);
		philosopher5.getVisionLine1().setRadius(0);
		philosopher5.getVisionLine2().setRadius(0);

		// chopstick1.getStringShape().setText("Not in use");
		// chopstick2.getStringShape().setText("Not in use");
		// chopstick3.getStringShape().setText("Not in use");
		// chopstick4.getStringShape().setText("Not in use");
		// chopstick5.getStringShape().setText("Not in use");
		// how can we have lasers shooting from phil's eyes?
		// RotatingLineInterface liney = new RotatingLine(50, 50, 5, 5);

		// philosopher1.move(100, 100);
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
	// @Position(20)
	public SpaghettiInterface getSpaghetti() {
		return spaghetti;
	}

	@Override
	// @Position(1)
	public SpaghettiInterface getMiniSpag1() {
		return miniSpag1;
	}

	@Override
	// @Position(2)
	public SpaghettiInterface getMiniSpag2() {
		return miniSpag2;
	}

	@Override
	// @Position(3)
	// finish numbering all the positions
	public SpaghettiInterface getMiniSpag3() {
		return miniSpag3;
	}

	@Override
	// @Position(4)
	public SpaghettiInterface getMiniSpag4() {
		return miniSpag4;
	}

	@Override
	// @Position(5)
	public SpaghettiInterface getMiniSpag5() {
		return miniSpag5;
	}

	@Override
	// @Position(6)
	public ChopstickInterface getChopstick1() {
		return chopstick1;
	}

	@Override
	// @Position(7)
	public ChopstickInterface getChopstick2() {
		return chopstick2;
	}

	@Override
	// @Position(8)
	public ChopstickInterface getChopstick4() {
		return chopstick4;
	}

	@Override
	// @Position(9)
	public ChopstickInterface getChopstick3() {
		return chopstick3;
	}

	@Override
	// @Position(10)
	public ChopstickInterface getChopstick5() {
		return chopstick5;
	}

	@Override
	// @Position(11)
	public PhilosopherAvatarInterface getPhilosopher1() {
		return philosopher1;
	}

	@Override
	// @Position(12)
	public PhilosopherAvatarInterface getPhilosopher2() {
		return philosopher2;
	}

	@Override
	// @Position(13)
	public PhilosopherAvatarInterface getPhilosopher3() {
		return philosopher3;
	}

	@Override
	// @Position(14)
	public PhilosopherAvatarInterface getPhilosopher4() {
		return philosopher4;
	}

	@Override
	// @Position(15)
	public PhilosopherAvatarInterface getPhilosopher5() {
		return philosopher5;
	}

	@Override
	// @Position(16)
	public RotatingLineInterface getTableLeg1() {
		return tableLeg1;
	}

	@Override
	// @Position(19)
	public RotatingLineInterface getTableLeg4() {
		return getTableLeg4();
	}

	@Override
	public void initNumberOfPhilosophers(int aNumberOfPhilosophers) {
		DiningUtil.setNumberOfPhilosophers(aNumberOfPhilosophers);
		numberOfPhilosophers = aNumberOfPhilosophers;
	}

	@Override
	public void nextCourseTime(int newVal) {
		DiningUtil.setNewCourseTime(newVal);
	}

	@Override
	public boolean preNextCourseTime() {
		return numberOfPhilosophers != -1;
	}

	@Override
	public boolean preInitNumberOfPhilosophers() {
		return numberOfPhilosophers == -1;
	}

	@Override
	public RotatingLineInterface getVisionLine() {
		return visionLine;
	}

	@Override
	public RotatingLineInterface getVisionLine2() {
		return visionLine2;
	}

	public double distanceBtwnTwoPoints(int oneX, int oneY, int twoX, int twoY) {
		int a = Math.abs(oneX - twoX);
		int b = Math.abs(oneY - twoY);
		double c = Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
		return c;
	}

	public double angleBtwnTwoPoints(int oneX, int oneY, int twoX, int twoY) {
		double hyp = distanceBtwnTwoPoints(oneX, oneY, twoX, twoY);
		double angle = Math.sin(oneY - twoY / hyp);
		System.out.println(angle);
		return angle;
	}

	// when wanting vision line to change, put in the philosopher class
	// everytime you want it to appear set it to height/width what you want
	// set them to 0,0


	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		if (evt.getSource().toString().equals("Philosopher 0")) {
			if (evt.getPropertyName().toString().equals("WithLeftChopstick") &  
					evt.getNewValue().toString().equals("true")) {
				chopstick5.getStringShape().setText("");
				chopstick5.moveTo(390, 368);
				philOneLeft = true;
				if (philOneLeft && philOneRight) {
					chopstick1.moveTo(390, 400);
					chopstick5.moveTo(390, 368);
					philosopher1.getStringShape().setText("I am eating!");
					System.out.print("set P1");
				}
		}
			if (evt.getPropertyName().toString().equals("WithRightChopstick")
					& evt.getNewValue().toString().equals("true")) {
				chopstick1.getStringShape().setText("");
				chopstick1.moveTo(390, 400);
				philOneRight = true;
				if (philOneLeft && philOneRight) {
					chopstick1.moveTo(390, 400);
					chopstick5.moveTo(390, 368);
					philosopher1.getStringShape().setText("I am eating!");
					System.out.print("set P1");
				}
			}
		if (evt.getSource().toString().equals("Philosopher 0")) {
			if (evt.getPropertyName().toString().equals("Fed") & evt.getNewValue().toString().equals("true")) {
				// philosopher1.setRaisedHand(false);
				philOneFed = true;
				philOneLeft = false;
				philOneRight = false;
				// philosopher1.getRightElbow().lowerArmRight();
				philosopher1.getStringShape().setText("I am fed");
				miniSpag1.setImageFileName("images/emptyplate.png");
				chopstick1.moveTo(CHOPSTICK1_X, CHOPSTICK1_Y);
				chopstick5.moveTo(CHOPSTICK5_X, CHOPSTICK5_Y);
			}
		}
	}
		if (evt.getSource().toString().equals("Philosopher 1")) {
	if (evt.getPropertyName().toString().equals("WithLeftChopstick") &  
			evt.getNewValue().toString().equals("true")) {
		chopstick1.getStringShape().setText("");
		chopstick1.moveTo(535, 530);
		philTwoLeft = true;
		if (philTwoLeft && philTwoRight) {
			chopstick1.moveTo(535, 530);
			chopstick2.moveTo(590, 530);
			philosopher2.getStringShape().setText("I am eating!");
			System.out.print("set P2");

		}
	}
	if (evt.getPropertyName().toString().equals("WithRightChopstick")
			& evt.getNewValue().toString().equals("true")) {
		chopstick2.getStringShape().setText("");
		chopstick2.moveTo(590, 530);
		philTwoRight = true;
		if (philTwoLeft && philTwoRight) {
			chopstick1.moveTo(535, 530);
			chopstick2.moveTo(590, 530);
			philosopher2.getStringShape().setText("I am eating!");
			System.out.print("set P2");
		}
	}
	if (evt.getPropertyName().toString().equals("Fed") & evt.getNewValue().toString().equals("true")) {
		// philosopher2.getRightElbow().lowerArmRight();
		// philosopher2.setRaisedHand(false);
		philTwoFed = true;
		philTwoLeft = false;
		philTwoRight = false;
		philosopher2.getStringShape().setText("I am fed");
		miniSpag2.setImageFileName("images/emptyplate.png");
		chopstick1.moveTo(CHOPSTICK1_X, CHOPSTICK1_Y);
		chopstick2.moveTo(CHOPSTICK2_X, CHOPSTICK2_Y);
	}
}
if (evt.getSource().toString().equals("Philosopher 2")) {
	if (evt.getPropertyName().toString().equals("WithLeftChopstick") & evt.getNewValue().toString().equals("true")) {
		chopstick2.getStringShape().setText("");
		chopstick2.moveTo(777, 462);
		philThreeLeft = true;
		if (philThreeRight && philThreeLeft) {
			chopstick2.moveTo(777, 462);
			chopstick3.moveTo(777, 428);
			philosopher3.getStringShape().setText("I am eating!");
			System.out.print("set P3");
		}
	}
	if (evt.getPropertyName().toString().equals("WithRightChopstick") & evt.getNewValue().toString().equals("true")) {
		chopstick3.getStringShape().setText("");
		chopstick3.moveTo(777, 428);
		philThreeRight = true;
		if (philThreeRight && philThreeLeft) {
			chopstick2.moveTo(777, 462);
			chopstick3.moveTo(777, 428);
			philosopher3.getStringShape().setText("I am eating!");
			System.out.print("set P3");
		}
	}
	if (evt.getPropertyName().toString().equals("Fed") & evt.getNewValue().toString().equals("true")) {
		// philosopher3.getRightElbow().lowerArmRight();
		// philosopher3.setRaisedHand(false);
		philThreeFed = true;
		philThreeLeft = false;
		philThreeRight = false;
		philosopher3.getStringShape().setText("I am fed");
		miniSpag3.setImageFileName("images/emptyplate.png");
		chopstick2.moveTo(CHOPSTICK2_X, CHOPSTICK2_Y);
		chopstick3.moveTo(CHOPSTICK3_X, CHOPSTICK3_Y);
	}
}
if (evt.getSource().toString().equals("Philosopher 3")) {
	if (evt.getPropertyName().toString().equals("WithLeftChopstick") & evt.getNewValue().toString().equals("true")) {
		chopstick3.getStringShape().setText("");
		chopstick3.moveTo(747, 215);
		philFourLeft = true;
		if (philFourRight && philFourLeft) {
			chopstick3.moveTo(747, 215);
			chopstick4.moveTo(700, 210);
			philosopher4.getStringShape().setText("I am eating!");
			System.out.print("set P4");
		}
	}
	if (evt.getPropertyName().toString().equals("WithRightChopstick") & evt.getNewValue().toString().equals("true")) {
		chopstick4.getStringShape().setText("");
		chopstick4.moveTo(700, 210);
		philFourRight = true;
		if (philFourRight && philFourLeft) {
			chopstick3.moveTo(747, 215);
			chopstick4.moveTo(700, 210);
			philosopher4.getStringShape().setText("I am eating!");
			System.out.print("set P4");
		}
	}
	if (evt.getPropertyName().toString().equals("Fed") & evt.getNewValue().toString().equals("true")) {
		// philosopher4.getRightElbow().lowerArmRight();
		// philosopher4.setRaisedHand(false);
		philFourFed = true;
		philFourLeft = false;
		philFourRight = false;
		philosopher4.getStringShape().setText("I am fed");
		miniSpag4.setImageFileName("images/emptyplate.png");
		chopstick3.moveTo(CHOPSTICK3_X, CHOPSTICK3_Y);
		chopstick4.moveTo(CHOPSTICK4_X, CHOPSTICK4_Y);
	}
} if (evt.getSource().toString().equals("Philosopher 4")) {
	if (evt.getPropertyName().toString().equals("WithLeftChopstick") & evt.getNewValue().toString().equals("true")) {
		chopstick4.getStringShape().setText("");
		chopstick4.moveTo(440, 210);
		philFiveLeft = true;
		if (philFiveRight && philFiveLeft) {
			chopstick4.moveTo(440, 210);
			chopstick5.moveTo(400, 210);
			philosopher5.getStringShape().setText("I am eating!");
			System.out.print("set P5");
		}
	}
	if (evt.getPropertyName().toString().equals("WithRightChopstick") & evt.getNewValue().toString().equals("true")) {
		chopstick5.getStringShape().setText("");
		chopstick5.moveTo(400, 210);
		philFiveRight = true;
		if (philFiveLeft && philFiveRight) {
			chopstick4.moveTo(440, 210);
			chopstick5.moveTo(400, 210);
			philosopher5.getStringShape().setText("I am eating!");
			System.out.print("set P5");
		}
		}
	if (evt.getPropertyName().toString().equals("Fed") & evt.getNewValue().toString().equals("true")) {
		// philosopher5.getRightElbow().lowerArmRight();
		// philosopher5.setRaisedHand(false);
		philFiveFed = true;
		philFiveRight = false;
		philFiveLeft = false;
		philosopher5.getStringShape().setText("I am fed");
		miniSpag5.setImageFileName("images/emptyplate.png");
		chopstick4.moveTo(CHOPSTICK4_X, CHOPSTICK4_Y);
		chopstick5.moveTo(CHOPSTICK5_X, CHOPSTICK5_Y);
	}
}
if (evt.getSource().toString().equals("Chopstick 0")) {
	if (evt.getPropertyName().toString().equals("Used") & evt.getNewValue().toString().equals("true")) {
		philosopher1.getVisionLine1().setRadius(-80);
		philosopher2.getVisionLine1().setRadius(-60);
		visionLine = new RotatingLine(CHOPSTICK1_X, CHOPSTICK1_Y,
				distanceBtwnTwoPoints(PHILOSOPHER1_X, CHOPSTICK1_X, PHILOSOPHER1_Y, CHOPSTICK1_Y),
				Math.PI - angleBtwnTwoPoints(PHILOSOPHER1_X, CHOPSTICK1_X, PHILOSOPHER1_Y, CHOPSTICK1_Y));
		visionLine2 = new RotatingLine(PHILOSOPHER2_X, PHILOSOPHER2_Y,
				distanceBtwnTwoPoints(PHILOSOPHER2_X, CHOPSTICK1_X, PHILOSOPHER2_X, CHOPSTICK1_Y),
				Math.PI - angleBtwnTwoPoints(PHILOSOPHER2_X, CHOPSTICK1_X, PHILOSOPHER2_Y, CHOPSTICK1_Y));
		System.out.println("vision line");
	}
}
if (evt.getSource().toString().equals("Chopstick 1")) {
	if (evt.getPropertyName().toString().equals("Used") & evt.getNewValue().toString().equals("true")) {
		philosopher2.getVisionLine2().setRadius(60);
		philosopher3.getVisionLine1().setRadius(100);
		visionLine = new RotatingLine(CHOPSTICK2_X, CHOPSTICK2_Y,
				distanceBtwnTwoPoints(PHILOSOPHER2_X, PHILOSOPHER2_Y, CHOPSTICK2_X, CHOPSTICK2_Y),
				Math.PI - angleBtwnTwoPoints(PHILOSOPHER2_X, PHILOSOPHER2_Y, CHOPSTICK2_X, CHOPSTICK2_Y));
		visionLine2 = new RotatingLine(PHILOSOPHER3_X, PHILOSOPHER3_Y,
				distanceBtwnTwoPoints(PHILOSOPHER3_X, PHILOSOPHER3_Y, CHOPSTICK2_X, CHOPSTICK2_Y),
				Math.PI - angleBtwnTwoPoints(PHILOSOPHER3_X, PHILOSOPHER3_Y, CHOPSTICK2_X, CHOPSTICK2_Y));
		System.out.println("vision line");
	}
}
if (evt.getSource().toString().equals("Chopstick 2")) {
	if (evt.getPropertyName().toString().equals("Used") & evt.getNewValue().toString().equals("true")) {
		// first visionLine has issues
		philosopher3.getVisionLine2().setRadius(80);
		philosopher4.getVisionLine1().setRadius(140);
		visionLine = new RotatingLine(CHOPSTICK3_X, CHOPSTICK3_Y,
				distanceBtwnTwoPoints(PHILOSOPHER3_X, PHILOSOPHER3_Y, CHOPSTICK3_X, CHOPSTICK3_Y),
				Math.PI - angleBtwnTwoPoints(PHILOSOPHER3_X, PHILOSOPHER3_Y, CHOPSTICK3_X, CHOPSTICK3_Y));
		visionLine2 = new RotatingLine(PHILOSOPHER4_X, PHILOSOPHER4_Y,
				distanceBtwnTwoPoints(PHILOSOPHER4_X, PHILOSOPHER4_Y, CHOPSTICK3_X, CHOPSTICK3_Y),
				Math.PI - angleBtwnTwoPoints(PHILOSOPHER4_X, PHILOSOPHER4_Y, CHOPSTICK3_X, CHOPSTICK3_Y));
		System.out.println("vision line");
}
}
if (evt.getSource().toString().equals("Chopstick 3")) {
	if (evt.getPropertyName().toString().equals("Used") & evt.getNewValue().toString().equals("true")) {
		// first visionLine has issues
		philosopher4.getVisionLine2().setRadius(110);
		philosopher5.getVisionLine2().setRadius(110);
		visionLine = new RotatingLine(CHOPSTICK4_X, CHOPSTICK4_Y,
				distanceBtwnTwoPoints(PHILOSOPHER5_X, PHILOSOPHER5_Y, CHOPSTICK4_X, CHOPSTICK4_Y),
				Math.PI - angleBtwnTwoPoints(PHILOSOPHER5_X, CHOPSTICK4_X, PHILOSOPHER5_Y, CHOPSTICK4_Y));
		visionLine2 = new RotatingLine(PHILOSOPHER4_X, PHILOSOPHER4_Y,
				distanceBtwnTwoPoints(PHILOSOPHER4_X, PHILOSOPHER4_Y, CHOPSTICK4_X, CHOPSTICK4_Y),
				Math.PI + angleBtwnTwoPoints(PHILOSOPHER4_X, CHOPSTICK4_X, PHILOSOPHER4_Y, CHOPSTICK4_Y));
		System.out.println("vision line");
}
}
if (evt.getSource().toString().equals("Chopstick 4")) {
	if (evt.getPropertyName().toString().equals("Used") & evt.getNewValue().toString().equals("true")) {
		// first visionLine has issues
		philosopher5.getVisionLine1().setRadius(140);
		philosopher1.getVisionLine2().setRadius(60);
		// philosopher1.getVisionLine1().setColor(913831);
		visionLine = new RotatingLine(PHILOSOPHER1_X, PHILOSOPHER1_Y,
				distanceBtwnTwoPoints(PHILOSOPHER1_X, PHILOSOPHER1_Y, CHOPSTICK5_X, CHOPSTICK5_Y),
				Math.PI + (Math.PI - angleBtwnTwoPoints(PHILOSOPHER5_X, PHILOSOPHER5_Y, CHOPSTICK5_X, CHOPSTICK5_Y)));
		visionLine2 = new RotatingLine(PHILOSOPHER5_X, PHILOSOPHER5_Y,
				distanceBtwnTwoPoints(PHILOSOPHER5_X, PHILOSOPHER5_Y, CHOPSTICK5_X, CHOPSTICK5_Y), Math.PI / 2 + Math.PI
						+ (Math.PI - angleBtwnTwoPoints(PHILOSOPHER5_X, PHILOSOPHER5_Y, CHOPSTICK5_X, CHOPSTICK5_Y)));
		System.out.println("vision line");
	}
}
}
}

