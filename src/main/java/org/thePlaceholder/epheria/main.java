package org.thePlaceholder.epheria;

import org.bukkit.plugin.java.JavaPlugin;
import org.thePlaceholder.epheria.registers.registerEvents;
import org.thePlaceholder.epheria.registers.registerRecipes;

public class main extends JavaPlugin
{

    public static main instance;

    public void onEnable()
    {
        instance = this;

        registerEvents.run(this);
        registerRecipes.run();
    }

    public static main getInstance() {return instance;}
}