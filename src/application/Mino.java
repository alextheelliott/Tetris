package application;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Mino {

	private Rectangle mino;
	
	public Rectangle getNode() {
		
		return this.mino;
		
	}
	
	public void setTranslate(int x, int y) {
		
		this.mino.setLayoutX(mino.getLayoutX() + x);
		this.mino.setLayoutY(mino.getLayoutY() + y);
		
	}
	
	public Mino(int x, int y) {
		
		this.mino = new Rectangle(30, 30);
		this.mino.setFill(Color.RED);
		
		this.mino.setLayoutX(5 + x);
		this.mino.setLayoutY(5 + y);
		
	}
	
}
