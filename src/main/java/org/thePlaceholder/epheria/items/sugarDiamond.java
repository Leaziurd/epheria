package org.thePlaceholder.epheria.items;

import net.kyori.adventure.text.Component;
import org.bukkit.*;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class sugarDiamond implements Listener
{
    public static ItemStack item()
    {
        ItemStack item = new ItemStack(Material.DIAMOND);
        ItemMeta meta = item.getItemMeta();

        meta.displayName(Component.text(ChatColor.BLUE + "Sugar Diamond"));
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.addEnchant(Enchantment.MENDING, 1, true);
        meta.setCustomModelData(128);

        item.setItemMeta(meta);
        return item;
    }

    public static void recipe()
    {
        ItemStack diamond = new ItemStack(Material.DIAMOND);
        ItemStack sugar = new ItemStack(Material.SUGAR);

        ShapelessRecipe recipe = new ShapelessRecipe(NamespacedKey.minecraft("sugar_diamond"), item());
        recipe.addIngredient(1, sugar);
        recipe.addIngredient(1, diamond);

        Bukkit.getServer().addRecipe(recipe);
    }

    @EventHandler
    public void interactions(PlayerInteractEvent event)
    {
        Player player = event.getPlayer();
        ItemStack item = player.getInventory().getItemInMainHand();
        if(item.isSimilar(item()))
        {
            player.damage(4);
            player.addPotionEffect(new PotionEffect(PotionEffectType.HEALTH_BOOST, 1200, 10, true));

            player.playSound(player, Sound.ENTITY_PLAYER_BURP, 1, 1);

            item.setAmount(item.getAmount() - 1);
            player.getInventory().setItem(player.getInventory().getHeldItemSlot(), item);
        }
    }
}