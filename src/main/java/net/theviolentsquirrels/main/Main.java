package net.theviolentsquirrels.main;

import net.theviolentsquirrels.commands.ChunkCommand;
import net.theviolentsquirrels.commands.CityCommand;
import net.theviolentsquirrels.commands.ClaimCommand;
import net.theviolentsquirrels.listeners.OnBlockInteractListener;
import net.theviolentsquirrels.listeners.OnPlayerInteractListener;
import net.theviolentsquirrels.listeners.OnPlayerJoinListener;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        this.registerCommands();
        this.getServer().getPluginManager().registerEvents(new OnPlayerInteractListener(), this);
        this.getServer().getPluginManager().registerEvents(new OnBlockInteractListener(), this);
        //this.getServer().getPluginManager().registerEvents(new OnPlayerJoinListener(), this);
    }

    @Override
    public void onDisable() {

    }

    public void registerCommands() {
        getCommand("claim").setExecutor(new ClaimCommand());
        getCommand("chunk").setExecutor(new ChunkCommand());
        getCommand("city").setExecutor(new CityCommand(this));
    }
}
