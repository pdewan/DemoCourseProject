package pc.graphics;

import java.beans.PropertyChangeListener;

import bus.uigen.OEFrame;
import bus.uigen.ObjectEditor;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;

@StructurePattern(StructurePatternNames.BEAN_PATTERN)
public class ATable implements Table {
	
	Line Top;
	Line Bottom;
	Line Left;
	Line Right;
	Line LeftDiagonal;
	Line RightDiagonal;
	Line TableLeg;
	
	int TopAndLeft = 50;
	int BottomAndRight = 70;
	int TopAndBottomRadius = 50;
	int HorizontalAngle = 48;
	int DiagonalRadius = 28;
	int DiagonalAngle = 152;
	int BottomRightX = 120;
	int BottomRightY = 70;
	int LeftRadius = 500;
	
	PropertyListenerSupport propertySupport = new APropertyListenerSupport();

	
	public ATable() {
		Top = new ALine();
		Bottom = new ALine();
		Left = new ALine();
		Right = new ALine();
		LeftDiagonal = new ALine();
		RightDiagonal = new ALine();
		TableLeg = new ALine();
		
		Top.setX(TopAndLeft);
		Top.setY(TopAndLeft);
		Left.setX(TopAndLeft);
		Left.setX(TopAndLeft);
		
		Top.setRadius(TopAndBottomRadius);
		Left.setRadius(LeftRadius);
		Top.rotate(HorizontalAngle);
		
		Bottom.setX(BottomAndRight);
		Bottom.setY(BottomAndRight);
		Right.setX(BottomAndRight);
		Right.setY(BottomAndRight);
		
		Bottom.setRadius(TopAndBottomRadius);
		Bottom.rotate(HorizontalAngle);
		
		LeftDiagonal.setX(BottomAndRight);
		LeftDiagonal.setY(BottomAndRight);
		LeftDiagonal.setRadius(DiagonalRadius);
		LeftDiagonal.rotate(DiagonalAngle);
		
		RightDiagonal.setX(BottomRightX);
		RightDiagonal.setY(BottomRightY);
		RightDiagonal.setRadius(DiagonalRadius);
		RightDiagonal.rotate(DiagonalAngle);
		
		TableLeg.setX(BottomRightX);
		TableLeg.setY(BottomRightY);
		TableLeg.setRadius(TopAndBottomRadius);
		
	}

	@Override
	public Line getTop() {
		return Top;
	}

	@Override
	public Line getBottom() {
		return Bottom;
	}

	@Override
	public Line getRight() {
		return Right;
	}

	@Override
	public Line getLeft() {
		return Left;
	}
	
	@Override
	public Line getLeftDiagonal() {
		return LeftDiagonal;
	}
	
	@Override
	public Line getRightDiagonal() {
		return RightDiagonal;
	}
	
	@Override
	public Line getTableLeg() {
		return TableLeg;
	}

	@Override
	public void move(int X, int Y) {
		Top.move(X, Y);
		Bottom.move(X, Y);
		Right.move(X, Y);
		Left.move(X, Y);
		LeftDiagonal.move(X, Y);
		RightDiagonal.move(X, Y);
		TableLeg.move(X, Y);
		
	}
	
	public static void main(String[] args) {
		Table NewTable = new ATable();
		OEFrame editor = ObjectEditor.edit(NewTable);
		editor.showDrawPanel();
		editor.showTreePanel();
		

	}
	
	@Override
	public void addPropertyChangeListener(PropertyChangeListener arg0) {
		propertySupport.addPropertyChangeListener(arg0);
	}




	
	
	
	

}
