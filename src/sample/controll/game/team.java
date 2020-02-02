package sample.controll.game;

public class team {

    private String team;


    public team(String login) {
        setLogin(login);
    }

    public team() {
    }

    public String getLogin() {
        return team;
    }

    public void setLogin(String login) {
        this.team = login;
    }
}
