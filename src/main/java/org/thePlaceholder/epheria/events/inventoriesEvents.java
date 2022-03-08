package org.thePlaceholder.epheria.events;

import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.EventHandler;
import java.io.IOException;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.Inventory;
import org.bukkit.entity.HumanEntity;
import org.thePlaceholder.epheria.data.customEnderChest;
import org.bukkit.ChatColor;
import org.bukkit.inventory.ItemStack;
import org.bukkit.Material;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.Bukkit;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.Listener;

public class inventoriesEvents implements Listener
{
    @EventHandler
    public void inventoryClick(final InventoryClickEvent event) throws IOException {
        final HumanEntity human = event.getWhoClicked();
        final Inventory generalMenu = Bukkit.createInventory((InventoryHolder)null, 27, "MENU");
        final ItemStack enderChestIcon = new ItemStack(Material.ENDER_CHEST);
        final ItemMeta enderChestIconMeta = enderChestIcon.getItemMeta();
        enderChestIconMeta.setDisplayName(ChatColor.YELLOW + "Ender Chest");
        enderChestIcon.setItemMeta(enderChestIconMeta);
        generalMenu.setItem(11, enderChestIcon);
        if (event.getSlot() == 17) {
            human.openInventory(generalMenu);
        }
        if (event.getSlot() == 11 && event.getView().getTitle() == "MENU") {
            customEnderChest.open(human);
        }
    }
    
    @EventHandler
    public void inventoryClose(final InventoryCloseEvent event) throws IOException {
        customEnderChest.set(event.getPlayer());
    }
    
    @EventHandler
    public void inventoryOpen(final InventoryOpenEvent event) throws IOException {
        final HumanEntity human = event.getPlayer();
        human.setItemOnCursor(new ItemStack(Material.AIR));
    }
}
