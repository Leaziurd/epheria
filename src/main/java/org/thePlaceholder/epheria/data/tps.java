package org.thePlaceholder.epheria.data;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class tps implements Runnable
{
    public static int TICK_COUNT= 0;
    public static long[] TICKS= new long[600];
    public static long LAST_TICK= 0L;

    public static String getTPS()
    {
        return getTPS(100);
    }

    public static String getTPS(int ticks)
    {
        if (TICK_COUNT< ticks) {
            return String.valueOf(20.0D);
        }
        int target = (TICK_COUNT- 1 - ticks) % TICKS.length;
        long elapsed = System.currentTimeMillis() - TICKS[target];

        DecimalFormat df = new DecimalFormat("#.#");
        df.setRoundingMode(RoundingMode.CEILING);

        if (ticks / (elapsed / 1000.0D) >= 20D) return "20";
        else return df.format(ticks / (elapsed / 1000.0D));
    }

    public static long getElapsed(int tickID)
    {
        if (TICK_COUNT- tickID >= TICKS.length)
        {
        }

        long time = TICKS[(tickID % TICKS.length)];
        return System.currentTimeMillis() - time;
    }

    public void run()
    {
        TICKS[(TICK_COUNT% TICKS.length)] = System.currentTimeMillis();

        TICK_COUNT+= 1;
    }
}
