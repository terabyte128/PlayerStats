package com.samwolfson.playerstats.commands;

import com.samwolfson.playerstats.PlayerTime;
import org.bukkit.Statistic;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class StatsCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (!(commandSender instanceof Player)) {
            return false;
        }

        Player p = (Player) commandSender;
        PlayerTime pt = new PlayerTime(p);
        p.sendMessage(String.format("You've played on this server for %d hours and %d minutes.", pt.getHours(), pt.getMinutes()));

        return true;
    }
}
