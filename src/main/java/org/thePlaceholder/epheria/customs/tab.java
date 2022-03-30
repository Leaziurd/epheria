package org.thePlaceholder.epheria.customs;

import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.thePlaceholder.epheria.data.moneyManager;
import org.thePlaceholder.epheria.data.prefix;
import org.thePlaceholder.epheria.main;

public class tab
{
    public static void set(Player player){
        String playerName = player.getName();
        String playerPrefix = prefix.get(player);

        Bukkit.getScheduler().scheduleSyncRepeatingTask(main.getInstance(), new Runnable()
        {
            @Override
            public void run()
            {
                player.sendPlayerListHeader(Component.text(" ⏳ | " + playerPrefix + " " + playerName + ChatColor.RESET +" | " + "%server_online%" + "/16 | " + "%server_tps_1%" + " TPS | " + moneyManager.get(player) + " EPH |  ⏳ "));
            }
        }, 0L, 40L);
    }
}
