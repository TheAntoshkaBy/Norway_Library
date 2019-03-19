package sample.windows.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import sample.dataBaseWorkClasses.DbHandler;
import sample.workedClasses.Book;

import java.awt.*;

public class AlertWindowController {


    @FXML
    private javafx.scene.control.Button Ok;

    @FXML
    private Label Text;

    @FXML
    void initialize()
    {
        Ok.setOnAction(event -> Ok.getScene().getWindow().hide());
    }
}

