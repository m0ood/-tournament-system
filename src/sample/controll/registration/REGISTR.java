package sample.controll.registration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.Data;

public class REGISTR {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField quantity;

    @FXML
    private Button okey;

    @FXML
    private TextField login;


    @FXML
    private TextField password;

    @FXML
    private Button back;
    public static boolean isNumeric(String str)
    {
        try
        {
            Integer d = Integer.parseInt(str);
        }
        catch(NumberFormatException nfe)
        {
            return false;
        }
        return true;
    }
    @FXML
    void initialize() {
        okey.setOnAction(event -> {
            if (isNumeric(quantity.getText()))
            {
                singUpNewUser();
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/sample/controll/login/registration.fxml"));

                try {
                    loader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                Parent root = loader.getRoot();
                Stage stage = new Stage();
                stage.setTitle("Вход");
                stage.setScene(new Scene(root));
                stage.show();
            }
        });
        back.setOnAction(event -> {
                back.getScene().getWindow().hide();
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/sample/controll/login/registration.fxml"));

                try {
                    loader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                Parent root = loader.getRoot();
                Stage stage = new Stage();
                stage.setTitle("Вход");
                stage.setScene(new Scene(root));
                stage.show();
        });

    }

    private void singUpNewUser() {
        Data db = new Data();
        String Quantity=quantity.getText();
        String Login=login.getText();
        String Password=password.getText();
        okey.getScene().getWindow().hide();
        try {
            db.singUpUser(Quantity, Login, Password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
