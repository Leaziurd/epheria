package org.thePlaceholder.epheria.data;

import java.io.IOException;

import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.entity.HumanEntity;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;

public class customEnderChest
{
    private static Inventory customEnderChest;
    
    public static void open(HumanEntity human) throws IOException, ClassNotFoundException {
        if(dataManager.getData((Player) human, "customEnderChest") != null)
        {
            String base64Inventory = (String) dataManager.getData((Player) human, "customEnderChest");
            customEnderChest = inventory2string.fromBase64(base64Inventory);
            human.openInventory(customEnderChest);
        }
        else
        {
            customEnderChest = Bukkit.createInventory(human, InventoryType.CHEST, Component.text("Ender Chest"));
            String base64Inventory = inventory2string.toBase64(customEnderChest);
            dataManager.setData((Player)human, "customEnderChest", base64Inventory);
            customEnderChest = inventory2string.fromBase64(base64Inventory);
            human.openInventory(customEnderChest);
        }
    }
    
    public static void set(final HumanEntity human) throws IOException {
        final String base64Inventory = inventory2string.toBase64(customEnderChest);
        dataManager.setData((Player)human, "customEnderChest", base64Inventory);
    }
}
