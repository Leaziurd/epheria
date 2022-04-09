package org.thePlaceholder.epheria.data;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;
import org.bukkit.configuration.file.YamlConfiguration;
import java.nio.file.Files;

import org.bukkit.entity.Player;
import java.io.File;

public class playerDataManager
{
    private static String playerDataDirString = "./plugins/epheria/player-data/";

    public static void setData(final Player player, final String variableName, final Object object)
    {
        UUID uuid = player.getUniqueId();
        String playerDataDirStringFull = playerDataDirString + uuid;
        Path playerDataDirPath = Paths.get(playerDataDirStringFull);
        File playerDataDir = playerDataDirPath.toFile();

        try
        {
            File file = new File(playerDataDir, "data");
            if (!playerDataDir.exists()) {
                Files.createDirectories(playerDataDirPath);
            }
            if (!file.exists()) {
                file.createNewFile();
            }
            YamlConfiguration config = YamlConfiguration.loadConfiguration(file);
            config.set(variableName, object);
            config.save(file);
        }catch (IOException ignored){}
    }
    
    public static Object getData(final Player player, final String variableName) {
        UUID uuid = player.getUniqueId();
        String playerDataDirStringFull = playerDataDirString + uuid;
        Path playerDataDirPath = Paths.get(playerDataDirStringFull);
        File playerDataDir = playerDataDirPath.toFile();
        File file = new File(playerDataDir, "data");
        YamlConfiguration config = YamlConfiguration.loadConfiguration(file);
        return config.get(variableName);
    }
}
