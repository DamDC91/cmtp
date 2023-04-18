package cmtp.plugin;

import cmtp.AbstractPlugin;
import generated.Form;

public class SimplePlugin extends AbstractPlugin {

	public SimplePlugin() {};
	
	public Form getForm()
	{
		// Read from file or generated using dynamic data
		return new Form();
	}
}
