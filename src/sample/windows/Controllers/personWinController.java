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
    void initialize()
    {
        prevWin.setOnAction(event -> {
            prevWin.getScene().getWindow().hide();

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/windows/FXML's/sample.fxml"));

            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Parent root = loader.getRoot();
            Stage stage = new Stage();
            Scene scene = new Scene(root);
            stage.getIcons().add(new Image(getClass().getResourceAsStream("/sample/Images/2.png")));
            scene.getStylesheets().add(getClass().getResource("/sample/cssFiles/mainWindow.css").toExternalForm());

            stage.setScene(scene);
            stage.showAndWait();
        });

        registration.setOnAction(event -> {
            if(GlobalStatic.isAuhthorization){
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/windows/FXML's/registrationWin.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Parent root = loader.getRoot();

            Stage stage = new Stage();
            Scene scene = new Scene(root);
            stage.getIcons().add(new Image(getClass().getResourceAsStream("/sample/Images/2.png")));
            scene.getStylesheets().add(getClass().getResource("/sample/cssFiles/registrationWin.css").toExternalForm());
            stage.setScene(scene);
            stage.showAndWait();
            }else{
                Shake shake = new Shake(registration);
                shake.play();
            }


        });

        avtorization.setOnAction(event -> {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/windows/FXML's/authorizationWin.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Parent root = loader.getRoot();

            Stage stage = new Stage();
            Scene scene = new Scene(root);
            stage.getIcons().add(new Image(getClass().getResourceAsStream("/sample/Images/2.png")));
            scene.getStylesheets().add(getClass().getResource("/sample/cssFiles/avtorize.css").toExternalForm());
            stage.setScene(scene);
            stage.showAndWait();


        });

        readersList.setOnAction(event -> {
          /*  if(GlobalStatic.isAuhthorization){
                System.out.println("SEEE");

            }else{
                Shake shake = new Shake(readersList);
                shake.play();
            }*/

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/windows/FXML's/readersWin.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Parent root = loader.getRoot();

            Stage stage = new Stage();
            Scene scene = new Scene(root);
            stage.getIcons().add(new Image(getClass().getResourceAsStream("/sample/Images/2.png")));
            scene.getStylesheets().add(getClass().getResource("/sample/cssFiles/readerList.css").toExternalForm());
            stage.setScene(scene);
            stage.showAndWait();
        });
    }

}