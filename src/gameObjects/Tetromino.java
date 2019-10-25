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
			toggle--;
			if(toggle % 2 == 0) {
				
				if(verifyRotate(-1, -1, 1, 1, 2, 2)) {
					this.m[0].setTranslate(-1, -1);
					this.m[2].setTranslate(1, 1);
					this.m[3].setTranslate(2, 2);
				} else {
					toggle++;
				}
				
			} else if(toggle % 2 == 1) {
				
				if(verifyRotate(1, 1, -1, -1, -2, -2)) {
					this.m[0].setTranslate(1, 1);
					this.m[2].setTranslate(-1, -1);
					this.m[3].setTranslate(-2, -2);
				} else {
					toggle++;
				}
				
			}
			
		} else if(this.form == 1) {
			
			//Square Piece
			//Nothing
			
		} else if(this.form == 2) {
			
			//L Piece
			toggle--;
			if(toggle % 4 == 0) { //Pointing Down
				
				if(verifyRotate(1, -1, -1, 1, 0, -2)) {
					this.m[0].setTranslate(1, -1);
					this.m[2].setTranslate(-1, 1);
					this.m[3].setTranslate(0, -2);
				} else {
					toggle++;
				}
				
			} else if(toggle % 4 == 1) { //Pointing Right
				
				if(verifyRotate(-1, -1, 1, 1, -2, 0)) {
					this.m[0].setTranslate(-1, -1);
					this.m[2].setTranslate(1, 1);
					this.m[3].setTranslate(-2, 0);
				} else {
					toggle++;
				}
				
			} else if(toggle % 4 == 2) { //Pointing Up
				
				if(verifyRotate(-1, 1, 1, -1, 0, 2)) {
					this.m[0].setTranslate(-1, 1);
					this.m[2].setTranslate(1, -1);
					this.m[3].setTranslate(0, 2);
				} else {
					toggle++;
				}
				
			} else if(toggle % 4 == 3) { //Pointing Left

				if(verifyRotate(1, 1, -1, -1, 2, 0)) {
					this.m[0].setTranslate(1, 1);
					this.m[2].setTranslate(-1, -1);
					this.m[3].setTranslate(2, 0);
				} else {
					toggle++;
				}
				
			}
			
		} else if(this.form == 3) {
			
			//L Piece 2
			toggle--;
			if(toggle % 4 == 0) { //Pointing Down
				
				if(verifyRotate(1, -1, -1, 1, -2, 0)) {
					this.m[0].setTranslate(1, -1);
					this.m[2].setTranslate(-1, 1);
					this.m[3].setTranslate(-2, 0);
				} else {
					toggle++;
				}
				
			} else if(toggle % 4 == 1) { //Pointing Right
				
				if(verifyRotate(-1, -1, 1, 1, 0, 2)) {
					this.m[0].setTranslate(-1, -1);
					this.m[2].setTranslate(1, 1);
					this.m[3].setTranslate(0, 2);
				} else {
					toggle++;
				}
				
			} else if(toggle % 4 == 2) { //Pointing Up
				
				if(verifyRotate(-1, 1, 1, -1, 2, 0)) {
					this.m[0].setTranslate(-1, 1);
					this.m[2].setTranslate(1, -1);
					this.m[3].setTranslate(2, 0);
				} else {
					toggle++;
				}
				
			} else if(toggle % 4 == 3) { //Pointing Left

				if(verifyRotate(1, 1, -1, -1, 0, -2)) {
					this.m[0].setTranslate(1, 1);
					this.m[2].setTranslate(-1, -1);
					this.m[3].setTranslate(0, -2);
				} else {
					toggle++;
				}
				
			}
			
		} else if(this.form == 4) {
			
			//T Piece
			//Toggles
			toggle--;
			if(toggle % 4 == 0) { //Pointing Down
				
				if(verifyRotate(1, -1, -1, 1, -1, -1)) {
					this.m[0].setTranslate(1, -1);
					this.m[2].setTranslate(-1, 1);
					this.m[3].setTranslate(-1, -1);
				} else {
					toggle++;
				}
				
			} else if(toggle % 4 == 1) { //Pointing Right
				
				if(verifyRotate(-1, -1, 1, 1, -1, 1)) {
					this.m[0].setTranslate(-1, -1);
					this.m[2].setTranslate(1, 1);
					this.m[3].setTranslate(-1, 1);
				} else {
					toggle++;
				}
				
			} else if(toggle % 4 == 2) { //Pointing Up
				
				if(verifyRotate(-1, 1, 1, -1, 1, 1)) {
					this.m[0].setTranslate(-1, 1);
					this.m[2].setTranslate(1, -1);
					this.m[3].setTranslate(1, 1);
				} else {
					toggle++;
				}
				
			} else if(toggle % 4 == 3) { //Pointing Left

				if(verifyRotate(1, 1, -1, -1, 1, -1)) {
					this.m[0].setTranslate(1, 1);
					this.m[2].setTranslate(-1, -1);
					this.m[3].setTranslate(1, -1);
				} else {
					toggle++;
				}
				
			}
			
		} else if(this.form == 5) {
		
			//Z Piece
			//Toggles
			toggle--;
			if(toggle % 2 == 0) {
				
				if(verifyRotate(1, -1, -1, 1, 0, 2)) {
					this.m[0].setTranslate(-1, -1);
					this.m[2].setTranslate(-1, 1);
					this.m[3].setTranslate(0, 2);
				} else {
					toggle++;
				}
				
			} else if(toggle % 2 == 1) {
				
				if(verifyRotate(1, 1, 1, -1, 0, -2)) {
					this.m[0].setTranslate(1, 1);
					this.m[2].setTranslate(1, -1);
					this.m[3].setTranslate(0, -2);
				} else {
					toggle++;
				}
				
			}
			
		} else if(this.form == 6) {
			
			//S Piece
			//Toggles
			toggle--;
			if(toggle % 2 == 0) {
				
				if(verifyRotate(-1, 1, 0, -2, -1, -1)) {
					this.m[1].setTranslate(-1, 1);
					this.m[2].setTranslate(0, -2);
					this.m[3].setTranslate(-1, -1);
				} else {
					toggle++;
				}
				
			} else if(toggle % 2 == 1) {
				
				if(verifyRotate(1, -1, 0, 2, 1, 1)) {
					this.m[1].setTranslate(1, -1);
					this.m[2].setTranslate(0, 2);
					this.m[3].setTranslate(1, 1);
				} else {
					toggle++;
				}
				
			}
			
		}
		
	}
	
	public void rotateCcw() {

		if(this.form == 0) {
			
			//I Piece
			toggle++;
			if(toggle % 2 == 0) {
				
				if(verifyRotate(-1, -1, 1, 1, 2, 2)) {
					this.m[0].setTranslate(-1, -1);
					this.m[2].setTranslate(1, 1);
					this.m[3].setTranslate(2, 2);
				} else {
					toggle--;
				}
				
			} else if(toggle % 2 == 1) {
				
				if(verifyRotate(1, 1, -1, -1, -2, -2)) {
					this.m[0].setTranslate(1, 1);
					this.m[2].setTranslate(-1, -1);
					this.m[3].setTranslate(-2, -2);
				} else {
					toggle--;
				}
				
			}
			
		} else if(this.form == 1) {
			
			//Square Piece
			//Nothing
			
		} else if(this.form == 2) {
			
			//L Piece
			toggle++;
			if(toggle % 4 == 0) { //Pointing Down
				
				if(verifyRotate(-1, -1, 1, 1, -2, 0)) {
					this.m[0].setTranslate(-1, -1);
					this.m[2].setTranslate(1, 1);
					this.m[3].setTranslate(-2, 0);
				} else {
					toggle--;
				}
				
			} else if(toggle % 4 == 1) { //Pointing Right
				
				if(verifyRotate(-1, 1, 1, -1, 0, 2)) {
					this.m[0].setTranslate(-1, 1);
					this.m[2].setTranslate(1, -1);
					this.m[3].setTranslate(0, 2);
				} else {
					toggle--;
				}
				
			} else if(toggle % 4 == 2) { //Pointing Up

				if(verifyRotate(1, 1, -1, -1, 2, 0)) {
					this.m[0].setTranslate(1, 1);
					this.m[2].setTranslate(-1, -1);
					this.m[3].setTranslate(2, 0);
				} else {
					toggle--;
				}
				
			} else if(toggle % 4 == 3) { //Pointing Left

				if(verifyRotate(1, -1, -1, 1, 0, -2)) {
					this.m[0].setTranslate(1, -1);
					this.m[2].setTranslate(-1, 1);
					this.m[3].setTranslate(0, -2);
				} else {
					toggle--;
				}
				
			}
			
		} else if(this.form == 3) {
			
			//L Piece 2
			toggle++;
			if(toggle % 4 == 0) { //Pointing Down
				
				if(verifyRotate(-1, -1, 1, 1, 0, 2)) {
					this.m[0].setTranslate(-1, -1);
					this.m[2].setTranslate(1, 1);
					this.m[3].setTranslate(0, 2);
				} else {
					toggle--;
				}
				
			} else if(toggle % 4 == 1) { //Pointing Right
				
				if(verifyRotate(-1, 1, 1, -1, 2, 0)) {
					this.m[0].setTranslate(-1, 1);
					this.m[2].setTranslate(1, -1);
					this.m[3].setTranslate(2, 0);
				} else {
					toggle--;
				}
				
			} else if(toggle % 4 == 2) { //Pointing Up

				if(verifyRotate(1, 1, -1, -1, 0, -2)) {
					this.m[0].setTranslate(1, 1);
					this.m[2].setTranslate(-1, -1);
					this.m[3].setTranslate(0, -2);
				} else {
					toggle--;
				}
				
			} else if(toggle % 4 == 3) { //Pointing Left

				if(verifyRotate(1, -1, -1, 1, -2, 0)) {
					this.m[0].setTranslate(1, -1);
					this.m[2].setTranslate(-1, 1);
					this.m[3].setTranslate(-2, 0);
				} else {
					toggle--;
				}
				
			}
			
		} else if(this.form == 4) {
			
			//T Piece
			//Toggles
			toggle++;
			if(toggle % 4 == 0) { //Pointing Down
				
				if(verifyRotate(-1, -1, 1, 1, -1, -1)) {
					this.m[0].setTranslate(-1, -1);
					this.m[2].setTranslate(1, 1);
					this.m[3].setTranslate(-1, 1);
				} else {
					toggle--;
				}
				
			} else if(toggle % 4 == 1) { //Pointing Right
				
				if(verifyRotate(-1, 1, 1, -1, 1, 1)) {
					this.m[0].setTranslate(-1, 1);
					this.m[2].setTranslate(1, -1);
					this.m[3].setTranslate(1, 1);
				} else {
					toggle--;
				}
				
			} else if(toggle % 4 == 2) { //Pointing Up
				
				if(verifyRotate(1, 1, -1, -1, 1, -1)) {
					this.m[0].setTranslate(1, 1);
					this.m[2].setTranslate(-1, -1);
					this.m[3].setTranslate(1, -1);
				} else {
					toggle--;
				}
				
			} else if(toggle % 4 == 3) { //Pointing Left

				if(verifyRotate(1, -1, -1, 1, -1, -1)) {
					this.m[0].setTranslate(1, -1);
					this.m[2].setTranslate(-1, 1);
					this.m[3].setTranslate(-1, -1);
				} else {
					toggle--;
				}
				
			}
			
		} else if(this.form == 5) {
		
			//Z Piece
			//Toggles
			toggle++;
			if(toggle % 2 == 0) {
				
				if(verifyRotate(-1, -1, -1, 1, 0, 2)) {
					this.m[0].setTranslate(-1, -1);
					this.m[2].setTranslate(-1, 1);
					this.m[3].setTranslate(0, 2);
				} else {
					toggle--;
				}
				
			} else if(toggle % 2 == 1) {
				
				if(verifyRotate(1, 1, 1, -1, 0, -2)) {
					this.m[0].setTranslate(1, 1);
					this.m[2].setTranslate(1, -1);
					this.m[3].setTranslate(0, -2);
				} else {
					toggle--;
				}
				
			}
			
		} else if(this.form == 6) {
			
			//S Piece
			//Toggles
			toggle++;
			if(toggle % 2 == 0) {
				
				if(verifyRotate(-1, 1, 0, -2, -1, -1)) {
					this.m[1].setTranslate(-1, 1);
					this.m[2].setTranslate(0, -2);
					this.m[3].setTranslate(-1, -1);
				} else {
					toggle--;
				}
				
			} else if(toggle % 2 == 1) {
				
				if(verifyRotate(1, 1, -1, -1, -2, -2)) {
					this.m[1].setTranslate(1, -1);
					this.m[2].setTranslate(0, 2);
					this.m[3].setTranslate(1, 1);
				} else {
					toggle--;
				}
				
			}
			
		}
		
	}

	private boolean verifyRotate(int r1, int c1, int r2, int c2, int r3, int c3) {
		
		if(this.m[0].getColumn() + r1 < 0 || this.m[0].getColumn() + c1 > 9)
			return false;
		if(this.m[2].getColumn() + r2 < 0 || this.m[2].getColumn() + c2 > 9)
			return false;
		if(this.m[3].getColumn() + r3 < 0 || this.m[3].getColumn() + c3 > 9)
			return false;
		
		for(int i = 0; i < Main.minoList.size(); i++) {
			if(this.m[0].getColumn() + c1 == Main.minoList.get(i).getColumn() 
			&& this.m[0].getRow() + r1 == Main.minoList.get(i).getRow())
				return false;
			if(this.m[2].getColumn() + c2 == Main.minoList.get(i).getColumn() 
			&& this.m[2].getRow() + r2 == Main.minoList.get(i).getRow())
				return false;
			if(this.m[3].getColumn() + c3 == Main.minoList.get(i).getColumn() 
			&& this.m[3].getRow() + r3 == Main.minoList.get(i).getRow())
				return false;
		}
		
		return true;
		
	}
	
 	public void setTranslate(int row, int column) {
		
		if(verifyTranslate(row, column)) 
			for(int i = 0; i < 4; i++)
				this.m[i].setTranslate(row, column);
		
	}
	
	private boolean verifyTranslate(int row, int column) {
		
		//Test for wall collisions
		for(int i = 0; i < 4; i++) {
			if(this.m[i].getColumn() + column < 0 || this.m[i].getColumn() + column > 9)
				return false;
			for(int j = 0; j < Main.minoList.size(); j++) {
				if(this.m[i].getColumn() + column == Main.minoList.get(j).getColumn() 
				&& this.m[i].getRow() + row == Main.minoList.get(j).getRow())
					return false;
			}
		}
		
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
		
		this.form = form;
		
		this.relativeCooldown = 0;
		
		this.toggle = 200;
		
		this.m = new Mino[4];
		for(int i = 0; i < 4; i++)
			this.m[i] = new Mino(this.form, this.relativePosY[i] + row, this.relativePosX[i] + column);
		
	}
	
}