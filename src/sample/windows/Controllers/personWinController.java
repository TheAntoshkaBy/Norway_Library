package sample.windows.Controllers;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import sample.animation.Shake;
import sample.global.GlobalStatic;

import java.io.IOException;

public class personWinController {

    @FXML
    private Button readersList;

    @FXML
    private Button registration;

    @FXML
    private Button avtorization;

    @FXML
    private Button prevWin;

    @FXML
    Controller button = new Controller();

    @FXML
    void initialize()
    {
        prevWin.setOnAction(event ->
            button.newWinButton("/sample/windows/FXML's/sample.fxml", prevWin, "/sample/cssFiles/mainWindow.css",1));

        registration.setOnAction(event -> {
            if(GlobalStatic.isAuhthorization){
                button.newWinButton("/sample/windows/FXML's/registrationWin.fxml", registration, "/sample/cssFiles/registrationWin.css",1);
            }else{
                Shake shake = new Shake(registration);
                shake.play();
            }
        });

        avtorization.setOnAction(event ->
                button.newWinButton("/sample/windows/FXML's/authorizationWin.fxml", avtorization, "/sample/cssFiles/avtorize.css",1));

        readersList.setOnAction(event ->
                button.newWinButton("/sample/windows/FXML's/readersWin.fxml", readersList, "/sample/cssFiles/readerList.css",1));
    }
}