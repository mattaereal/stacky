package controller.cards.edit;

import java.util.ArrayList;
import java.util.Optional;

import cards.AbstractCard;
import cards.Card;
import cards.CardDBHandler;
import cards.CardType;
import cards.factories.CardTypeFactory;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class EditCardController {
	@FXML
	private TextField textFieldCardName;
	@FXML
	private Button buttonSaveCard;
	@FXML
	private Button buttonCancelCard;
	@FXML
	private Text textCtype;
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
	private AbstractCard current;
	
	
	@FXML
	public void initialize() {
	}

	@FXML
	public void cancelCardAction() {
	    Stage stage = (Stage) buttonCancelCard.getScene().getWindow();
	    stage.close();
	}
	
	@FXML
	public void saveCardAction() {
		this.viewData.remove(current);
		this.cdbHandler.delCard(current.getID());
		
		String name = textFieldCardName.getText();
		String altura = textFieldAltura.getText();
		String fuerza = textFieldFuerza.getText();
		String peso = textFieldPeso.getText();
		String peleas = textFieldPeleasGanadas.getText();
		String velocidad = textFieldVelocidad.getText();
		
		if (name.equals("")) {
			textError.setText("Error: Card name must be set.");
		} else if ((altura.equals("")) || (fuerza.equals("")) || (peso.equals("")) || (peleas.equals("")) || (velocidad.equals(""))) {
			textError.setText("Error: All card attributes must be set.");
		} else {
			Card newCard = new Card(name, this.current.getCtype());
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
	
	public void setupCreation(CardDBHandler handler, ObservableList<AbstractCard> data, AbstractCard curr) {
		this.cdbHandler = handler;
		this.viewData = data;
		this.current = curr;
		
		setData();
	}
	
	public void setData() {
		textCtype.setText(this.current.getCtype().toString());
		textFieldAltura.setText(String.format("%d", this.current.getAttribute("Altura")));
		textFieldFuerza.setText(String.format("%d", this.current.getAttribute("Fuerza")));
		textFieldPeso.setText(String.format("%d", this.current.getAttribute("Peso")));
		textFieldPeleasGanadas.setText(String.format("%d", this.current.getAttribute("Peleas ganadas")));
		textFieldVelocidad.setText(String.format("%d", this.current.getAttribute("Velocidad")));
		textFieldCardName.setText(this.current.getName());
	}
	
	public void dialogError(String err) {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Error");
		alert.setContentText(err);
		alert.setResizable(true);

		alert.showAndWait();
	}
}
