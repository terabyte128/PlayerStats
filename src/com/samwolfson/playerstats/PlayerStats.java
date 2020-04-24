package com.samwolfson.playerstats;

import com.samwolfson.playerstats.commands.RankCommand;
import com.samwolfson.playerstats.commands.StatsCommand;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public class PlayerStats extends JavaPlugin {
    ConsoleCommandSender console = getServer().getConsoleSender();

    @Override
    public void onDisable() {
    }

    @Override
    public void onEnable() {
        this.getCommand("stats").setExecutor(new StatsCommand());
        this.getCommand("rank").setExecutor(new RankCommand());
    }
}
