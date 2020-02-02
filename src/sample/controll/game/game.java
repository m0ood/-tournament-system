package sample.controll.game;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;


import javafx.scene.control.TableColumn;
import javafx.stage.Stage;
import sample.Const;
import sample.Data;
import sample.Team;
import sample.animation.singup;

import java.io.IOException;
import java.sql.SQLException;

import static sample.controll.registration.REGISTR.isNumeric;

public class game {

    public Button apply;
    private ObservableList<team> usersData = FXCollections.observableArrayList();
    private ObservableList<team> data = FXCollections.observableArrayList();
    @FXML
    private TableView<team> tableUsers;

    @FXML
    private TableColumn<team, String> loginColumn;
    @FXML
    private TableView<team> tableUsers1;

    @FXML
    private TableColumn<team, String> loginColumn1;

    @FXML
    private TextField kill1;

    @FXML
    private TextField death1;

    @FXML
    private TextField kill2;

    @FXML
    private TextField death2;

    @FXML
    private TextField kill3;

    @FXML
    private TextField death3;

    @FXML
    private TextField kill4;

    @FXML
    private TextField death4;

    @FXML
    private TextField kill5;

    @FXML
    private TextField death5;

    @FXML
    private TextField kill6;

    @FXML
    private TextField death6;

    @FXML
    private TextField kill7;

    @FXML
    private TextField death7;

    @FXML
    private TextField kill8;

    @FXML
    private TextField death8;

    @FXML
    private TextField kill9;

    @FXML
    private TextField death9;

    @FXML
    private TextField kill10;

    @FXML
    private TextField death10;

    @FXML
    private TextField score;

    // инициализируем форму данными
    @FXML
    private void initialize() throws SQLException, ClassNotFoundException {
        Data dbData = new Data();
        Team team1= new Team();
        team1.setTeamname(Const.TEAM1);

        Team team2= new Team();
        String a1=dbData.getsIdTeam(team1);
        team2.setTeamname(Const.TEAM2);
        String a2=dbData.getsIdTeam(team2);
        String[] Team1= dbData.getsPlayers(team1);
        String[] Team2= dbData.getsPlayers(team2);
        initData(Team1,usersData);
        initData(Team2,data);

        loginColumn.setCellValueFactory(new PropertyValueFactory<>("Login"));
        loginColumn1.setCellValueFactory(new PropertyValueFactory<>("Login"));

        // заполняем таблицу данными
        tableUsers.setItems(usersData);
        tableUsers1.setItems(data);
        kill1.getText();

        apply.setOnAction(event -> {
            if (!isNumeric(kill1.getText()) | !isNumeric(kill2.getText()) | !isNumeric(kill3.getText()) | !isNumeric(kill4.getText()) | !isNumeric(kill5.getText()) | !isNumeric(kill6.getText())| !isNumeric(kill7.getText())| !isNumeric(kill8.getText())| !isNumeric(kill9.getText())| !isNumeric(kill10.getText())| !isNumeric(death1.getText()) | !isNumeric(death2.getText()) | !isNumeric(death3.getText()) | !isNumeric(death4.getText()) | !isNumeric(death5.getText()) | !isNumeric(death6.getText())| !isNumeric(death7.getText())| !isNumeric(death8.getText())| !isNumeric(death9.getText())| !isNumeric(death10.getText())) {
                singup Name = new singup(kill1);
                singup Name1 = new singup(kill2);
                singup Name2 = new singup(kill3);
                singup Name3 = new singup(kill4);
                singup Name4 = new singup(kill5);
                singup Name5 = new singup(kill6);
                singup Name6 = new singup(kill7);
                singup Name7 = new singup(kill8);
                singup Name8 = new singup(kill9);
                singup Name9 = new singup(kill10);
                singup Name10 = new singup(death1);
                singup Name11 = new singup(death2);
                singup Name12 = new singup(death3);
                singup Name13 = new singup(death4);
                singup Name14 = new singup(death5);
                singup Name15 = new singup(death6);
                singup Name16 = new singup(death7);
                singup Name17 = new singup(death8);
                singup Name18 = new singup(death9);
                singup Name19 = new singup(death10);
                Name.playAnim();
                Name1.playAnim();
                Name2.playAnim();
                Name3.playAnim();
                Name4.playAnim();
                Name5.playAnim();
                Name6.playAnim();
                Name7.playAnim();
                Name8.playAnim();
                Name9.playAnim();
                Name10.playAnim();
                Name11.playAnim();
                Name12.playAnim();
                Name13.playAnim();
                Name14.playAnim();
                Name15.playAnim();
                Name16.playAnim();
                Name17.playAnim();
                Name18.playAnim();
                Name19.playAnim();
                System.out.println(kill1.getText());
                try {
                    System.out.println(dbData.getsKd(kill1.getText()));
                } catch (SQLException | ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
            else {
                try {
                    if(dbData.getMa(Const.TEAM1)==0){
                    dbData.setKD(Team1[0], toDouble(kill1.getText(), death1.getText()),a1);
                    dbData.setKD(Team1[1], toDouble(kill2.getText(), death2.getText()),a1);
                    dbData.setKD(Team1[2], toDouble(kill3.getText(), death3.getText()),a1);
                    dbData.setKD(Team1[3], toDouble(kill4.getText(), death4.getText()),a1);
                    dbData.setKD(Team1[4], toDouble(kill5.getText(), death5.getText()),a1);}
                    else{ dbData.setKD(Team1[0], ((toDouble(kill1.getText(), death1.getText()))+dbData.getsKd(Team1[0]))/2,a1);
                    dbData.setKD(Team1[1], ((toDouble(kill2.getText(), death2.getText()))+dbData.getsKd(Team1[1]))/2,a1);
                    dbData.setKD(Team1[2], ((toDouble(kill3.getText(), death3.getText()))+dbData.getsKd(Team1[2]))/2,a1);
                    dbData.setKD(Team1[3], ((toDouble(kill4.getText(), death4.getText()))+dbData.getsKd(Team1[3]))/2,a1);
                    dbData.setKD(Team1[4], ((toDouble(kill5.getText(), death5.getText()))+dbData.getsKd(Team1[4]))/2,a1);}
                    if(dbData.getMa(Const.TEAM2)==0) {
                    dbData.setKD(Team2[0], toDouble(kill6.getText(), death6.getText()),a2);
                    dbData.setKD(Team2[1], toDouble(kill7.getText(), death7.getText()),a2);
                    dbData.setKD(Team2[2], toDouble(kill8.getText(), death8.getText()),a2);
                    dbData.setKD(Team2[3], toDouble(kill9.getText(), death9.getText()),a2);
                    dbData.setKD(Team2[4], toDouble(kill10.getText(), death10.getText()),a2);}
                    else {dbData.setKD(Team2[0], ((toDouble(kill6.getText(), death6.getText()))+dbData.getsKd(Team2[0]))/2,a2);
                   dbData.setKD(Team2[1], ((toDouble(kill7.getText(), death7.getText()))+dbData.getsKd(Team2[1]))/2,a2);
                   dbData.setKD(Team2[2], ((toDouble(kill8.getText(), death8.getText()))+dbData.getsKd(Team2[2]))/2,a2);
                   dbData.setKD(Team2[3], ((toDouble(kill9.getText(), death9.getText()))+dbData.getsKd(Team2[3]))/2,a2);
                   dbData.setKD(Team2[4], ((toDouble(kill10.getText(), death10.getText()))+dbData.getsKd(Team2[4]))/2,a2);}
                } catch (SQLException | ClassNotFoundException e) {
                    e.printStackTrace();
                }
                try {
                    dbData.setMatch(Const.TEAM1);
                    dbData.setMatch(Const.TEAM2);
                    dbData.singUpMatch(Const.TEAM1,Const.TEAM2,Const.MAP,score.getText());
                } catch (ClassNotFoundException | SQLException e) {
                    e.printStackTrace();
                }
                apply.getScene().getWindow().hide();
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/sample/controll/menu/window3.fxml"));
                try {
                    loader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Parent root = loader.getRoot();
                Stage stage = new Stage();
                stage.setTitle("Информация");
                stage.setScene(new Scene(root));
                stage.show();
            }
        });

    }

    // подготавливаем данные для таблицы
    // вы можете получать их с базы данных
    private void initData(String[] team,ObservableList<team> data1) {
        data1.add(new team(team[0]));
        data1.add(new team(team[1]));
        data1.add(new team(team[2]));
        data1.add(new team(team[3]));
        data1.add(new team(team[4]));
    }
    private double toDouble(String a,String t)
    {
        Double i1 =1.0;
        Double i2=1.0;
        try {
            i1 = Double.valueOf(a);
            i2 = Double.valueOf(t);
        }catch (NumberFormatException e) {

        }
        return i1/i2;
    }

}
