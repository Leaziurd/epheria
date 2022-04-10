package org.thePlaceholder.epheria.menus;

import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.player.PlayerAttemptPickupItemEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.thePlaceholder.epheria.data.playerWorldManager;

public class mainMenu implements Listener
{
    public ItemStack phItem = new ItemStack(Material.LIGHT_GRAY_STAINED_GLASS_PANE);

    @EventHandler
    public void inventoryClick(InventoryClickEvent event) throws ClassNotFoundException {
        HumanEntity human = event.getWhoClicked();
        Player player = (Player) event.getWhoClicked();
        Inventory generalMenu = Bukkit.createInventory(null, 9, Component.text("Menu"));
        ItemStack customEnderChestItem = customEnderChest.getItem();
        ItemStack clickedItem = event.getCurrentItem();


        ItemMeta phItemMeta = phItem.getItemMeta();
        phItemMeta.displayName(Component.text(" "));
        phItem.setItemMeta(phItemMeta);

        generalMenu.setItem(0, phItem);
        generalMenu.setItem(1, phItem);
        generalMenu.setItem(2, phItem);
        generalMenu.setItem(3, customEnderChestItem);
        generalMenu.setItem(4, phItem);
        generalMenu.setItem(5, pocketDimensionItem());
        generalMenu.setItem(6, phItem);
        generalMenu.setItem(7, phItem);
        generalMenu.setItem(8, phItem);

        if(clickedItem == null) return;

        if(clickedItem.isSimilar(phItem))
        {
            event.setCancelled(true);
        }

        if(clickedItem.isSimilar(generateMenuStar()))
        {
            if(event.getInventory().getHolder() instanceof Player) human.getInventory().addItem(human.getItemOnCursor());
            event.setCancelled(true);
            human.openInventory(generalMenu);
            player.playSound(human.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1.0f, 1.0f);
        }

        if(clickedItem.isSimilar(customEnderChestItem))
        {
            event.setCancelled(true);
            customEnderChest.open(human);
        }

        if(clickedItem.isSimilar(pocketDimensionItem()))
        {
            playerWorldManager.join(player);
            player.playSound(player.getLocation(), Sound.ENTITY_ENDER_PEARL_THROW, 1, 1);
        }
    }

    @EventHandler
    public void inventoryOpen(final InventoryOpenEvent event)
    {
        HumanEntity human = event.getPlayer();
        Player player = (Player) human;

        human.setItemOnCursor(null);
        player.updateInventory();
    }

    public static ItemStack generateMenuStar()
    {
        ItemStack menuStar = new ItemStack(Material.NETHER_STAR);
        ItemMeta menuStarMeta = menuStar.getItemMeta();
        menuStarMeta.displayName(Component.text(ChatColor.DARK_PURPLE + "Menu"));
        menuStar.setItemMeta(menuStarMeta);

        return menuStar;
    }

    @EventHandler
    public void onItemDrop(PlayerDropItemEvent event)
    {
        if (event.getItemDrop().getItemStack().isSimilar(generateMenuStar()))
        {
            event.setCancelled(true);
        }
    }

    public static ItemStack pocketDimensionItem()
    {
        ItemStack item = new ItemStack(Material.ENDER_PEARL);
        ItemMeta meta = item.getItemMeta();
        meta.displayName(Component.text(ChatColor.LIGHT_PURPLE + "Pocket Dimension"));
        item.setItemMeta(meta);

        return item;
    }

    @EventHandler
    public void pickupItem(PlayerAttemptPickupItemEvent event)
    {
        event.getPlayer().updateInventory();
    }
}
