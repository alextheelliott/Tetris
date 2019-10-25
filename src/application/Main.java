package application;

import java.util.ArrayList;
import java.util.Random;

import controller.Controller;
import gameObjects.Mino;
import gameObjects.Tetromino;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;

public class Main extends Application {
	
	static Pane root;
	static Scene scene;
	static Controller controller;
	static AnimationTimer timer;
	
	static Random random;
	
	static Tetromino currentTetromino;
	public static ArrayList<Mino> minoList;
	
	public static float controllerDropMod;
	public static float levelDropMod;
	
	static public boolean shouldPlace() {
		
		for(int i = 0; i < 4; i++) {
			if(currentTetromino.getMino(i).getRow() == -19) {
				return true;
			}
		}
		
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < Main.minoList.size(); j++) {
				if(currentTetromino.getMino(i).getColumn() == Main.minoList.get(j).getColumn() &&
						currentTetromino.getMino(i).getRow() - 1 == Main.minoList.get(j).getRow())
					return true;
			}
		}
		
		return false;
		
	}
	
	static public void place() {
		
		for(int i = 0; i < 4; i++) {
			minoList.add(currentTetromino.getMino(i));
		}
		currentTetromino = null;
		currentTetromino = new Tetromino((int) (random.nextDouble() * 7), 0, 4);
		root.getChildren().addAll(currentTetromino.getNodes());
		
	}
	
	public boolean anyFullRows() {
		
		int[] rows = new int[20];
		
		for(int i = 0; i < minoList.size(); i++)
			for(int j = 0; j < 20; j++)
				if(minoList.get(i).getRow() == (-19 + j))
					rows[j]++;
		
		for(int i = 0; i < 20; i++)
			if(rows[i] == 10)
				return true;
		
		return false;
		
	}
	
	public void deleteFullRows() {
		
		int[] rows = new int[20];
		int[] rowsRemoved = new int[4];
		int rowRemovedIndex = 0;
		
		for(int i = 0; i < minoList.size(); i++)
			for(int j = 0; j < 20; j++)
				if(minoList.get(i).getRow() == (-19 + j))
					rows[j]++;
		
		for(int i = 0; i < 20; i++) { //Goes through the rows
			if(rows[i] == 10) { //If the row is full
				rowsRemoved[rowRemovedIndex++] = (-19 + i);
				for(int j = 0; j < minoList.size(); j++) { //Goes through all the minos
					if(minoList.get(j).getRow() == (-19 + i)) { //If the minos have the right row
						minoList.get(j).setTranslate(-100, 0);
						minoList.remove(j--);
					}
				}
			}
		}
			
		for(int i = 0; i < rowRemovedIndex; i++)
			for(int j = 0; j < minoList.size(); j++)
				if(minoList.get(j).getRow() > rowsRemoved[i] - i)
					minoList.get(j).setTranslate(-1, 0);
		
	}
	
	public void loop(long now) {
		
		deleteFullRows();
		
		if(Controller.xButton.getState()) {
			currentTetromino.rotateCw();
		}
		
		if(Controller.zButton.getState()) {
			currentTetromino.rotateCcw();
		}
		
		if(Controller.leftButton.getState(now)) {
			currentTetromino.setTranslate(0, -1);
			Controller.leftButton.startCooldown(now);
		}
		
		if(Controller.rightButton.getState(now)) {
			currentTetromino.setTranslate(0, 1);
			Controller.rightButton.startCooldown(now);
		}
		
		if(Controller.downButton.getState(now)) {
			controllerDropMod = 15.0f;
		} else {
			controllerDropMod = 1.0f;
		}
		
		if(currentTetromino.cooledDown(now)) {
			if(shouldPlace())
				place();
			currentTetromino.setTranslate(-1, 0);
			currentTetromino.startCooldown(now);
		}
		
	}
	
	@Override
	public void start(Stage primaryStage) {
		
		root = new Pane();
		scene = new Scene(root, (35 * 10) + 5, (35 * 20) + 5);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		controller = new Controller(scene);
		
		primaryStage.setScene(scene);
		primaryStage.show();
		
		random = new Random();
		
		minoList = new ArrayList<Mino>();
		currentTetromino = new Tetromino((int) (random.nextDouble() * 7), 0, 4); //random.nextDouble() * 7
		root.getChildren().addAll(currentTetromino.getNodes());
		
		controllerDropMod = 1.0f;
		levelDropMod = 1.0f;
		
		timer = new AnimationTimer() {
			@Override
			public void handle(long now) {
				loop((long) (now/(1e6)));
			}
		};
		timer.start();
	
	}
	
	public static void main(String[] args) {
		
		launch(args);
		
	}
	
}