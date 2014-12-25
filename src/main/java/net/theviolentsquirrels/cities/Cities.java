package net.theviolentsquirrels.cities;

import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class Cities {

    private static List<City> citiesList = new ArrayList<City>();

    public static List<City> getCitiesList() { return citiesList; }

    public static void setCitiesList(List<City> citiesList) {
        Cities.citiesList = citiesList;
    }

    public static City getSpecificCity(String cityName) {
        for (City city : getCitiesList()) {
            if (city.getCityName().equalsIgnoreCase(cityName)) { return (city); }
        }
        return (null);
    }

    public static City isInCity(String playerName){
        for (City city : Cities.getCitiesList()) {
            for (Citizen citizen : city.getCitizensList()) {
                if (citizen.getCitizenName().equalsIgnoreCase(playerName))
                    return (city);
            }
        }
        return (null);
    }
}
