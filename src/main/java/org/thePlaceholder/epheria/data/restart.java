package org.thePlaceholder.epheria.data;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;

import java.util.Calendar;

public class restart
{
    public static int start(Plugin plugin, Runnable task, int hour)
    {
        Calendar cal = Calendar.getInstance();

        long now = cal.getTimeInMillis();

        if(cal.get(Calendar.HOUR_OF_DAY) >= hour)
            cal.add(Calendar.DATE, 1);

        cal.set(Calendar.HOUR_OF_DAY, hour);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);

        long offset = cal.getTimeInMillis() - now;
        long ticks = offset / 50L;

        return Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, task, ticks, 1728000L);
    }
}
