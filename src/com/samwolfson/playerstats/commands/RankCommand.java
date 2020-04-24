package com.samwolfson.playerstats.commands;

import com.samwolfson.playerstats.PlayerTime;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

public class RankCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (!(commandSender instanceof Player)) {
            return false;
        }

        Player p = (Player) commandSender;

        Set<PlayerTime> ranks = new TreeSet<>(Collections.reverseOrder());

        for (OfflinePlayer op : commandSender.getServer().getWhitelistedPlayers()) {
            ranks.add(new PlayerTime(op));
        }

        StringBuilder message = new StringBuilder();
        message.append(ChatColor.GOLD).append(ChatColor.BOLD).append("Play Time Rankings").append(ChatColor.RESET).append("\n");

        int currentRank = 1;

        for (PlayerTime pt : ranks) {
            if (p.equals(pt.getPlayer())) {
                message.append(ChatColor.BOLD);
            }
            message.append(currentRank).append(". ").append(pt.getPlayer().getName());
            message.append(" (").append(pt.getHours()).append("h ").append(pt.getMinutes()).append("m").append(")");
            message.append(ChatColor.RESET).append("\n");
            currentRank++;
        }

        commandSender.sendMessage(message.toString());
        return true;
    }
}
