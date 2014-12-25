package net.theviolentsquirrels.listeners;

import net.theviolentsquirrels.cities.Cities;
import net.theviolentsquirrels.cities.City;
import net.theviolentsquirrels.cities.Wanderer;
import net.theviolentsquirrels.cities.Wanderers;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class OnPlayerJoinListener implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        if (!(player.hasPlayedBefore())) {
            Wanderers.getWanderersList().add(new Wanderer(player.getDisplayName()));
        } else {
            City city = Cities.isInCity(player.getDisplayName());
            if (city != null) {
                player.sendMessage("§6§o" + city.getCityBoardMessage());
            } else {
                player.sendMessage("§6§oGo home, wanderer, you're drunk.");
            }
        }
    }
}
