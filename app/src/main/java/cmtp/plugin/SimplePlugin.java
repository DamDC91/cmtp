package cmtp.plugin;

import cmtp.AbstractPlugin;
import generated.Form;
import generated.Question;
import generated.TextInput;

public class SimplePlugin extends AbstractPlugin {

	public SimplePlugin() {};
	
	public Form getForm() // add id
	{
		// Read from file or generated using dynamic data
		Form f = new Form();
		f.setId("42");
		f.setTitle("SimpleForm");
		Question q = new Question();
		q.setText("Simple Question");
		q.setId("42/1");
		TextInput t = new TextInput();
		t.setLabel("input");
		q.setTextInput(t);
		f.getQuestionOrTextOrForm().add(q);
		return f;
	}
}
