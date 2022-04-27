package pc.graphics;

import java.awt.BorderLayout;
import java.awt.Component;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import bus.uigen.shapes.AnImageModel;
import bus.uigen.shapes.OEShapeModel;
import pc.animations.APlateAnimationCommand;
import pc.animations.APlateAnimator;
import pc.animations.PlateAnimator;
import pc.controls.AController;
import pc.controls.ConsoleSceneView;
import pc.controls.Controller;
import pc.factories.AFactory;
import util.annotations.EditablePropertyNames;
import util.annotations.Label;
import util.annotations.ObserverRegisterer;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Visible;
import util.misc.ThreadSupport;

@StructurePattern(StructurePatternNames.BEAN_PATTERN)
@PropertyNames({
	"patronList",
	"chefList",
	"buffer"
})
@EditablePropertyNames({
})
@Label("Producer-Consumer Scene")
public class AProducerConsumerScene implements ProducerConsumerScene {
	List<APatron> patronList;
	List<AChef> chefList;
	BoundedBufferView bufferView;
	List<APlate> plateList;
	
	int resetPatronNumber;
	int resetChefNumber;
	
	int maxAmountofAvatars;
	
	int Patron_X = 1000;
	int Chef_X = 50;
	int AvatarA_Y = 50;
	int AvatarB_Y = 200;
	int AvatarC_Y = 320;
	int AvatarD_Y = 450;
	
	String[] chefImages = {"images/0.png","images/1.png","images/4.png","images/3.png"};
	String[] patronImages = {"images/6.png", "", "", "", "", ""};
	String[] plateImages = {"images/12.png", "images/13.png", "images/14.png", "images/15.png", "images/16.png", "images/17.png", "images/18.png", "images/19.png", "images/20.png"};
	int[] chefXValues = {150,50,50,150};
	int[] chefYValues = {50,150,350,450};
	int[] patronXValues = {1000,1100,1100,1000};
	int[] patronYValues = {50,150,350,450};
	
	char zero = '0';
	char one = '1';
	char two = '2';
	char three = '3';
	char four = '4';
	char five = '5';
	char six = '6';
	
	OEShapeModel testPlate;
	
	APlateAnimationCommand command;
	PlateAnimator animator;
	
	boolean[] bufferOccupied = {false, false, false, false, false, false, false, false};
	
	int[] yValues = {AvatarA_Y, AvatarB_Y, AvatarC_Y, AvatarD_Y};
	
	List<PropertyChangeListener> propertyChangeListeners = new ArrayList<PropertyChangeListener>();
	
	public AProducerConsumerScene(int patronAmount, int chefAmount) {
	
		initScene(patronAmount, chefAmount);
		
	}
	
	public AProducerConsumerScene() {
		bufferView = new ABoundedBufferView();
		patronList = new ArrayList<APatron>();
		patronList.add(0, new APatron());
		patronList.get(0).move(patronXValues[0], patronYValues[0]);
		patronList.get(0).patron.getHead().setImageFileName(patronImages[0]);
		chefList = new ArrayList<AChef>();
		chefList.add(0, new AChef());
		chefList.get(0).move(chefXValues[0], chefYValues[0]);
		chefList.get(0).chef.getHead().setImageFileName(chefImages[0]);
		testPlate = new AnImageModel("images/12.png");
		animator = new APlateAnimator();
		command = new APlateAnimationCommand(animator, chefList.get(0).chef.getPlate(), 39, 10);
	}
	
	@Label("Init Scene")
	public void initScene(int patronAmount, int chefAmount) {
		
		patronList.clear();
		chefList.clear();
		resetPatronNumber = patronAmount;
		resetChefNumber = chefAmount;
		for (int i=0; i<patronAmount; i++) { 
			APatron patron = new APatron();
			patronList.add(i, patron);
			patron.move(patronXValues[i], patronYValues[i]);
			patron.patron.getHead().setImageFileName(patronImages[i]);
			patron.patron.getArms().removeArms();
		}
		for (int i=0; i<chefAmount; i++) {
			AChef chef = new AChef();
			chefList.add(i, chef);
			chef.move(chefXValues[i], chefYValues[i]);
			chef.chef.getHead().setImageFileName(chefImages[i]);
		}
		
		ConsoleSceneView console = AFactory.ConsoleSceneViewFactoryMethod(chefAmount, patronAmount);
		Controller control = new AController(console);
	
	} 
	
	@Override
	public List<APatron> getPatronList() {
		return patronList;
	}


	@Override
	public List<AChef> getChefList() {
		return chefList;
	}

	@Override
	public BoundedBufferView getBuffer() {
		return bufferView;
	}
	
	private int randomizeDish (int dish) {
		int min = 0;
		int max = 8;
		dish = (int) Math.floor(Math.random()*(max-min+1)+min);
		return dish;
	}
	
	@Override
	public void cook(Head aHead) {
		if (aHead.getImageFileName().charAt(7) == zero) {
			chefList.get(0).chef.getPlate().setImageFileName("images/12.png");
			chefList.get(0).chef.getPlate().setX(130);
			chefList.get(0).chef.getPlate().setY(80);
			chefList.get(0).chef.getPlate().setWidth(10);
			chefList.get(0).chef.getPlate().setHeight(10);
			System.out.println("The height of the plate initial:" + chefList.get(0).chef.getPlate().getHeight());
//			animatePlate(0);
//			testPlate.setX(130);
//			testPlate.setY(80);
//			testPlate.setWidth(40);
//			testPlate.setHeight(40);
			Thread thread = new Thread (command);
			System.out.println("object:");
			thread.start();
			
			System.out.println("The height of the plate initial:" + chefList.get(0).chef.getPlate().getHeight());
			
		} else if (aHead.getImageFileName().charAt(7) == one) {
			
		} else if (aHead.getImageFileName().charAt(7) == four) {
			
		} else if (aHead.getImageFileName().charAt(7) == three) {
			
		}
	}
	
	@Override
	public synchronized void animatePlate(int avatar) {
//		int sleep = 500;
//		Thread a = new Thread();
//		a.start();
//		try {
//			a.join();
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		for (int i=0; i<39; i++) {
//			chefList.get(avatar).chef.getPlate().setHeight(i);
//			chefList.get(avatar).chef.getPlate().setWidth(i);
//			ThreadSupport.sleep(sleep);
//		}
//		Thread.yield();
	}
	
	
	@Override
	@Label("Chef to the table")
	public void chefToTable(Head aHead) {
		int min = 0;
		int max = 8;
		int buffer = bufferView.getBoundedBuffer().get();
		int dish = (int) Math.floor(Math.random()*(max-min+1)+min);
		System.out.println(buffer);
		
		if (buffer == 0 && bufferOccupied[0] == true) {
			System.out.println("Table already occupied!");
		} else if (buffer == 1 && bufferOccupied[1] == true) {
			System.out.println("Table already occupied!");
		} else if (buffer == 2 && bufferOccupied[2] == true) {
			System.out.println("Table already occupied!");
		} else if (buffer == 3 && bufferOccupied[3] == true) {
			System.out.println("Table already occupied!");
		} else if (buffer == 4 && bufferOccupied[4] == true) {
			System.out.println("Table already occupied!");
		} else if (buffer == 5 && bufferOccupied[5] == true) {
			System.out.println("Table already occupied!");
		} else if (buffer == 6 && bufferOccupied[6] == true) {
			System.out.println("Table already occupied!");
		} else if (buffer == 7 && bufferOccupied[7] == true) {
			System.out.println("Table already occupied!");
		}
		
		if (buffer == 0 && bufferOccupied[0] == false) {
			
			if (aHead.getImageFileName().charAt(7) == zero) {
				chefList.get(0).getChef().move(360, 60);
				chefList.get(0).getChef().dropPlate(plateImages[dish]);
				chefList.get(0).getChef().goBack(-360, -60);
				bufferOccupied[0] = true;
			} else if (aHead.getImageFileName().charAt(7) == one) {
				chefList.get(1).getChef().move(430, -15);
				dish = randomizeDish(dish);
				chefList.get(1).getChef().dropPlate(plateImages[dish]);
				bufferOccupied[0] = true;
				chefList.get(1).getChef().goBack(-430,15);
			} else if (aHead.getImageFileName().charAt(7) == four) {
				chefList.get(2).getChef().move(430, -235);
				dish = randomizeDish(dish);
				bufferOccupied[0] = true;
				chefList.get(2).getChef().dropPlate(plateImages[dish]);
				chefList.get(2).getChef().goBack(-430,235);
			} else if (aHead.getImageFileName().charAt(7) == three) {
				chefList.get(3).getChef().move(360, -330);
				dish = randomizeDish(dish);
				bufferOccupied[0] = true;
				chefList.get(3).getChef().dropPlate(plateImages[dish]);
				chefList.get(3).getChef().goBack(-360, 330);
			}
			bufferView.getBoundedBuffer().put(0);
			
		} else if (buffer == 1 && bufferOccupied[1] == false) {
			
			if (aHead.getImageFileName().charAt(7) == zero) {
				chefList.get(0).getChef().move(460, 70);
				bufferOccupied[1] = true;
				dish = randomizeDish(dish);
				chefList.get(0).getChef().dropPlate(plateImages[dish]);
				chefList.get(0).getChef().goBack(-460, -70);
			} else if (aHead.getImageFileName().charAt(7) == one) {
				chefList.get(1).getChef().move(530, -15);
				bufferOccupied[1] = true;
				dish = randomizeDish(dish);
				chefList.get(1).getChef().dropPlate(plateImages[dish]);
				chefList.get(1).getChef().goBack(-530, 15);
			} else if (aHead.getImageFileName().charAt(7) == four) {
				chefList.get(2).getChef().move(530, -235);
				bufferOccupied[1] = true;
				dish = randomizeDish(dish);
				chefList.get(2).getChef().dropPlate(plateImages[dish]);
				chefList.get(2).getChef().goBack(-530, 235);
			} else if (aHead.getImageFileName().charAt(7) == three) {
				chefList.get(3).getChef().move(460, -345);
				bufferOccupied[1] = true;
				dish = randomizeDish(dish);
				chefList.get(3).getChef().dropPlate(plateImages[dish]);
				chefList.get(3).getChef().goBack(-460, 345);
			}
			bufferView.getBoundedBuffer().put(1);
			
		} else if (buffer == 2 && bufferOccupied[2] == false) {
			
			if (aHead.getImageFileName().charAt(7) == zero) {
				chefList.get(0).getChef().move(510, 150);
				bufferOccupied[2] = true;
				dish = randomizeDish(dish);
				chefList.get(0).getChef().dropPlate(plateImages[dish]);
				chefList.get(0).getChef().goBack(-510, -150);
			} else if (aHead.getImageFileName().charAt(7) == one) {
				chefList.get(1).getChef().move(600, 40);
				bufferOccupied[2] = true;
				dish = randomizeDish(dish);
				chefList.get(1).getChef().dropPlate(plateImages[dish]);
				chefList.get(1).getChef().goBack(-600, -40);
			} else if (aHead.getImageFileName().charAt(7) == four) {
				chefList.get(2).getChef().move(580, -150);
				bufferOccupied[2] = true;
				dish = randomizeDish(dish);
				chefList.get(2).getChef().dropPlate(plateImages[dish]);
				chefList.get(2).getChef().goBack(-580, 150);
			} else if (aHead.getImageFileName().charAt(7) == three) {
				chefList.get(3).getChef().move(510, -260);
				bufferOccupied[2] = true;
				dish = randomizeDish(dish);
				chefList.get(3).getChef().dropPlate(plateImages[dish]);
				chefList.get(3).getChef().goBack(-510, 260);
			}
			bufferView.getBoundedBuffer().put(2);
			
		} else if (buffer == 3 && bufferOccupied[3] == false) {
			
			if (aHead.getImageFileName().charAt(7) == zero) {
				chefList.get(0).getChef().move(510, 250);
				bufferOccupied[3] = true;
				dish = randomizeDish(dish);
				chefList.get(0).getChef().dropPlate(plateImages[dish]);
				chefList.get(0).getChef().goBack(-510, -250);
			} else if (aHead.getImageFileName().charAt(7) == one) {
				chefList.get(1).getChef().move(600, 140);
				bufferOccupied[3] = true;
				dish = randomizeDish(dish);
				chefList.get(1).getChef().dropPlate(plateImages[dish]);
				chefList.get(1).getChef().goBack(-600, -140);
			} else if (aHead.getImageFileName().charAt(7) == four) {
				chefList.get(2).getChef().move(580, -75);
				bufferOccupied[3] = true;
				dish = randomizeDish(dish);
				chefList.get(2).getChef().dropPlate(plateImages[dish]);
				chefList.get(2).getChef().goBack(-580, 75);
			} else if (aHead.getImageFileName().charAt(7) == three) {
				chefList.get(3).getChef().move(510, -175);
				bufferOccupied[3] = true;
				dish = randomizeDish(dish);
				chefList.get(3).getChef().dropPlate(plateImages[dish]);
				chefList.get(3).getChef().goBack(-510, 175);
			}
			bufferView.getBoundedBuffer().put(3);
			
		} else if (buffer == 4 && bufferOccupied[4] == false) {
			
			if (aHead.getImageFileName().charAt(7) == zero) {
				chefList.get(0).getChef().move(460, 300);
				bufferOccupied[4] = true;
				dish = randomizeDish(dish);
				chefList.get(0).getChef().dropPlate(plateImages[dish]);
				chefList.get(0).getChef().goBack(-460, -300);
			} else if (aHead.getImageFileName().charAt(7) == one) {
				chefList.get(1).getChef().move(530, 200);
				bufferOccupied[4] = true;
				dish = randomizeDish(dish);
				chefList.get(1).getChef().dropPlate(plateImages[dish]);
				chefList.get(1).getChef().goBack(-530, -200);
			} else if (aHead.getImageFileName().charAt(7) == four) {
				chefList.get(2).getChef().move(530, 0);
				bufferOccupied[4] = true;
				dish = randomizeDish(dish);
				chefList.get(2).getChef().dropPlate(plateImages[dish]);
				chefList.get(2).getChef().goBack(-530, 0);
			} else if (aHead.getImageFileName().charAt(7) == three) {
				chefList.get(3).getChef().move(460, -95);
				bufferOccupied[4] = true;
				dish = randomizeDish(dish);
				chefList.get(3).getChef().dropPlate(plateImages[dish]);
				chefList.get(3).getChef().goBack(-460, 95);
			}
			bufferView.getBoundedBuffer().put(4);
			
		} else if (buffer == 5 && bufferOccupied[5] == false) {
			
			if (aHead.getImageFileName().charAt(7) == zero) {
				chefList.get(0).getChef().move(360, 270);
				bufferOccupied[5] = true;
				dish = randomizeDish(dish);
				chefList.get(0).getChef().dropPlate(plateImages[dish]);
				chefList.get(0).getChef().goBack(-360, -270);
			} else if (aHead.getImageFileName().charAt(7) == one) {
				chefList.get(1).getChef().move(430, 200);
				bufferOccupied[5] = true;
				dish = randomizeDish(dish);
				chefList.get(1).getChef().dropPlate(plateImages[dish]);
				chefList.get(1).getChef().goBack(-430, -200);
			} else if (aHead.getImageFileName().charAt(7) == four) {
				chefList.get(2).getChef().move(430, 0);
				bufferOccupied[5] = true;
				dish = randomizeDish(dish);
				chefList.get(2).getChef().dropPlate(plateImages[dish]);
				chefList.get(2).getChef().goBack(-430, 0);
			} else if (aHead.getImageFileName().charAt(7) == three) {
				chefList.get(3).getChef().move(360, -110);
				bufferOccupied[5] = true;
				dish = randomizeDish(dish);
				chefList.get(3).getChef().dropPlate(plateImages[dish]);
				chefList.get(3).getChef().goBack(-360, 110);
			}
			bufferView.getBoundedBuffer().put(5);
			
		} else if (buffer == 6 && bufferOccupied[6] == false) {
			
			if (aHead.getImageFileName().charAt(7) == zero) {
				chefList.get(0).getChef().move(300, 220);
				bufferOccupied[6] = true;
				dish = randomizeDish(dish);
				chefList.get(0).getChef().dropPlate(plateImages[dish]);
				chefList.get(0).getChef().goBack(-300, -220);
			} else if (aHead.getImageFileName().charAt(7) == one) {
				chefList.get(1).getChef().move(380, 120);
				bufferOccupied[6] = true;
				dish = randomizeDish(dish);
				chefList.get(1).getChef().dropPlate(plateImages[dish]);
				chefList.get(1).getChef().goBack(-380, -120);
			} else if (aHead.getImageFileName().charAt(7) == four) {
				chefList.get(2).getChef().move(380, -80);
				bufferOccupied[6] = true;
				dish = randomizeDish(dish);
				chefList.get(2).getChef().dropPlate(plateImages[dish]);
				chefList.get(2).getChef().goBack(-380, 80);
			} else if (aHead.getImageFileName().charAt(7) == three) {
				chefList.get(3).getChef().move(300, -180);
				bufferOccupied[6] = true;
				dish = randomizeDish(dish);
				chefList.get(3).getChef().dropPlate(plateImages[dish]);
				chefList.get(3).getChef().goBack(-300, 180);
			}
			bufferView.getBoundedBuffer().put(6);
			
		} else if (buffer == 7 && bufferOccupied[7] == false) {
			
			if (aHead.getImageFileName().charAt(7) == zero) {
				chefList.get(0).getChef().move(300, 150);
				bufferOccupied[7] = true;
				dish = randomizeDish(dish);
				chefList.get(0).getChef().dropPlate(plateImages[dish]);
				chefList.get(0).getChef().goBack(-300, -150);
			} else if (aHead.getImageFileName().charAt(7) == one) {
				chefList.get(1).getChef().move(380, 50);
				bufferOccupied[7] = true;
				dish = randomizeDish(dish);
				chefList.get(1).getChef().dropPlate(plateImages[dish]);
				chefList.get(1).getChef().goBack(-380, -50);
			} else if (aHead.getImageFileName().charAt(7) == four) {
				chefList.get(2).getChef().move(380, -160);
				bufferOccupied[7] = true;
				dish = randomizeDish(dish);
				chefList.get(2).getChef().dropPlate(plateImages[dish]);
				chefList.get(2).getChef().goBack(-380, 160);
			} else if (aHead.getImageFileName().charAt(7) == three) {
				chefList.get(3).getChef().move(300, -250);
				bufferOccupied[7] = true;
				dish = randomizeDish(dish);
				chefList.get(3).getChef().dropPlate(plateImages[dish]);
				chefList.get(3).getChef().goBack(-300, 250);
			}
			bufferView.getBoundedBuffer().put(7);
			
		}
		
	}
	
	public boolean preProcessFirstBufferChef() {
		return true;
	}
	
	public void processHeads(Head aHead) {
		System.out.println("Do head" + aHead.getImageFileName());
	}
	
	public boolean preProcessHeads() {
		return true;
	}
	
	@Override
	@Label("Reset")
	public void reset() {
		patronList.clear();
		chefList.clear();
		for (int i=0; i<resetPatronNumber; i++) { 
			APatron patron = new APatron();
			patronList.add(i, patron);
			patron.move(patronXValues[i], patronYValues[i]);
			patron.patron.getHead().setImageFileName(patronImages[i]);
			patron.patron.getArms().removeArms();
		}
		for (int i=0; i<resetChefNumber; i++) {
			AChef chef = new AChef();
			chefList.add(i, chef);
			chef.move(chefXValues[i], chefYValues[i]);
			chef.chef.getHead().setImageFileName(chefImages[i]);
		}
		for (int i=0; i<bufferOccupied.length; i++) {
			bufferOccupied[i] = false;
		}
	}

	@Override
	public void addPropertyChangeListener(PropertyChangeListener arg0) {
		for (int i = 0; i<patronList.size(); i++) {
			patronList.get(i).addPropertyChangeListener(patronList.get(i), arg0);
		}
		for (int i = 0; i<chefList.size(); i++) {
			chefList.get(i).addPropertyChangeListener(chefList.get(i), arg0);
		}
		//bufferView.addPropertyChangeListener(arg0);
	}

	
	
	
	
}
