package cmtp;

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
        primaryStage.setTitle("CMTP MC");
        Parent root = null;
        try{
        	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/views/main_view.fxml"));
        	root = fxmlLoader.load();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        root.getStylesheets().add(getClass().getResource("/style/main_style.css").toExternalForm());
        primaryStage.setScene(new Scene(root, 300, 250));
        primaryStage.setMaximized(true);
        primaryStage.show();
    }
    
    
}
