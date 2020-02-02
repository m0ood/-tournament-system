package sample;

public class Const extends Config{
    public static final String USERS_TABLE = "users";
    public static final String USERS_QUANTITY = "quantity";
    public static final String USERS_LOGIN = "login";
    public static final String USERS_PASSWORD = "password";
    public static final String PLAYER_TABLE = "player";
    public static final String PLAYER_NAME = "player";
    public static final String PLAYER_KD = "kd";
    public static final String PLAYER_TEAMS_ID = "team_id";
    public static final String TRAM_ID = "idteam";
    public static final String TEAM_NAME = "teamname";
    public static final String TEAM_TABLE = "team";
    public static final String TEAM_WIN="matchs";
    public static final String TEAM_ID="iduser";
    public static final String MATCHES_TABLE = "matches";
    public static final String MATCHES_TEAM1 = "Team1";
    public static final String MATCHES_TEAM2 = "Team2";
    public static final String MATCHES_MAP = "Map";
    public static final String MATCHES_SCORE = "score";
    public static String ID;
    public static Integer SCORE;
    public static Integer SCORETEAM;
    public static String[] NamesTeam;
    public static String TEAM1;
    public static String TEAM2;
    public static String MAP;
    public static Integer TEAMS;
    public void get(){
        dbName="new_schema";
    }
}
