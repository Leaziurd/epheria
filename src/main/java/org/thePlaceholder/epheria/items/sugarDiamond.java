package org.thePlaceholder.epheria.items;

import net.kyori.adventure.text.Component;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.thePlaceholder.epheria.main;

public class sugarDiamond implements Listener
{
    public static ItemStack sugarDiamondItem(int amount)
    {
        ItemStack item = new ItemStack(Material.DIAMOND, amount);
        ItemMeta meta = item.getItemMeta();

        meta.displayName(Component.text(ChatColor.BLUE + "Sugar Diamond"));
        meta.setCustomModelData(128);

        item.setItemMeta(meta);

        return item;
    }

    public static ShapedRecipe sugarDiamondRecipe()
    {
        NamespacedKey sugarDiamondKey = new NamespacedKey(main.getInstance(), "sugar_diamond");
        ShapedRecipe sugarDiamondRecipe = new ShapedRecipe(sugarDiamondKey, sugarDiamondItem(2));

        sugarDiamondRecipe.shape
            (
                "SSS",
                "SDS",
                "SSS"
            );

        sugarDiamondRecipe.setIngredient('D', Material.SUGAR);
        sugarDiamondRecipe.setIngredient('S', Material.DIAMOND);

        return sugarDiamondRecipe;
    }
}
