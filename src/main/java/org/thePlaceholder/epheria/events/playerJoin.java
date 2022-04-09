package org.thePlaceholder.epheria.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.thePlaceholder.epheria.generators.playerJoinMessage;
import org.thePlaceholder.epheria.generators.spawningSequence;

public class playerJoin implements Listener
{
    @EventHandler
    public void playerJoin(PlayerJoinEvent event)
    {
        Player player = event.getPlayer();
        spawningSequence.spawn(player);
        playerJoinMessage.joinMessage(event);
    }
}
