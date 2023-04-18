package cmtp.controller;

import java.util.ArrayList;
import java.util.Set;

import cmtp.AccessingAllClassesInPackage;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class ConvCreationController {
	
	@FXML
	ChoiceBox<String> pluginChoiceBox;
	
	@FXML
	TextField recipientTextField;
	
	@FXML
	VBox vbox;
	
	 @FXML
	 private void initialize() {
		 Set<String> plugins = AccessingAllClassesInPackage.findAllClasses("cmtp.plugin");
		 for(String name : plugins)
		 {
			 pluginChoiceBox.getItems().add(name);
		 }
	 }
	 
	 public void onAddRecipientCliked()
	 {
		 vbox.getChildren().add(0, new Label(recipientTextField.getText()));
		 recipientTextField.setText("");
	 }
	 
	 public void onAddPluginCliked()
	 {
		 // TODO
		 System.out.println("Adding plugin: "+ pluginChoiceBox.getSelectionModel().getSelectedItem());
	 }
	 

	 
	 
}
