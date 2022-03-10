package org.thePlaceholder.epheria.data;

import java.nio.file.Paths;
import java.io.IOException;
import java.util.UUID;
import org.bukkit.configuration.file.YamlConfiguration;
import java.nio.file.Files;

import org.bukkit.entity.Player;
import java.io.File;
import java.nio.file.Path;

public class dataManager
{
    private static String playerDataDirString = "./plugins/epheria/player-data";
    private static Path playerDataDirPath = Paths.get(playerDataDirString);
    private static File playerDataDir = playerDataDirPath.toFile();
    
    public static void setData(final Player player, final String variableName, final Object object) throws IOException
    {
        final UUID uuid = player.getUniqueId();
        final File file = new File(dataManager.playerDataDir, uuid.toString());
        if (!dataManager.playerDataDir.exists()) {
            Files.createDirectories(dataManager.playerDataDirPath);
        }
        if (!file.exists()) {
            file.createNewFile();
        }
        final YamlConfiguration config = YamlConfiguration.loadConfiguration(file);
        config.set(variableName, object);
        config.save(file);
    }
    
    public static Object getData(final Player player, final String variableName) {
        final UUID uuid = player.getUniqueId();
        final File file = new File(dataManager.playerDataDir, uuid.toString());
        final YamlConfiguration config = YamlConfiguration.loadConfiguration(file);
        return config.get(variableName);
    }
}
