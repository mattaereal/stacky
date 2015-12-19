package controller.main;

import java.io.IOException;

import application.Main;
import game.GameCriterion;
import game.GameCriterionBigger;
import controller.game.GameController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class RootLayoutController {
	
	@FXML
	private AnchorPane anchorPaneGameProperties;
	
	@FXML
	private BorderPane borderPaneContainer;
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
	private ComboBox<GameCriterion> comboBoxGameCriterion;
	@FXML
	private ComboBox<String> comboBoxStrategyPlayer;
	@FXML
	private ComboBox<String> comboBoxStrategyCPU;
	@FXML
	private ComboBox<String> comboBoxDeck;
	
	@FXML
	public void initialize() {
		comboBoxGameCriterion.getItems().add(new GameCriterionBigger());
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
	
	@FXML
	public void startGame() {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("/view/game/GameView.fxml"));
		BorderPane pane = null;
		try {
			pane = loader.load();
		} catch(IOException e){
			e.printStackTrace();
		}
		
		GameController controller = loader.getController();
		controller.setBorderPaneContainer(borderPaneContainer, anchorPaneGameProperties);
		
		if (comboBoxGameCriterion.getSelectionModel().getSelectedItem() != null) {
			controller.setGameProperties(comboBoxGameCriterion.getSelectionModel().getSelectedItem());
		} else {
			//Default behaviour
			controller.setGameProperties(new GameCriterionBigger());
		}

		borderPaneContainer.setCenter(pane);
	}
	

}
