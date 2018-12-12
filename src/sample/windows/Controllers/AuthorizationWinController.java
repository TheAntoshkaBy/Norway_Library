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
    void initialize(){

        out.setOnAction(event -> {
            out.getScene().getWindow().hide();
        });

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
                System.out.println("Empty");
            }

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
            System.out.println("Yahooo");
            GlobalStatic.isAuhthorization = true;
            input.getScene().getWindow().hide();

        }else{
            System.out.println("Error");
            Shake loginShake = new Shake(this.login);
            Shake passShake = new Shake(password);
            loginShake.play();
            passShake.play();
        }
    }
}
