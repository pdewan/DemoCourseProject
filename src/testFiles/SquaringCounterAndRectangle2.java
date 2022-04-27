package testFiles;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import bus.uigen.OEFrame;
import bus.uigen.ObjectEditor;
import graphics.BoundedShape;
import graphics.Table;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.models.PropertyListenerRegisterer;
@StructurePattern(StructurePatternNames.BEAN_PATTERN)
public class SquaringCounterAndRectangle2 implements PropertyListenerRegisterer {
	
	PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);
	int number = 2;
	final int MAGNIFICATION = 10;
	BoundedShape rectangle = new Table(10, 10, 10, 10);
//	 ShapeModel rectangle ;

	BoundedShape squaredRectangle = new Table(20, 20, 20, 20);
//	 ShapeModel squaredRectangle;
	


	public SquaringCounterAndRectangle2() {
//		  try {
//			rectangle = new shapes.RectangleModel();
//			squaredRectangle  = new shapes.RectangleModel();
//		} catch (RemoteException e) {
//			e.printStackTrace();
//		}

		// ((FlexibleShape) rectangle).setFilled(true);
		// ((FlexibleShape) rectangle).setColor(Color.red);
		// squaredRectangle.setFilled(true);
		// squaredRectangle.setColor(Color.cyan);
		rectangle.setZIndex(6);
		squaredRectangle.setZIndex(4);
		updateRectangles();
//		rectangle = new ARectangleModel(new Rectangle(0, 0, magnifiedSide, magnifiedSide));
//		 
//		squaredRectangle = new ARectangleModel(new Rectangle(0, 0, magnifiedSide*magnifiedSide, 
//				magnifiedSide*magnifiedSide));		
	}
	
	protected void updateRectangles() {
		int magnifiedSide = getNumber()*MAGNIFICATION;
		int magnifiedSquareSide = getSquare()*MAGNIFICATION;
		// rectangle.setSize(new Dimension(magnifiedSide, magnifiedSide));
		// squaredRectangle.setSize(new Dimension(magnifiedSquareSide,
		// magnifiedSquareSide));
	}
	 	 
	

	public void increment() {
		setNumber(number + 1);
	}
	void setNumber(int newValue) {
		int oldNumber = number;
		int oldSquare = getSquare();
		number = newValue;
		propertyChangeSupport.firePropertyChange("number", oldNumber, number);
		propertyChangeSupport.firePropertyChange("square", oldSquare, getSquare());
		updateRectangles();

	}

	public void decrement() {
		setNumber(number - 1);		
	}

//	@Row(1)
	public int getNumber() {
		return number;
	}

//	@Row(2)
	public int getSquare() {
		return number*number;
	}


	public BoundedShape getRectangle() {
		return rectangle;
	}

	public BoundedShape getSquaredRectangle() {
		return squaredRectangle;
	}
	
	@Override
	public void addPropertyChangeListener(PropertyChangeListener aListener) {
		propertyChangeSupport.addPropertyChangeListener(aListener);
		
	}
	public static void main (String[] args) {
		
		OEFrame oeFrame = ObjectEditor.edit(new SquaringCounterAndRectangle2());


		
	}

}