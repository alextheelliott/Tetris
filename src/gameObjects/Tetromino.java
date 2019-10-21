package gameObjects;

import application.Main;
import javafx.scene.shape.Rectangle;

public class Tetromino {

	private Mino[] m;
	
	private int[] relativePosX, relativePosY;
	
	private int form;
	
	private final short COOLDOWN = 800;
	private long relativeCooldown;
	
	private int toggle;
	
	public Mino getMino(int i) {
		
		return this.m[i];
		
	}
	
	public Rectangle[] getNodes() {
		
		Rectangle[] out = new Rectangle[4];
		for(int i = 0; i < 4; i++)
			out[i] = this.m[i].getNode();
		
		return out;
		
	}
	
	public void rotateCw() {
		
		if(this.form == 0) {
			
			//I Piece
			
		} else if(this.form == 1) {
			
			//Square Piece
			//Nothing
			
		} else if(this.form == 2) {
			
			//L Piece
			
		} else if(this.form == 3) {
			
			//L Piece 2
			
		} else if(this.form == 4) {
			
			//T Piece
			
		} else if(this.form == 5) {
			
			//S Piece
			//Toggles
			if(toggle % 2 == 0) {
				
				toggle++;
				
			} else if(toggle % 2 == 1) {
				
				toggle++;
				
			}
			
		} else if(this.form == 6) {
			
			//Z Piece
			//Toggles
			if(toggle % 2 == 0) {
				
				
				
			} else if(toggle % 2 == 1) {
				
				
				
			}
			
		}
		
	}
	
	public void rotateCcw() {
		
	}
	
	public void setTranslate(int row, int column) {
		
		if(verifyTranslate(row, column)) 
			for(int i = 0; i < 4; i++)
				this.m[i].setTranslate(row, column);
		
	}
	
	public boolean verifyTranslate(int row, int column) {
		
		//Test for wall collisions
		for(int i = 0; i < 4; i++)
			if(this.m[i].getColumn() + column < 0 || this.m[i].getColumn() + column > 9)
				return false;
		
		return true;
	
	}
	
	public void startCooldown(long now) {
		
		this.relativeCooldown = now;
		
	}
	
	public boolean cooledDown(long now) {
		
		if(this.relativeCooldown < now  - (this.COOLDOWN / (Main.controllerDropMod * Main.levelDropMod)))
			return true;
			
		return false;
		
	}
	
	public void calcRelativeForm(int form) {
	
		if(form == 0) { //I Piece
			this.relativePosX[0] = 0;
			this.relativePosY[0] = 0;
			this.relativePosX[1] = 1;
			this.relativePosY[1] = 0;
			this.relativePosX[2] = 2;
			this.relativePosY[2] = 0;
			this.relativePosX[3] = 3;
			this.relativePosY[3] = 0;
		} else if(form == 1) { //Square Piece
			this.relativePosX[0] = 0;
			this.relativePosY[0] = 0;
			this.relativePosX[1] = 1;
			this.relativePosY[1] = 0;
			this.relativePosX[2] = 0;
			this.relativePosY[2] = 1;
			this.relativePosX[3] = 1;
			this.relativePosY[3] = 1;
		} else if(form == 2) { //L Piece
			this.relativePosX[0] = 0;
			this.relativePosY[0] = 0;
			this.relativePosX[1] = 1;
			this.relativePosY[1] = 0;
			this.relativePosX[2] = 2;
			this.relativePosY[2] = 0;
			this.relativePosX[3] = 0;
			this.relativePosY[3] = 1;
		} else if(form == 3) { //L Piece 2
			this.relativePosX[0] = 0;
			this.relativePosY[0] = 0;
			this.relativePosX[1] = 1;
			this.relativePosY[1] = 0;
			this.relativePosX[2] = 2;
			this.relativePosY[2] = 0;
			this.relativePosX[3] = 2;
			this.relativePosY[3] = 1;
		} else if(form == 4) { //T Piece
			this.relativePosX[0] = 0;
			this.relativePosY[0] = 0;
			this.relativePosX[1] = 1;
			this.relativePosY[1] = 0;
			this.relativePosX[2] = 2;
			this.relativePosY[2] = 0;
			this.relativePosX[3] = 1;
			this.relativePosY[3] = 1;
		} else if(form == 5) { //Z Piece
			this.relativePosX[0] = 0;
			this.relativePosY[0] = 0;
			this.relativePosX[1] = 1;
			this.relativePosY[1] = 0;
			this.relativePosX[2] = 1;
			this.relativePosY[2] = 1;
			this.relativePosX[3] = 2;
			this.relativePosY[3] = 1;
		} else if(form == 6) { //S Piece
			this.relativePosX[0] = 1;
			this.relativePosY[0] = 0;
			this.relativePosX[1] = 2;
			this.relativePosY[1] = 0;
			this.relativePosX[2] = 0;
			this.relativePosY[2] = 1;
			this.relativePosX[3] = 1;
			this.relativePosY[3] = 1;
		}
		
	}
	
	public Tetromino(int form, int row, int column) {
		
		this.relativePosX = new int[4];
		this.relativePosY = new int[4];
		calcRelativeForm(form);
		
		this.m = new Mino[4];
		for(int i = 0; i < 4; i++)
			this.m[i] = new Mino(relativePosY[i] + row, relativePosX[i] + column);
		
		this.form = form;
		
		this.relativeCooldown = 0;
		
		this.toggle = 0;
		
	}
	
}