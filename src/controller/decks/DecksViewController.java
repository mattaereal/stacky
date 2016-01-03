package controller.decks;

import java.util.HashMap;

import java.util.Iterator;

import cards.AbstractCard;
import cards.CardDBHandler;
import cards.CardDeck;
import cards.factories.CardDBHandlerFactory;
import cards.factories.CardDeckFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class DecksViewController {
	@FXML
	private Button buttonAddCardToDeck;
	@FXML
	private Button buttonDeleteCardFromDeck;
	@FXML
	private Button buttonPersist;
	@FXML
	private Button buttonClose;
	@FXML
	private TableView<AbstractCard> tvCardsDB;
	@FXML
	private TableView<CardDeck> tvDecks;
	@FXML
	private TableView<AbstractCard> tvCardsFromDeck;
	@FXML
	private TableColumn<AbstractCard, String> itemCardName;
	@FXML
	private TableColumn<AbstractCard, String> itemCardType;
	@FXML
	private TableColumn<AbstractCard, String> itemCardNameR;
	@FXML
	private TableColumn<AbstractCard, String> itemCardTypeR;
	@FXML
	private TableColumn<CardDeck, String> itemCardNameM;
	
	private CardDBHandler cardHandler;
	private final ObservableList<AbstractCard> dataLeft = FXCollections.observableArrayList();
	private final ObservableList<AbstractCard> dataRight = FXCollections.observableArrayList();
	private final ObservableList<CardDeck> dataMid = FXCollections.observableArrayList();
	
	private HashMap<CardDeck, String> deckPath;
	
	@FXML
	public void initialize() {
		deckPath = new HashMap<CardDeck, String>();
	}
	
	@FXML
	public void addCardToDeckAction() {
		AbstractCard card = tvCardsDB.getFocusModel().getFocusedItem();
		CardDeck deck = tvDecks.getFocusModel().getFocusedItem();
		try {
			deck.addCard(card);
			dataRight.add(card);
		} catch (Exception e) {
			dialogError(e + ". Select a card from the DB and a deck where to add it.");
		}
		
	}
	
	@FXML
	public void deleteCardFromDeckAction() {
		AbstractCard card = tvCardsFromDeck.getFocusModel().getFocusedItem();
		CardDeck deck = tvDecks.getFocusModel().getFocusedItem();
		try {
			deck.delCard(card);
			dataRight.remove(card);
		} catch (Exception e) {
			dialogError(e + ". Select a card and a deck from it first.");
		}
	}
	
	@FXML
	public void persistAction() {
		Iterator<CardDeck> it = tvDecks.getItems().iterator();
		CardDeck curr;
		while (it.hasNext()) {
			curr = it.next();
			CardDeckFactory.toFile(deckPath.get(curr), curr);
		}
		
		dataMid.clear();
		dataLeft.clear();
        setData();
	}
	
	@FXML
	public void closeAction() {
		Stage stage = (Stage) buttonClose.getScene().getWindow();
		stage.close();
		
	}
	
	public void setCardsFromDB() {
		itemCardName.setCellValueFactory(
                new PropertyValueFactory<AbstractCard, String>("name"));
 
        itemCardType.setCellValueFactory(
                new PropertyValueFactory<AbstractCard, String>("ctype"));
        
		cardHandler = CardDBHandlerFactory.fromFile();
		Iterator<AbstractCard> it = cardHandler.getList().iterator();
		
		while(it.hasNext()) {
			dataLeft.add(it.next());
		}
		
		tvCardsDB.setItems(dataLeft);
		
	}
	
	public void setCardsFromDeck() {
		itemCardNameR.setCellValueFactory(
                new PropertyValueFactory<AbstractCard, String>("name"));
 
        itemCardTypeR.setCellValueFactory(
                new PropertyValueFactory<AbstractCard, String>("ctype"));
	}
	
	public void setDecks() {
		itemCardNameM.setCellValueFactory(
                new PropertyValueFactory<CardDeck, String>("name"));    
		// TODO: Hardcoded, should be getting them from default folder file.
		
        CardDeck cars = CardDeckFactory.fromFile("db/decks/cars.xml");
        deckPath.put(cars, "db/decks/cars.xml");
        
        CardDeck sh_classic = CardDeckFactory.fromFile("db/decks/superheroes_classic.xml");
        deckPath.put(sh_classic, "db/decks/superheroes_classic.xml");
        
        CardDeck sh = CardDeckFactory.fromFile("db/decks/superheroes.xml");
        deckPath.put(sh, "db/decks/superheroes.xml");
        
        dataMid.add(cars);
        dataMid.add(sh_classic);
        dataMid.add(sh);
        
        tvDecks.setItems(dataMid);
	}
	
	@FXML
	public void updateDeckTable() {
		dataRight.clear();
		CardDeck deck = tvDecks.getSelectionModel().getSelectedItem();
		if (deck != null) {
			Iterator<AbstractCard> it = deck.getDeck().iterator();
			
			while(it.hasNext()) {
				dataRight.add(it.next());
			}
			
	        tvCardsFromDeck.setItems(dataRight);
		}
	}
	
	public void setData() {
		setCardsFromDB();
		setDecks();
		setCardsFromDeck();
	}
	
	public void dialogError(String err) {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Error");
		alert.setContentText(err);
		alert.setResizable(true);

		alert.showAndWait();
	}
}
