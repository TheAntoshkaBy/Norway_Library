package sample.windows.Controllers;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class Controller {

    public void newWinButton(String fxmlPatch, Button button, String cssPatch)
    {
        button.getScene().getWindow().hide();

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(fxmlPatch));

        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Parent root = loader.getRoot();
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.getIcons().add(new Image(getClass().getResourceAsStream("/sample/Images/2.png")));
        if(cssPatch != "null")
        scene.getStylesheets().add(getClass().getResource(cssPatch).toExternalForm());

        stage.setScene(scene);
        stage.show();
    }



    @FXML
    private Button personWindow;

    @FXML
    private Button libraryWindow;

    @FXML
    private Label Welcome;


    @FXML
    void initialize(){
        personWindow.setOnAction(event -> newWinButton("/sample/windows/FXML's/personWindow.fxml", personWindow, "/sample/cssFiles/personWindow.css"));
        libraryWindow.setOnAction(event -> newWinButton("/sample/windows/FXML's/libraryWin.fxml", personWindow, "/sample/cssFiles/personWindow.css"));
    }


}
