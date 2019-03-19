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
        prevWin.setOnAction(event -> button.newWinButton("/sample/windows/FXML's/sample.fxml", prevWin, "/sample/cssFiles/mainWindow.css", 1));
        bookingList.setOnAction(event -> button.newWinButton("/sample/windows/FXML's/libraryListWin.fxml", bookingList, "/sample/cssFiles/readerList.css", 1));
        newBook.setOnAction(event ->  button.newWinButton("/sample/windows/FXML's/newBook.fxml", newBook, "/sample/cssFiles/personWindow.css", 0));
    }
}
