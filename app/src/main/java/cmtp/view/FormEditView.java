package cmtp.view;

import generated.Form;
import generated.Question;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class FormEditView extends AnchorPane {
	
    private void addQuestion(Pane pane, Question question)
    {
    	pane.getChildren().add(new AnswerEditView(question));
    }
    
    private void addForm(Pane pane, Form form)
    {
    	pane.getChildren().add(new FormEditView(form));
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
	
    
	public FormEditView(Form f)
	{
		super();
		VBox vbox = new VBox();
		
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
