package cmtp.controller;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import cmtp.repository.ModelManager;
import cmtp.view.MessageView;
import generated.Conv;
import generated.Form;
import generated.Msg;
import generated.Question;
import generated.Reply;
import javafx.fxml.FXML;
import javafx.scene.layout.VBox;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.StackPane;
import javafx.fxml.FXMLLoader;
import cmtp.repository.ReferenceResolver;
import cmtp.view.QuestionFeedView;

public class AppController {
	
    @FXML 
    private VBox convList;
    
    @FXML
    private ScrollPane mainPane;
    
    @FXML
    private ScrollPane editPane;
    
    @FXML
    private VBox answerFeed;
    
    @FXML
    private VBox questionFeed;
    
    private TextInputDialog convNameInputDialog = new TextInputDialog();    
    
    private MessageEditController editController = null;

    @FXML
	private void initialize() {
    	convNameInputDialog.setHeaderText("Conversation name");
    	for(Conv v : ModelManager.getInstance().getAllConv())
    		addConversationButton(v);
    }
    
    public void OnCreateConversationCliked()
    {    	
    	convNameInputDialog.showAndWait();
    	String result = convNameInputDialog.getResult();
    	if(result != null && !result.isBlank())
    		addConversationButton(ModelManager.getInstance().createConvAndSave(result));
    }
    
    private ArrayList<Reply> getAllReplies(Conv c)
    {
    	ArrayList<Reply> replies = new ArrayList<Reply>();
    	for(Msg msg : c.getMsg())
    		for(Object o : msg.getData().getQuestionOrReplyOrForm())
    			if(o instanceof Reply)
    				replies.add((Reply)o);
    	System.out.println("reply size" + replies.size());
    	return replies;
    }
    
    private ArrayList<Question> getAllQuestionsUnansweredFromForm(Form f, Set<Question> questionsAnswered)
    {
    	ArrayList<Question> questionsUnanswered = new ArrayList<Question>();
    	for(Object o : f.getQuestionOrTextOrForm())
    	{
    		if(o instanceof Form)
    			questionsAnswered.addAll(getAllQuestionsUnansweredFromForm((Form)o, questionsAnswered));
    		else if(o instanceof Question)
    			questionsUnanswered.add((Question)o);
    	}
    	return questionsUnanswered;
    }
    
    private ArrayList<Question> getAllQuestionsUnanswered(Conv c)
    {
    	Set<Question> questionsAnswered = getAllReplies(c).stream().map(e -> ReferenceResolver.getQuestion(c, e)).filter(e -> e.isPresent()).map(e -> e.get()).collect(Collectors.toSet());;
    	
    	System.out.println("questionAnswered" + questionsAnswered.size());
    	System.out.println("null question " + getAllReplies(c).stream().map(e -> ReferenceResolver.getQuestion(c, e)).filter(e -> !e.isPresent()).collect(Collectors.toSet()).size());
    	ArrayList<Question> questionsUnanswered = new ArrayList<Question>();
    	
    	for(Msg msg : c.getMsg())
    		for(Object o : msg.getData().getQuestionOrReplyOrForm())
    		{
    			if(o instanceof Question && !questionsAnswered.contains((Question)o))
    				questionsUnanswered.add((Question)o);
    			else if(o instanceof Form)
    				questionsUnanswered.addAll(getAllQuestionsUnansweredFromForm((Form) o, questionsAnswered));
    		}
    	return questionsUnanswered;
    	
    }
    

    public void loadConversationMessages(Conv c) {
    	// TODO: Reloading the conv using its id
    	// New messages received after the application started will not being displayed
    	
    	Parent root = null;
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/views/conversation_creation.fxml"));
    	try {
			root = fxmlLoader.load();
			editController = fxmlLoader.getController();
			editController.setConvId(c.getId());
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
    	
    	Label l =(Label) questionFeed.getChildren().get(0);
    	questionFeed.getChildren().clear();
    	questionFeed.getChildren().add(l);
    	QuestionFeedView v = new QuestionFeedView(x -> editController.addEditQuestion(x));
    	for(Question q : getAllQuestionsUnanswered(c))
    	{
    		questionFeed.getChildren().add(v.addQuestion(q));
    	}
    	
    	
    	
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