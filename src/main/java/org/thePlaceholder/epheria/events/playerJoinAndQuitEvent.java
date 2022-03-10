package org.thePlaceholder.epheria.events;

import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.scheduler.BukkitScheduler;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.entity.Player;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.thePlaceholder.epheria.main;
import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.ChatColor;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.Listener;

public class playerJoinAndQuitEvent implements Listener
{
    Economy economy = main.economy;

    @EventHandler
    public void playerJoin(PlayerJoinEvent event)
    {
        Player player = event.getPlayer();
        String playerName = player.getName();
        String plus = ChatColor.WHITE + "[" + ChatColor.GREEN + "+" + ChatColor.WHITE + "]";
        String playerPrefix = PlaceholderAPI.setPlaceholders(player, "%luckperms_prefix%");

        if (!player.hasPlayedBefore())
        {
            event.setJoinMessage(plus + " It's " + playerPrefix + " " + playerName + " first time on the server.");
            economy.depositPlayer(player, 25.0);
            player.sendMessage(ChatColor.DARK_PURPLE + "" + ChatColor.MAGIC + "Leaziurd" + ChatColor.RESET + ChatColor.WHITE + " sent you " + ChatColor.RESET + ChatColor.DARK_PURPLE + " 25.0EPH");
        }
        else
        {
            event.setJoinMessage(plus + " " + playerPrefix + " " + playerName);
        }
        player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1.0f, 1.0f);

        player.getInventory().setItem(17, main.menuStar);

        BukkitScheduler tabUpdate = Bukkit.getServer().getScheduler();
        tabUpdate.scheduleSyncRepeatingTask(main.getPlugin(), () -> player.setPlayerListHeader(" ⏳ | " + playerPrefix + " " + playerName + ChatColor.RESET +" | " + PlaceholderAPI.setPlaceholders(player,"%server_online%") + "/16 | " + PlaceholderAPI.setPlaceholders(player, "%server_tps_1%") + " TPS | " + PlaceholderAPI.setPlaceholders(player, "%vault_eco_balance%") + " EPH |  ⏳ "), 0L, 100L);
        BukkitScheduler inventoryUpdate = Bukkit.getServer().getScheduler();
        inventoryUpdate.scheduleSyncRepeatingTask(main.getPlugin(), () -> player.updateInventory(), 0L, 20L);
    }
    
    @EventHandler
    public void playerQuit(PlayerQuitEvent event)
    {
        Player player = event.getPlayer();
        String playerName = player.getName();
        String minus = ChatColor.WHITE + "[" + ChatColor.RED + "-" + ChatColor.WHITE + "]";
        String playerPrefix = PlaceholderAPI.setPlaceholders(player, "%luckperms_prefix%");
        event.setQuitMessage(minus + " " + playerPrefix + " " + playerName);
    }
}
