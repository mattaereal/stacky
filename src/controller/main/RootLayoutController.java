package controller.main;

import java.io.IOException;

import application.Main;
import controller.cards.CardsViewController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class RootLayoutController {
	@FXML
	private MenuItem mainMenuClose;
	@FXML
	private MenuItem mainMenuCardsView;
	@FXML
	private MenuItem mainMenuDecksView;
	@FXML
	private MenuItem mainMenuAbout;
	@FXML
	private MenuBar mainMenuBar;
	
	@FXML
	public void initialize() {
		
	}
	
	@FXML
	public void openCardsView(){
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("/view/cards/CardsView.fxml"));
		AnchorPane pane = null;
		try {
			pane = loader.load();
		} catch(IOException e){
			e.printStackTrace();
		}
		
		Stage stage = new Stage();
		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.show();
		
	}
	
	@FXML
	public void closeAppAction() {
		Stage stage = (Stage) mainMenuBar.getScene().getWindow();
		stage.close();
	}
	

}
