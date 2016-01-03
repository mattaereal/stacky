package controller.cards;

import java.io.IOException;
import java.util.Iterator;

import application.Main;
import cards.AbstractCard;
import cards.CardDBHandler;
import cards.CardType;
import cards.factories.CardDBHandlerFactory;
import cards.factories.CardTypeFactory;
import controller.cards.create.CreateCardController;
import controller.cards.edit.EditCardController;
import controller.game.GameController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart.Data;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class CardsViewController {
	@FXML
	private TableView<AbstractCard> tvCards;
	@FXML
	private TableColumn<AbstractCard, String> itemCardName;
	@FXML
	private TableColumn<AbstractCard, String> itemCardType;
	@FXML
	private Button buttonCreateCard;
	@FXML
	private Button buttonEditCard;
	@FXML
	private Button buttonDeleteCard;
	@FXML
	private Button buttonCancel;
	@FXML
	private Button buttonPersist;
	@FXML
	private Text textCurrentAttrs;
	
	private CardDBHandler cardHandler;

	private final ObservableList<AbstractCard> data = FXCollections.observableArrayList();
	
	@FXML
	public void initialize() {
        itemCardName.setCellValueFactory(
                new PropertyValueFactory<AbstractCard, String>("name"));
 
        itemCardType.setCellValueFactory(
                new PropertyValueFactory<AbstractCard, String>("ctype"));
 
		
		cardHandler = CardDBHandlerFactory.fromFile();
		Iterator<AbstractCard> it = cardHandler.getList().iterator();
		while(it.hasNext()) {
			data.add(it.next());
		}
		
		tvCards.setItems(data);		
	}
	
	@FXML
	public void deleteCard() {
		AbstractCard curr = tvCards.getSelectionModel().getSelectedItem();
		System.out.println("Deleting: " + curr);
		data.remove(curr);
		cardHandler.delCard(curr.getID());
	}
	
	@FXML
	public void persistAction() {
		CardDBHandlerFactory.toFile(cardHandler);
	    Stage stage = (Stage) buttonPersist.getScene().getWindow();
	    stage.close();
	}
	
	@FXML
	public void openCreateView(){
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("/view/cards/create/CreateView.fxml"));
		AnchorPane pane = null;
		try {
			pane = loader.load();
		} catch(IOException e){
			e.printStackTrace();
		}
		
		CreateCardController controller = loader.getController();
		controller.setupCreation(cardHandler, data);
		
		Stage stage = new Stage();
		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.show();
	}
	
	@FXML
	public void openEditView(){
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("/view/cards/edit/EditView.fxml"));
		AnchorPane pane = null;
		try {
			pane = loader.load();
		} catch(IOException e){
			e.printStackTrace();
		}
		
		EditCardController controller = loader.getController();
		AbstractCard curr = tvCards.getSelectionModel().getSelectedItem();
		CardType superheroes = CardTypeFactory.fromFile("Superheroes");
		if (!curr.getCtype().equals(superheroes)) {
			this.dialogError("Can't edit card that kind of card.");
		} else {
			controller.setupCreation(cardHandler, data, curr);
			Stage stage = new Stage();
			Scene scene = new Scene(pane);
			stage.setScene(scene);
			stage.show();
		}
	}
	
	@FXML
	public void updateAttributes() {
		try {
			textCurrentAttrs.setText(tvCards.getSelectionModel().getSelectedItem().getAttributes());
		} catch (Exception NullPointerException) {
			// Nothing to do.
		}
	}
	
	@FXML
	public void cancelAction() {
	    Stage stage = (Stage) buttonCancel.getScene().getWindow();
	    stage.close();
	}
	
	public void dialogError(String err) {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Error");
		alert.setContentText(err);
		alert.setResizable(true);

		alert.showAndWait();
	}
}
