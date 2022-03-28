package org.thePlaceholder.epheria.events;

import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
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
    public void playerJoin(PlayerJoinEvent event) throws IOException {
        Player player = event.getPlayer();
        String playerName = player.getName();
        String plus = ChatColor.WHITE + "[" + ChatColor.GREEN + "+" + ChatColor.WHITE + "]";
        String playerPrefix = PlaceholderAPI.setPlaceholders(player, "%luckperms_prefix%");

        if (!player.hasPlayedBefore())
        {
            event.joinMessage(Component.text(plus + " It's " + playerPrefix + " " + playerName + " first time on the server."));
            moneyManager.add(player,25);
            player.sendMessage(ChatColor.DARK_PURPLE + "" + ChatColor.MAGIC + "Leaziurd" + ChatColor.RESET + ChatColor.WHITE + " sent you " + ChatColor.RESET + ChatColor.DARK_PURPLE + " 25.0EPH");
        }
        else
        {
            event.joinMessage(Component.text(plus + " " + playerPrefix + " " + playerName));
        }
        player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1.0f, 1.0f);

        player.getInventory().setItem(17, main.menuStar);

        Bukkit.getScheduler().scheduleSyncRepeatingTask(main.instance, new Runnable()
        {
            @Override
            public void run()
            {
                player.sendPlayerListHeader(Component.text(PlaceholderAPI.setPlaceholders(player, " ⏳ | " + playerPrefix + " " + playerName + ChatColor.RESET +" | " + "%server_online%" + "/16 | " + "%server_tps_1%" + " TPS | " + "%vault_eco_balance%" + " EPH |  ⏳ ")));
            }
        }, 0L, 40L);
    }
    
    @EventHandler
    public void playerQuit(PlayerQuitEvent event)
    {
        Player player = event.getPlayer();
        String playerName = player.getName();
        String minus = ChatColor.WHITE + "[" + ChatColor.RED + "-" + ChatColor.WHITE + "]";
        String playerPrefix = PlaceholderAPI.setPlaceholders(player, "%luckperms_prefix%");
        event.quitMessage(Component.text(minus + " " + playerPrefix + " " + playerName));
    }
}
