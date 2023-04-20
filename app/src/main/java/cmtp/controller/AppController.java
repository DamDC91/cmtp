package cmtp.controller;


import java.io.IOException;
import java.util.function.Consumer;

import cmtp.repository.ModelManager;
import cmtp.view.MessageView;
import generated.Conv;
import generated.Msg;
import generated.Question;
import javafx.fxml.FXML;
import javafx.scene.layout.VBox;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.StackPane;
import javafx.fxml.FXMLLoader;

public class AppController {
	
    @FXML 
    private VBox convList;
    
    @FXML
    private ScrollPane mainPane;
    
    @FXML
    private ScrollPane editPane;
    
    private TextInputDialog convNameInputDialog = new TextInputDialog();
    
    private ModelManager manager = new ModelManager("repository");
    
    private MessageEditController editController = null;

    @FXML
	private void initialize() {
    	convNameInputDialog.setHeaderText("Conversation name");
    	for(Conv v : manager.getAllConv())
    		addConversationButton(v);
    }
    
    public void OnCreateConversationCliked()
    {    	
    	convNameInputDialog.showAndWait();
    	String result = convNameInputDialog.getResult();
    	if(result != null && !result.isBlank())
    		addConversationButton(manager.createConvAndSave(result));
    }
    
    
    

    public void loadConversationMessages(Conv c) {
    	// TODO: Reloading the conv using its id
    	// New messages received after the application started will not being displayed
    	
    	Parent root = null;
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/views/conversation_creation.fxml"));
    	try {
			root = fxmlLoader.load();
			editController = fxmlLoader.getController();
		} catch (IOException e) {
			e.printStackTrace();
		}
    	
    	c.getMsg().sort ((Msg a, Msg b) -> a.getHeader().getDate().compare(b.getHeader().getDate()));

    	MessageView mv = new MessageView(x -> editController.addEditQuestion(x));    	
    	VBox vbox = new VBox();    	
    	for(Msg m : c.getMsg()) 
    		vbox.getChildren().add(mv.addMessage(m));
    	   
    	mainPane.setContent(vbox);
    	editPane.setContent(root);
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