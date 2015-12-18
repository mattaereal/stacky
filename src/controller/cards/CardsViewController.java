package controller.cards;

import java.util.Iterator;

import application.Main;
import cards.AbstractCard;
import cards.Card;
import cards.CardDBHandler;
import cards.CardType;
import cards.factories.CardDBHandlerFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class CardsViewController {
	@FXML
	TableView<AbstractCard> tvCards;
	@FXML
	TableColumn<AbstractCard, String> itemCardName;
	@FXML
	TableColumn<AbstractCard, String> itemCardType;

	private final ObservableList<AbstractCard> data = FXCollections.observableArrayList();
	
	@FXML
	public void initialize() {
        itemCardName.setCellValueFactory(
                new PropertyValueFactory<AbstractCard, String>("name"));
 
        itemCardType.setCellValueFactory(
                new PropertyValueFactory<AbstractCard, String>("ctype"));
 
		
		CardDBHandler ch = CardDBHandlerFactory.fromFile();
		Iterator<AbstractCard> it = ch.getList().iterator();
		while(it.hasNext()) {
			data.add(it.next());
		}
		
		tvCards.setItems(data);		
	}
}
