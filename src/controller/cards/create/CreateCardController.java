package controller.cards.create;

import cards.AbstractCard;
import cards.Card;
import cards.CardDBHandler;
import cards.CardType;
import cards.factories.CardTypeFactory;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class CreateCardController {
	@FXML
	private TextField textFieldCardName;
	@FXML
	private Button buttonSaveCard;
	@FXML
	private Button buttonCancelCard;
	@FXML
	private ComboBox<CardType> comboBoxCtype;
	@FXML
	private TextField textFieldAltura;
	@FXML
	private TextField textFieldFuerza;
	@FXML
	private TextField textFieldPeso;
	@FXML
	private TextField textFieldPeleasGanadas;
	@FXML
	private TextField textFieldVelocidad;
	@FXML
	private Text textError;
	
	
	private CardDBHandler cdbHandler;
	private ObservableList<AbstractCard> viewData;
	
	
	@FXML
	public void initialize() {
		CardType superheroes = CardTypeFactory.fromFile("Superheroes");
		comboBoxCtype.getItems().add(superheroes);
		comboBoxCtype.setValue(superheroes);
	}

	@FXML
	public void cancelCardAction() {
	    Stage stage = (Stage) buttonCancelCard.getScene().getWindow();
	    stage.close();
	}
	
	@FXML
	public void saveCardAction() {
		String name = textFieldCardName.getText();
		String altura = textFieldAltura.getText();
		String fuerza = textFieldFuerza.getText();
		String peso = textFieldPeso.getText();
		String peleas = textFieldPeleasGanadas.getText();
		String velocidad = textFieldVelocidad.getText();
		CardType ctype = comboBoxCtype.getSelectionModel().getSelectedItem();
		
		if (name.equals("")) {
			textError.setText("Error: Card name must be set.");
		} else if (ctype == null) {
			textError.setText("Error: Card type must be set.");
		} else if ((altura.equals("")) || (fuerza.equals("")) || (peso.equals("")) || (peleas.equals("")) || (velocidad.equals(""))) {
			textError.setText("Error: All card attributes must be set.");
		} else {
			Card newCard = new Card(name, ctype);
			newCard.addAttribute("Altura", Integer.parseInt(altura));
			newCard.addAttribute("Fuerza", Integer.parseInt(fuerza));
			newCard.addAttribute("Peso", Integer.parseInt(peso));
			newCard.addAttribute("Peleas ganadas", Integer.parseInt(peleas));
			newCard.addAttribute("Velocidad", Integer.parseInt(velocidad));
			cdbHandler.addCard(newCard);
			viewData.add(newCard);
			
		    Stage stage = (Stage) buttonSaveCard.getScene().getWindow();
		    stage.close();
			
		}
		
	}
	
	public void setupCreation(CardDBHandler handler, ObservableList<AbstractCard> data) {
		this.cdbHandler = handler;
		this.viewData = data;
	}
	

}
