package cmtp.view;

import generated.CheckboxGroup;
import generated.DecimalInput;
import generated.EmailInput;
import generated.IntegerInput;
import generated.PhoneNumberInput;
import generated.Question;
import generated.Radio;
import generated.RadioGroup;
import generated.TextInput;
import generated.Checkbox;
import javafx.scene.layout.Pane;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ColorPicker;
import javafx.scene.paint.Color;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class QuestionView {
	
	private boolean editable;
	
	public QuestionView(boolean editable)
	{
		this.editable = editable;
	}
	
	public QuestionView()
	{}
	
	

	private void addCheckboxGroup(Pane pane, CheckboxGroup checkboxGroup)
	{
		for(Checkbox c : checkboxGroup.getCheckbox())
		{			
			CheckBox but = new CheckBox(c.getLabel());
			pane.getChildren().add(but);
		}		
	}
	

	private void addRadioGroup(Pane pane, RadioGroup radioGroup)
	{
		ToggleGroup tg = new ToggleGroup();	
		for(Radio c : radioGroup.getRadio())
		{			
			RadioButton but = new RadioButton(c.getLabel());
			but.setToggleGroup(tg);
			pane.getChildren().add(but);
		}
	}
	
	private void addTextInput(Pane pane, TextInput textInput)
	{		
		addTextUserInput(pane, textInput.getLabel());		
	}
	
	private void addEmailInput(Pane pane, EmailInput emailInput)
	{
		addTextUserInput(pane, emailInput.getLabel(), "^([0-9a-zA-Z]([-.\\w]*[0-9a-zA-Z])*@([0-9a-zA-Z][-\\w]*[0-9a-zA-Z]\\.)+[a-zA-Z]{2,9})$");
	}
	
	private void addPhoneNumberInput(Pane pane, PhoneNumberInput phoneNumberInput)
	{
		addTextUserInput(pane, phoneNumberInput.getLabel(), "\\+?\\d{10,14}$");
	}
	
	private void addDecimalInput(Pane pane, DecimalInput decimalInput)
	{
		addTextUserInput(pane, decimalInput.getLabel(), "^\\-?((\\d+\\.?\\d*)|(\\.\\d+))([Ee][+-]?\\d+)?$");
	}
	
	private void addIntegerInput(Pane pane, IntegerInput integerInput)
	{
		addTextUserInput(pane, integerInput.getLabel(), "^\\-?\\d+$");
	}
	
	private void addTextUserInput(Pane pane, String label)
	{
		addTextUserInput(pane, label, "");
	}
	
	private void addTextUserInput(Pane pane, String label, String regex)
	{
		Node paneChild = null;
		TextField input = new TextField();
		if(label != null && !label.isBlank())
		{
			Label l = new Label(label);
			HBox hbox = new HBox(10.0, l, input);
			paneChild = hbox;
		}
		else
		{			
			paneChild = input;
		}
		if(!regex.isBlank())
		{
			Pattern pattern = Pattern.compile(regex);
			input.setOnAction(e -> { 
				Matcher matcher = pattern.matcher(input.getText());
				if(!matcher.matches())
					input.setBorder(new Border(new BorderStroke(Color.RED, BorderStrokeStyle.SOLID, null, null)));
				else
					input.setBorder(null);
			});

		}
		pane.getChildren().add(paneChild);
	}
	
	private void addColorPicker(Pane pane)
	{
		pane.getChildren().add(new ColorPicker());
	}
	
	private void addDatePicker(Pane pane)
	{
		pane.getChildren().add(new DatePicker());
	}
	
	
	private void dispatch(Pane pane, Question q)
	{		
		if(q.getCheckboxGroup() != null)
		{
			addCheckboxGroup(pane, q.getCheckboxGroup());
		}
		if(q.getRadioGroup() != null)
		{
			addRadioGroup(pane, q.getRadioGroup());
		}
		else if(q.getTextInput() != null)
		{
			addTextInput(pane, q.getTextInput());
		}
		else if(q.getEmailInput() != null)
		{
			addEmailInput(pane, q.getEmailInput());
		}
		else if(q.getPhoneNumberInput() != null)
		{
			addPhoneNumberInput(pane, q.getPhoneNumberInput());
		}
		else if(q.getDecimalInput() != null)
		{
			addDecimalInput(pane, q.getDecimalInput());
		}
		else if(q.getIntegerInput() != null)
		{
			addIntegerInput(pane, q.getIntegerInput());
		}
		else if(q.getColorpicker() != null)
		{
			addColorPicker(pane);
		}
		else if(q.getDatepicker() != null)
		{
			addDatePicker(pane);
		}
		
	}
	
	public Pane addQuestion(Question q)
	{
		VBox vbox = new VBox();
		Pane pane = new Pane(vbox);
		
		if(!q.getText().isBlank()) 
		{
			Label label = new Label(q.getText());
			vbox.getChildren().add(label);
		}
		dispatch(vbox, q);
		return pane;
	}

}
