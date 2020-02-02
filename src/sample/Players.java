package sample;

public class Players{

    private String players;
    private double kd;
    private String team;
    public Players(String players, double kd,String team) {
       setPlayers(players);
       setKd(kd);
       setTeam(team);
    }
    public String getPlayers() {
        return players;
    }
    public void setPlayers(String players) {
        this.players = players;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }


    public double getKd() {
        return kd;
    }

    public void setKd(double kd) {
        this.kd = kd;
    }


}
