package abysm.abysm.crafting.recipes;

import abysm.abysm.crafting.CustomRecipe;
import abysm.abysm.utils.Items;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.inventory.meta.ItemMeta;

public class EnchantedSugar extends CustomRecipe {
    final Items items = new Items();

    public EnchantedSugar(NamespacedKey namespacedKey) {
        super(namespacedKey);
        final ShapelessRecipe recipe = new ShapelessRecipe(namespacedKey, items.getEnchantedSugar());
        recipe.addIngredient(9, Material.SUGAR);
        setRecipe(recipe);
    }
}
