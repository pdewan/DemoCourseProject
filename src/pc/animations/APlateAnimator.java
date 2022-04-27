package pc.animations;

import bus.uigen.shapes.OEShapeModel;
import pc.graphics.Plate;
import util.annotations.Visible;
import util.misc.ThreadSupport;

public class APlateAnimator implements PlateAnimator {
	
	public APlateAnimator() {
		
	}
	
	@Override
	public void animateCooking(Plate aPlate, int pauseTime, int stepSize) {
		System.out.println("Entering the animateCooking method!");
		System.out.println("Now in thread: " + Thread.currentThread());
		int increment = 0;
		
//		for (int i=0; i<stepSize; i++) {
//			aPlate.setHeight(i);
//			aPlate.setWidth(i);
//			ThreadSupport.sleep(pauseTime);
//			System.out.println("step size is now " + stepSize);
//		}
		
		while (increment < stepSize) {
			aPlate.setHeight(increment);
			aPlate.setWidth(increment);
			ThreadSupport.sleep(pauseTime);
			System.out.println("Increment is now " + increment);
			increment++;
		}
		
	}
}
