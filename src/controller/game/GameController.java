package controller.game;

import cards.AbstractCard;
import cards.CardDeck;
import controller.main.RootLayoutController;
import game.Game;
import game.GameCriterion;
import game.Player;
import game.strategies.PlayerInteractiveStrategy;
import game.strategies.PlayerStrategy;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;

public class GameController {

	private Game game;
	private Player player1;
	private Player player2;
	private Player player_turn;
	private CardDeck cardDeck;
	private GameCriterion gameCrit;
	private Boolean firstHand = true;
	private int gameLimit;
	
	@FXML
	private BorderPane container;
	
	@FXML
	private AnchorPane anchorPaneGameProperties;
	
	@FXML
	private Text textPlayer1Card;
	
	@FXML
	private Text textPlayer2Card;
	
	@FXML
	private Text textPlayer1;
	
	@FXML
	private Text textPlayer2;
	
	@FXML
	private Text textPlayerTurn;
	
	@FXML
	private Text textPlayerWon;
	
	@FXML
	private Text textRemainingCardsP1;
	
	@FXML
	private Text textRemainingCardsP2;
	
	@FXML
	private Text textCardsInPool;
	
	@FXML
	private Button buttonHand;
	
	public void setGame() {
		this.game = new Game(player1, player2, cardDeck, gameCrit);
		game.setLimit(gameLimit);
		game.setup();
	}

	public void setGameLimit(int lim) {
		this.gameLimit = lim;
	}
	
	public void setPlayer1(Player p1) {
		this.player1 = p1;
	}
	
	public void setPlayer2(Player p2) {
		this.player2 = p2;
	}
	
	public void setCardDeck(CardDeck cd) {
		this.cardDeck = cd;
	}
	
	public void setGameCriterion(GameCriterion gc) {
		this.gameCrit = gc;
	}
	
	public void setBorderPaneContainer(BorderPane container, AnchorPane pane) {
		this.container = container;
		this.anchorPaneGameProperties = pane;
	}
	
	@FXML
	public void initialize() {
		
	}
	
	public void loadGame() {
		setGame();
		textPlayer1Card.setText((player1.peek().getAttributes()));
		textPlayer2Card.setText((player2.peek().getAttributes()));
		textPlayer1.setText(player1.toString());
		textPlayer2.setText(player2.toString());
	}
	
	@FXML
	public void playHand() {
		textCardsInPool.setText(String.format("%d", game.tiePool.size()));
		textRemainingCardsP1.setText(String.format("%d", player1.getRemainingCards()));
		textRemainingCardsP2.setText(String.format("%d", player2.getRemainingCards()));
		if (firstHand) {
			firstHand = false;
			int min = 0;
			int max = 100;
			int rand = min + (int)(Math.random() * ((max - min) + 1));
			
			if (rand < 50) {
				player_turn = player1;
			} else {
				player_turn = player2;
			}
			
			textPlayerTurn.setText(player_turn.toString());
			textPlayer1Card.setText((player1.peek().getAttributes()));
			textPlayer2Card.setText((player2.peek().getAttributes()));
		} else {
			if (game.getHandCount() < game.getLimit()) {
				if (player1.hasCards() && player2.hasCards()) {
					player_turn = game.hand(player_turn, player1, player2, gameCrit);
					textPlayerTurn.setText(player_turn.toString());
					// Si justo se queda sin cartas después de jugar revienta.
					textPlayer1Card.setText((player1.peek().getAttributes()));
					textPlayer2Card.setText((player2.peek().getAttributes()));
				} else if (player1.hasCards()) {
					textPlayerWon.setText(player1.toString());
				} else if (player2.hasCards()) {
					textPlayerWon.setText(player2.toString());
				} else {
					throw new RuntimeException("Something happened @ game play.");
				}
			} else {
				if (player1.getRemainingCards() > player2.getRemainingCards()) {
					textPlayerWon.setText(player1.toString());
				} else if (player1.getRemainingCards() < player2.getRemainingCards()) {
					textPlayerWon.setText(player2.toString());
				} else {
					textPlayerWon.setText("Tie!");
				}
			}
		}
	}

	@FXML
	public void endGame() {
		this.container.setCenter(this.anchorPaneGameProperties);
	}
}
