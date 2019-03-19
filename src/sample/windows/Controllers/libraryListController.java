package sample.windows.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import sample.interfaces.impl.DbBookingList;
import sample.interfaces.impl.DbReaderList;
import sample.workedClasses.Book;
import sample.workedClasses.User;

import java.sql.SQLException;

public class libraryListController {


    @FXML
    private TableColumn<Book, String> name;

    @FXML
    private TableColumn<Book, String> author;


    @FXML
    private Button out;

    @FXML
    private TableView<Book> table;

    @FXML
    private Label label;

    @FXML
    void initialize() {
        out.setOnAction(event -> {
            out.getScene().getWindow().hide();
            Controller controller = new Controller();
            controller.newWinButton("/sample/windows/FXML's/libraryWin.fxml", out, "/sample/cssFiles/personWindow.css",1);
        });

        name.setCellValueFactory(new PropertyValueFactory<Book, String>("nameBook"));
        author.setCellValueFactory(new PropertyValueFactory<Book, String>("author"));

        DbBookingList dbReaderList = new DbBookingList();
        try {
            dbReaderList.addAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        table.setItems(dbReaderList.getBookingList());

        label.setText(label.getText() + dbReaderList.getBookingList().size());

    }
}


