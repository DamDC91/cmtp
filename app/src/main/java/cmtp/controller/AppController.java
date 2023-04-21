package cmtp.controller;


import java.io.IOException;
import java.math.BigInteger;
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
import cmtp.view.ReplyView;
import java.util.Optional;

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
    	return replies;
    }
    
    private ArrayList<QuestionWithIds> getAllQuestionsUnansweredFromForm(Form f, ArrayList<BigInteger> formIds,  Set<Question> questionsAnswered)
    {
    	ArrayList<QuestionWithIds> questionsUnanswered = new ArrayList<QuestionWithIds>();
    	ArrayList<BigInteger> currentFormIds = (ArrayList<BigInteger>) formIds.clone();
    	currentFormIds.add(new BigInteger(f.getId()));
    	for(Object o : f.getQuestionOrTextOrForm())
    	{
    		if(o instanceof Form)
    			questionsUnanswered.addAll(getAllQuestionsUnansweredFromForm((Form)o, currentFormIds, questionsAnswered));
    		else if(o instanceof Question && !questionsAnswered.contains((Question)o))
    			questionsUnanswered.add(new QuestionWithIds((Question)o, currentFormIds));
    	}
    	return questionsUnanswered;
    }
    
    private ArrayList<QuestionWithIds> getAllQuestionsUnanswered(Conv c)
    {
    	Set<Question> questionsAnswered = getAllReplies(c).stream().map(e -> ReferenceResolver.getQuestion(c, e)).filter(e -> e.isPresent()).map(e -> e.get()).collect(Collectors.toSet());
    	ArrayList<QuestionWithIds> questionsUnanswered = new ArrayList<QuestionWithIds>();
    	
    	for(Msg msg : c.getMsg())
    		for(Object o : msg.getData().getQuestionOrReplyOrForm())
    		{
    			if(o instanceof Question && !questionsAnswered.contains((Question)o))
    				questionsUnanswered.add(new QuestionWithIds((Question)o, new ArrayList<BigInteger>()));
    			else if(o instanceof Form)
    				questionsUnanswered.addAll(getAllQuestionsUnansweredFromForm((Form) o, new ArrayList<BigInteger>(), questionsAnswered));
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
	
    	VBox vbox = new VBox();    	
    	for(Msg m : c.getMsg()) 
    		vbox.getChildren().add(new MessageView(c, m, x -> editController.addEditQuestion(x)));
    	
    	mainPane.setContent(vbox);
    	editPane.setContent(root);
    	
    	Label l =(Label) questionFeed.getChildren().get(0);
    	questionFeed.getChildren().clear();
    	questionFeed.getChildren().add(l);
    	for(QuestionWithIds q : getAllQuestionsUnanswered(c))
    	{
    		QuestionFeedView v = new QuestionFeedView(x -> editController.addEditQuestion(x), q.getParentIdList(), q.getQuestion());
    		questionFeed.getChildren().add(v);
    	}
    	
    	l =(Label) answerFeed.getChildren().get(0);
    	answerFeed.getChildren().clear();
    	answerFeed.getChildren().add(l);
    	for(Reply r : getAllReplies(c))
    	{
    		Optional<Question> q = ReferenceResolver.getQuestion(c, r);
    		if(q.isPresent())
    			answerFeed.getChildren().add(new ReplyView(r, q.get()));
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