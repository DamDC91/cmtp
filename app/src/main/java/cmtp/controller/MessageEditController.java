package cmtp.controller;

import java.util.Set;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;
import java.util.GregorianCalendar;

import cmtp.plugin.PluginManager;
import cmtp.repository.ModelManager;
import cmtp.repository.ModelManager.UnknownConversation;
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
	
	@FXML
	private ExpandableTextArea firstExpandableTextArea;
	
	
	private Set<String> recipientNames;
	
	
	private Map<AnswerEditView, QuestionWithIds> answerToQuestion;
	
	
	private ArrayList<Object> msgElements;
	
	private BigInteger convId;
	
	 @FXML
	 private void initialize() {
		 recipientNames = new HashSet<String>();
		 msgElements = new ArrayList<Object>();
		 msgElements.add(firstExpandableTextArea);
		 answerToQuestion = new HashMap<AnswerEditView, QuestionWithIds>();
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
				 vbox.getChildren().add(vbox.getChildren().size()-2, new FormEditView(f));				 
				 ExpandableTextArea text = new ExpandableTextArea("", true, false, 3, 300);
				 msgElements.add(text);
				 vbox.getChildren().add(vbox.getChildren().size()-2, text);
			} catch (Exception e) {
				e.printStackTrace();
			}
			pluginChoiceBox.getSelectionModel().clearSelection();
		 }		
	 }
	 
	 public void setConvId(BigInteger id)
	 {
		 this.convId = id;
	 }
	 
	 public void addEditQuestion(QuestionWithIds q)
	 {
		 AnswerEditView answerView = new AnswerEditView(q.getQuestion());
		 msgElements.add(answerView);
		 answerToQuestion.put(answerView, q);
		 vbox.getChildren().add(vbox.getChildren().size()-2, answerView);
		 ExpandableTextArea text = new ExpandableTextArea("", true, false, 3, 300);
		 vbox.getChildren().add(vbox.getChildren().size()-2, text);
		 msgElements.add(text);
	 }
	 
	 
	 
	 public Msg createMsg()
	 {
		 Msg msg = new Msg();
		 msg.setConvId(convId);
		 Msg.Header header = new Msg.Header();
		 GregorianCalendar cal = new GregorianCalendar();
		 cal.setTime(new Date());
		 XMLGregorianCalendar xCal = null;
		try {
			xCal = DatatypeFactory.newInstance()
			     .newXMLGregorianCalendar(cal);
		} catch (DatatypeConfigurationException e) {
			e.printStackTrace();
		}
		 header.setDate(xCal);
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
				 Question q = answerToQuestion.get(answerEditView).getQuestion();
				 reply.setQuestionId(answerToQuestion.get(answerEditView).getFullId());
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
		 msg.setData(data);
		 return msg;
	 }
	 
	 public void onSendCliked()
	 {
		 try {
			ModelManager.getInstance().addMsg(createMsg());
		} catch (UnknownConversation e) {			
			e.printStackTrace();
		}
		// TODO reset everything to initial state
	 }
}
