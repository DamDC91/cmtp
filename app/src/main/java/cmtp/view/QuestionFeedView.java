package cmtp.view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

import java.util.function.Consumer;

import generated.Question;
import javafx.scene.layout.Pane;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.AnchorPane;

public class QuestionFeedView {
	
	private Consumer<Question> handler;
	
	public QuestionFeedView()
	{
		this.handler = null;
	}
	
	public QuestionFeedView(Consumer<Question> handler)
	{
		this.handler = handler;
	}
	
	public Pane addQuestion(Question q)
	{
		HBox hbox = new HBox(10.0);
		Pane pane = new AnchorPane(hbox);
				
		if(!q.getText().isBlank()) 
		{
			Label label = new Label(q.getText());
			Button button = new Button("respond");
			button.setOnAction(e -> handler.accept(q));
			hbox.getChildren().addAll(label, button);
		}
		
		return pane;
	}

}
