package net.theviolentsquirrels.listeners;

import net.theviolentsquirrels.claims.ClaimPoints;
import net.theviolentsquirrels.claims.Claims;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class OnPlayerInteractListener implements Listener {

    @EventHandler
    public void OnPlayerInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        ItemStack playerHand = player.getItemInHand();
        if (playerHand != null && playerHand.getType() == Material.GOLD_HOE) {
            if (event.getAction() == Action.LEFT_CLICK_BLOCK) {
                Block block = event.getClickedBlock();
                if (!(Claims.getClaimPointsMap().containsKey(player.getDisplayName()))) {
                    Claims.getClaimPointsMap().put(player.getDisplayName(), new ClaimPoints(null, null));
                }
                Claims.getClaimPointsMap().get(player.getDisplayName()).setPoint1(block.getLocation());
                event.setCancelled(true);
                player.sendMessage("Position 1 set !");
            } else if (event.getAction() == Action.RIGHT_CLICK_BLOCK) {
                Block block = event.getClickedBlock();
                if (!(Claims.getClaimPointsMap().containsKey(player.getDisplayName()))) {
                    Claims.getClaimPointsMap().put(player.getDisplayName(), new ClaimPoints(null, null));
                }
                Claims.getClaimPointsMap().get(player.getDisplayName()).setPoint2(block.getLocation());
                event.setCancelled(true);
                player.sendMessage("Position 2 set !");
            }
        }
    }
}
