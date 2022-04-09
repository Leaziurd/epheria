package org.thePlaceholder.epheria.data;

import org.bukkit.*;
import org.bukkit.entity.Player;
import org.thePlaceholder.epheria.epheria;

import java.util.UUID;

public class playerWorldManager
{
    public static void join(Player player)
    {
        create(player);
        UUID uuid = player.getUniqueId();
        String worldName = uuid + "-pocket_dimension";
        World world = epheria.getInstance().getServer().getWorld(worldName);
        Location loc = new Location(world, 0, world.getHighestBlockYAt(0, 0), 0);

        player.teleport(loc);

        player.setGameMode(GameMode.SURVIVAL);
    }

    public static void create(Player player)
    {
        UUID uuid = player.getUniqueId();
        String worldName = uuid + "-pocket_dimension";
        World world = epheria.getInstance().getServer().getWorld(worldName);

        if(world == null)
        {
            WorldCreator wc = new WorldCreator(uuid + "-pocket_dimension");

            wc.environment(World.Environment.NORMAL);
            wc.type(WorldType.NORMAL);
            wc.seed((long) (Math.random()*100));

            world = wc.createWorld();

            epheria.getInstance().getServer().getWorlds().add(world);

            WorldBorder border = world.getWorldBorder();
            border.setCenter(0,0);
            border.setSize(512);
        }
        else
        {
            epheria.getInstance().getServer().getWorlds().add(world);
        }
    }

    public static void delete(Player player)
    {

    }

    public static void unload(Player player)
    {
        UUID uuid = player.getUniqueId();
        String worldName = uuid + "-pocket_dimension";
        World world = epheria.getInstance().getServer().getWorld(worldName);

        epheria.getInstance().getServer().unloadWorld(world, true);
    }
}
