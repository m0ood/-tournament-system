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
import sample.Team;

import java.io.IOException;
import java.sql.SQLException;

public class teamsController {
    @FXML
    private ObservableList<Team> usersData = FXCollections.observableArrayList();

    @FXML
    private Button key2;

    @FXML
    private Button key4;

    @FXML
    private TableView<Team> team1;

    @FXML
    private TableColumn<Team, String> Teams;

    @FXML
    private TableColumn<Team, Integer>  maps;
    @FXML
    private Button back;
    @FXML
    void initialize() throws SQLException, ClassNotFoundException {
        Teams.setCellValueFactory(new PropertyValueFactory<Team, String>("teamname"));
        maps.setCellValueFactory(new PropertyValueFactory<Team,Integer>("matchs"));
        Data dbData = new Data();
        Team team=new Team();
        team.setIdUser(Integer.parseInt(Const.ID));
        usersData=dbData.getsTeamsInfo(team);
        team1.setItems(usersData);
        key2.setOnAction(event -> {
            key2.getScene().getWindow().hide();
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
            stage.setTitle("Игры");
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
