package application;

import java.io.IOException;
import java.util.logging.Logger;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class Main extends Application {
		
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

		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.show();
	}
	
}
