package sample.windows.Controllers;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import sample.Main;

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

       });
    }

}
