package org.thePlaceholder.epheria.items;

import net.kyori.adventure.text.Component;
import org.bukkit.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class banana implements Listener
{
    public static ItemStack item()
    {
        ItemStack item = new ItemStack(Material.GOLDEN_CARROT);
        ItemMeta meta = item.getItemMeta();

        meta.displayName(Component.text(ChatColor.YELLOW + "Banana"));
        meta.setCustomModelData(128);

        item.setItemMeta(meta);
        return item;
    }

    @EventHandler
    public void eatEvent(PlayerItemConsumeEvent event)
    {
        if(event.getItem().isSimilar(item()))
        {
            event.getPlayer().setFoodLevel(event.getPlayer().getFoodLevel() * 2);
        }
    }

    @EventHandler
    public void breakEvent(BlockBreakEvent event)
    {
        if(event.getBlock().getType() == Material.JUNGLE_LEAVES)
        {
            double random = Math.random();
            if (random < 0.25)
            {
                event.getPlayer().getWorld().dropItem(event.getBlock().getLocation(), item());
            }
        }
    }
}