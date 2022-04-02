package org.thePlaceholder.epheria.generators;

import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.thePlaceholder.epheria.data.moneyManager;
import org.thePlaceholder.epheria.data.prefix;
import org.thePlaceholder.epheria.data.tps;
import org.thePlaceholder.epheria.main;
import org.thePlaceholder.epheria.menus.mainMenu;

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
                player.sendPlayerListHeader(Component.text(" ⏳ | " + playerPrefix + " " + playerName + ChatColor.RESET +" | " + Bukkit.getServer().getOnlinePlayers().size() + "/16 | " + tps.getTPS() + " TPS | " + moneyManager.get(player) + " EPH |  ⏳ "));
                player.getInventory().setItem(17, mainMenu.generateMenuStar());
            }
        }, 0L, 40L);
    }
}
