package controller.game;

import java.util.ArrayList;
import java.util.Optional;

import cards.AbstractCard;
import cards.CardDeck;
import game.Game;
import game.GameCriterion;
import game.Player;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Labeled;
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
	@FXML
	private Text textHiddenCard;
	
	public void setGame() {
		this.game = new Game(player1, player2, cardDeck, gameCrit);
		game.setLimit(gameLimit);
		game.setup();
	}

	public void setGameLimit(int lim) {
		this.gameLimit = lim;
	}
	
	public void setPlayer1(Player p1) {
		if (p1.getName().equals(""))
			p1.setName("Player 1");
		this.player1 = p1; 
		
	}
	
	public void setPlayer2(Player p2) {
		if (p2.getName().equals(""))
			p2.setName("Player 2");
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
		textPlayer1.setText(player1.getName());
		textPlayer2.setText(player2.getName());
	}
	
	@FXML
	public void playHand() {
		textCardsInPool.setText(String.format("%d", game.tiePool.size()));
		textRemainingCardsP1.setText(String.format("%d", player1.getRemainingCards()));
		textRemainingCardsP2.setText(String.format("%d", player2.getRemainingCards()));
		AbstractCard tmp;
		
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
			if (player_turn.equals(player1))
				textPlayer1Card.setText((player1.peek().getAttributes()));
			else
				textPlayer2Card.setText((player2.peek().getAttributes()));
		} else {
			if (!game.hasEnded(player1, player2)) {
				if (player1.hasCards() && player2.hasCards()) {
					String preferedAtrribute = null;
					
					if (player_turn.getgStrategy().isInteractive() && !game.isTie()) {
						preferedAtrribute = getInteractiveAttr(player_turn.peek());
					} 
					
					tmp = getOther(player_turn).peek();
					player_turn.getgStrategy().setupNextPlay(player_turn.peek(), game.getGameRecord(), preferedAtrribute, gameCrit);
					player_turn = game.hand(player_turn, player1, player2, gameCrit);
					textPlayerTurn.setText(player_turn.toString());

					textHiddenCard.setText(tmp.getAttributes());
					
			
					if (player1.hasCards() && player_turn.equals(player1)) {
						textPlayer1Card.setText((player1.peek().getAttributes()));
					} else {
						textPlayer1Card.setText("Nothing to show.");
					}
					
					if (player2.hasCards() && player_turn.equals(player2)) {
						textPlayer2Card.setText((player2.peek().getAttributes()));
					} else {
						textPlayer2Card.setText("Nothing to show.");
					}
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
	
	public String getInteractiveAttr(AbstractCard current) {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Atrribute selection: " + player_turn);
		alert.setContentText("Choose the card attribute you desire to play with.");
		alert.setResizable(true);
		alert.getDialogPane().setPrefSize(850, 200);

		ArrayList<ButtonType> buttons = new ArrayList<ButtonType>();
		ArrayList<String> attributes = new ArrayList<String>();
		
		for(String key: current.getCtype().getAttrs()) {
			buttons.add(new ButtonType(key + ": " + current.getAttribute(key)));
			attributes.add(key);
		}
		
		alert.getButtonTypes().setAll(buttons);

		Optional<ButtonType> result = alert.showAndWait();
		
		while (!result.isPresent()) {
			result = alert.showAndWait();
		}
		
		return attributes.get(buttons.indexOf(result.get()));
	}
	
	public Player getOther(Player p) {
		if (player1.equals(p))
			return player2;
		return player1;
	}

	@FXML
	public void endGame() {
		this.container.setCenter(this.anchorPaneGameProperties);
	}
}
