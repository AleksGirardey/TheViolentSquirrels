package net.theviolentsquirrels.cities;

public class Wanderer {

    String wandererName;
    String wandererRank;

    public Wanderer(String wandererName) {
        this.wandererName = wandererName;
        this.wandererRank = "Wanderer";
    }

    public String getWandererName() {
        return wandererName;
    }

    public void setWandererName(String wandererName) {
        this.wandererName = wandererName;
    }

    public String getWandererRank() {
        return wandererRank;
    }

    public void setWandererRank(String wandererRank) {
        this.wandererRank = wandererRank;
    }
}
