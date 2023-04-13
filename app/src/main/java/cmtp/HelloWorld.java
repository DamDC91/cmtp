package cmtp;
 
import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import generated.Msg;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
 
public class HelloWorld extends Application 
{

    public static void main(String[] args) 
    {
    	
        launch(args);
        try {
	        JAXBContext jc = JAXBContext.newInstance(Msg.class);
	
	        Unmarshaller unmarshaller = jc.createUnmarshaller();
	        File xml = new File("put your xml file path here");
	        Msg Message = (Msg) unmarshaller.unmarshal(xml);
	        System.out.println(Message.getHeader().getFrom());
		}
		catch(Exception e) {
			e.printStackTrace();
		}
    }

    @Override
    public void start(Stage primaryStage) 
    {
        primaryStage.setTitle("TCMP MC");
        Parent root = null;
        try{
            root = FXMLLoader.load(getClass().getResource("/views/main_view.fxml"));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        primaryStage.setScene(new Scene(root, 300, 250));
        primaryStage.setMaximized(true);
        primaryStage.show();
    }
}
