package sample.windows.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class PersonPageController {
    @FXML
    public Button closeButton;

    @FXML
    public Label name;

    @FXML
    private Label reserveBook;

    @FXML
    private Label data;

    @FXML
    private Label surname;


    @FXML
    private Label login;

    @FXML
    private Label readBook;

    @FXML
    private Label male;

    @FXML
    private Pane imageField;

    private static String nameOfField;
    private static String surnameOfField;
    private static String loginOfField;
    private static String readBookOfField;
    private static String reserveOfField;
    private static String maleOfField;


    @FXML
    public void handleCloseButtonAction(ActionEvent event) {
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }
    @FXML
    void initialize() {
        name.setText(name.getText() + " " +nameOfField);
        surname.setText(surname.getText() + " " + surnameOfField);
        login.setText(login.getText() + " " + loginOfField);
        male.setText(male.getText() + " " + maleOfField);
        data.setText(data.getText() + " " + "08.02.2019");
        readBook.setText(readBook.getText() + " " + readBookOfField);
        reserveBook.setText(reserveBook.getText() + " " + reserveOfField);
        Image image = new Image(getClass().getResourceAsStream("../../Images/1.jpg"));
        ImageView imageView = new ImageView(image);
        imageField.getChildren().addAll(imageView);
    }
    public static void PersonPage(String name, String surname, String login, String male, String readBook, String reserveBook){
        try {

            nameOfField = name;
            surnameOfField = surname;
            loginOfField = login;
            maleOfField = male;
            readBookOfField = readBook;
            reserveOfField = reserveBook;

            FXMLLoader fxmlLoader = new FXMLLoader(PersonPageController.class.getResource("/sample/windows/FXML's/personPageWin.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}