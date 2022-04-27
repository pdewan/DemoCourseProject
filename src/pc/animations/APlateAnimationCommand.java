package pc.animations;

import bus.uigen.shapes.OEShapeModel;
import pc.graphics.Plate;

public class APlateAnimationCommand implements Runnable {

	PlateAnimator animator;
	int pause;
	int step;
	Plate plate;
	
	public APlateAnimationCommand(PlateAnimator aPlateAnimator, Plate aPlate, int animationStep, int pauseStep) {
		animator = aPlateAnimator;
		pause = pauseStep;
		step = animationStep;
		plate = aPlate;
	}
	@Override
	public void run() {
		System.out.println(Thread.currentThread() + "about to call animatePlate from " + animator);
		animator.animateCooking(plate, pause, step);
	}

}
