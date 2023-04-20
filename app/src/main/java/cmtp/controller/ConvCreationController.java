package cmtp.controller;

import java.lang.reflect.InvocationTargetException;
import java.util.Set;

import cmtp.AbstractPlugin;
import cmtp.plugin.PluginManager;
import cmtp.view.FormView;
import generated.Form;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
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
		 Set<String> plugins = PluginManager.getAllPlugins();
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
		 if(!pluginChoiceBox.getSelectionModel().isEmpty())
		 {
			 System.out.println("Adding plugin: "+ pluginChoiceBox.getSelectionModel().getSelectedItem());		
			 try {
				 Form f = PluginManager.getPlugin(pluginChoiceBox.getSelectionModel().getSelectedItem()).getDeclaredConstructor().newInstance().getForm();
				 vbox.getChildren().add(vbox.getChildren().size()-1, new FormView().addForm(f));
				 System.out.println(f.toString());
			} catch (Exception e) {
				e.printStackTrace();
			}
			 pluginChoiceBox.getSelectionModel().clearSelection();
		}
		
	 }
	 

	 
	 
}
