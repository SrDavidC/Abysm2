package abysm.abysm.crafting.recipes;

import abysm.abysm.crafting.CustomRecipe;
import abysm.abysm.utils.Items;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ShapelessRecipe;

public class EnchantedObsidian extends CustomRecipe {
    Items items = new Items();

    public EnchantedObsidian(NamespacedKey namespacedKey) {
        super(namespacedKey);
        final ShapelessRecipe recipe = new ShapelessRecipe(namespacedKey, items.getEnchantedObsidian());
        recipe.addIngredient(9, Material.OBSIDIAN);
        setRecipe(recipe);
    }
}
