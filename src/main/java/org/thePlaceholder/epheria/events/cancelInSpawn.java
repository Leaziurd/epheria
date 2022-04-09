package org.thePlaceholder.epheria.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.thePlaceholder.epheria.epheria;

public class cancelInSpawn implements Listener
{
    @EventHandler
    public void interactEvent(PlayerInteractEvent event)
    {
        if(!event.getPlayer().hasPermission("epheria.op"))
        {
            if (event.getPlayer().getWorld() == epheria.getInstance().getServer().getWorld("spawn"))
            {
                event.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void interactEvent(PlayerDropItemEvent event)
    {
        if(!event.getPlayer().hasPermission("epheria.op"))
        {
            if (event.getPlayer().getWorld() == epheria.getInstance().getServer().getWorld("spawn"))
            {
                event.setCancelled(true);
            }
        }
    }
}
