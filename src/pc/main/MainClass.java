package pc.main;

import java.awt.BorderLayout;
import java.awt.Component;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import bus.uigen.OEFrame;
import bus.uigen.ObjectEditor;
import bus.uigen.attributes.AttributeNames;
import bus.uigen.test.AFunctionTester;
import bus.uigen.widgets.VirtualComponent;
import pc.controls.AController;
import pc.controls.ConsoleSceneView;
import pc.controls.Controller;
import pc.controls.Painter;
import pc.factories.AFactory;
import pc.graphics.AButtonArrayScene;
import pc.graphics.AChef;
import pc.graphics.ACircle;
import pc.graphics.ALine;
import pc.graphics.APatron;
import pc.graphics.AProducerConsumerScene;
import pc.graphics.AScene;
import pc.graphics.AnAngle;
import pc.graphics.AnAvatar;
import pc.graphics.Angle;
import pc.graphics.Avatar;
import pc.graphics.Line;
import pc.graphics.ProducerConsumerScene;
import pc.graphics.Scene;
import util.misc.Console;

public class MainClass {
	static ProducerConsumerScene scene = AFactory.arrayBasedSceneFactoryMethod();
	static ProducerConsumerScene scene1 = new AButtonArrayScene();

	public static void main(String[] args) {
		
//		animateGraphics();
//		animateArrayUse();
		animateArrayUseInteractive();
	}
	
	public static void animateGraphics() {
		Scene Restaurant = new AScene();
		OEFrame editor = ObjectEditor.edit(Restaurant);
		editor.showDrawPanel();
		editor.showTreePanel();
//		Component c = editor.getDrawComponent();
//		VirtualComponent v = editor.getDrawVirtualComponent();
//		c.addMouseListener(null);

		
	}

	public static void animateArrayUseInteractive() {

		ObjectEditor.confirmSelectedMethodParameters(false);
		ObjectEditor.setMethodAttribute(AProducerConsumerScene.class, "initScene", AttributeNames.TOOLBAR_METHOD, true);
		ObjectEditor.setMethodAttribute(AProducerConsumerScene.class, "initScene", AttributeNames.LABEL, "Init Scene");
		ObjectEditor.setMethodAttribute(AProducerConsumerScene.class, "chefToTable", AttributeNames.TOOLBAR_METHOD, true);
		ObjectEditor.setMethodAttribute(AProducerConsumerScene.class, "chefToTable", AttributeNames.LABEL, "Chef to the table");
		ObjectEditor.setMethodAttribute(AProducerConsumerScene.class, "reset", AttributeNames.TOOLBAR_METHOD, true);
		ObjectEditor.setMethodAttribute(AProducerConsumerScene.class, "reset", AttributeNames.LABEL, "Reset");



		try {
			Class[] initSceneArgTypes = {Integer.TYPE, Integer.TYPE};
			Object[] initSceneDefaultArgs = {1, 4};
			String[] initSceneArgNames = {"number of patrons", "number of chefs"};

			Method initSceneMethod = AProducerConsumerScene.class.getMethod("initScene", initSceneArgTypes);
			ObjectEditor.registerDefaultParameterValues(initSceneMethod, initSceneDefaultArgs);
			ObjectEditor.registerParameterNames(initSceneMethod, initSceneArgNames);

		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		OEFrame editor = ObjectEditor.edit(scene);
		//editor.hideMainPanel();
		editor.showDrawPanel();
		editor.showToolBar();
		
//		JFrame frame = new JFrame();
//		//frame.add((Component) console, BorderLayout.CENTER);
//		frame.setSize(1000, 1000);
//		frame.setVisible(true);
		
	
		
//		JPanel panel = new JPanel();
//		JButton button1 = control.getChefToBuffer();
//		panel.add(button1);
//		frame.add(panel);
	}
	
	public static void animatePainterTwo(Painter view) {
		JFrame aFrame = new JFrame();
		aFrame.add((Component) view, BorderLayout.CENTER);
		aFrame.setSize(1000, 1000);
		aFrame.setVisible(true);
		JPanel panel = new JPanel();
		aFrame.add(panel, BorderLayout.NORTH);
	}
	
	public static void moveAvatar() {
		System.out.println("test1");
		scene.getChefList().get(2).getChef().move(30, 0);
		scene.getChefList().get(2).getStove().move(10, 0);
		System.out.println("Moving the stove: \n");
		scene.getChefList().get(3).getStove().move(30, 30);
	}

}
