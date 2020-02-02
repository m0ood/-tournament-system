package sample.controll.tournament;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.Const;
import sample.Data;
import sample.Team;

import static sample.controll.registration.REGISTR.isNumeric;

public class window5 {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ChoiceBox<String> team1;

    @FXML
    private ChoiceBox<String> team2;

    @FXML
    private TextField map;

    @FXML
    private Button apply;
    @FXML
    private Button back;

    @FXML
    void initialize() throws SQLException, ClassNotFoundException {
        Data dbData = new Data();
        Team team= new Team();
        team.setIdUser(Integer.parseInt(Const.ID));
        Const.NamesTeam = dbData.getsTeams(team);
        int a=0;
        while(a<Const.SCORETEAM) {
            team1.getItems().add(Const.NamesTeam[a]);
            a++;
        }
        int b=0;
        while(b<Const.SCORETEAM) {
            team2.getItems().add(Const.NamesTeam[b]);
            b++;
        }
        apply.setOnAction(event -> {
                String Team1 = team1.getValue();
                String Team2 = team2.getValue();
                Const.TEAM1= Team1;
                Const.TEAM2= Team2;
                if(!Team1.equals(Team2)|!isNumeric(map.getText())) {
                    Const.MAP=map.getText();
                apply.getScene().getWindow().hide();
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/sample/controll/game/xxx.fxml"));

                try {
                    loader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                Parent root = loader.getRoot();
                Stage stage = new Stage();
                stage.setTitle("Регистрация матча");
                stage.setScene(new Scene(root));
                stage.show();
                }
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
                stage.setTitle("Регистрация команды");
                stage.setScene(new Scene(root));
                stage.show();

        });
    }
}
