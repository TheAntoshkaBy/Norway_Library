package sample.windows.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import sample.dataBaseWorkClasses.DbHandler;
import sample.workedClasses.User;


public class RegistrationWin {
    /**
     * В этом окне осуществляется работа с базой данных, мы вводим данные и отправляем их на SQL сервер.
     * Надеюсь получится, пока хз как буду делать.
     *
     */
    @FXML
    private TextField password;


    @FXML
    private CheckBox wooman;

    @FXML
    private TextField bookForClub;

    @FXML
    private TextField surname;

    @FXML
    private TextField name;

    @FXML
    private CheckBox man;

    @FXML
    private TextField logIn;

    @FXML
    private TextField nowBook;

    @FXML
    private Button registration;

    @FXML
    private Button out;




    @FXML
    void initialize() {
        out.setOnAction(event -> {
            out.getScene().getWindow().hide();
        });

        registration.setOnAction(event -> {
            DbHandler DbHandler = new DbHandler();
            String maleUs ="";
            if(man.isSelected())
            {
                maleUs = "мужской";
            }else{
                maleUs = "женский";
            }

            User user = new User(name.getText(),surname.getText(),logIn.getText(),nowBook.getText(),bookForClub.getText(),maleUs,password.getText());

            DbHandler.signUpUser(user);
        });
    }


}
