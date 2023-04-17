package cmtp;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import cmtp.ui.controller.AppController;
import generated.Conv;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
 
public class App extends Application 
{

    public static void main(String[] args) 
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage)
    {
        primaryStage.setTitle("TCMP MC");
        Parent root = null;
        try{
        	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/views/main_view.fxml"));
        	root = fxmlLoader.load();
        	AppController controller = fxmlLoader.getController();
        	addConv(controller);
        	
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        root.getStylesheets().add(getClass().getResource("/style/main_style.css").toExternalForm());
        primaryStage.setScene(new Scene(root, 300, 250));
        primaryStage.setMaximized(true);
        primaryStage.show();
    }
    
    
    // Testing purpose only
    private void addConv(AppController w) 
    {
        try {
	        JAXBContext jc = JAXBContext.newInstance(Conv.class);

	        Unmarshaller unmarshaller = jc.createUnmarshaller();
	        File xml = new File("../message-specs/test/kernel/question1.xml");
	        Conv conv= (Conv) unmarshaller.unmarshal(xml);
	        w.addConversationButton(conv);
	        w.addConversationButton(conv);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
    }
}
