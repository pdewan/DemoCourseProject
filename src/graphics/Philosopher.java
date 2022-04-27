package graphics;

import java.beans.PropertyChangeListener;
import java.util.List;

import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;

@PropertyNames({ "X", "Y", "Width", "Height" })
@EditablePropertyNames({ "X", "Y", "Width", "Height" })

@StructurePattern(StructurePatternNames.OVAL_PATTERN)

public class Philosopher extends Locatable implements PhilosopherInterface {

	int width;
	int height;
	boolean waiting;
	// create philo avatar, also create vars for raised hand and the motion! then
	// bind to property change listeners //
	public Philosopher(int initX, int initY, int initWidth, int initHeight) {
		super(initX, initY);
		width = initWidth;
		height = initHeight;
		waiting = false;
		// TODO Auto-generated constructor stub
	}

	final static int OFFSET = 100;
    final static int MINOR_OFFSET = 10;
    final static int LEFT_ROTATE = 24;
    final static int RIGHT_ROTATE = 8;
    final static int BODY_ROTATE = 16;
    final static int BODY_RADIUS = 100;
    final static int BODY_ANGLE = 0;
    final static int DIVIDER = 2;

    final static int INITIAL_RADIUS = 40;
    final static int INITIAL_ANGLE1 = 0;
    final static int INITIAL_ANGLE2 = 0;
    final static int START_X = 100;
    final static int START_Y = 100;

    AngleInterface arms;
    RotatingLineInterface body;

    public Philosopher(int initX, int initY) {
    	super(initX, initY);
        arms = new Angle();
        arms.getLeftLine().rotate(LEFT_ROTATE);
        arms.getRightLine().rotate(RIGHT_ROTATE);
		body = new RotatingLine(initX, initY, 50, 50);
        body.rotate(BODY_ROTATE);
		height = 100;
		width = 50;
		waiting = false;
    }
    
	@Override
	public int getWidth() {
		return width;

	}

	@Override
	public int getHeight() {
		return height;
	}

	@Override
	public boolean getWaiting() {
		return waiting;
	}

	@Override
	public void setWaiting(boolean waitStatus) {
		waiting = waitStatus;
	}

	@Override
	public void addPropertyChangeListener(PropertyChangeListener newListen) {
		propertySupport.addListen(newListen);
	}

	@Override
	public List<PropertyChangeListener> getPropertyChangeListeners() {
		return propertySupport.generateList();
	}

}
