package sample.controll.login;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.Const;
import sample.Data;
import sample.Team;
import sample.User;
import sample.animation.singup;

public class REGISTRATION {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField login;

    @FXML
    private PasswordField password;

    @FXML
    private Button SingIn;

    @FXML
    private Button SingUp;

    @FXML
    void initialize() {
        SingIn.setOnAction(event -> {
            String logintext= login.getText().trim();
            String passwordtext= password.getText().trim();
            if(logintext.equals("")) {
                System.out.println("Error");
            }
            else {
                if (passwordtext.equals(""))
                    System.out.println("Error");
                else {
                    try {
                        loginUser(logintext, passwordtext);
                    } catch (SQLException | ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        SingUp.setOnAction(event -> {
            SingUp.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/sample/controll/registration/REGISTR.fxml"));

            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setTitle("Регистрация");
            stage.setScene(new Scene(root));
            stage.show();
        });
    }

    private void loginUser(String logintext, String passwordtext) throws SQLException, ClassNotFoundException {
            Data dbData = new Data();
            User user = new User();
            user.setLogin(logintext);
            user.setPassword(passwordtext);
            ResultSet result= dbData.getUser(user);
            int a=0;
            while(result.next())
            {
                a++;
            }
            if(a>=1)
            {
                Team team= new Team();
                Const.SCORETEAM=dbData.getsCountTeam(user);
                Const.ID= dbData.getsId(user);
                team.setIdUser(Integer.parseInt(Const.ID));
                Const.NamesTeam = dbData.getsTeams(team);
                Const.SCORE= dbData.getsCount(team);
                SingIn.getScene().getWindow().hide();
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
            else {
                singup Login = new singup(login);
                singup Password = new singup(password);
                Login.playAnim();
                Password.playAnim();
            }
    }
}
