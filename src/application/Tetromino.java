package application;

import javafx.scene.shape.Rectangle;

public class Tetromino {

	Mino[] m;
	
	int[] relativePosX = new int[4];
	int[] relativePosY = new int[4];
	
	public Rectangle[] getNodes() {
		
		Rectangle[] out = new Rectangle[4];
		for(int i = 0; i < 4; i++)
			out[i] = this.m[i].getNode();
		
		return out;
		
	}
	
	public void setTranslate(int x, int y) {
		
		for(int i = 0; i < 4; i++)
			this.m[i].setTranslate(x, y);
		
	}
	
	public void calcRelativeForm(int form) {
	
		if(form == 0) { //I Piece
			relativePosX[0] = 0;
			relativePosY[0] = 0;
			relativePosX[1] = 1;
			relativePosY[1] = 0;
			relativePosX[2] = 2;
			relativePosY[2] = 0;
			relativePosX[3] = 3;
			relativePosY[3] = 0;
		} else if(form == 1) { //Square Piece
			relativePosX[0] = 0;
			relativePosY[0] = 0;
			relativePosX[1] = 1;
			relativePosY[1] = 0;
			relativePosX[2] = 0;
			relativePosY[2] = 1;
			relativePosX[3] = 1;
			relativePosY[3] = 1;
		} else if(form == 2) { //L Piece
			relativePosX[0] = 0;
			relativePosY[0] = 0;
			relativePosX[1] = 1;
			relativePosY[1] = 0;
			relativePosX[2] = 2;
			relativePosY[2] = 0;
			relativePosX[3] = 0;
			relativePosY[3] = 1;
		} else if(form == 3) { //L Piece 2
			relativePosX[0] = 0;
			relativePosY[0] = 0;
			relativePosX[1] = 1;
			relativePosY[1] = 0;
			relativePosX[2] = 2;
			relativePosY[2] = 0;
			relativePosX[3] = 2;
			relativePosY[3] = 1;
		} else if(form == 4) { //T Piece
			relativePosX[0] = 0;
			relativePosY[0] = 0;
			relativePosX[1] = 1;
			relativePosY[1] = 0;
			relativePosX[2] = 2;
			relativePosY[2] = 0;
			relativePosX[3] = 1;
			relativePosY[3] = 1;
		} else if(form == 5) { //Z Piece
			relativePosX[0] = 0;
			relativePosY[0] = 0;
			relativePosX[1] = 1;
			relativePosY[1] = 0;
			relativePosX[2] = 1;
			relativePosY[2] = 1;
			relativePosX[3] = 2;
			relativePosY[3] = 1;
		} else if(form == 6) { //S Piece
			relativePosX[0] = 1;
			relativePosY[0] = 0;
			relativePosX[1] = 2;
			relativePosY[1] = 0;
			relativePosX[2] = 0;
			relativePosY[2] = 1;
			relativePosX[3] = 1;
			relativePosY[3] = 1;
		}
		
	}
	
	public Tetromino(int form) {
		
		calcRelativeForm(form);
		
		m = new Mino[4];
		
		for(int i = 0; i < 4; i++)
			this.m[i] = new Mino(35 * relativePosX[i], 35 * relativePosY[i]);
		
	}
	
}
