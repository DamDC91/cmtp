package cmtp.view;

import javafx.scene.control.Button;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.function.BiConsumer;
import generated.Question;
import javafx.scene.layout.Pane;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.AnchorPane;

public class QuestionFeedView {
	
	private BiConsumer<Question, ArrayList<BigInteger>> handler;
	
	private ArrayList<BigInteger> formId;
	
	public QuestionFeedView(BiConsumer<Question, ArrayList<BigInteger>> handler, ArrayList<BigInteger> formId)
	{
		this.handler = handler;
		this.formId = formId;
	}
	
	public Pane addQuestion(Question q)
	{
		HBox hbox = new HBox(10.0);
		Pane pane = new AnchorPane(hbox);
				
		if(!q.getText().isBlank()) 
		{
			Label label = new Label(q.getText());
			Button button = new Button("respond");
			button.setOnAction(e -> handler.accept(q, formId));
			hbox.getChildren().addAll(label, button);
		}
		
		return pane;
	}

}
