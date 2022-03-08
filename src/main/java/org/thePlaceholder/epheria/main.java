package org.thePlaceholder.epheria;

import org.bukkit.Material;
import org.thePlaceholder.epheria.commands.b0tCommands;
import org.thePlaceholder.epheria.events.interactsEvents;
import org.thePlaceholder.epheria.events.inventoriesEvents;
import org.thePlaceholder.epheria.events.messagesEvent;
import org.thePlaceholder.epheria.events.playerJoinAndQuitEvent;
import org.bukkit.ChatColor;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public class main extends JavaPlugin
{
    private static main instance;

    public static ItemStack menuStar = new ItemStack(Material.NETHER_STAR);
    ItemMeta menuStarMeta = menuStar.getItemMeta();

    public static Economy economy;
    
    public void onEnable()
    {
        menuStarMeta.setDisplayName(ChatColor.YELLOW + "Ender Chest");
        menuStar.setItemMeta(this.menuStarMeta);

        getServer().getPluginManager().registerEvents(new playerJoinAndQuitEvent(), this);
        getServer().getPluginManager().registerEvents(new messagesEvent(), this);
        getServer().getPluginManager().registerEvents(new inventoriesEvents(), this);
        getServer().getPluginManager().registerEvents(new interactsEvents(), this);

        getCommand("b0t").setExecutor(new b0tCommands());
    }
    
    public static main getPlugin() {return instance;}
}
