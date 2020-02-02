package sample.controll.registrteam;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.*;
import sample.animation.singup;

import static sample.controll.registration.REGISTR.isNumeric;

public class window4 extends Config {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button select;

    @FXML
    private TextField name;

    @FXML
    private TextField name1;

    @FXML
    private TextField name2;

    @FXML
    private TextField name3;

    @FXML
    private TextField name4;

    @FXML
    private TextField name5;


    public void singUpCommand(String Name,String Name1,String Name2,String Name3,String Name4,String Name5) throws SQLException, ClassNotFoundException {
        String  insert= "INSERT INTO "+ Const.TEAM_TABLE+"("
                +Const.TEAM_NAME+","+Const.TEAM_ID+")"+"VALUES(?,?)";
        try {
            PreparedStatement prSt= getDbConnection().prepareStatement(insert);
            prSt.setString(1,Name);
            prSt.setString(2,Const.ID);
            prSt.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        Data dbData = new Data();
        Team team= new Team();
        team.setTeamname(Name);
        team.setIdUser(Integer.parseInt(Const.ID));
        Const.SCORE= dbData.getsCount(team);
        System.out.print(Const.SCORE);
        String a= dbData.getsIdTeam(team);
        singUpPlayer(Name1,a);
        singUpPlayer(Name2,a);
        singUpPlayer(Name3,a);
        singUpPlayer(Name4,a);
        singUpPlayer(Name5,a);
    }
    public void singUpPlayer(String Name,String id_team)
    {
        String  insertPlayer= "INSERT INTO "+ Const.PLAYER_TABLE+"("
                +Const.PLAYER_NAME+","+Const.PLAYER_TEAMS_ID+")"+"VALUES(?,?)";
        try {
            PreparedStatement prSt= getDbConnection().prepareStatement(insertPlayer);
            prSt.setString(1,Name);
            prSt.setString(2,id_team);
            prSt.executeUpdate();
        }
        catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Connection getDbConnection()
            throws ClassNotFoundException, SQLException{
        String connectionString = "jdbc:mysql://" + dbHost + ":"
                + dbPort +"/" +dbName+"?serverTimezone=UTC";
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(connectionString, dbUser, dbPass);
    }

    @FXML
    void initialize() {
        select.setOnAction(event -> {
            if (isNumeric(name.getText()) | isNumeric(name1.getText()) | isNumeric(name2.getText()) | isNumeric(name3.getText()) | isNumeric(name4.getText()) | isNumeric(name5.getText()))
            {singup Name = new singup(name);
            singup Name1 = new singup(name1);
            singup Name2 = new singup(name2);
            singup Name3 = new singup(name3);
            singup Name4 = new singup(name4);
            singup Name5 = new singup(name5);
            Name.playAnim();
            Name1.playAnim();
            Name2.playAnim();
            Name3.playAnim();
            Name4.playAnim();
            Name5.playAnim();
            }
            else {
                try {
                    singUpNewUser();
                } catch (SQLException | ClassNotFoundException e) {
                    e.printStackTrace();
                }
                select.getScene().getWindow().hide();
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
            }
        });

    }
    private void singUpNewUser() throws SQLException, ClassNotFoundException {
        String Name=name.getText();
        String Name1=name1.getText();
        String Name2=name2.getText();
        String Name3=name3.getText();
        String Name4=name4.getText();
        String Name5=name5.getText();
        select.getScene().getWindow().hide();
            singUpCommand(Name, Name1, Name2, Name3, Name4,Name5);

    }
}
