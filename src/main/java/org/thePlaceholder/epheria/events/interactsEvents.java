package org.thePlaceholder.epheria.events;

import org.bukkit.event.EventHandler;
import java.io.IOException;
import org.bukkit.entity.HumanEntity;
import org.thePlaceholder.epheria.data.customEnderChest;
import org.bukkit.Material;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.Listener;

public class interactsEvents implements Listener
{
    @EventHandler
    public void interactions(final PlayerInteractEvent event) throws IOException
    {

        if (event.getAction() == Action.RIGHT_CLICK_BLOCK && event.getClickedBlock().getType() == Material.ENDER_CHEST) {
            event.setCancelled(true);
            customEnderChest.open(event.getPlayer());
        }

    }
}
