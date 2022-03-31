package org.thePlaceholder.epheria.events;

import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.thePlaceholder.epheria.generators.playerJoinMessage;
import org.thePlaceholder.epheria.generators.playerRepeating;

import java.io.IOException;

public class playerJoin implements Listener
{
    @EventHandler
    public void playerJoin(PlayerJoinEvent event) throws IOException {
        Player player = event.getPlayer();

        playerJoinMessage.joinMessage(event);
        playerRepeating.run(player);

        player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1.0f, 1.0f);
    }
}
