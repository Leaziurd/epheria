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
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.io.IOException;

public class mainMenu implements Listener
{
    @EventHandler
    public void inventoryClick(InventoryClickEvent event) throws IOException, ClassNotFoundException {
        HumanEntity human = event.getWhoClicked();
        Player player = (Player) event.getWhoClicked();
        Inventory generalMenu = Bukkit.createInventory(null, 9, Component.text("MENU"));
        ItemStack customEnderChestItem = customEnderChest.getItem();
        ItemStack clickedItem = event.getCurrentItem();

        generalMenu.setItem(4, customEnderChestItem);

        if(clickedItem == null) return;

        if(clickedItem.isSimilar(generateMenuStar()))
        {
            event.setCancelled(true);
            human.openInventory(generalMenu);
            human.getInventory().removeItem(mainMenu.generateMenuStar());
            human.getInventory().setItem(17, mainMenu.generateMenuStar());
            player.updateInventory();
            player.playSound(human.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1.0f, 1.0f);
        }

        if(clickedItem.isSimilar(customEnderChestItem))
        {
            event.setCancelled(true);
            customEnderChest.open(human);
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
        menuStarMeta.displayName(Component.text(ChatColor.DARK_PURPLE + "MENU"));
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
}
