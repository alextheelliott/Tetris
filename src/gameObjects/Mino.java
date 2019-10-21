package gameObjects;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Mino {

	private Rectangle mino;
	
	private int row, column;
	
	public Rectangle getNode() {
		
		return this.mino;
		
	}
	
	public int getRow() {
		
		return this.row;
		
	}
	
	public int getColumn() {
		
		return this.column;
		
	}
	
	public void setTranslate(int row, int column) {
		
		this.row += row;
		this.column += column;
		
		this.mino.setLayoutX(mino.getLayoutX() + (column * 35));
		this.mino.setLayoutY(mino.getLayoutY() + (row * -35));
		
	}
	
	public Mino(int row, int column) {
		
		this.mino = new Rectangle(30, 30);
		this.mino.setFill(Color.RED);
		
		this.mino.setLayoutX(5 + (column * 35));
		this.mino.setLayoutY(5 + (row * 35));
		
		this.row = -row;
		this.column = column;
		
	}
	
}