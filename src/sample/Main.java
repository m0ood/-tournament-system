package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.sql.SQLException;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("controll/login/registration.fxml"));
        primaryStage.setTitle("Вход");
        primaryStage.setScene(new Scene(root, 720, 500));
        primaryStage.show();
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {launch(args);
    Data.getDbConnection().close();;
}
}