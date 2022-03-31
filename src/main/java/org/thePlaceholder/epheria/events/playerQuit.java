package org.thePlaceholder.epheria.events;

import net.kyori.adventure.text.Component;

import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.entity.Player;import org.bukkit.ChatColor;
import org.bukkit.event.Listener;
import org.thePlaceholder.epheria.data.prefix;
import org.thePlaceholder.epheria.generators.playerQuitMessage;

public class playerQuit implements Listener
{
    @EventHandler
    public static void playerQuit(PlayerQuitEvent event)
    {
        playerQuitMessage.quitMessage(event);
    }
}
