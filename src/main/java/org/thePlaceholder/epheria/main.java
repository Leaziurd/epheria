package org.thePlaceholder.epheria;

import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.thePlaceholder.epheria.events.playerChat;
import org.thePlaceholder.epheria.events.playerDeath;
import org.thePlaceholder.epheria.events.playerJoin;
import org.thePlaceholder.epheria.events.interactsEvents;
import org.thePlaceholder.epheria.events.inventoriesEvents;
import org.thePlaceholder.epheria.events.playerQuit;
import org.bukkit.ChatColor;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public class main extends JavaPlugin
{
    public static main instance;

    public static ItemStack menuStar = new ItemStack(Material.NETHER_STAR);
    ItemMeta menuStarMeta = menuStar.getItemMeta();
    
    public void onEnable()
    {
        menuStarMeta.displayName(Component.text(ChatColor.DARK_PURPLE + "MENU"));
        menuStar.setItemMeta(menuStarMeta);

        getServer().getPluginManager().registerEvents(new playerQuit(), this);
        getServer().getPluginManager().registerEvents(new playerChat(), this);
        getServer().getPluginManager().registerEvents(new playerDeath(), this);
        getServer().getPluginManager().registerEvents(new playerJoin(), this);
        getServer().getPluginManager().registerEvents(new inventoriesEvents(), this);
        getServer().getPluginManager().registerEvents(new interactsEvents(), this);

        instance = this;
    }

    public static main getInstance() {return instance;}
}
