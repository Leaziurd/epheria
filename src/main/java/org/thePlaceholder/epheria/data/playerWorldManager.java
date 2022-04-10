package org.thePlaceholder.epheria.data;

import org.bukkit.*;
import org.bukkit.entity.Player;
import org.thePlaceholder.epheria.epheria;

import java.util.UUID;

public class playerWorldManager
{
    public static void join(Player player)
    {
        World world = create(player);
        Location loc = new Location(world, 0, world.getHighestBlockYAt(0, 0) + 1, 0);

        epheria.getInstance().getServer().getWorlds().add(world);

        player.teleport(loc);

        player.setGameMode(GameMode.SURVIVAL);
    }

    public static World create(Player player)
    {
        UUID uuid = player.getUniqueId();
        String worldName = "./plugins/epheria/player-data/" + uuid + "/pocket-dimension";
        World world = epheria.getInstance().getServer().getWorld(worldName);

        if(world == null)
        {
            WorldCreator wc = new WorldCreator(worldName);

            wc.environment(World.Environment.NORMAL);
            wc.type(WorldType.NORMAL);
            wc.seed((long) (Math.random()*100));

            world = wc.createWorld();

            epheria.getInstance().getServer().getWorlds().add(world);

            WorldBorder border = world.getWorldBorder();
            border.setCenter(0,0);
            border.setSize(512);
        }

        return world;
    }

    public static void unload(Player player)
    {
        World world = create(player);
        epheria.getInstance().getServer().unloadWorld(world, true);
    }
}
