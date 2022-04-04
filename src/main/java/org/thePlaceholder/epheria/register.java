package org.thePlaceholder.epheria;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.thePlaceholder.epheria.data.tps;
import org.thePlaceholder.epheria.events.playerChat;
import org.thePlaceholder.epheria.events.playerDeath;
import org.thePlaceholder.epheria.events.playerJoin;
import org.thePlaceholder.epheria.events.playerQuit;
import org.thePlaceholder.epheria.items.sugarDiamond;
import org.thePlaceholder.epheria.menus.customEnderChest;
import org.thePlaceholder.epheria.menus.mainMenu;

import static org.bukkit.Bukkit.getServer;

public class register
{
    public static void run(Plugin plugin)
    {
        getServer().getPluginManager().registerEvents(new playerQuit(), plugin);
        getServer().getPluginManager().registerEvents(new playerChat(), plugin);
        getServer().getPluginManager().registerEvents(new playerDeath(), plugin);
        getServer().getPluginManager().registerEvents(new playerJoin(), plugin);
        getServer().getPluginManager().registerEvents(new mainMenu(), plugin);
        getServer().getPluginManager().registerEvents(new customEnderChest(), plugin);

        Bukkit.addRecipe(sugarDiamond.sugarDiamondRecipe());

        Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, new tps(), 100L, 1L);
    }
}
