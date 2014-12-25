package net.theviolentsquirrels.commands;

import com.google.common.base.Joiner;
import net.theviolentsquirrels.cities.*;
import net.theviolentsquirrels.main.Invitations;
import net.theviolentsquirrels.main.Main;
import org.apache.commons.lang.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.List;

public class CityCommand implements CommandExecutor {

    private final Main plugin;

    public CityCommand(Main plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (args.length <= 0) { this.displayHelp(player); return (true); }
            else {
                if (args[0].equalsIgnoreCase("create")) {
                    if (args.length == 2) {
                        City city = Cities.isInCity(player.getDisplayName());
                        if (city == null) {
                            city = Cities.getSpecificCity(args[1]);
                            if (city == null) {
                                city = new City(args[1], player.getDisplayName(), 0, 0);
                                Cities.getCitiesList().add(city);
                                Wanderers.getWanderersList().remove(Wanderers.getSpecificWanderer(player.getDisplayName()));
                                player.sendMessage("§a§oCity §b§o" + args[1] + "§a§o set up successfully ! LET THE EMPIRE BEGIN. :D");
                                Bukkit.broadcastMessage("§6The player §4" + city.getCityOwner() + "§6 has founded a new city, named §4" + city.getCityName() + "§6.");
                            } else {
                                player.sendMessage("§c§oThere already is an existing city with this name. :(");
                            }
                        } else {
                            player.sendMessage("§c§oYou are already in a city ! :D");
                        }
                    } else {
                        player.sendMessage("Invalid number of arguments ! Type §6/city create §4<cityName>");
                    }
                    return (true);
                } else if (args[0].equalsIgnoreCase("delete")) {
                    if (args.length == 2) {
                        City city = Cities.getSpecificCity(args[1]);
                        if (city != null) {
                            Cities.getCitiesList().remove(city);
                            player.sendMessage("§a§oCity §b§o" + args[1] + "§a§o deleted successfully !");
                            Bukkit.broadcastMessage("§6The city §4" + city.getCityName() + "§6 has fallen !");
                        } else {
                            player.sendMessage("§c§oThere is no city founded with this name. :(");
                        }
                    } else {
                        player.sendMessage("Invalid number of arguments ! Type §6/city delete §4<cityName>");
                    }
                    return (true);
                } else if (args[0].equalsIgnoreCase("list")) {
                    List<City> citiesList = Cities.getCitiesList();
                    if (citiesList.size() > 0) {
                        player.sendMessage("List of founded cities (§5" + citiesList.size() + "§r) :");
                        player.sendMessage(Joiner.on(", ").join(citiesList));
                    } else {
                        player.sendMessage("§c§oThere is no city in list !");
                    }
                    return (true);
                } else if (args[0].equalsIgnoreCase("info")) {
                    if (args.length == 2) {
                        City city = Cities.getSpecificCity(args[1]);
                        if (city != null) {
                            player.sendMessage("§6=-=-=-=-= " + city.getCityName() + " =-=-=-=-=");
                            player.sendMessage("§6=- §o" + city.getCityBoardMessage());
                            player.sendMessage("§6=- Mayor : " + city.getCityOwner());
                            player.sendMessage("§6=- Piggy bank : " + city.getCityMoney());
                            player.sendMessage("§6=- City points : " + city.getCityPoints());
                            player.sendMessage("§6=- PVP mode : " + (city.isAbleToFight() == true ? "enabled" : "disabled"));
                            player.sendMessage("§6=-=-=-=-= " + StringUtils.repeat("-", city.getCityName().length()) + " =-=-=-=-=");
                        } else {
                            player.sendMessage("§c§oThere is no city founded with this name. :(");
                        }
                    } else {
                        City city = Cities.isInCity(player.getDisplayName());
                        if (city != null) {
                            player.sendMessage("§6=-=-=-=-= " + city.getCityName() + " =-=-=-=-=");
                            player.sendMessage("§6=- §o" + city.getCityBoardMessage());
                            player.sendMessage("§6=- Mayor : " + city.getCityOwner());
                            player.sendMessage("§6=- Piggy bank : " + city.getCityMoney());
                            player.sendMessage("§6=- City points : " + city.getCityPoints());
                            player.sendMessage("§6=- PVP mode : " + (city.isAbleToFight() == true ? "enabled" : "disabled"));
                            player.sendMessage("§6=-=-=-=-= " + StringUtils.repeat("-", city.getCityName().length()) + " =-=-=-=-=");
                        } else {
                            player.sendMessage("§c§oYou don't belong to any city on this server. :(");
                        }
                    }
                    return (true);
                } else if (args[0].equalsIgnoreCase("playerlist")) {
                    City city = Cities.isInCity(player.getDisplayName());
                    if (city != null) {
                        player.sendMessage("Current citizens in " + city.getCityName() + " (" + city.getCitizensList().size() + ") :");
                        for (int i = 0; i < city.getCitizensList().size(); i++) {
                            player.sendMessage("Player : " + city.getCitizensList().get(i).getCitizenName());
                        }
                    } else {
                        player.sendMessage("§c§oYou don't belong to any city. :(");
                    }
                    return (true);
                } else if (args[0].equalsIgnoreCase("mayor")) {
                    if (args.length == 2) {
                        City city = Cities.getSpecificCity(args[1]);
                        if (city != null) {
                            if (city.hasMayor()) {
                                player.sendMessage("§a§oThe current mayor of §b§o" + city.getCityName() + "§a§o is §b§o" + city.getCityOwner() + "§a§o.");
                                player.sendMessage("§a§oLONG LIVE §b§o" + city.getCityOwner().toUpperCase() + "§a§o ! \\o/");
                            } else {
                                player.sendMessage("§c§oThere is no mayor affiliated with this city. WTF.");
                            }
                        } else {
                            player.sendMessage("§c§oThere is no city founded with this name. :(");
                        }
                    } else {
                        City city = Cities.isInCity(player.getDisplayName());
                        if (city != null) {
                            if (city.hasMayor()) {
                                player.sendMessage("§a§oThe current mayor of your city is §b§o" + city.getCityOwner() + "§a§o.");
                                player.sendMessage("§a§oLONG LIVE §b§o" + city.getCityOwner().toUpperCase() + "§a§o ! \\o/");
                            } else {
                                player.sendMessage("§c§oThere is no mayor affiliated with your city. WTF.");
                            }
                        } else {
                            player.sendMessage("§c§oYou don't belong to any city on this server. :(");
                        }
                    }
                  return (true);
                } else if (args[0].equalsIgnoreCase("invite")) {
                    if (args.length == 2) {
                        City city = Cities.isInCity(player.getDisplayName());
                        if (city != null) {
                            if (city.isMayor(player)) {
                                Player invited = Bukkit.getPlayer(args[1]);
                                if (invited != null) {
                                    if (invited.isOnline()) {
                                        City playerCity = Cities.isInCity(invited.getDisplayName());
                                        if (playerCity == null) {
                                            player.sendMessage("§aThe player §b" + invited.getDisplayName() + "§a has been invited !");
                                            invited.sendMessage("§aThe mayor §b" + city.getCityOwner() + "§a has invited you to join his city §b" + city.getCityName() + "§a...");
                                            invited.sendMessage("§aWould you like to join his city as a citizen ? Type §b/accept§a or §b/decline§a.");
                                            Invitations.sendInvitation(this.plugin, invited, player);
                                        } else {
                                            player.sendMessage("§c§oThe player you're trying to invite is already in a city !");
                                        }
                                    } else {
                                        player.sendMessage("The player you're trying to invite is offline");
                                    }
                                } else {
                                    player.sendMessage("§c§oThe player you're trying to invite doesn't exist.");
                                }
                            } else {
                                player.sendMessage("§c§oYou don't have the ability to invite someone in your city. :(");
                            }
                        } else {
                            player.sendMessage("§c§oYou don't belong to any city on this server. :(");
                        }
                    } else {
                        player.sendMessage("§c§oYou need to specify a player ! Type /city invite <player>");
                    }
                  return (true);
                } else if (args[0].equalsIgnoreCase("accept")) {
                    if (Invitations.getInvitationsPending().containsKey(player)) {
                        City city = Cities.isInCity(Invitations.getInvitationsPending().get(player).getDisplayName());
                        if (city != null) {
                            Invitations.getInvitationsPending().remove(player);
                            city.getCitizensList().add(new Citizen(player.getDisplayName(), city, "squirrel"));
                            player.sendMessage("§a§oCongratulations ! You're now a part of §b§o" + city.getCityName() + "§a§o ! \\o/");
                            Bukkit.getPlayer(city.getCityOwner()).sendMessage("§b§o" + player.getDisplayName() + "§a§o has joined the city !");
                        } else {
                            player.sendMessage("§c§oSurry, this city doesn't exist anymore. WTF.");
                        }
                    } else {
                        player.sendMessage("§c§oSurry, you don't have any invitation at this time. :(");
                    }
                } else {
                    player.sendMessage("Unknown command, surry. Type /city to get some help !");
                }
                return (true);
            }
        }
        return (false);
    }

    public void displayHelp(Player player) {
        player.sendMessage("§aNeed some help with city commands ?");
        player.sendMessage("§8> §6/city create §b<name>");
        player.sendMessage("§8> §6/city delete §b<name>");
        player.sendMessage("§8> §6/city info §b<name>");
        player.sendMessage("§8> §6/city list");
        player.sendMessage("§8> §6/city playerlist");
    }
}
