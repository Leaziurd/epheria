package org.thePlaceholder.epheria.registers;

import org.thePlaceholder.epheria.events.*;
import org.thePlaceholder.epheria.items.sugarDiamond;
import org.thePlaceholder.epheria.epheria;
import org.thePlaceholder.epheria.menus.customEnderChest;
import org.thePlaceholder.epheria.menus.mainMenu;

import static org.bukkit.Bukkit.getServer;

public class registerEvents
{
    public static void run()
    {
        epheria plugin = epheria.getInstance();

        getServer().getPluginManager().registerEvents(new playerQuit(), plugin);
        getServer().getPluginManager().registerEvents(new playerChat(), plugin);
        getServer().getPluginManager().registerEvents(new playerDeath(), plugin);
        getServer().getPluginManager().registerEvents(new playerJoin(), plugin);
        getServer().getPluginManager().registerEvents(new mainMenu(), plugin);
        getServer().getPluginManager().registerEvents(new customEnderChest(), plugin);
        getServer().getPluginManager().registerEvents(new sugarDiamond(), plugin);
        getServer().getPluginManager().registerEvents(new playerResource(), plugin);
        getServer().getPluginManager().registerEvents(new cancelInSpawn(), plugin);
    }
}