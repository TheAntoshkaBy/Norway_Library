package sample.windows.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class LibraryWinController {

    @FXML
    private Button prevWin;

    @FXML
    private Button bookingList;

    @FXML
    private Button newBook;

    @FXML
    Controller button = new Controller();


    @FXML
    void initialize(){
        button.newWinButton("/sample/windows/FXML's/sample.fxml", prevWin, "/sample/cssFiles/mainWindow.css");
        button.newWinButton("/sample/windows/FXML's/libraryListWin.fxml", bookingList, "/sample/cssFiles/readerList.css");
        newBook.setOnAction(event -> {

                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("/sample/windows/FXML's/newBook.fxml"));
                try {
                    loader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Parent root = loader.getRoot();

                Stage stage = new Stage();
                Scene scene = new Scene(root);
                stage.getIcons().add(new Image(getClass().getResourceAsStream("/sample/Images/2.png")));
               // scene.getStylesheets().add(getClass().getResource("/sample/cssFiles/readerList.css").toExternalForm());
                stage.setScene(scene);
                stage.showAndWait();

        });

    }
}
