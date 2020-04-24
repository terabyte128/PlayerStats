package com.samwolfson.playerstats;

import org.bukkit.OfflinePlayer;
import org.bukkit.Statistic;

/**
 * Class to keep track of players and their play time (and compare them with others).
 */
public class PlayerTime implements Comparable<PlayerTime> {
    OfflinePlayer player;
    int hours;
    int minutes;

    public PlayerTime(OfflinePlayer player) {
        this.player = player;

        // 20 ticks per second
        int totalSeconds = player.getStatistic(Statistic.PLAY_ONE_MINUTE) / 20;

        this.hours = totalSeconds / 3600;
        this.minutes = totalSeconds / 60 - hours * 60;
    }

    public OfflinePlayer getPlayer() {
        return player;
    }

    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }

    @Override
    public int compareTo(PlayerTime o) {
        if (this.hours != o.hours) {
            return this.hours - o.hours;
        } else {
            return this.minutes - o.minutes;
        }
    }
}