package com.example.fahad.acls2.activity.model;

public class MatchesBean {

    private int matchId;
    private String teamOne;
    private String teamTwo;
    private String time;

    public MatchesBean(int matchId, String teamOne, String teamTwo, String time) {
        this.matchId = matchId;
        this.teamOne = teamOne;
        this.teamTwo = teamTwo;
        this.time = time;
    }

    public int getMatchId() {
        return matchId;
    }

    public void setMatchId(int matchId) {
        this.matchId = matchId;
    }

    public String getTeamOne() {
        return teamOne;
    }

    public void setTeamOne(String teamOne) {
        this.teamOne = teamOne;
    }

    public String getTeamTwo() {
        return teamTwo;
    }

    public void setTeamTwo(String teamTwo) {
        this.teamTwo = teamTwo;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
