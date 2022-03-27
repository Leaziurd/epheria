package org.thePlaceholder.epheria;

import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.thePlaceholder.epheria.events.interactsEvents;
import org.thePlaceholder.epheria.events.inventoriesEvents;
import org.thePlaceholder.epheria.events.messagesEvent;
import org.thePlaceholder.epheria.events.playerJoinAndQuitEvent;
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

        getServer().getPluginManager().registerEvents(new playerJoinAndQuitEvent(), this);
        getServer().getPluginManager().registerEvents(new messagesEvent(), this);
        getServer().getPluginManager().registerEvents(new inventoriesEvents(), this);
        getServer().getPluginManager().registerEvents(new interactsEvents(), this);
    }
}
