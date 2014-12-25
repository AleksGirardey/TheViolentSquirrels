package net.theviolentsquirrels.commands;

import net.theviolentsquirrels.players.PlayerChunk;
import net.theviolentsquirrels.players.PlayerChunks;
import org.bukkit.Chunk;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.List;

public class ChunkCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (args.length <= 0) { this.displayHelp(player); return (true); }
            else {
                if (args[0].equalsIgnoreCase("claim")) {
                    if (args.length == 2) {
                        PlayerChunk playerChunk = PlayerChunks.getSpecificPlayerChunk(args[1]);
                        if (playerChunk == null) {
                            Chunk chunk = player.getLocation().getChunk();
                            PlayerChunk selectedChunk = new PlayerChunk(args[1], player.getDisplayName(), chunk.getX(), chunk.getZ());
                            if (!(PlayerChunks.isAlreadyChunked(selectedChunk))) {
                                PlayerChunks.getPlayerChunksList().add(selectedChunk);
                                player.sendMessage("§a§oChunk §b§o" + args[1] + "§a§o claimed successfully !");
                            } else {
                                player.sendMessage("§c§oThis chunk is already claimed at this location. :(");
                            }
                        } else {
                            player.sendMessage("§c§oA chunk is already claimed at this name. :(");
                        }
                    } else {
                        player.sendMessage("Invalid number of arguments ! Type §6/claim chunk §4<chunkName>");
                    }
                    return (true);
                } else if (args[0].equalsIgnoreCase("unclaim")) {
                    if (args.length == 2) {
                        PlayerChunk playerChunk = PlayerChunks.getSpecificPlayerChunk(args[1]);
                        if (playerChunk != null) {
                            PlayerChunks.getPlayerChunksList().remove(playerChunk);
                            player.sendMessage("§a§oChunk §b§o" + args[1] + "§a§o unclaimed successfully !");
                        } else {
                            player.sendMessage("§c§oNo claim found with this name ! :(");
                        }
                    } else {
                        player.sendMessage("Invalid number of arguments ! Type §6/claim delete §4<claimName>");
                    }
                    return (true);
                } else if (args[0].equalsIgnoreCase("list")) {
                    List<PlayerChunk> playerChunksList = PlayerChunks.getPlayerChunksList();
                    if (playerChunksList.size() > 0) {
                        player.sendMessage("List of defined chunks claimed (§5" + playerChunksList.size() + "§r) :");
                        for (PlayerChunk playerChunk : playerChunksList) {
                            player.sendMessage("- §2§o" + playerChunk.getChunkName() + "§r (Owner : §6§o" + playerChunk.getChunkOwner() + "§r at (" + playerChunk.getChunkX() + ", " + playerChunk.getChunkZ() + "))");
                        }
                    } else {
                        player.sendMessage("§c§oThere are no chunks in this list !");
                    }
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
        player.sendMessage("§3§lChunks help :");
        player.sendMessage("§8> §6/chunk claim §4<chunkName>");
        player.sendMessage("§8> §6/chunk unclaim §4<chunkName>");
        player.sendMessage("§8> §6/chunk list");
    }
}
