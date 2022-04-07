package org.thePlaceholder.epheria.registers;

import org.thePlaceholder.epheria.items.overridesRecipes;
import org.thePlaceholder.epheria.items.sugarDiamond;

public class registerRecipes
{
    public static void run()
    {
        sugarDiamond.recipe();

        overridesRecipes.override();
    }
}
