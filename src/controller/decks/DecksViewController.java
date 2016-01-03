package controller.decks;

import java.util.Iterator;

import cards.AbstractCard;
import cards.CardDBHandler;
import cards.CardDeck;
import cards.factories.CardDBHandlerFactory;
import cards.factories.CardDeckFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

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
	private TableColumn<AbstractCard, String> itemCardName;
	@FXML
	private TableColumn<AbstractCard, String> itemCardType;
	@FXML
	private TableColumn<AbstractCard, String> itemCardNameR;
	@FXML
	private TableColumn<AbstractCard, String> itemCardTypeR;
	@FXML
	private TableColumn<CardDeck, String> itemCardNameM;
	@FXML
	private TableColumn<CardDeck, String> itemCardTypeM;
	
	private CardDBHandler cardHandler;
	private final ObservableList<AbstractCard> dataLeft = FXCollections.observableArrayList();
	private final ObservableList<AbstractCard> dataRight = FXCollections.observableArrayList();
	private final ObservableList<CardDeck> dataMid = FXCollections.observableArrayList();
	
	@FXML
	public void initialize() {
		setCardsFromDB();
		

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
 
        itemCardTypeM.setCellValueFactory(
                new PropertyValueFactory<CardDeck, String>("ctype"));
        
        CardDeck test = CardDeckFactory.fromFile("db/decks/DeckTest1.xml");
        CardDeck cars = CardDeckFactory.fromFile("db/decks/cars.xml");
        CardDeck sh_classic = CardDeckFactory.fromFile("db/decks/superheroes_classic.xml");
        CardDeck sh = CardDeckFactory.fromFile("db/decks/superheroes.xml");
        dataMid.add(test);
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
		setCardsFromDeck();
	}
}
