package cmtp.view;

import generated.Form;
import generated.Msg;
import generated.Question;
import generated.Reply;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class MessageView {
	
	private void addReply(Pane pane, Reply reply)
    {
		//TODO
    }
    
    private void addQuestion(Pane pane, Question question)
    {
    	QuestionView qv = new QuestionView();
    	Pane p = qv.addQuestion(question);    	
    	pane.getChildren().add(p);
    }
    
    private void addForm(Pane pane, Form form)
    {
    	for(Object o : form.getQuestionOrTextOrForm()) 
    		dipatch(pane, o);    	
    }
    
    private void addText(Pane pane, String string)
    {
    	Text text = new Text(string);
    	pane.getChildren().add(text);
		text.wrappingWidthProperty().bind(pane.widthProperty());
    }
    
    private void dipatch(Pane pane, Object o)
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
		Pane pane = new Pane(vbox);
		vbox.setPadding(new Insets(5, 5, 5, 10));
		
		Label labelFrom = new Label("from: " + msg.getHeader().getFrom());
		labelFrom.setLayoutX(25.0);
		labelFrom.setLayoutY(45.0);
		labelFrom.setPadding(new Insets(10, 0, 10, 0));
		vbox.getChildren().add(labelFrom);
		
		for(Object o : msg.getData().getQuestionOrReplyOrForm())
		{
			dipatch(vbox, o);
		}
		return pane;
    }

}
