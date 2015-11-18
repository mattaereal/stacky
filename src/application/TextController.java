package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class TextController {
	
	@FXML
	private TextArea text;
	@FXML
	private Button okButton;
	@FXML
	private Button cancelButton;
	
	public TextController () {
		
	}
	
	@FXML
	public void initialize(){
		
	}
	
	@FXML
	public void probar(){
		if(!text.getText().equals(""))
			okButton.setDisable(false);
	}
	

}
