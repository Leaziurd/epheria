package org.thePlaceholder.epheria;

import org.bukkit.inventory.ItemStack;
import org.thePlaceholder.epheria.data.tps;
import org.thePlaceholder.epheria.events.playerChat;
import org.thePlaceholder.epheria.events.playerDeath;
import org.thePlaceholder.epheria.events.playerJoin;
import org.thePlaceholder.epheria.events.playerQuit;
import org.bukkit.ChatColor;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.thePlaceholder.epheria.menus.customEnderChest;
import org.thePlaceholder.epheria.menus.mainMenu;

public class main extends JavaPlugin {

    public static main instance;
    public static ItemStack starMenu;

    public void onEnable() {
        getServer().getPluginManager().registerEvents(new playerQuit(), this);
        getServer().getPluginManager().registerEvents(new playerChat(), this);
        getServer().getPluginManager().registerEvents(new playerDeath(), this);
        getServer().getPluginManager().registerEvents(new playerJoin(), this);
        getServer().getPluginManager().registerEvents(new mainMenu(), this);
        getServer().getPluginManager().registerEvents(new customEnderChest(), this);

        tps.run();
        instance = this;
    }

    public static main getInstance() {return instance;}
}