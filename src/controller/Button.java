package controller;

public class Button {

	private boolean keyPressed;
	
	private final short COOLDOWN = 100;
	private long relativeCooldown;
	
	public void setTrue() {
		
		keyPressed = true;
		
	}

	public void setFalse() {
	
		keyPressed = false;
		
	}
	
	public boolean getState(long now) {
		
		if(this.relativeCooldown < now - this.COOLDOWN)
			return keyPressed;
			
		return false;
		
	}
	
	public void startCooldown(long now) {
		
		this.relativeCooldown = now;
		
	}
	
	public Button() {
		
		this.keyPressed = false;
		
		this.relativeCooldown = 0;
		
	}
	
}
