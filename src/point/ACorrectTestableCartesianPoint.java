package point;

import util.annotations.Explanation;
import util.annotations.Tags;

import java.util.Scanner;

import bus.uigen.ObjectEditor;
import testables.java.sharedCode.AnAbstractTestableCartesianPoint;
@Explanation("Uses Cartesian representation.")
@Tags({"cartesian", "point"})
public class ACorrectTestableCartesianPoint extends AnAbstractTestableCartesianPoint implements TestablePoint {	
	public static Scanner scanner = new Scanner(System.in);
	public ACorrectTestableCartesianPoint(int theX, int theY) {
		super(theX, theY);
	}
	public ACorrectTestableCartesianPoint(double theRadius, double theAngle) {
		super(theRadius, theAngle);
	}
	@Override
	public TestablePoint translate (int anXDelta, int aYDelta) {
		return new ACorrectTestableCartesianPoint (getX() + anXDelta, getY() + aYDelta);
	}
	public static final String QUIT = "quit";
	public static int inputInt(String aPrompt) {
		System.out.println(aPrompt);
		String aNextLine = scanner.nextLine();
		if (QUIT.equals(aNextLine)) {
			System.out.println("quitting");
			System.exit(0);		}
		int anX = Integer.parseInt(aNextLine);
		return anX;
	}
	public static void main(String args[]) {
		System.out.println("You can type quit anytime to terminate");
		for (;;) {
			int anX = inputInt("Please enter the X coordinate.");			
			int aY = inputInt("Please enter the Y coordinate.");
			TestablePoint aPoint = new ACorrectTestableCartesianPoint(anX, aY);
			aPoint.print();
			int anXDelta = inputInt("Please enter how much to move in the X direction");			
			int aYDelta = inputInt("Please enter how much to move in the Y direction");
			TestablePoint aTranslatedPoint = aPoint.translate(anXDelta, aYDelta);
			aTranslatedPoint.print();

			
		}
//		TestablePoint point =  new ACorrectTestableCartesianPoint (50, 100);
//		point = new ACorrectTestableCartesianPoint(100, Math.PI/4);	
	}
}
