package org.thePlaceholder.epheria.events;

import net.kyori.adventure.text.Component;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerResourcePackStatusEvent;
import org.thePlaceholder.epheria.generators.spawningSequence;

public class playerResource implements Listener
{
    @EventHandler
    public void playerJoin(PlayerResourcePackStatusEvent event)
    {
        Player player = event.getPlayer();

        if(event.getStatus() == PlayerResourcePackStatusEvent.Status.DECLINED)
        {
            player.kick(Component.text(ChatColor.RED + "PLEASE ENABLE SERVER RESOURCE PACK"));
        }
        else
        {
            spawningSequence.connect(player);
        }
    }
}
