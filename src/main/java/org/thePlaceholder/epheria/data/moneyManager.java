package org.thePlaceholder.epheria.data;

import org.bukkit.entity.Player;

public class moneyManager
{
    public static void add(Player player, Integer integer)
    {
        Integer money = (Integer) playerDataManager.getData(player, "money");

        if(money == null)
        {
            playerDataManager.setData(player, "money", integer);
        }
        else
        {
            playerDataManager.setData(player, "money", money + integer);
        }
    }

    public static double get(Player player)
    {
        Integer amount = (Integer) playerDataManager.getData(player, "money");
        if(amount == null) return 0.00;
        return amount;
    }
}
