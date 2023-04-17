package cmtp.ui.controller;


import generated.Conv;
import generated.Msg;
import javafx.fxml.FXML;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;

public class AppController {
	
    @FXML 
    private VBox convList;
    
    @FXML
    private VBox mailList;

    @FXML
	private void initialize() {
    	// TODO Load 
    }
            
    public void loadConversationMessages(Conv c) {
    	// TODO: Reloading the conv using its id
    	// New messages received after the application started will not being displayed
    	
    	c.getMsg().sort ((Msg a, Msg b) -> a.getHeader().getDate().compare(b.getHeader().getDate()));
    	MessageView mv = new MessageView();
    	mailList.getChildren().clear();
    	for(Msg m : c.getMsg()) 
    	{
    		mailList.getChildren().add(mv.addMessage(m));
    	}
    }
    
    
    public void addConversationButton(Conv c) {
    	Label label = new Label("conv id: " + c.getId().toString());
    	StackPane stackPane = new StackPane(label);
    	stackPane.getStyleClass().add("convButton");
    	stackPane.setOnMouseClicked(e -> { loadConversationMessages(c); });
    	convList.getChildren().add(stackPane);
    }
}