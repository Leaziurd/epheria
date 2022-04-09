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
    public static void spawn(Player player)
    {
        World world = epheria.getInstance().getServer().getWorld("spawn");
        Location loc = new Location(world, 8, -60, 8);
        player.teleport(loc);

        player.setGameMode(GameMode.ADVENTURE);

        player.getInventory().setItem(17, mainMenu.generateMenuStar());
        playerRepeating.run(player);

        player.playerListName(Component.text(" " + prefix.get(player) + " " + player.getName()));

        player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1.0f, 1.0f);

        player.setResourcePack("https://www.dropbox.com/s/kor3tr9cteq2hw1/epheria.zip?dl=1","d3970b31e44de70dfedd47827dbc92b9d438cc7e");

        playerWorldManager.join(player);
    }
}
