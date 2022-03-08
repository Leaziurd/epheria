// 
// Decompiled by Procyon v0.5.36
// 

package org.thePlaceholder.epheria.data;

import java.nio.file.Paths;
import org.thePlaceholder.epheria.main;
import java.io.IOException;
import java.util.UUID;
import org.bukkit.configuration.file.YamlConfiguration;
import java.nio.file.Files;
import java.nio.file.attribute.FileAttribute;
import org.bukkit.entity.Player;
import java.io.File;
import java.nio.file.Path;

public class dataManager
{
    private static String playerDataDirString;
    private static Path playerDataDirPath;
    private static File playerDataDir;
    
    public static void setData(final Player player, final String variableName, final Object object) throws IOException {
        final UUID uuid = player.getUniqueId();
        final File file = new File(dataManager.playerDataDir, invokedynamic(makeConcatWithConstants:(Ljava/util/UUID;)Ljava/lang/String;, uuid));
        if (!dataManager.playerDataDir.exists()) {
            Files.createDirectories(dataManager.playerDataDirPath, (FileAttribute<?>[])new FileAttribute[0]);
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
        final File file = new File(dataManager.playerDataDir, invokedynamic(makeConcatWithConstants:(Ljava/util/UUID;)Ljava/lang/String;, uuid));
        final YamlConfiguration config = YamlConfiguration.loadConfiguration(file);
        return config.get(variableName);
    }
    
    static {
        dataManager.playerDataDirString = invokedynamic(makeConcatWithConstants:(Ljava/io/File;)Ljava/lang/String;, main.getPlugin().getDataFolder());
        dataManager.playerDataDirPath = Paths.get(dataManager.playerDataDirString, new String[0]);
        dataManager.playerDataDir = new File(dataManager.playerDataDirString);
    }
}
