package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception{

        Parent root = FXMLLoader.load(getClass().getResource("windows/FXML's/sample.fxml"));
        Scene scene = new Scene(root, 1100, 700);
        stage.setTitle("Booking Club");
        stage.getIcons().add(new Image(getClass().getResourceAsStream("Images/2.png")));
        scene.getStylesheets().add(getClass().getResource("cssFiles/mainWindow.css").toExternalForm());
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
