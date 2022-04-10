package org.thePlaceholder.epheria.events;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.thePlaceholder.epheria.menus.mainMenu;

import static org.thePlaceholder.epheria.data.playerWorldManager.create;

public class playerRespawn implements Listener
{
    @EventHandler
    public void playerJoin(PlayerRespawnEvent event)
    {
        World world = create(event.getPlayer());
        event.setRespawnLocation(new Location(world, 0, world.getHighestBlockYAt(0, 0), 0));
        event.getPlayer().getInventory().setItem(17, mainMenu.generateMenuStar());
    }
}
