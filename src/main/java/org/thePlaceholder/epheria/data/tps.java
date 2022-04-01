package org.thePlaceholder.epheria.data;

import org.bukkit.Bukkit;
import org.thePlaceholder.epheria.main;

public class tps
{
    private static Integer tps;

    public static void run(){
        Bukkit.getScheduler().scheduleSyncRepeatingTask(main.getInstance(), new Runnable()
        {
            long sec;
            long currentSec;
            int ticks;

            @Override
            public void run()
            {
                sec = (System.currentTimeMillis() / 1000);

                if (currentSec == sec) {
                    ticks++;
                } else {
                    currentSec = sec;
                    tps = (tps == 0 ? ticks : ((tps + ticks) / 2));
                    ticks = 0;
                }
            }
        }, 0, 1);
    }

    public static Integer get()
    {
        return tps;
    }
}
