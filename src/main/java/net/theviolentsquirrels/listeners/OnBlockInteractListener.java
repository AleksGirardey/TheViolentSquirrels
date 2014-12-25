package net.theviolentsquirrels.listeners;

import net.theviolentsquirrels.claims.Claim;
import net.theviolentsquirrels.claims.Claims;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

import java.util.List;

public class OnBlockInteractListener implements Listener {

    @EventHandler
    public void onBreakBlock(BlockBreakEvent event) {
        Player player = event.getPlayer();
        Block block = event.getBlock();
        Claim claim = getClaimOnLocation(block.getLocation());
        if (claim != null && !(claim.getClaimOwner().equals(player.getDisplayName()))) {
            player.sendMessage("You don't have " + claim.getClaimOwner() + "'s permission to break blocks here !");
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onPlaceBlock(BlockPlaceEvent event) {
        Player player = event.getPlayer();
        Block block = event.getBlock();
        Claim claim = getClaimOnLocation(block.getLocation());
        if (claim != null && !(claim.getClaimOwner().equals(player.getDisplayName()))) {
            player.sendMessage("You don't have " + claim.getClaimOwner() + "'s permission to place blocks here !");
            event.setCancelled(true);
        }
    }

    private static Claim getClaimOnLocation(Location loc) {
        List<Claim> claimsList = Claims.getClaimsList();
        for (Claim claim : claimsList) {
            Location point1 = claim.getLoc1();
            Location point2 = claim.getLoc2();

            int minX = point1.getBlockX() < point2.getBlockX() ? point1.getBlockX() : point2.getBlockX();
            int minY = point1.getBlockY() < point2.getBlockY() ? point1.getBlockY() : point2.getBlockY();
            int minZ = point1.getBlockZ() < point2.getBlockZ() ? point1.getBlockZ() : point2.getBlockZ();

            int maxX = point1.getBlockX() > point2.getBlockX() ? point1.getBlockX() : point2.getBlockX();
            int maxY = point1.getBlockY() > point2.getBlockY() ? point1.getBlockY() : point2.getBlockY();
            int maxZ = point1.getBlockZ() > point2.getBlockZ() ? point1.getBlockZ() : point2.getBlockZ();

            if (loc.getBlockX() >= minX && loc.getBlockX() <= maxX) {
                if (loc.getBlockY() >= minY && loc.getBlockY() <= maxY) {
                    if (loc.getBlockZ() >= minZ && loc.getBlockZ() <= maxZ) {
                        return (claim);
                    }
                }
            }

        }
        return (null);
    }
}
