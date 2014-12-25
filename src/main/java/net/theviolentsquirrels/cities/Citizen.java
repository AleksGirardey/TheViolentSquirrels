package net.theviolentsquirrels.cities;

import org.bukkit.entity.Player;

public class Citizen {

    String citizenName;
    City citizenCity;
    String citizenRank;

    public Citizen(String citizenName, City citizenCity, String citizenRank) {
        this.citizenName = citizenName;
        this.citizenCity = citizenCity;
        this.citizenRank = citizenRank;
    }

    public String getCitizenName() {
        return citizenName;
    }

    public void setCitizenName(String citizenName) {
        this.citizenName = citizenName;
    }

    public City getCitizenCity() {
        return citizenCity;
    }

    public void setCitizenCity(City citizenCity) {
        this.citizenCity = citizenCity;
    }

    public String getCitizenRank() {
        return citizenRank;
    }

    public void setCitizenRank(String citizenRank) {
        this.citizenRank = citizenRank;
    }

    public boolean isInCity() {
        return (this.citizenCity != null);
    }
}
