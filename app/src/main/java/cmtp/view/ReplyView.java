package cmtp.view;

import java.util.ArrayList;
import java.util.stream.Collectors;

import generated.Question;
import generated.Reply;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

public class ReplyView extends AnchorPane {
	
	public ReplyView(Reply reply, Question question)
	{
		super();
		
		if(!question.getText().isBlank()) 
		{
			Label label = new Label(question.getText() +  " : " + getReplyText(reply, question));
			this.getChildren().add(label);
		}
	}
	
	private String getReplyText(Reply reply, Question question)
	{
		String replyLabel = new String();

		if(reply.getReplyCheckbox() != null)
		{
			ArrayList<String> s = (ArrayList<String>) reply.getReplyCheckbox().getCheckedBox().stream()
					.map(e -> e.getOffset().intValue())
					.map(e -> question.getCheckboxGroup().getCheckbox().get(e).getLabel())
					.collect(Collectors.toList());
			
			replyLabel = (String.join(", ", s));
		}
		else if(reply.getReplyRadio() != null)
		{
			replyLabel = (question.getRadioGroup().getRadio().get(reply.getReplyRadio().getOffset().intValue()).getLabel());
		}
		else if(reply.getReplyColor() != null)
		{
			replyLabel = ("r:" + reply.getReplyColor().getR() +
							 " g:" + reply.getReplyColor().getG() +
							 " b:" + reply.getReplyColor().getB() +
							 " a:"+ reply.getReplyColor().getA());
		}
		else if(reply.getReplyDate() != null)
		{
			replyLabel = (reply.getReplyDate().getValue().toString());
		}
		else if(reply.getReplyText() != null)
		{
			replyLabel = (reply.getReplyText().getValue());
		}
		else if(reply.getReplyEmail() != null)
		{
			replyLabel = (reply.getReplyEmail().getValue());
		}
		else if(reply.getReplyPhoneNumber() != null)
		{
			replyLabel = (reply.getReplyPhoneNumber().getValue());
		}
		else if(reply.getReplyDecimal() != null)
		{
			replyLabel = (reply.getReplyDecimal().getValue().toString());
		}
		else if(reply.getReplyInteger() != null)
		{
			replyLabel = (reply.getReplyInteger().getValue().toString());
		}
		
		return replyLabel;
	}

}
