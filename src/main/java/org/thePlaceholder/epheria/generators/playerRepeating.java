package org.thePlaceholder.epheria.generators;

import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.thePlaceholder.epheria.data.moneyManager;
import org.thePlaceholder.epheria.data.prefix;
import org.thePlaceholder.epheria.main;

public class playerRepeating
{
    public static void run(Player player)
    {
        String playerName = player.getName();
        String playerPrefix = prefix.get(player);

        Bukkit.getScheduler().scheduleSyncRepeatingTask(main.getInstance(), new Runnable()
        {
            @Override
            public void run()
            {
                player.sendPlayerListHeader(Component.text(" ⏳ | " + playerPrefix + " " + playerName + ChatColor.RESET +" | " + "%server_online%" + "/16 | " + "%server_tps_1%" + " TPS | " + moneyManager.get(player) + " EPH |  ⏳ "));
                player.getInventory().setItem(17, main.menuStar);
            }
        }, 0L, 40L);
    }
}
