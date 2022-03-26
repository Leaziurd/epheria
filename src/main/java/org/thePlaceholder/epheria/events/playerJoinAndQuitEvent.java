package org.thePlaceholder.epheria.events;

import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.entity.Player;
import org.bukkit.Sound;
import org.bukkit.scheduler.BukkitScheduler;
import org.thePlaceholder.epheria.data.moneyManager;
import org.thePlaceholder.epheria.main;
import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.ChatColor;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.Listener;

import java.io.IOException;

import static org.bukkit.Bukkit.getServer;

public class playerJoinAndQuitEvent implements Listener
{
    @EventHandler
    public void playerJoin(PlayerJoinEvent event) throws InterruptedException, IOException {
        Player player = event.getPlayer();
        String playerName = player.getName();
        String plus = ChatColor.WHITE + "[" + ChatColor.GREEN + "+" + ChatColor.WHITE + "]";
        String playerPrefix = PlaceholderAPI.setPlaceholders(player, "%luckperms_prefix%");

        if (!player.hasPlayedBefore())
        {
            event.setJoinMessage(plus + " It's " + playerPrefix + " " + playerName + " first time on the server.");
            moneyManager.add(player,25);
            player.sendMessage(ChatColor.DARK_PURPLE + "" + ChatColor.MAGIC + "Leaziurd" + ChatColor.RESET + ChatColor.WHITE + " sent you " + ChatColor.RESET + ChatColor.DARK_PURPLE + " 25.0EPH");
        }
        else
        {
            event.setJoinMessage(plus + " " + playerPrefix + " " + playerName);
        }
        player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1.0f, 1.0f);

        player.getInventory().setItem(17, main.menuStar);

        BukkitScheduler tabUpdate = getServer().getScheduler();
        tabUpdate.scheduleSyncRepeatingTask(main.getPlugin(), () -> player.setPlayerListHeader(" ⏳ | " + playerPrefix + " " + playerName + ChatColor.RESET +" | " + PlaceholderAPI.setPlaceholders(player,"%server_online%") + "/16 | " + PlaceholderAPI.setPlaceholders(player, "%server_tps_1%") + " TPS | " + PlaceholderAPI.setPlaceholders(player, "%vault_eco_balance%") + " EPH |  ⏳ "),0L,100L);
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
