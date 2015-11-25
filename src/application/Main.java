package application;

//import java.io.IOException;

import cards.CardDeck;
import cards.CardDeckFactory;
import game.Game;
import game.GameCriterion;
import game.GameCriterionBigger;
import game.GameStrategy;
import game.InteractiveStrategy;
import game.Player;
import game.RandomStrategy;
//import javafx.application.Application;
//import javafx.fxml.FXMLLoader;
//import javafx.scene.Scene;
//import javafx.scene.control.Button;
//import javafx.scene.layout.AnchorPane;
//import javafx.scene.layout.StackPane;
//import javafx.stage.Stage;

public class Main {
	
	public static void main(String[] args) {
		
		GameStrategy interactive = new InteractiveStrategy();
		GameStrategy random = new RandomStrategy();
		
		Player p1 = new Player("Matt", interactive); //Se pregunta por prompt (user)
		Player p2 = new Player("CPU", random); //Siempre atrib aleatorio
		
		GameCriterion gCrit = new GameCriterionBigger();
		CardDeck filedeck = CardDeckFactory.fromFile("decks/DeckTest1.xml");
		Game g = new Game(p1, p2, filedeck, gCrit);
		g.start();
		
	}
	
//public class Main extends Application {
//	Button button;
//	
//	public static void main(String[] args) {
//		launch(args);
//	}

//	@Override
//	public void start(Stage primaryStage) throws Exception {
//		primaryStage.setTitle("Probando");
//		button = new Button();
//		button.setText("Click");
//		
//		StackPane layout = new StackPane();
//		layout.getChildren().add(button);
//		
//		Scene scene = new Scene(layout, 300, 250);
//		primaryStage.setScene(scene);
//		primaryStage.show();
//	}
//	
//	public void start(Stage stage) {
//		FXMLLoader loader = new FXMLLoader();
//		loader.setLocation(Main.class.getResource("main.fxml"));
//		AnchorPane anchor = null;
//		try {
//			anchor = (AnchorPane) loader.load();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		
//		TextController controller = loader.getController();
//		Scene scene = new Scene(anchor);
//		stage.setScene(scene);
//		stage.setTitle("Probado");
//		stage.show();
//	}
	
	
}
