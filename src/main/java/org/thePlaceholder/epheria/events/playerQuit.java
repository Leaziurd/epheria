package org.thePlaceholder.epheria.events;

import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.thePlaceholder.epheria.generators.playerQuitMessage;

public class playerQuit implements Listener
{
    @EventHandler
    public static void playerQuit(PlayerQuitEvent event)
    {
        playerQuitMessage.quitMessage(event);
    }
}
