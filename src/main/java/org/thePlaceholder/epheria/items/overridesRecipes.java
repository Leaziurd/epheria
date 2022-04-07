package org.thePlaceholder.epheria.items;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;

public class overridesRecipes
{
    public static void override()
    {
        {
            String recipeName = "diamond_block";
            remove(recipeName);
            ShapedRecipe recipe = new ShapedRecipe(NamespacedKey.minecraft(recipeName), new ItemStack(Material.DIAMOND_BLOCK));
            recipe.shape("***", "***", "***");
            recipe.setIngredient('*', vanillaItems.diamond);
            Bukkit.addRecipe(recipe);
        }
    }

    public static void remove(String key) {Bukkit.removeRecipe(NamespacedKey.minecraft(key));}
}
