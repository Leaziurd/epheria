package org.thePlaceholder.epheria.menus;

import java.io.IOException;
import java.util.Objects;

import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.entity.HumanEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.thePlaceholder.epheria.data.dataManager;
import org.thePlaceholder.epheria.data.inventory2string;

public class customEnderChest implements Listener
{
    private static Inventory customEnderChest;
    
    public static void open(HumanEntity human) throws IOException, ClassNotFoundException {

        Player player = (Player) human;
        player.playSound(player.getLocation(), Sound.BLOCK_ENDER_CHEST_OPEN, 1f, 1f);

        if(dataManager.getData(player, "customEnderChest") != null)
        {
            String base64Inventory = (String) dataManager.getData((Player) human, "customEnderChest");
            customEnderChest = inventory2string.fromBase64(base64Inventory, "Ender Chest");
            human.openInventory(customEnderChest);
        }
        else
        {
            customEnderChest = Bukkit.createInventory(human, 54 , Component.text("Ender Chest"));
            String base64Inventory = inventory2string.toBase64(customEnderChest);
            dataManager.setData(player, "customEnderChest", base64Inventory);
            customEnderChest = inventory2string.fromBase64(base64Inventory, "Ender Chest");
            human.openInventory(customEnderChest);
        }
    }
    
    public static void set(final HumanEntity human) throws IOException {
        final String base64Inventory = inventory2string.toBase64(customEnderChest);
        dataManager.setData((Player)human, "customEnderChest", base64Inventory);
    }

    public static ItemStack getItem(){
        ItemStack enderChestIcon = new ItemStack(Material.ENDER_CHEST);
        ItemMeta enderChestIconMeta = enderChestIcon.getItemMeta();
        enderChestIconMeta.displayName(Component.text(ChatColor.YELLOW + "Ender Chest"));
        enderChestIcon.setItemMeta(enderChestIconMeta);
        return enderChestIcon;
    }

    @EventHandler
    public void inventoryClose(InventoryCloseEvent event) throws IOException
    {
        if(event.getInventory() == customEnderChest)
        {
            Player player = (Player) event.getPlayer();
            player.playSound(player.getLocation(), Sound.BLOCK_ENDER_CHEST_OPEN, 1f, 1f);

            set(event.getPlayer());
        }
    }

    @EventHandler
    public void interactions(PlayerInteractEvent event) throws IOException, ClassNotFoundException {

        if (Objects.requireNonNull(event.getClickedBlock()).getType() == Material.ENDER_CHEST && event.getAction() == Action.RIGHT_CLICK_BLOCK)
        {
            if(event.getPlayer().isSneaking())
            {
                if(Objects.equals(event.getPlayer().getActiveItem(), new ItemStack(Material.AIR))) open(event.getPlayer());
                else event.setCancelled(true);
            }
            else open(event.getPlayer());
            event.setCancelled(true);
        }
    }
}
