package org.thePlaceholder.epheria.data;

import org.bukkit.*;
import org.bukkit.entity.Player;
import org.thePlaceholder.epheria.epheria;

import java.util.List;
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
            wc.seed((long) (Math.random()*1000000));

            world = wc.createWorld();

            epheria.getInstance().getServer().getWorlds().add(world);

            WorldBorder border = world.getWorldBorder();
            border.setCenter(0,0);
            int wSize = 512;

            if()
            if(player.hasPermission("epheria.op")) wSize = 10240;

            border.setSize(wSize);
        }

        return world;
    }

    public static void unload(Player player)
    {
        World world = create(player);
        List<Player> players = world.getPlayers();

        for(int i = 0; i < players.size(); i++)
        {
            Player player2kick = players.get(i);
            join(player2kick);
        }

        epheria.getInstance().getServer().unloadWorld(world, true);
    }
}
