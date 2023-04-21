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

public class FormFeedView extends AnchorPane {

	private Consumer<QuestionWithIds> handler;
	private ArrayList<BigInteger> formIds;
	private BigInteger currentFormId;
		
    private void addQuestion(Pane pane, Question question)
    {
    	ArrayList<BigInteger> ids = (ArrayList<BigInteger>) formIds.clone();
    	ids.add(currentFormId);
    	pane.getChildren().add(new QuestionFeedView(handler, ids, question));
    }
    
    private void addForm(Pane pane, Form form)
    {
    	ArrayList<BigInteger> ids = (ArrayList<BigInteger>) formIds.clone();
    	ids.add(currentFormId);
    	pane.getChildren().add(new FormFeedView(handler, ids, form));
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
	
	public FormFeedView(Consumer<QuestionWithIds> handler, ArrayList<BigInteger> formIds, Form f)
	{
		super();
		this.handler = handler;
		this.formIds = formIds;
		VBox vbox = new VBox();
		
		currentFormId = new BigInteger(f.getId());
		
		if(!f.getTitle().isBlank()) 
		{
			Label label = new Label(f.getTitle());
			vbox.getChildren().add(label);
		}
		for(Object o : f.getQuestionOrTextOrForm())
			dispatch(vbox, o);
		this.getChildren().add(vbox);
	}
}
