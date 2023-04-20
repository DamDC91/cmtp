package cmtp.controller;

import java.util.Set;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;

import cmtp.plugin.PluginManager;
import cmtp.view.ExpandableTextArea;
import cmtp.view.FormEditView;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

import cmtp.view.AnswerEditView;
import generated.*;

public class MessageEditController {
	
	@FXML
	private ChoiceBox<String> pluginChoiceBox;
	
	@FXML
	private TextField recipientTextField;
	
	@FXML
	private TextField writterTextField;
	
	@FXML
	private VBox vbox;
	
	
	private Set<String> recipientNames;
	
	
	private Map<AnswerEditView, Question> answerToQuestion;
	
	
	private ArrayList<Object> msgElements;
	
	 @FXML
	 private void initialize() {
		 recipientNames = new HashSet<String>();
		 msgElements = new ArrayList<Object>();
		 answerToQuestion = new HashMap<AnswerEditView, Question>();
		 Set<String> plugins = PluginManager.getAllPlugins();
		 for(String name : plugins)		 
			 pluginChoiceBox.getItems().add(name);
		 
	 }
	 
	 public void onAddRecipientCliked()
	 {
		 String recipient = recipientTextField.getText(); 
		 if (!recipient.isBlank() && !recipientNames.contains(recipient))
		 {
			 vbox.getChildren().add(1, new Label(recipientTextField.getText()));
			 recipientNames.add(recipientTextField.getText());
			 recipientTextField.setText("");
		 }
	 }
	 
	 
	 public void onAddPluginCliked()
	 {
		 if(!pluginChoiceBox.getSelectionModel().isEmpty())
		 {		
			try {
				 Form f = PluginManager.getPlugin(pluginChoiceBox.getSelectionModel().getSelectedItem()).getDeclaredConstructor().newInstance().getForm();
				 msgElements.add(f);
				 vbox.getChildren().add(vbox.getChildren().size()-1, new FormEditView().addForm(f));				 
				 ExpandableTextArea text = new ExpandableTextArea("", true, false, 3, 300);
				 msgElements.add(text);
				 vbox.getChildren().add(vbox.getChildren().size()-1, text);
			} catch (Exception e) {
				e.printStackTrace();
			}
			pluginChoiceBox.getSelectionModel().clearSelection();
		 }		
	 }
	 
	 
	 
	 public void addEditQuestion(Question q)
	 {
		 AnswerEditView answerView = new AnswerEditView();
		 msgElements.add(answerView);
		 answerToQuestion.put(answerView, q);
		 vbox.getChildren().add(vbox.getChildren().size()-1, answerView.addQuestion(q));
		 ExpandableTextArea text = new ExpandableTextArea("", true, false, 3, 300);
		 vbox.getChildren().add(vbox.getChildren().size()-1, text);
		 msgElements.add(text);
	 }
	 
	 
	 public Msg createMsg(BigInteger id)
	 {
		 Msg msg = new Msg();
		 msg.setConvId(id);
		 Msg.Header header = new Msg.Header();
		 header.setDate(null); //TODO
		 header.setFrom(writterTextField.getText());
		 header.setTo(String.join(",", recipientNames));
		 msg.setHeader(header);
		 Data data = new Data();
		 for(Object o : msgElements)
		 {
			 if(o instanceof Form)
				 data.getQuestionOrReplyOrForm().add((Form)o);
			 else if(o instanceof ExpandableTextArea)
				 data.getQuestionOrReplyOrForm().add(((ExpandableTextArea)o).getText());
			 else if(o instanceof AnswerEditView)
			 {
				 Reply reply = new Reply();
				 AnswerEditView answerEditView = (AnswerEditView)o;
				 Question q = answerToQuestion.get(answerEditView);
				 reply.setQuestionId(q.getId());
				 if(q.getTextInput() != null)
				 {
					 ReplyText r =  new ReplyText();
					 r.setValue(answerEditView.getStringResult());
					 reply.setReplyText(r);
				 }	
				 else if(q.getEmailInput() != null)
				 {
					 ReplyEmail r =  new ReplyEmail();
					 r.setValue(answerEditView.getStringResult());
					 reply.setReplyEmail(r);
				 }	
				 else if(q.getPhoneNumberInput() != null)
				 {
					 ReplyPhoneNumber r =  new ReplyPhoneNumber();
					 r.setValue(answerEditView.getStringResult());
					 reply.setReplyPhoneNumber(r);
				 }
				 else if(q.getDecimalInput() != null)
				 {
					 ReplyDecimal r =  new ReplyDecimal();
					 r.setValue(new BigDecimal(answerEditView.getStringResult()));
					 reply.setReplyDecimal(r);
				 }
				 else if(q.getIntegerInput() != null)
				 {
					 ReplyInteger r =  new ReplyInteger();
					 r.setValue(new BigInteger(answerEditView.getStringResult()));
					 reply.setReplyInteger(r);
				 }
				 data.getQuestionOrReplyOrForm().add(reply);
			 }
		 }
		 return msg;
	 }
	 
	 
}
