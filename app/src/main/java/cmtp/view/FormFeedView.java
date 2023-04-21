package cmtp.view;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.function.Consumer;

import cmtp.controller.QuestionWithIds;
import generated.Form;
import generated.Question;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class FormFeedView {

	private Consumer<QuestionWithIds> handler;
	private ArrayList<BigInteger> formIds;
	private BigInteger currentFormId;
	
	
	public FormFeedView(Consumer<QuestionWithIds> handler, ArrayList<BigInteger> formIds)
	{
		this.handler = handler;
		this.formIds = formIds;
	}
	
	
    private void addQuestion(Pane pane, Question question)
    {
    	ArrayList<BigInteger> ids = (ArrayList<BigInteger>) formIds.clone();
    	ids.add(currentFormId);
    	pane.getChildren().add(new QuestionFeedView(handler, ids).addQuestion(question));
    }
    
    private void addForm(Pane pane, Form form)
    {
    	ArrayList<BigInteger> ids = (ArrayList<BigInteger>) formIds.clone();
    	ids.add(currentFormId);
    	pane.getChildren().add(new FormFeedView(handler, ids).addForm(form));
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
    }
	
	public Pane addForm(Form f)
	{
		VBox vbox = new VBox();
		Pane pane = new AnchorPane(vbox);
		
		currentFormId = new BigInteger(f.getId());
		
		if(!f.getTitle().isBlank()) 
		{
			Label label = new Label(f.getTitle());
			vbox.getChildren().add(label);
		}
		for(Object o : f.getQuestionOrTextOrForm())
			dispatch(vbox, o);
		return pane;
	}
}
