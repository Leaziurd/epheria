package org.thePlaceholder.epheria;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.thePlaceholder.epheria.data.restart;
import org.thePlaceholder.epheria.registers.registerEvents;
import org.thePlaceholder.epheria.registers.registerRecipes;

public class epheria extends JavaPlugin
{
    public static epheria instance;

    public void onEnable()
    {
        instance = this;

        registerEvents.run();
        registerRecipes.run();

        restart.start(this, () -> {
            Bukkit.spigot().restart();

        }, 24);
    }

    public static epheria getInstance() {return instance;}
}