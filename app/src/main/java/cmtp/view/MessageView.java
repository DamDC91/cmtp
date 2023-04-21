package cmtp.view;

import java.util.function.Consumer;

import cmtp.controller.QuestionWithIds;
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
import java.math.BigInteger;

public class MessageView {
	
	private Consumer<QuestionWithIds> handler;
	
	public MessageView()
	{
		this.handler = null;
	}
	
	public MessageView(Consumer<QuestionWithIds> handler)
	{
		this.handler = handler;
	}
	
	private void addReply(Pane pane, Reply reply)
    {
		//TODO
    }
    
    private void addQuestion(Pane pane, Question question)
    { 	
    	pane.getChildren().add(new QuestionFeedView(handler, new ArrayList<BigInteger>()).addQuestion(question));
    }
    
    private void addForm(Pane pane, Form form)
    {
    	pane.getChildren().add(new FormFeedView(handler, new ArrayList<BigInteger>()).addForm(form));
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
    		//TODO
    	}
    }
    
    public Pane addMessage(Msg msg)
    {
    	VBox vbox = new VBox(8);
		Pane pane = new AnchorPane(vbox);
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
		return pane;
    }

}
