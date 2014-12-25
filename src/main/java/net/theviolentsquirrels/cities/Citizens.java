package net.theviolentsquirrels.cities;

import java.util.ArrayList;
import java.util.List;

public class Citizens {

    private static List<Citizen> citizensList = new ArrayList<Citizen>();

    public static List<Citizen> getCitizensList() { return citizensList; }

    public static List<Citizen> getCitizensList(City city) { return city.getCitizensList(); }

    public static void setCitizensList(List<Citizen> citizensList) {
        Citizens.citizensList = citizensList;
    }
}
