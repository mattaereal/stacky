package controller.cards.composite;

import java.util.Iterator;

import cards.AbstractCard;
import cards.CardDBHandler;
import cards.CompositeCard;
import cards.factories.CardDBHandlerFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class CompositeCardController {
	@FXML
	private Button buttonAddCardToLeague;
	@FXML
	private Button buttonDeleteCardFromLeague;
	@FXML
	private Button buttonCreateLeague;
	@FXML
	private TableView<AbstractCard> tvCardsDB;
	@FXML
	private TableView<AbstractCard> tvSelectedCards;
	@FXML
	private TableColumn<AbstractCard, String> itemCardNameM;
	@FXML
	private TableColumn<AbstractCard, String> itemCardName;
	@FXML
	private TableColumn<AbstractCard, String> itemCardType;
	@FXML
	private TextField textFieldName;
	
	private ObservableList<AbstractCard> dbData = FXCollections.observableArrayList();
	private final ObservableList<AbstractCard> leagueData = FXCollections.observableArrayList();
	private CardDBHandler cardHandler;
	
	public void setCardList(ObservableList<AbstractCard> cardsData) {
		this.dbData = cardsData;
		tvCardsDB.setItems(dbData);	
	}
	
	public void setHandler(CardDBHandler ch) {
		this.cardHandler = ch;
	}
	
	@FXML
	public void initialize() {
        itemCardName.setCellValueFactory(
                new PropertyValueFactory<AbstractCard, String>("name"));
 
        itemCardType.setCellValueFactory(
                new PropertyValueFactory<AbstractCard, String>("ctype"));
 
        itemCardNameM.setCellValueFactory(
                new PropertyValueFactory<AbstractCard, String>("name"));
        
		tvSelectedCards.setItems(leagueData);
	}
	
	@FXML
	public void addCardToLeagueAction() {
		AbstractCard sel = tvCardsDB.getFocusModel().getFocusedItem();
		if (sel == null) {
			dialogError("A card must be selected.");
		} else {
			leagueData.add(sel);
		}
	}
	
	@FXML
	public void deleteCardFromLeagueAction() {
		AbstractCard sel = tvCardsDB.getFocusModel().getFocusedItem();
		if (sel == null) {
			dialogError("A card must be selected.");
		} else {
			leagueData.remove(sel);
		}
	}

	@FXML
	public void createLeague() {
		if (leagueData.size() < 2) {
			dialogError("League must contain at least 2 cards.");
		} else {
			Iterator<AbstractCard> it = leagueData.iterator();
			AbstractCard curr = it.next();
			AbstractCard next = curr;
			while(it.hasNext()) {
				next = it.next();
				if (!curr.getCtype().equals(next.getCtype())) {
					dialogError("The cards must be from all the same type");
					return;
				}
				curr = next;
			}
			
			String name = textFieldName.getText();
			if (name != null) {
				CompositeCard newComp = new CompositeCard(name, next.getCtype());
				it = leagueData.iterator();
				while(it.hasNext()) {
					newComp.addCard(it.next());
				}
				dbData.add(newComp);
				cardHandler.addCard(newComp);
				Stage stage = (Stage) buttonCreateLeague.getScene().getWindow();
				stage.close();
			} else {
				dialogError("Name must be not empty.");
			}
		}
	}
	
	@FXML
	public void updateDeckTable() {
		
	}
	
	public void dialogError(String err) {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Error");
		alert.setContentText(err);
		alert.setResizable(true);

		alert.showAndWait();
	}
}
