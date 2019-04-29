package com.example.fahad.acls2.activity.model;

public class PlayerBean {
    private String name;
    private String short_country;
    private String skill;
    private double points;
    private double credits;
    private boolean isChecked;

    public PlayerBean(String name, String short_country, String skill, double points, double credits, boolean isChecked) {
        this.name = name;
        this.short_country = short_country;
        this.skill = skill;
        this.points = points;
        this.credits = credits;
        this.isChecked = isChecked;
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

    public double getPoints() {
        return points;
    }

    public void setPoints(double points) {
        this.points = points;
    }

    public double getCredits() {
        return credits;
    }

    public void setCredits(double credits) {
        this.credits = credits;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }

    @Override
    public String toString() {
        return "PlayerBean{" +
                "name='" + name + '\'' +
                ", short_country='" + short_country + '\'' +
                ", skill='" + skill + '\'' +
                ", points=" + points +
                ", credits=" + credits +
                ", isChecked=" + isChecked +
                '}';
    }
}
