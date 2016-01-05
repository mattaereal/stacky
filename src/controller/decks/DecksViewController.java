package controller.decks;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.regex.Pattern;
import cards.AbstractCard;
import cards.CardDBHandler;
import cards.CardDeck;
import cards.CardType;
import cards.factories.CardDBHandlerFactory;
import cards.factories.CardDeckFactory;
import cards.factories.CardTypeFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import utils.Util;

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
	private Button buttonCreateDeck;
	@FXML
	private Button buttonDeleteDeck;
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
	private TextField textFieldDeckName;
	@FXML
	private ComboBox<CardType> comboBoxCtype;
	
	private CardDBHandler cardHandler;
	private final ObservableList<AbstractCard> dataLeft = FXCollections.observableArrayList();
	private final ObservableList<AbstractCard> dataRight = FXCollections.observableArrayList();
	private final ObservableList<CardDeck> dataMid = FXCollections.observableArrayList();
	private HashMap<CardDeck, String> deckPath;

	
	@FXML
	public void initialize() {
		deckPath = new HashMap<CardDeck, String>();
		CardType superheroes = CardTypeFactory.fromFile("Superheroes");
		comboBoxCtype.getItems().add(superheroes);
		comboBoxCtype.setValue(superheroes);
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
		
		File folder = new File(Util.deckspath);
		File[] listOfFiles = folder.listFiles();
		    for (int i = 0; i < listOfFiles.length; i++) {
		      if (listOfFiles[i].isFile()) {
		        CardDeck tmp = CardDeckFactory.fromFile(listOfFiles[i].getName());
		        deckPath.put(tmp, listOfFiles[i].getName());
		        dataMid.add(tmp);
		      }
		    }
		   
        tvDecks.setItems(dataMid);
	}
	
	@FXML
	public void createDeck() {
		Pattern p = Pattern.compile("[^a-zA-Z0-9]");
		String name = textFieldDeckName.getText();
		boolean hasSpecialChar = p.matcher(name).find();
		if (!hasSpecialChar) {
			CardType ct = comboBoxCtype.getSelectionModel().getSelectedItem();
			if (ct == null)
				dialogError("Card type must be selected from drop list.");
			
			else if (deckExists(name)) {
				dialogError("There's already a deck with that name.");
			} else {
				CardDeck newDeck = new CardDeck(name, ct);
				dataMid.add(newDeck);
				deckPath.put(newDeck, name+Util.fileext);
			}
		} else {
			dialogError("The card deck must have alphanumeric characters.");
		}
	}
	
	public boolean deckExists(String name) {
		Iterator<CardDeck> it = dataMid.iterator();
		CardDeck cur;
		while(it.hasNext()) {
			cur = it.next();
			if (cur.getName().equals(name))
				return true;
		}
		
		return false;
	}
	
	@FXML
	public void deleteDeck() {
		CardDeck del = tvDecks.getFocusModel().getFocusedItem();
		if (del != null) {
			dataMid.remove(del);
			try {
			    new File(Util.deckspath + deckPath.get(del)).delete();
			    deckPath.remove(del);
			} catch (Exception x) {
				System.out.println(x);   
			}
		}
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
