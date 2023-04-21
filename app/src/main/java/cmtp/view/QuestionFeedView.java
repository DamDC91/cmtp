package cmtp.view;

import javafx.scene.control.Button;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.function.Consumer;

import cmtp.controller.QuestionWithIds;
import generated.Question;
import javafx.scene.layout.Pane;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.AnchorPane;

public class QuestionFeedView {
	
	private Consumer<QuestionWithIds> handler;
	
	private ArrayList<BigInteger> formIds;
	
	public QuestionFeedView(Consumer<QuestionWithIds> handler, ArrayList<BigInteger> formIds)
	{
		this.handler = handler;
		this.formIds = formIds;
	}
	
	public Pane addQuestion(Question q)
	{
		HBox hbox = new HBox(10.0);
		Pane pane = new AnchorPane(hbox);
				
		if(!q.getText().isBlank()) 
		{
			Label label = new Label(q.getText());
			Button button = new Button("respond");
			button.setOnAction(e -> handler.accept(new QuestionWithIds(q, formIds)));
			hbox.getChildren().addAll(label, button);
		}
		return pane;
	}

}
