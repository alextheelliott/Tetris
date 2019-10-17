package application;

import controller.Controller;
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
	
	Tetromino t;
	
	public void loop(long now) {
		
		if(Controller.upButton.getState() && now % 1000 == 0) {
			t.setTranslate(35, 0);
		}
		
	}
	
	@Override
	public void start(Stage primaryStage) {
		
		root = new Pane();
		scene = new Scene(root, 600, 600);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		
		controller = new Controller(scene);
		
		primaryStage.setScene(scene);
		primaryStage.show();
		
		t = new Tetromino(0);
		root.getChildren().addAll(t.getNodes());
		
		timer = new AnimationTimer() {
			@Override
			public void handle(long now) {
				loop(now);
			}
		};
		timer.start();
	
	}
	
	public static void main(String[] args) {
		
		launch(args);
		
	}
	
}
