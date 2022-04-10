package org.thePlaceholder.epheria.generators;

import net.kyori.adventure.text.Component;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.thePlaceholder.epheria.data.playerWorldManager;
import org.thePlaceholder.epheria.data.prefix;
import org.thePlaceholder.epheria.epheria;
import org.thePlaceholder.epheria.menus.mainMenu;

public class spawningSequence
{
    public static void getSpawn(Player player)
    {
        World world = epheria.getInstance().getServer().getWorld("spawn");
        Location loc = new Location(world, 8, -60, 8);

        player.setGameMode(GameMode.ADVENTURE);

        player.teleport(loc);
    }

    public static void connect(Player player)
    {
        player.getInventory().setItem(17, mainMenu.generateMenuStar());
        playerRepeating.run(player);

        player.playerListName(Component.text(" " + prefix.get(player) + " " + player.getName()));

        player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1.0f, 1.0f);

        playerWorldManager.join(player);
    }
}
