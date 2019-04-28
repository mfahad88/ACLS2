package com.example.fahad.acls2.activity.model;

public class PlayerBean {
    private String name;
    private String short_country;
    private String skill;
    private float points;
    private float credits;

    public PlayerBean(String name, String short_country, String skill, float points, float credits) {
        this.name = name;
        this.short_country = short_country;
        this.skill = skill;
        this.points = points;
        this.credits = credits;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShort_country() {
        return short_country;
    }

    public void setShort_country(String short_country) {
        this.short_country = short_country;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public float getPoints() {
        return points;
    }

    public void setPoints(float points) {
        this.points = points;
    }

    public float getCredits() {
        return credits;
    }

    public void setCredits(float credits) {
        this.credits = credits;
    }
}
