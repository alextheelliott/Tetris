package controller;

import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;

public class Controller {

	public static Button upButton, leftButton, rightButton, downButton; 
	public static SingleFireButton zButton, xButton, cButton, vButton;
	
	public static void controlReg(Scene s) {
		
		s.addEventHandler(KeyEvent.KEY_PRESSED, event -> {
			if (event.getCode().toString().equals("UP"))
				upButton.setTrue();
			if (event.getCode().toString().equals("LEFT"))
				leftButton.setTrue();
			if (event.getCode().toString().equals("RIGHT"))
				rightButton.setTrue();
			if (event.getCode().toString().equals("DOWN"))
				downButton.setTrue();
			if (event.getCode().toString().equals("Z"))
				zButton.setTrue();
			if (event.getCode().toString().equals("X"))
				xButton.setTrue();
			if (event.getCode().toString().equals("C"))
				cButton.setTrue();	
			if (event.getCode().toString().equals("V"))
				vButton.setTrue();
		});
		
		s.addEventHandler(KeyEvent.KEY_RELEASED, event -> {
			if (event.getCode().toString().equals("UP"))
				upButton.setFalse();
			if (event.getCode().toString().equals("LEFT"))
				leftButton.setFalse();
			if (event.getCode().toString().equals("RIGHT"))
				rightButton.setFalse();
			if (event.getCode().toString().equals("DOWN"))
				downButton.setFalse();
			if (event.getCode().toString().equals("Z"))
				zButton.setFalse();
			if (event.getCode().toString().equals("X"))
				xButton.setFalse();
			if (event.getCode().toString().equals("C"))
				cButton.setFalse();	
			if (event.getCode().toString().equals("V"))
				vButton.setFalse();		
		});
	
	}
	
	public Controller(Scene s) {
		
		upButton = new Button();
		leftButton = new Button();
		rightButton = new Button();
		downButton = new Button();
		zButton = new SingleFireButton();
		xButton = new SingleFireButton();
		cButton = new SingleFireButton();
		vButton = new SingleFireButton();
		
		controlReg(s);
		
	}
	
}
