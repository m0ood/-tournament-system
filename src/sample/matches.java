package sample;

public class matches {
   private String team1;
   private String team2;
   private String map;
   private String score;

    public matches(String team1, String team2, String map, String score) {
        setTeam1(team1);
        setTeam2(team2);
        setMap(map);
        setScore(score);
    }

    public String getTeam1() {
        return team1;
    }

    public void setTeam1(String team1) {
        this.team1 = team1;
    }

    public String getTeam2() {
        return team2;
    }

    public void setTeam2(String team2) {
        this.team2 = team2;
    }

    public String getMap() {
        return map;
    }

    public void setMap(String map) {
        this.map = map;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }
}
