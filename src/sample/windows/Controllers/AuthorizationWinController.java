package sample.windows.Controllers;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import sample.animation.Shake;
import sample.dataBaseWorkClasses.DbHandler;
import sample.global.GlobalStatic;
import sample.workedClasses.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AuthorizationWinController {
    @FXML
    private Button input;

    @FXML
    private TextField password;

    @FXML
    private TextField login;

    @FXML
    private Button out;

    @FXML
    private Controller button = new Controller();

    @FXML
    private AlertWindowController text = new AlertWindowController();

    @FXML
    void initialize(){

        out.setOnAction(event -> button.newWinButton("/sample/windows/FXML's/personWindow.fxml", out, "/sample/cssFiles/personWindow.css",1));

        input.setOnAction(event -> {

            String loginText = login.getText().trim();
            String passText = password.getText().trim();

            if(!loginText.isEmpty() && !passText.isEmpty())
            {
                try {
                    loginUser(loginText,passText);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }else {
                button.newWinButton("/sample/windows/FXML's/ErrorWindow.fxml", input, "/sample/cssFiles/personWindow.css", 0);
                System.out.println("Empty");
            }
            button.newWinButton("/sample/windows/FXML's/libraryWin.fxml", input, "/sample/cssFiles/personWindow.css", 1);
        });
    }

    private void loginUser(String login, String pass) throws SQLException {
        DbHandler dbHandler = new DbHandler();
        User user = new User();
        user.setLogin(login);
        user.setPassword(pass);
        ResultSet resultSet = dbHandler.getUser(user);

        int counter = 0;
        while (resultSet.next()){
            counter++;
        }
        if(counter>=1){
            button.newWinButton("/sample/windows/FXML's/alertWindow.fxml", input, "/sample/cssFiles/personWindow.css", 0);
            GlobalStatic.isAuhthorization = true;
        }else{
            button.newWinButton("/sample/windows/FXML's/ErrorWindow.fxml", input, "/sample/cssFiles/personWindow.css", 0);
            System.out.println("Error");
            Shake loginShake = new Shake(this.login);
            Shake passShake = new Shake(password);
            loginShake.play();
            passShake.play();
        }
    }
}
