package net.theviolentsquirrels.main;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;

public class Invitations {

    private static Map<Player, Player> invitationsPending = new HashMap<Player, Player>();
    private static long invitationCooldown = 20L * 30;

    public static Map<Player, Player> getInvitationsPending() {
        return invitationsPending;
    }

    public static void setInvitationsPending(Map<Player, Player> invitationsPending) {
        Invitations.invitationsPending = invitationsPending;
    }

    public static void sendInvitation(Main plugin, final Player player, final Player invited) {
        getInvitationsPending().put(player, invited);
        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
            public void run() {
                if (getInvitationsPending().containsValue(invited)) {
                    getInvitationsPending().remove(player, invited);
                    Bukkit.broadcastMessage(player.getDisplayName() + " and " + invited.getDisplayName() + " removed from this list.");
                }
            }
        }, invitationCooldown);
    }
}
