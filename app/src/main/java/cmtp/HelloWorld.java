package cmtp;
 
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
