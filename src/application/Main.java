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
	static ArrayList<Mino> minoList;
	
	public static float controllerDropMod;
	public static float levelDropMod;
	
	static 
	
	public boolean shouldPlace() {
		
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
	
	public void loop(long now) {
		
		if(shouldPlace()) {
			place();
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
			controllerDropMod = 3.0f;
		} else {
			controllerDropMod = 1.0f;
		}
		
		if(currentTetromino.cooledDown(now)) {
			currentTetromino.setTranslate(-1, 0);
			currentTetromino.startCooldown(now);
		}
		
	}
	
	@Override
	public void start(Stage primaryStage) {
		
		root = new Pane();
		scene = new Scene(root, (35 * 15) + 5, (35 * 20) + 5);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		controller = new Controller(scene);
		
		primaryStage.setScene(scene);
		primaryStage.show();
		
		random = new Random();
		
		minoList = new ArrayList<Mino>();
		currentTetromino = new Tetromino((int) (random.nextDouble() * 7), 0, 4);
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