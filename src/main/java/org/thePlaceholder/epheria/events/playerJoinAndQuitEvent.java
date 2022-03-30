package org.thePlaceholder.epheria.events;

import net.kyori.adventure.text.Component;

import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.entity.Player;import org.bukkit.ChatColor;
import org.bukkit.event.Listener;
import org.thePlaceholder.epheria.data.prefix;

public class playerJoinAndQuitEvent implements Listener
{
    @EventHandler
    public void playerQuit(PlayerQuitEvent event)
    {
        Player player = event.getPlayer();
        String playerName = player.getName();
        String minus = ChatColor.WHITE + "[" + ChatColor.RED + "-" + ChatColor.WHITE + "]";
        String playerPrefix = prefix.get(event.getPlayer());
        event.quitMessage(Component.text(minus + " " + playerPrefix + " " + playerName));
    }
}
