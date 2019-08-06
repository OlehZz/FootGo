package ua.lviv.footgo.jsonmapper;

public class TeamSignUpRequestJsonBody {

    private String teamName;
    private String captainName;
    private String captainPhone;
    private String captainEmail;
    private String playerList;


    public TeamSignUpRequestJsonBody(String teamName, String captainName, String captainPhone, String captainEmail, String playerList) {
        this.teamName = teamName;
        this.captainName = captainName;
        this.captainPhone = captainPhone;
        this.captainEmail = captainEmail;
        this.playerList = playerList;
    }



    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getCaptainName() {
        return captainName;
    }

    public void setCaptainName(String captainName) {
        this.captainName = captainName;
    }

    public String getCaptainPhone() {
        return captainPhone;
    }

    public void setCaptainPhone(String captainPhone) {
        this.captainPhone = captainPhone;
    }

    public String getCaptainEmail() {
        return captainEmail;
    }

    public void setCaptainEmail(String captainEmail) {
        this.captainEmail = captainEmail;
    }

    public String getPlayerList() {
        return playerList;
    }

    public void setPlayerList(String playerList) {
        this.playerList = playerList;
    }






}
