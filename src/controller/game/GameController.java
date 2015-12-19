package controller.game;

import controller.main.RootLayoutController;
import game.GameCriterion;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

public class GameController {

	private GameCriterion gc;
	private BorderPane container;
	private AnchorPane anchorPaneGameProperties;
	
	public void setGameProperties(GameCriterion gc) {
		this.gc = gc;
	}
	
	public void setBorderPaneContainer(BorderPane container, AnchorPane pane) {
		this.container = container;
		this.anchorPaneGameProperties = pane;
	}
	
	@FXML
	public void endGame() {
		this.container.setCenter(this.anchorPaneGameProperties);
	}
}
