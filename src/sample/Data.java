package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

public class Data extends Config {
    public static Connection getDbConnection() throws ClassNotFoundException, SQLException {
        String connectionString = "jdbc:mysql://" + dbHost + ":"
                + dbPort +"/" +dbName+"?serverTimezone=UTC";
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(connectionString, dbUser, dbPass);
    }
    public void singUpUser(String key,String login, String password) throws  ClassNotFoundException {
        String  insert= "INSERT INTO "+ Const.USERS_TABLE+"("
                +Const.USERS_QUANTITY+","+Const.USERS_LOGIN+","+Const.USERS_PASSWORD+")"+"VALUES(?,?,?)";
        try {
            PreparedStatement prSt= getDbConnection().prepareStatement(insert);
            prSt.setString(1,key);
            prSt.setString(2,login);
            prSt.setString(3,password);
            prSt.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public ResultSet getUser(User user) throws ClassNotFoundException {
        ResultSet resSet= null;
        String select = "SELECT * FROM "+Const.USERS_TABLE+" WHERE "+Const.USERS_LOGIN+"=? AND "+Const.USERS_PASSWORD+"=?";
        try {
            PreparedStatement prSt= getDbConnection().prepareStatement(select);
            prSt.setString(1,user.getLogin());
            prSt.setString(2,user.getPassword());
            resSet=prSt.executeQuery();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return resSet;
    }
    public String getsId(User user) throws SQLException, ClassNotFoundException {
        PreparedStatement stmt =
                getDbConnection().prepareStatement("SELECT * FROM users WHERE login=? AND password=?");

        stmt.setString(1, user.getLogin());
        stmt.setString(2, user.getPassword());
        ResultSet rs = stmt.executeQuery();
        String a = "0";
        while(rs.next()){
            a= rs.getString("idusers");
        }
        return a;
    }
    public String getsIdTeam(Team team) throws SQLException, ClassNotFoundException {
        PreparedStatement stmt =
                getDbConnection().prepareStatement("SELECT * FROM team WHERE teamname=?");
        stmt.setString(1, team.getTeamname());
        ResultSet rs = stmt.executeQuery();
        String a = "0";
        while(rs.next()){
            a= rs.getString(Const.TRAM_ID);
        }
        return a;
    }
    public Integer getsCount(Team team) throws SQLException, ClassNotFoundException {
        PreparedStatement stmt =
                getDbConnection().prepareStatement("SELECT * FROM team WHERE iduser=?");
        stmt.setInt(1, team.getIdUser());
        ResultSet rs = stmt.executeQuery();
        Integer a = 0;
        while(rs.next()){
            a++;
        }
        return a;
    }
    public Integer getsCountTeam(User user) throws SQLException, ClassNotFoundException {
        PreparedStatement stmt =
                getDbConnection().prepareStatement("SELECT * FROM users WHERE login=? AND password=?");

        stmt.setString(1, user.getLogin());
        stmt.setString(2, user.getPassword());
        ResultSet rs = stmt.executeQuery();
        Integer a = 0;
        while(rs.next()){
            a= rs.getInt(Const.USERS_QUANTITY);
        }
        return a;
    }
    public String[] getsTeams(Team team) throws SQLException, ClassNotFoundException {
        PreparedStatement stmt =
                getDbConnection().prepareStatement("SELECT * FROM team WHERE iduser=?");
        stmt.setInt(1, team.getIdUser());
        ResultSet rs = stmt.executeQuery();
        String[] a = new String[Const.SCORETEAM];
        int b=0;
        while(rs.next()){
            a[b]=rs.getString(Const.TEAM_NAME);
            b++;
        }
        return a;
    }

    public String[] getsPlayers(Team team) throws SQLException, ClassNotFoundException {
        PreparedStatement stmt =
                getDbConnection().prepareStatement("SELECT * FROM player WHERE team_id=?");
        String u= getsIdTeam(team);
        stmt.setString(1, u);
        ResultSet rs = stmt.executeQuery();
        String[] a = new String[5];
        int b=0;
        while(rs.next()){
            a[b]=rs.getString(Const.PLAYER_NAME);
            b++;
        }
        return a;
    }
    public Integer getsKd(String name) throws SQLException, ClassNotFoundException {
        PreparedStatement stmt =
                getDbConnection().prepareStatement("SELECT * FROM player WHERE kd=?");
        stmt.setString(1, name);
        ResultSet rs = stmt.executeQuery();
        int b=-1;
        while(rs.next()){
            b=rs.getInt(Const.PLAYER_KD);
        }
        return b;
    }
    public void setKD(String name,double kd,String id) throws SQLException, ClassNotFoundException {
        String a= "UPDATE player SET kd = '"+kd+"' WHERE team_id = '"+id+"' AND player = '"+name+"';";
        Statement statement = getDbConnection().createStatement();
        double stmt =statement.executeUpdate(a);
    }
    public int getMa(String name) throws SQLException, ClassNotFoundException {
        PreparedStatement stmt =
                getDbConnection().prepareStatement("SELECT * FROM team WHERE teamname=?");
        stmt.setString(1, name);
        ResultSet rs = stmt.executeQuery();
        int b=-1;
        while(rs.next()){
            b=rs.getInt("matchs");
        }
        return b;
    }
    public void setMatch(String name) throws SQLException, ClassNotFoundException {
        int b=getMa(name);
        b++;
        String a= "UPDATE team SET matchs = '"+b+"' WHERE teamname = '"+name+"';";
        Statement statement = getDbConnection().createStatement();
        double stmt1 =statement.executeUpdate(a);
    }
    public void singUpMatch(String name1,String name2,String map,String score) throws  ClassNotFoundException {
        String  insert= "INSERT INTO "+ Const.MATCHES_TABLE+"("
                +Const.MATCHES_TEAM1+","+Const.MATCHES_TEAM2+","+Const.MATCHES_MAP+","+Const.MATCHES_SCORE+",id_user)"+"VALUES(?,?,?,?,?)";
        try {
            PreparedStatement prSt= getDbConnection().prepareStatement(insert);
            prSt.setString(1,name1);
            prSt.setString(2,name2);
            prSt.setString(3,map);
            prSt.setString(4,score);
            prSt.setString(5,Const.ID);
            prSt.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public ObservableList<Team> getsTeamsInfo(Team team) throws SQLException, ClassNotFoundException {
        PreparedStatement stmt =
                getDbConnection().prepareStatement("SELECT * FROM team WHERE iduser=?");
        stmt.setInt(1, team.getIdUser());
        ResultSet rs = stmt.executeQuery();
        ObservableList<Team> Info = FXCollections.observableArrayList();
        while(rs.next()){
            Info.add(new Team(rs.getString(Const.TEAM_NAME),rs.getInt(Const.TEAM_WIN)));
        }
        return Info;
    }
    public String[] getsTeamsIds(Team team) throws SQLException, ClassNotFoundException {
        PreparedStatement stmt =
                getDbConnection().prepareStatement("SELECT * FROM team WHERE iduser=?");
        stmt.setInt(1, team.getIdUser());
        ResultSet rs = stmt.executeQuery();
        String[] Info = new String[100];
        int b=0;
        while(rs.next()){
            Info[b]=rs.getString(Const.TRAM_ID);
            b++;
        }
        Const.TEAMS=b;
        return Info;
    }
    public ObservableList<Players> AllPlayers(String[] teams) throws SQLException, ClassNotFoundException {
        PreparedStatement stmt =
                getDbConnection().prepareStatement("SELECT * FROM player WHERE team_id=?");
        ObservableList<Players> Info = FXCollections.observableArrayList();
        for (int i=0;i<=Const.TEAMS;i++) {
            stmt.setString(1, teams[i]);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Info.add(new Players(rs.getString(Const.PLAYER_NAME), rs.getDouble(Const.PLAYER_KD),Const.NamesTeam[i]));
            }
        }
        return Info;
    }
    public ObservableList<matches> AllMatchs() throws SQLException, ClassNotFoundException {
        PreparedStatement stmt =
                getDbConnection().prepareStatement("SELECT * FROM matches WHERE id_user=?");
        ObservableList<matches> Info = FXCollections.observableArrayList();
        stmt.setString(1, Const.ID);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            Info.add(new matches(rs.getString(Const.MATCHES_TEAM1), rs.getString(Const.MATCHES_TEAM2), rs.getString(Const.MATCHES_MAP), rs.getString(Const.MATCHES_SCORE)));
        }
        return Info;
    }
    public void Delete() throws SQLException, ClassNotFoundException {
        PreparedStatement stmt =
                getDbConnection().prepareStatement("DELETE FROM users WHERE idusers = "+Const.ID);
        int stmt1 =stmt.executeUpdate();
    }

}
