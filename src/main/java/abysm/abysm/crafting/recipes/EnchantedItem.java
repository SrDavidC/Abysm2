package abysm.abysm.crafting.recipes;

import abysm.abysm.crafting.CustomRecipe;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapedRecipe;

public class EnchantedItem extends CustomRecipe {

    public EnchantedItem(NamespacedKey namespacedKey, ItemStack outline, Material center, ItemStack result, int amount) {
        super(namespacedKey);
        final ShapedRecipe recipe = new ShapedRecipe(namespacedKey, result);
        outline.setAmount(amount);
        RecipeChoice flowers = new RecipeChoice.ExactChoice(outline);
        recipe.shape("AAA","ABA","AAA");
        recipe.setIngredient('A', center);
        recipe.setIngredient('B',flowers);

        setRecipe(recipe);
    }
}
