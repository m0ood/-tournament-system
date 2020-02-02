package sample.controll.overview;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import sample.Const;
import sample.Data;
import sample.Players;
import sample.Team;

import java.io.IOException;
import java.sql.SQLException;

public class playerController {

    @FXML
    private Button key3;

    @FXML
    private Button key4;

    @FXML
    private ObservableList<Players> usersData = FXCollections.observableArrayList();

    @FXML
    private TableView<Players> personTable;

    @FXML
    private TableColumn<Players, String> players;

    @FXML
    private TableColumn<Players, String> teams;


    @FXML
    private TableColumn<Players, Double> kd;
    @FXML
    private Button back;

    @FXML
    void initialize() throws SQLException, ClassNotFoundException {
        players.setCellValueFactory(new PropertyValueFactory<>("players"));
        teams.setCellValueFactory(new PropertyValueFactory<>("team"));
        kd.setCellValueFactory(new PropertyValueFactory<>("kd"));
        Data dbData = new Data();
        Team team=new Team();
        team.setIdUser(Integer.parseInt(Const.ID));
        String[] teams= dbData.getsTeamsIds(team);
        usersData=dbData.AllPlayers(teams);


        key3.setOnAction(event -> {
            key3.getScene().getWindow().hide();

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/sample/controll/overview/Teams.fxml"));

            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setTitle("Команды");
            stage.setScene(new Scene(root));
            stage.show();
        });
        key4.setOnAction(event -> {
            key4.getScene().getWindow().hide();

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/sample/controll/overview/games.fxml"));

            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setTitle("Матчи");
            stage.setScene(new Scene(root));
            stage.show();
        });
        personTable.setItems(usersData);
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
