package net.theviolentsquirrels.cities;

import java.util.ArrayList;
import java.util.List;

public class Wanderers {

    private static List<Wanderer> wanderersList = new ArrayList<Wanderer>();

    public static List<Wanderer> getWanderersList() { return wanderersList; }

    public static void setWanderersList(List<Wanderer> wanderersList) {
        Wanderers.wanderersList = wanderersList;
    }

    public static Wanderer getSpecificWanderer(String wandererName) {
        for (Wanderer wanderer : getWanderersList()) {
            if (wanderer.getWandererName().equalsIgnoreCase(wandererName)) { return (wanderer); }
        }
        return (null);
    }
}
