package application;

import java.io.IOException;
import java.util.logging.Logger;

import controller.cards.CardsViewController;
import controller.main.RootLayoutController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

//import cards.*;
//import game.*;


public class Main extends Application {
	
	private BorderPane rootLayout = null;
	
	static Logger logger = Logger.getLogger(Main.class.getName());
	
	public static void main(String[] args) {
		logger.info("Entering application.");
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		loadRootLayout(stage);
	}	
	
	private void loadRootLayout(Stage stage) {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("/view/main/RootLayout.fxml"));
		BorderPane pane = null;
		try {
			pane = (BorderPane)loader.load();
		} catch(IOException e) {
			e.printStackTrace();
		}
		RootLayoutController controller = loader.getController();
		rootLayout = pane;
		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.show();
	}
	
}
