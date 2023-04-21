package cmtp.view;

import java.util.function.Consumer;

import cmtp.controller.QuestionWithIds;
import generated.Conv;
import generated.Form;
import generated.Msg;
import generated.Question;
import generated.Reply;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import java.util.ArrayList;
import java.util.Optional;
import java.math.BigInteger;
import cmtp.repository.ReferenceResolver;

public class MessageView extends AnchorPane {
	
	private Consumer<QuestionWithIds> handler;
	private Conv currentConv;
	
	private void addReply(Pane pane, Reply reply)
    {
		Optional<Question> q = ReferenceResolver.getQuestion(currentConv, reply);
		if(q.isPresent())
			pane.getChildren().add(new ReplyView(reply, q.get()));
    }
    
    private void addQuestion(Pane pane, Question question)
    { 	
    	pane.getChildren().add(new QuestionFeedView(handler, new ArrayList<BigInteger>(), question));
    }
    
    private void addForm(Pane pane, Form form)
    {
    	pane.getChildren().add(new FormFeedView(handler, new ArrayList<BigInteger>(), form));
    }
    
    private void addText(Pane pane, String string)
    {
    	Text text = new Text(string);
    	pane.getChildren().add(text);
		text.wrappingWidthProperty().bind(pane.widthProperty());
    }
    
    private void dispatch(Pane pane, Object o)
    {    	
    	if(o instanceof String)
    	{
    		addText(pane, (String) o);
    	}
    	else if(o instanceof Form)
    	{
    		addForm(pane, (Form)o);
    	}
    	else if(o instanceof Question)
    	{
    		addQuestion(pane, (Question)o);
    	}
    	else if(o instanceof Reply)
    	{
    		addReply(pane, (Reply)o);
    	}
    }
    
    public MessageView(Conv c, Msg msg, Consumer<QuestionWithIds> handler)
    {
    	super();
    	this.currentConv = c;
    	this.handler = handler;
    	VBox vbox = new VBox(8);
		vbox.setPadding(new Insets(5, 5, 5, 10));
		
		Label labelFrom = new Label("from: " + msg.getHeader().getFrom());
		labelFrom.setLayoutX(25.0);
		labelFrom.setLayoutY(45.0);
		labelFrom.setPadding(new Insets(10, 0, 10, 0));
		vbox.getChildren().add(labelFrom);
		
		for(Object o : msg.getData().getQuestionOrReplyOrForm())
		{
			dispatch(vbox, o);
		}
		this.getChildren().add(vbox);
    }
    

}
