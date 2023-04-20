package cmtp.controller;


import cmtp.repository.ModelManager;
import cmtp.view.MessageView;
import generated.Conv;
import generated.Msg;
import javafx.fxml.FXML;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.StackPane;

public class AppController {
	
    @FXML 
    private VBox convList;
    
    @FXML
    private ScrollPane mainPane;
    
    private TextInputDialog convNameInputDialog = new TextInputDialog();
    
    private ModelManager manager = new ModelManager("repository");

    @FXML
	private void initialize() {
    	convNameInputDialog.setHeaderText("Conversation name");
    	for(Conv v : manager.getAllConv())
    		addConversationButton(v);
    }
    
    public void OnCreateConversationCliked()
    {    	
    	convNameInputDialog.showAndWait();
    	addConversationButton(manager.createConvAndSave(convNameInputDialog.getEditor().getText()));
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


    private void addConversationButton(Conv c) {
    	Label label = new Label("conv id: " + c.getId().toString());
    	StackPane stackPane = new StackPane(label);
    	stackPane.getStyleClass().add("button");
    	stackPane.setId("largeButton");    	
    	stackPane.setOnMouseClicked(e -> { loadConversationMessages(c); });
    	convList.getChildren().add(stackPane);
    }
    
}