package controller.main;

import java.io.IOException;
import application.Main;
import cards.CardDeck;
import cards.factories.CardDeckFactory;
import game.GameCriterion;
import game.GameCriterionBigger;
import game.Player;
import game.strategies.PlayerAlwaysBiggerStrategy;
import game.strategies.PlayerInteractiveStrategy;
import game.strategies.PlayerRandomStrategy;
import game.strategies.PlayerStaticStrategy;
import game.strategies.PlayerStrategy;
import controller.game.GameController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
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
	private ComboBox<PlayerStrategy> comboBoxStrategyPlayer1;
	@FXML
	private ComboBox<PlayerStrategy> comboBoxStrategyPlayer2;
	@FXML
	private ComboBox<CardDeck> comboBoxDeck;
	@FXML
	private TextField textFieldLimit;
	@FXML
	private TextField textFieldPlayer1;
	@FXML
	private TextField textFieldPlayer2;
	
	@FXML
	public void initialize() {
		// Currently they are all static. But can be loaded with factories from custom folders.
		// Criterion
		comboBoxGameCriterion.getItems().add(new GameCriterionBigger());
		
		// Player1 strategies
		comboBoxStrategyPlayer1.getItems().add(new PlayerAlwaysBiggerStrategy());
		comboBoxStrategyPlayer1.getItems().add(new PlayerStaticStrategy());
		comboBoxStrategyPlayer1.getItems().add(new PlayerRandomStrategy());
		comboBoxStrategyPlayer1.getItems().add(new PlayerInteractiveStrategy());

		// Player2 strategies
		comboBoxStrategyPlayer2.getItems().add(new PlayerAlwaysBiggerStrategy());
		comboBoxStrategyPlayer2.getItems().add(new PlayerStaticStrategy());
		comboBoxStrategyPlayer2.getItems().add(new PlayerRandomStrategy());
		comboBoxStrategyPlayer2.getItems().add(new PlayerInteractiveStrategy());
		
		// Deck
		CardDeck superheroes = CardDeckFactory.fromFile("db/decks/superheroes.xml");
		CardDeck classic_sh = CardDeckFactory.fromFile("db/decks/superheroes_classic.xml");
		CardDeck cars = CardDeckFactory.fromFile("db/decks/cars.xml");
		
		comboBoxDeck.getItems().add(superheroes);
		comboBoxDeck.getItems().add(classic_sh);
		comboBoxDeck.getItems().add(cars);
		
		textFieldLimit.setText("100");
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
		
		GameCriterion gameCriterion = comboBoxGameCriterion.getSelectionModel().getSelectedItem();
		PlayerStrategy player1Strat = comboBoxStrategyPlayer1.getSelectionModel().getSelectedItem();
		PlayerStrategy player2Strat = comboBoxStrategyPlayer2.getSelectionModel().getSelectedItem();
		CardDeck cardDeck = comboBoxDeck.getSelectionModel().getSelectedItem();
		String gameLimit = textFieldLimit.getText();
		String p1name = textFieldPlayer1.getText();
		String p2name = textFieldPlayer2.getText();
		
		
		if ( gameCriterion != null) {
			controller.setGameCriterion(gameCriterion);
		} else {
			controller.setGameCriterion(new GameCriterionBigger());
		}
		
		if (player1Strat != null) {
			Player p1 = new Player(p1name, player1Strat);
			controller.setPlayer1(p1);
		} else {
			Player p1 = new Player(p1name, new PlayerRandomStrategy());
			controller.setPlayer1(p1);
		}
		
		if (player2Strat != null) {
			Player p2 = new Player(p2name, player2Strat);
			controller.setPlayer2(p2);
		} else {
			Player p2 = new Player(p2name, new PlayerRandomStrategy());
			controller.setPlayer2(p2);
		}
		
		if (cardDeck != null) {
			controller.setCardDeck(cardDeck);
		} else {
			controller.setCardDeck(CardDeckFactory.fromFile("db/decks/superheroes.xml"));
		}
		
		if ( !gameLimit.equals("")) {
			System.out.println(gameLimit);
			int lim = Integer.parseInt(gameLimit);
			controller.setGameLimit(lim);
		} else {
			controller.setGameLimit(100);
		}

		controller.loadGame();
		borderPaneContainer.setCenter(pane);
	}
	

}
