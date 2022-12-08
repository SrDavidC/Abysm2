package abysm.abysm.crafting.recipes;

import abysm.abysm.crafting.CustomRecipe;
import abysm.abysm.utils.Items;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.ShapelessRecipe;

public class EnchantedNetherite extends CustomRecipe {
    Items items = new Items();

    public EnchantedNetherite(NamespacedKey namespacedKey) {
        super(namespacedKey);
        final ShapedRecipe recipe = new ShapedRecipe(namespacedKey, items.getEnchantedNetherite());
        ItemStack flower = new ItemStack(Material.PEONY);
        flower.setAmount(16);
        RecipeChoice flowers = new RecipeChoice.ExactChoice(flower);
        recipe.shape("AAA","ABA","AAA");
        recipe.setIngredient('A', Material.NETHERITE_INGOT);
        recipe.setIngredient('B',flowers);

        setRecipe(recipe);
    }
}
