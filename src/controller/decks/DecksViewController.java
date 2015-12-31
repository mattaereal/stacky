package controller.decks;

import cards.AbstractCard;
import cards.CardDeck;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;

public class DecksViewController {
	@FXML
	private Button buttonAddCardToDeck;
	@FXML
	private Button buttonDeleteCardFromDeck;
	@FXML
	private Button buttonPersist;
	@FXML
	private Button buttonCancel;
	@FXML
	private TableView<AbstractCard> tvCardsDB;
	@FXML
	private TableView<CardDeck> tvDecks;
	@FXML
	private TableView<AbstractCard> tvCardsFromDeck;
	
	@FXML
	public void initialize() {
		
	}
	
	@FXML
	public void addCardToDeckAction() {
		
	}
	
	@FXML
	public void deleteCardFromDeckAction() {
		
	}
	
	@FXML
	public void persistAction() {
		
	}
	
	@FXML
	public void cancelAction() {
		
	}
}
