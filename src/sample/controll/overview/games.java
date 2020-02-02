package sample.controll.overview;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import sample.Data;
import sample.matches;

public class games {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button key2;

    @FXML
    private Button key1;

    @FXML
    private TableView<matches> personTable;

    @FXML
    private TableColumn<matches, String> team1;

    @FXML
    private TableColumn<matches, String> team2;

    @FXML
    private TableColumn<matches,String> map;

    @FXML
    private TableColumn<matches, String> score;
    @FXML
    private Button back;

    @FXML
    void initialize() throws SQLException, ClassNotFoundException {
        team1.setCellValueFactory(new PropertyValueFactory<>("team1"));
        team2.setCellValueFactory(new PropertyValueFactory<>("team2"));
        map.setCellValueFactory(new PropertyValueFactory<>("map"));
        score.setCellValueFactory(new PropertyValueFactory<>("score"));
        Data dbData = new Data();
        personTable.setItems(dbData.AllMatchs());
        key1.setOnAction(event -> {
            key1.getScene().getWindow().hide();

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/sample/controll/overview/kappa.fxml"));

            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setTitle("Игроки");
            stage.setScene(new Scene(root));
            stage.show();
        });
        key2.setOnAction(event -> {
            key2.getScene().getWindow().hide();

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/sample/controll/overview/Teams.fxml"));

            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setTitle("Команда");
            stage.setScene(new Scene(root));
            stage.show();
        });
        back.setOnAction(event -> {
            back.getScene().getWindow().hide();

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/sample/controll/menu/window3.fxml"));

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
