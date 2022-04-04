package org.thePlaceholder.epheria;

import org.bukkit.plugin.java.JavaPlugin;

public class main extends JavaPlugin {

    public static main instance;

    public void onEnable()
    {
        instance = this;
        register.run(this);
    }

    public static main getInstance() {return instance;}
}