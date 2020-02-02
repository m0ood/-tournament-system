package sample.controll.menu;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import sample.Const;
import sample.Data;

public class window3 {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button main;

    @FXML
    private Button addcomand;

    @FXML
    private Button match;

    @FXML
    private Button delete;

    @FXML
    void initialize() {
        main.setOnAction(event -> {
            main.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/sample/controll/overview/kappa.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setTitle("Обзор");
            stage.setScene(new Scene(root));
            stage.show();
        });
        addcomand.setOnAction(event -> {
            if(Const.SCORE <Const.SCORETEAM) {
                addcomand.getScene().getWindow().hide();
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/sample/controll/registrteam/window4.fxml"));
                try {
                    loader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                Parent root = loader.getRoot();
                Stage stage = new Stage();
                stage.setTitle("Регистрация команды");
                stage.setScene(new Scene(root));
                stage.show();
            }
            else {
            }
        });
        match.setOnAction(event -> {
            match.getScene().getWindow().hide();

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/sample/controll/tournament/window5.fxml"));

            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setTitle("Провести матч");
            stage.setScene(new Scene(root));
            stage.show();
        });
        delete.setOnAction(event -> {
            Data dbData = new Data();
            try {
                dbData.Delete();
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }
            delete.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/sample/controll/login/registration.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setTitle("Обзор");
            stage.setScene(new Scene(root));
            stage.show();
        });
    }
}
