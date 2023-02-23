package cmtp.ui.controller;

import javafx.fxml.FXML;
import javafx.scene.text.Text;
import javafx.scene.Parent;
import javafx.scene.layout.Pane;

public class MainWindow {
    @FXML 
    private Text emailContent;

    @FXML
	private void initialize() {
        emailContent.wrappingWidthProperty().bind(((Pane)emailContent.getParent()).widthProperty());
    }
}