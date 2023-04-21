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

public class QuestionFeedView extends AnchorPane {
	
	private Consumer<QuestionWithIds> handler;
	
	private ArrayList<BigInteger> formIds;
	
	public QuestionFeedView(Consumer<QuestionWithIds> handler, ArrayList<BigInteger> formIds, Question q)
	{
		super();
		this.handler = handler;
		this.formIds = formIds;
		HBox hbox = new HBox(10.0);
				
		if(!q.getText().isBlank()) 
		{
			Label label = new Label(q.getText());
			Button button = new Button("respond");
			button.setOnAction(e -> handler.accept(new QuestionWithIds(q, formIds)));
			hbox.getChildren().addAll(label, button);
		}
		this.getChildren().add(hbox);
	}

}
