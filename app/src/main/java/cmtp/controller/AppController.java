package cmtp.controller;


import java.io.IOException;
import cmtp.view.MessageView;
import generated.Conv;
import generated.Msg;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.VBox;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.StackPane;

public class AppController {
	
    @FXML 
    private VBox convList;
    
    @FXML
    private ScrollPane mainPane;

    @FXML
	private void initialize() {
    	// TODO Load 
    }
    
    public void OnCreateConversationCliked()
    {
    	Parent root = null;
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/views/conversation_creation.fxml"));
    	try {
			root = fxmlLoader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
    	mainPane.setContent(root);
    }

    public void loadConversationMessages(Conv c) {
    	// TODO: Reloading the conv using its id
    	// New messages received after the application started will not being displayed
    	
    	c.getMsg().sort ((Msg a, Msg b) -> a.getHeader().getDate().compare(b.getHeader().getDate()));
    	MessageView mv = new MessageView();    	
    	VBox vbox = new VBox();    	
    	for(Msg m : c.getMsg()) 
    	{
    		vbox.getChildren().add(mv.addMessage(m));
    	}
    	mainPane.setContent(vbox);
    }


    public void addConversationButton(Conv c) {
    	Label label = new Label("conv id: " + c.getId().toString());
    	StackPane stackPane = new StackPane(label);
    	stackPane.getStyleClass().add("button");
    	stackPane.setId("largeButton");    	
    	stackPane.setOnMouseClicked(e -> { loadConversationMessages(c); });
    	convList.getChildren().add(stackPane);
    }
}