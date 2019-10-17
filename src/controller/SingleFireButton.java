package controller;

public class SingleFireButton {

	private boolean keyPressed;
	private boolean keyPressing;
	
	public void setTrue() {
		
		keyPressed = true;
		
	}

	public void setFalse() {
	
		keyPressed = false;
		
	}
	
	public boolean getState() {
		
		if(keyPressed && !keyPressing) {
			keyPressing = true;
			return true;
		} else if (!keyPressed) {
			keyPressing = false;
			return false;
		}
		
		return false;
		
	}
	
	public SingleFireButton() {
		
		this.keyPressed = false;
		this.keyPressing = false;
		
	}
	
}
