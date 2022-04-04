package org.thePlaceholder.epheria.generators;

import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.thePlaceholder.epheria.data.moneyManager;
import org.thePlaceholder.epheria.data.prefix;
import org.thePlaceholder.epheria.data.tps;
import org.thePlaceholder.epheria.main;

public class playerRepeating
{
    public static void run(Player player)
    {
        String playerName = player.getName();
        String playerPrefix = prefix.get(player);

        Bukkit.getScheduler().scheduleSyncRepeatingTask(main.getInstance(), () ->
                player.sendPlayerListHeader(Component.text(" ⏳ | " + playerPrefix + " " + playerName + ChatColor.RESET +" | " + Bukkit.getServer().getOnlinePlayers().size() + "/16 | " + tps.getTPS() + " TPS | " + moneyManager.get(player) + " EPH |  ⏳ ")),
        0L, 40L);
    }
}
