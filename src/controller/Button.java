package controller;

public class Button {

	private boolean keyPressed;
	
	public void setTrue() {
		
		keyPressed = true;
		
	}

	public void setFalse() {
	
		keyPressed = false;
		
	}
	
	public boolean getState() {
		
		return keyPressed;
		
	}
	
	public Button() {
		
		this.keyPressed = false;
		
	}
	
}
