package sample.windows.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import sample.dataBaseWorkClasses.DbHandler;
import sample.workedClasses.Book;

import java.sql.ResultSet;
import java.sql.SQLException;

public class newBookController {


    @FXML
    private Button Cancel;

    @FXML
    private TextField author;

    @FXML
    private TextField name;

    @FXML
    private Button Ok;

    @FXML
    private Controller controller = new Controller();

    private AlertWindowController text= new AlertWindowController();

    @FXML
    void initialize()
    {
        Cancel.setOnAction(event -> {
            Cancel.getScene().getWindow().hide();
        });

        Ok.setOnAction(event -> {
            DbHandler dbHandler = new DbHandler();
            Book book = new Book();
            book.setNameBook(name.getText().trim());
            System.out.println(name.getText().trim());
            System.out.println(author.getText().trim());
            book.setAuthor(author.getText().trim());

           dbHandler.newBook(book);
            if(DbHandler.getFlag()==0) controller.newWinButton("/sample/windows/FXML's/alertWindow.fxml", Ok, "/sample/cssFiles/personWindow.css", 0);
            else controller.newWinButton("/sample/windows/FXML's/ErrorWindow.fxml", Ok, "/sample/cssFiles/personWindow.css", 0);
        });
    }
}
