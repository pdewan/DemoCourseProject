package OEshapegraphics;

import java.awt.BasicStroke;
import java.beans.PropertyChangeEvent;

import bus.uigen.shapes.ALineModel;
import bus.uigen.shapes.AnImageModel;
import bus.uigen.shapes.AnOvalModel;
import bus.uigen.shapes.OEShapeModel;
import diningPhilosopher.main.DiningUtil;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;

@StructurePattern(StructurePatternNames.BEAN_PATTERN)

public class DiningSceneOeShape implements DiningSceneInterface {

	OEShapeModel table;

	OEShapeModel spaghetti;
	OEShapeModel miniSpag1;
	OEShapeModel miniSpag2;
	OEShapeModel miniSpag3;
	OEShapeModel miniSpag4;
	OEShapeModel miniSpag5;
	OEShapeModel emptySpag1;
	OEShapeModel emptySpag2;
	OEShapeModel emptySpag3;
	OEShapeModel emptySpag4;
	OEShapeModel emptySpag5;

	OEShapeModel chopstick1;
	OEShapeModel chopstick2;
	OEShapeModel chopstick3;
	OEShapeModel chopstick4;
	OEShapeModel chopstick5;
	OEShapeModel visionLine;
	OEShapeModel visionLine2;

	OEShapeModel tableLeg1;
	OEShapeModel tableLeg2;

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


	public DiningSceneOeShape() {
		visionLine = new ALineModel();
		visionLine.setX(10);
		visionLine.setY(10);
		visionLine.setRadius(0);
		visionLine.setAngle(10);
		visionLine2 = new ALineModel();
		visionLine2.setX(10);
		visionLine2.setY(10);
		visionLine2.setRadius(0);
		visionLine2.setAngle(10);

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
		// OEShapeModel rectangle = new ARectangleModel();

		table = new AnOvalModel();
		table.setX(400);
		table.setY(200);
		table.setWidth(400);
		table.setHeight(300);
		tableLeg1 = new ALineModel();
		tableLeg1.setX(450);
		tableLeg1.setY(450);
		tableLeg1.setRadius(70);
		tableLeg1.setAngle(Math.PI / 32 * 16);
		// need to rotate by 16
		tableLeg2 = new ALineModel();
		tableLeg2.setX(750);
		tableLeg2.setY(450);
		tableLeg2.setRadius(70);
		tableLeg2.setAngle(Math.PI / 32 * 16);
		// tableLeg1.setStroke(10f);
		// tableLeg2.setStroke(10f);

		tableLeg1.setStroke(new BasicStroke(10f));
		tableLeg2.setStroke(new BasicStroke(10f));

		philosopher2.getArms().getLeftLine().setAngle(110);
		philosopher2.getArms().getRightLine().setAngle(50);
		philosopher1.getArms().getLeftLine().setAngle(100);
		philosopher3.getArms().getRightLine().setAngle(280);

		spaghetti = new AnImageModel("images/spag.png");
		spaghetti.setX(SPAG_X);
		spaghetti.setY(SPAG_Y);
		miniSpag1 = new AnImageModel("images/minispag.png");
		miniSpag1.setX(MINISPAG1_X);
		miniSpag1.setY(MINISPAG1_Y);
		miniSpag2 = new AnImageModel("images/minispag.png");
		miniSpag2.setX(MINISPAG2_X);
		miniSpag2.setY(MINISPAG2_Y);
		miniSpag3 = new AnImageModel("images/minispag.png");
		miniSpag3.setX(MINISPAG3_X);
		miniSpag3.setY(MINISPAG3_Y);
		miniSpag4 = new AnImageModel("images/minispag.png");
		miniSpag4.setX(MINISPAG4_X);
		miniSpag4.setY(MINISPAG4_Y);
		miniSpag5 = new AnImageModel("images/minispag.png");
		miniSpag5.setX(MINISPAG5_X);
		miniSpag5.setY(MINISPAG5_Y);
		chopstick1 = new AnImageModel("images/chopsticks.png");
		chopstick1.setX(CHOPSTICK1_X);
		chopstick1.setY(CHOPSTICK1_Y);
		chopstick2 = new AnImageModel("images/chopsticks.png");
		chopstick2.setX(CHOPSTICK2_X);
		chopstick2.setY(CHOPSTICK2_Y);
		chopstick3 = new AnImageModel("images/chopsticks.png");
		chopstick3.setX(CHOPSTICK3_X);
		chopstick3.setY(CHOPSTICK3_Y);
		chopstick4 = new AnImageModel("images/chopsticks.png");
		chopstick4.setX(CHOPSTICK4_X);
		chopstick4.setY(CHOPSTICK4_Y);
		chopstick5 = new AnImageModel("images/chopsticks.png");
		chopstick5.setX(CHOPSTICK5_X);
		chopstick5.setY(CHOPSTICK5_Y);
		emptySpag1 = new AnImageModel("images/emptyplates.png");
		emptySpag1.setX(MINISPAG1_X);
		emptySpag1.setY(MINISPAG1_Y);
		emptySpag2 = new AnImageModel("images/emptyplates.png");
		emptySpag2.setX(MINISPAG2_X);
		emptySpag2.setY(MINISPAG2_Y);
		emptySpag3 = new AnImageModel("images/emptyplates.png");
		emptySpag3.setX(MINISPAG3_X);
		emptySpag3.setY(MINISPAG3_Y);
		emptySpag4 = new AnImageModel("images/emptyplates.png");
		emptySpag4.setX(MINISPAG4_X);
		emptySpag4.setY(MINISPAG4_Y);
		emptySpag5 = new AnImageModel("images/emptyplates.png");
		emptySpag5.setX(MINISPAG5_X);
		emptySpag5.setY(MINISPAG5_Y);

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
	}

	@Override
	public OEShapeModel getTable() {
		return table;
	}

	@Override
	// @Position(20)
	public OEShapeModel getSpaghetti() {
		return spaghetti;
	}

	@Override
	// @Position(1)
	public OEShapeModel getMiniSpag1() {
		return miniSpag1;
	}

	@Override
	// @Position(2)
	public OEShapeModel getMiniSpag2() {
		return miniSpag2;
	}

	@Override
	// @Position(3)
	// finish numbering all the positions
	public OEShapeModel getMiniSpag3() {
		return miniSpag3;
	}

	@Override
	// @Position(4)
	public OEShapeModel getMiniSpag4() {
		return miniSpag4;
	}

	@Override
	// @Position(5)
	public OEShapeModel getMiniSpag5() {
		return miniSpag5;
	}

	@Override
	public OEShapeModel getEmptySpag1() {
		return miniSpag1;
	}

	@Override
	public OEShapeModel getEmptySpag2() {
		return miniSpag2;
	}

	@Override
	public OEShapeModel getEmptySpag3() {
		return miniSpag3;
	}

	@Override
	public OEShapeModel getEmptySpag4() {
		return miniSpag4;
	}

	@Override
	public OEShapeModel getEmptySpag5() {
		return miniSpag5;
	}

	@Override
	// @Position(6)
	public OEShapeModel getChopstick1() {
		return chopstick1;
	}

	@Override
	// @Position(7)
	public OEShapeModel getChopstick2() {
		return chopstick2;
	}

	@Override
	// @Position(8)
	public OEShapeModel getChopstick4() {
		return chopstick4;
	}

	@Override
	// @Position(9)
	public OEShapeModel getChopstick3() {
		return chopstick3;
	}

	@Override
	// @Position(10)
	public OEShapeModel getChopstick5() {
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
	public OEShapeModel getTableLeg1() {
		return tableLeg1;
	}

	@Override
	// @Position(19)
	public OEShapeModel getTableLeg2() {
		return tableLeg2;
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
	public OEShapeModel getVisionLine() {
		return visionLine;
	}

	@Override
	public OEShapeModel getVisionLine2() {
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
				chopstick5.setX(390);
				chopstick5.setY(368);
				philOneLeft = true;
				if (philOneLeft && philOneRight) {
					chopstick1.setX(390);
					chopstick1.setY(400);
					chopstick5.setX(390);
					chopstick5.setY(368);
					philosopher1.getStringShape().setText("I am eating!");
					System.out.print("set P1");
				}
		}
			if (evt.getPropertyName().toString().equals("WithRightChopstick")
					& evt.getNewValue().toString().equals("true")) {
				chopstick1.setX(390);
				chopstick1.setY(400);
				philOneRight = true;
				if (philOneLeft && philOneRight) {
					chopstick1.setX(390);
					chopstick1.setY(400);
					chopstick5.setX(390);
					chopstick5.setY(368);
					philosopher1.getStringShape().setText("I am eating!");
					System.out.print("set P1");
				}
			}
		if (evt.getSource().toString().equals("Philosopher 0")) {
			if (evt.getPropertyName().toString().equals("Fed") & evt.getNewValue().toString().equals("true")) {
				philOneFed = true;
				philOneLeft = false;
				philOneRight = false;
				philosopher1.getStringShape().setText("I am fed");
				miniSpag1 = new AnImageModel("images/emptyplate.png", MINISPAG1_X, MINISPAG1_Y);
				chopstick1.setX(CHOPSTICK1_X);
				chopstick1.setY(CHOPSTICK1_Y);
				chopstick5.setX(CHOPSTICK5_X);
				chopstick5.setY(CHOPSTICK5_Y);
			}
		}
	}
		if (evt.getSource().toString().equals("Philosopher 1")) {
	if (evt.getPropertyName().toString().equals("WithLeftChopstick") &  
			evt.getNewValue().toString().equals("true")) {
		chopstick1.setX(535);
		chopstick1.setY(530);
		philTwoLeft = true;
		if (philTwoLeft && philTwoRight) {
			chopstick1.setX(535);
			chopstick1.setY(530);
			chopstick2.setX(590);
			chopstick2.setY(530);
			philosopher2.getStringShape().setText("I am eating!");
			System.out.print("set P2");

		}
	}
	if (evt.getPropertyName().toString().equals("WithRightChopstick")
			& evt.getNewValue().toString().equals("true")) {
		chopstick2.setX(590);
		chopstick2.setY(530);
		philTwoRight = true;
		if (philTwoLeft && philTwoRight) {
			chopstick1.setX(535);
			chopstick1.setY(530);
			chopstick2.setX(590);
			chopstick2.setY(530);
			philosopher2.getStringShape().setText("I am eating!");
			System.out.print("set P2");
		}
	}
	if (evt.getPropertyName().toString().equals("Fed") & evt.getNewValue().toString().equals("true")) {
		philTwoFed = true;
		philTwoLeft = false;
		philTwoRight = false;
		philosopher2.getStringShape().setText("I am fed");
		miniSpag2 = new AnImageModel("images/emptyplate.png", MINISPAG2_X, MINISPAG2_Y);
		chopstick1.setX(CHOPSTICK1_X);
		chopstick1.setY(CHOPSTICK1_Y);
		chopstick2.setX(CHOPSTICK2_X);
		chopstick2.setY(CHOPSTICK2_Y);
	}
}
if (evt.getSource().toString().equals("Philosopher 2")) {
	if (evt.getPropertyName().toString().equals("WithLeftChopstick") & evt.getNewValue().toString().equals("true")) {
		chopstick2.setX(777);
		chopstick2.setY(462);
		philThreeLeft = true;
		if (philThreeRight && philThreeLeft) {
			chopstick2.setX(777);
			chopstick2.setY(462);
			chopstick3.setX(777);
			chopstick3.setY(428);
			philosopher3.getStringShape().setText("I am eating!");
			System.out.print("set P3");
		}
	}
	if (evt.getPropertyName().toString().equals("WithRightChopstick") & evt.getNewValue().toString().equals("true")) {
		chopstick3.setX(777);
		chopstick3.setY(428);
		philThreeRight = true;
		if (philThreeRight && philThreeLeft) {
			chopstick2.setX(777);
			chopstick2.setY(462);
			chopstick3.setX(777);
			chopstick3.setY(428);
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
		miniSpag3 = new AnImageModel("images/emptyplate.png", MINISPAG3_X, MINISPAG3_Y);
		chopstick2.setX(CHOPSTICK2_X);
		chopstick2.setY(CHOPSTICK2_Y);
		chopstick3.setX(CHOPSTICK3_X);
		chopstick3.setY(CHOPSTICK3_Y);
	}
}
if (evt.getSource().toString().equals("Philosopher 3")) {
	if (evt.getPropertyName().toString().equals("WithLeftChopstick") & evt.getNewValue().toString().equals("true")) {
		chopstick3.setX(747);
		chopstick3.setY(215);
		philFourLeft = true;
		if (philFourRight && philFourLeft) {
			chopstick3.setX(747);
			chopstick3.setY(215);
			chopstick4.setX(700);
			chopstick4.setY(210);
			philosopher4.getStringShape().setText("I am eating!");
			System.out.print("set P4");
		}
	}
	if (evt.getPropertyName().toString().equals("WithRightChopstick") & evt.getNewValue().toString().equals("true")) {
		chopstick4.setX(700);
		chopstick4.setY(210);
		philFourRight = true;
		if (philFourRight && philFourLeft) {
			chopstick3.setX(747);
			chopstick3.setY(215);
			chopstick4.setX(700);
			chopstick4.setY(210);
			philosopher4.getStringShape().setText("I am eating!");
			System.out.print("set P4");
		}
	}
	if (evt.getPropertyName().toString().equals("Fed") & evt.getNewValue().toString().equals("true")) {
		philFourFed = true;
		philFourLeft = false;
		philFourRight = false;
		philosopher4.getStringShape().setText("I am fed");
		miniSpag4 = new AnImageModel("images/emptyplate.png", MINISPAG4_X, MINISPAG4_Y);
		chopstick3.setX(CHOPSTICK3_X);
		chopstick3.setY(CHOPSTICK3_Y);
		chopstick4.setX(CHOPSTICK4_X);
		chopstick4.setY(CHOPSTICK4_Y);
	}
} if (evt.getSource().toString().equals("Philosopher 4")) {
	if (evt.getPropertyName().toString().equals("WithLeftChopstick") & evt.getNewValue().toString().equals("true")) {
		chopstick4.setX(440);
		chopstick4.setY(210);
		philFiveLeft = true;
		if (philFiveRight && philFiveLeft) {
			chopstick4.setX(440);
			chopstick4.setY(210);
			chopstick5.setX(400);
			chopstick5.setY(210);
			philosopher5.getStringShape().setText("I am eating!");
			System.out.print("set P5");
		}
	}
	if (evt.getPropertyName().toString().equals("WithRightChopstick") & evt.getNewValue().toString().equals("true")) {
		chopstick5.setX(400);
		chopstick5.setY(210);
		philFiveRight = true;
		if (philFiveLeft && philFiveRight) {
			chopstick4.setX(440);
			chopstick4.setY(210);
			chopstick5.setX(400);
			chopstick5.setY(210);
			philosopher5.getStringShape().setText("I am eating!");
			System.out.print("set P5");
		}
		}
	if (evt.getPropertyName().toString().equals("Fed") & evt.getNewValue().toString().equals("true")) {
		philFiveFed = true;
		philFiveRight = false;
		philFiveLeft = false;
		philosopher5.getStringShape().setText("I am fed");
		miniSpag5 = new AnImageModel("images/emptyplates.png", MINISPAG5_X, MINISPAG5_Y);
		chopstick4.setX(CHOPSTICK4_X);
		chopstick4.setY(CHOPSTICK4_Y);
		chopstick5.setX(CHOPSTICK5_X);
		chopstick5.setY(CHOPSTICK5_Y);
	}
}
if (evt.getSource().toString().equals("Chopstick 0")) {
	if (evt.getPropertyName().toString().equals("Used") & evt.getNewValue().toString().equals("true")) {
		philosopher1.getVisionLine1().setRadius(-80);
		philosopher2.getVisionLine1().setRadius(-60);
		System.out.println("vision line");
	}
}
if (evt.getSource().toString().equals("Chopstick 1")) {
	if (evt.getPropertyName().toString().equals("Used") & evt.getNewValue().toString().equals("true")) {
		philosopher2.getVisionLine2().setRadius(60);
		philosopher3.getVisionLine1().setRadius(100);
		System.out.println("vision line");
	}
}
if (evt.getSource().toString().equals("Chopstick 2")) {
	if (evt.getPropertyName().toString().equals("Used") & evt.getNewValue().toString().equals("true")) {
		philosopher3.getVisionLine2().setRadius(80);
		philosopher4.getVisionLine1().setRadius(140);
		System.out.println("vision line");
}
}
if (evt.getSource().toString().equals("Chopstick 3")) {
	if (evt.getPropertyName().toString().equals("Used") & evt.getNewValue().toString().equals("true")) {
		philosopher4.getVisionLine2().setRadius(110);
		philosopher5.getVisionLine2().setRadius(110);
		System.out.println("vision line");
}
}
if (evt.getSource().toString().equals("Chopstick 4")) {
	if (evt.getPropertyName().toString().equals("Used") & evt.getNewValue().toString().equals("true")) {
		philosopher5.getVisionLine1().setRadius(140);
		philosopher1.getVisionLine2().setRadius(60);
		System.out.println("vision line");
	}
}
}
}

