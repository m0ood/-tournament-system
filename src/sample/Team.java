package sample;

public class Team {




    private Integer id;
    private String teamname;
    private Integer matchs;
    private Integer idUser;
    public Team(String teamname, Integer matchs) {
        this.teamname = teamname;
        this.matchs = matchs;
    }
    public Team() {
    }
    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer iduser) {
        this.idUser = iduser;
    }

    public Integer getIdTeam() {
        return id;
    }

    public void setIdTeam(Integer id) {
        this.id = id;
    }

    public String getTeamname() {
        return teamname;
    }

    public  void setTeamname(String teamname) {
        this.teamname = teamname;
    }

    public Integer getMatchs() {
        return matchs;
    }

    public void setMatchs(Integer matchs) {
        this.matchs = matchs;
    }

}
