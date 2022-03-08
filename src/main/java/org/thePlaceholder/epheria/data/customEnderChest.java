package org.thePlaceholder.epheria.data;

import java.io.IOException;
import java.io.EOFException;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.entity.HumanEntity;
import org.bukkit.inventory.Inventory;

public class customEnderChest
{
    private static Inventory customEnderChest;
    
    public static void open(final HumanEntity human) throws IOException {
        try {
            final String base64Inventory = (String)dataManager.getData((Player)human, "customEnderChest");
            human.openInventory(org.thePlaceholder.epheria.data.customEnderChest.customEnderChest = inventory2string.fromBase64(base64Inventory));
        }
        catch (EOFException er01) {
            org.thePlaceholder.epheria.data.customEnderChest.customEnderChest = Bukkit.createInventory((InventoryHolder)human, 54, "Ender Chest");
            final String base64Inventory2 = inventory2string.toBase64(org.thePlaceholder.epheria.data.customEnderChest.customEnderChest);
            dataManager.setData((Player)human, "customEnderChest", base64Inventory2);
        }
    }
    
    public static void set(final HumanEntity human) throws IOException {
        final String base64Inventory = inventory2string.toBase64(org.thePlaceholder.epheria.data.customEnderChest.customEnderChest);
        dataManager.setData((Player)human, "customEnderChest", base64Inventory);
    }
}
