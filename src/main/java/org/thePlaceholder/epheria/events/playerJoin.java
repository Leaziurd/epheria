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
        spawningSequence.getSpawn(event.getPlayer());

        player.setResourcePack("https://www.dropbox.com/s/kor3tr9cteq2hw1/epheria.zip?dl=1","28fa5b558ced046e0f005392a88da4a6d54b650b");
        playerJoinMessage.joinMessage(event);
    }
}
