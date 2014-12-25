package net.theviolentsquirrels.commands;

import net.theviolentsquirrels.claims.Claim;
import net.theviolentsquirrels.claims.ClaimPoints;
import net.theviolentsquirrels.claims.Claims;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class ClaimCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (args.length <= 0) { this.displayHelp(player); return (true); }
            else {
                if (args[0].equalsIgnoreCase("create")) {
                    if (args.length == 2) {
                        Claim claim = Claims.getSpecificClaim(args[1]);
                        if (claim == null) {
                            if (Claims.getClaimPointsMap().containsKey(player.getDisplayName())) {
                                ClaimPoints points = Claims.getClaimPointsMap().get(player.getDisplayName());
                                if (points.getPoint1() != null && points.getPoint2() != null) {
                                    if (points.getPoint1().getWorld().getName().equalsIgnoreCase(points.getPoint2().getWorld().getName())) {
                                        Claim selectedClaim = new Claim(args[1], player.getDisplayName(), points.getPoint1(), points.getPoint2());
                                        Claims.getClaimsList().add(selectedClaim);
                                        player.sendMessage("Claim §o§4" + args[1] + "§r created successfully !");
                                    } else {
                                        player.sendMessage("Surry bro, you have to stay in the same world to perform a good claim region !");
                                    }
                                    return (true);
                                }
                            } else {
                                player.sendMessage("Please, define a claim region with the magic tool !");
                            }
                        } else {
                            player.sendMessage("§4§oThis claim's name is already taken. :(");
                        }
                    } else {
                        player.sendMessage("Invalid number of arguments ! Type §6/claim create §4<claimName>");
                    }
                    return (true);
                } else if (args[0].equalsIgnoreCase("delete")) {
                    if (args.length == 2) {
                        Claim claim = Claims.getSpecificClaim(args[1]);
                        if (claim != null) {
                            Claims.getClaimsList().remove(claim);
                            player.sendMessage("Claim §o§4" + args[1] + "§r deleted successfully !");
                        } else {
                            player.sendMessage("§4§oNo claim found with this name ! :(");
                        }
                    } else {
                        player.sendMessage("Invalid number of arguments ! Type §6/claim delete §4<claimName>");
                    }
                    return (true);
                } else if (args[0].equalsIgnoreCase("list")) {
                    List<Claim> claimsList = Claims.getClaimsList();
                    if (claimsList.size() > 0) {
                        sender.sendMessage("List of defined claims (§6" + claimsList.size() + "§r) :");
                        for (Claim claim : claimsList) {
                            sender.sendMessage("- §o§4" + claim.getClaimName() + "§r (Owner : §o§6" + claim.getClaimOwner() + ")");
                        }
                    } else {
                        player.sendMessage("There are no defined claims here !");
                    }
                    return (true);
                } else if (args[0].equalsIgnoreCase("tool")) {
                    ItemStack tool = new ItemStack(Material.GOLD_HOE, 1);
                    ItemMeta meta = tool.getItemMeta();
                    meta.setDisplayName("§o§0Magic Claim Tool (MCT)");
                    tool.setItemMeta(meta);
                    player.getInventory().addItem(tool);
                    player.sendMessage("You summoned a MCT, be careful with these dark powers...");
                    return (true);
                } else {
                    player.sendMessage("Unknown command, surry. Type /claim to get some help !");
                }
                return (true);
            }
        }
        return (false);
    }

    private void displayHelp(Player player) {
        player.sendMessage("§3§lClaims help :");
        player.sendMessage("§8> §6/claim create §4<claimName>");
        player.sendMessage("§8> §6/claim delete §4<claimName>");
        player.sendMessage("§8> §6/claim list");
        player.sendMessage("§8> §6/claim tool");
    }
}
