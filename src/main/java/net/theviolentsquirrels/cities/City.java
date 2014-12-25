package net.theviolentsquirrels.cities;

import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class City {

    String cityName;
    String cityOwner;
    String cityBoardMessage;
    String cityBorderMessage;
    int cityMoney;
    int cityPoints;
    boolean isAbleToFight;
    List<Citizen> citizensList = new ArrayList<Citizen>();

    public City(String cityName, String cityOwner, int cityMoney, int cityPoints) {
        this.cityName = cityName;
        this.cityOwner = cityOwner;
        this.cityBoardMessage = "City " + this.cityName + " freshly founded !";
        this.cityBorderMessage = "Welcome to " + this.cityName + " !";
        this.cityMoney = cityMoney;
        this.cityPoints = cityPoints;
        this.isAbleToFight = false;
        this.citizensList.add(new Citizen(this.cityOwner, this, "mayorSquirrel"));
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCityOwner() {
        return cityOwner;
    }

    public void setCityOwner(String cityOwner) {
        this.cityOwner = cityOwner;
    }

    public String getCityBoardMessage() {
        return cityBoardMessage;
    }

    public void setCityBoardMessage(String cityBoardMessage) {
        this.cityBoardMessage = cityBoardMessage;
    }

    public String getCityBorderMessage() {
        return cityBorderMessage;
    }

    public void setCityBorderMessage(String cityBorderMessage) {
        this.cityBorderMessage = cityBorderMessage;
    }

    public int getCityMoney() {
        return cityMoney;
    }

    public void setCityMoney(int cityMoney) {
        this.cityMoney = cityMoney;
    }

    public int getCityPoints() {
        return cityPoints;
    }

    public void setCityPoints(int cityPoints) {
        this.cityPoints = cityPoints;
    }

    public boolean isAbleToFight() {
        return isAbleToFight;
    }

    public void setAbleToFight(boolean isAbleToFight) {
        this.isAbleToFight = isAbleToFight;
    }

    public List<Citizen> getCitizensList() {
        return citizensList;
    }

    public void setCitizensList(List<Citizen> citizensList) {
        this.citizensList = citizensList;
    }

    public boolean isMayor(Player player) {
        return (player.getDisplayName() == this.getCityOwner());
    }

    public boolean hasMayor() {
        return (this.getCityOwner() != null);
    }
}
