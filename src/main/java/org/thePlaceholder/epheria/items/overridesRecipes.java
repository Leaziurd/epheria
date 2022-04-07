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
        diamond();
        fireworkStar();
    }

    private static void fireworkStar()
    {
        remove("firework_star_fade");
        remove("firework_star");
    }

    private static void diamond()
    {
        {
            String recipeName = "diamond_block";
            remove(recipeName);
            ShapedRecipe recipe = new ShapedRecipe(NamespacedKey.minecraft(recipeName), new ItemStack(Material.DIAMOND_BLOCK));
            recipe.shape("***", "***", "***");
            recipe.setIngredient('*', vanillaItems.diamond);
            Bukkit.addRecipe(recipe);
        }
        {
            String recipeName = "diamond_axe";
            remove(recipeName);
            ShapedRecipe recipe = new ShapedRecipe(NamespacedKey.minecraft(recipeName), new ItemStack(Material.DIAMOND_AXE));
            recipe.shape("** ", "*# ", " # ");
            recipe.setIngredient('*', vanillaItems.diamond);
            recipe.setIngredient('#', vanillaItems.stick);
            Bukkit.addRecipe(recipe);
        }
        {
            String recipeName = "diamond_boots";
            remove(recipeName);
            ShapedRecipe recipe = new ShapedRecipe(NamespacedKey.minecraft(recipeName), new ItemStack(Material.DIAMOND_BOOTS));
            recipe.shape("   ", "* *", "* *");
            recipe.setIngredient('*', vanillaItems.diamond);
            Bukkit.addRecipe(recipe);
        }
        {
            String recipeName = "diamond_chestplate";
            remove(recipeName);
            ShapedRecipe recipe = new ShapedRecipe(NamespacedKey.minecraft(recipeName), new ItemStack(Material.DIAMOND_CHESTPLATE));
            recipe.shape("* *", "***", "***");
            recipe.setIngredient('*', vanillaItems.diamond);
            Bukkit.addRecipe(recipe);
        }
        {
            String recipeName = "diamond_helmet";
            remove(recipeName);
            ShapedRecipe recipe = new ShapedRecipe(NamespacedKey.minecraft(recipeName), new ItemStack(Material.DIAMOND_HELMET));
            recipe.shape("***", "* *", "   ");
            recipe.setIngredient('*', vanillaItems.diamond);
            Bukkit.addRecipe(recipe);
        }
        {
            String recipeName = "diamond_hoe";
            remove(recipeName);
            ShapedRecipe recipe = new ShapedRecipe(NamespacedKey.minecraft(recipeName), new ItemStack(Material.DIAMOND_HOE));
            recipe.shape("** ", " # ", " # ");
            recipe.setIngredient('*', vanillaItems.diamond);
            recipe.setIngredient('#', vanillaItems.stick);
            Bukkit.addRecipe(recipe);
        }
        {
            String recipeName = "diamond_leggings";
            remove(recipeName);
            ShapedRecipe recipe = new ShapedRecipe(NamespacedKey.minecraft(recipeName), new ItemStack(Material.DIAMOND_LEGGINGS));
            recipe.shape("***", "* *", "* *");
            recipe.setIngredient('*', vanillaItems.diamond);
            Bukkit.addRecipe(recipe);
        }
        {
            String recipeName = "diamond_pickaxe";
            remove(recipeName);
            ShapedRecipe recipe = new ShapedRecipe(NamespacedKey.minecraft(recipeName), new ItemStack(Material.DIAMOND_PICKAXE));
            recipe.shape("***", " # ", " # ");
            recipe.setIngredient('*', vanillaItems.diamond);
            recipe.setIngredient('#', vanillaItems.stick);
            Bukkit.addRecipe(recipe);
        }
        {
            String recipeName = "diamond_shovel";
            remove(recipeName);
            ShapedRecipe recipe = new ShapedRecipe(NamespacedKey.minecraft(recipeName), new ItemStack(Material.DIAMOND_SHOVEL));
            recipe.shape(" * ", " # ", " # ");
            recipe.setIngredient('*', vanillaItems.diamond);
            recipe.setIngredient('#', vanillaItems.stick);
            Bukkit.addRecipe(recipe);
        }
        {
            String recipeName = "diamond_sword";
            remove(recipeName);
            ShapedRecipe recipe = new ShapedRecipe(NamespacedKey.minecraft(recipeName), new ItemStack(Material.DIAMOND_SWORD));
            recipe.shape(" * ", " * ", " # ");
            recipe.setIngredient('*', vanillaItems.diamond);
            recipe.setIngredient('#', vanillaItems.stick);
            Bukkit.addRecipe(recipe);
        }
        {
            String recipeName = "enchanting_table";
            remove(recipeName);
            ShapedRecipe recipe = new ShapedRecipe(NamespacedKey.minecraft(recipeName), new ItemStack(Material.ENCHANTING_TABLE));
            recipe.shape(" . ", "*#*", "###");
            recipe.setIngredient('*', vanillaItems.diamond);
            recipe.setIngredient('#', vanillaItems.obsidian);
            recipe.setIngredient('.', vanillaItems.book);
            Bukkit.addRecipe(recipe);
        }
        {
            String recipeName = "jukebox";
            remove(recipeName);
            ShapedRecipe recipe = new ShapedRecipe(NamespacedKey.minecraft(recipeName), new ItemStack(Material.JUKEBOX));
            recipe.shape("###", "#*#", "###");
            recipe.setIngredient('*', vanillaItems.diamond);
            recipe.setIngredient('#', vanillaItems.plank);
            Bukkit.addRecipe(recipe);
        }
    }

    public static void remove(String key) {Bukkit.removeRecipe(NamespacedKey.minecraft(key));}
}