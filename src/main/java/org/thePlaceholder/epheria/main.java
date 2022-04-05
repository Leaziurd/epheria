package org.thePlaceholder.epheria;

import org.bukkit.plugin.java.JavaPlugin;
import org.thePlaceholder.epheria.items.sugarDiamond;
import org.thePlaceholder.epheria.registers.registerEvents;

public class main extends JavaPlugin
{

    public static main instance;

    public void onEnable()
    {
        instance = this;

        registerEvents.run(this);
        
        sugarDiamond.recipe();
    }

    public static main getInstance() {return instance;}
}