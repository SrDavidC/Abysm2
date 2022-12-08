package abysm.abysm.crafting.recipes;

import abysm.abysm.crafting.CustomRecipe;
import abysm.abysm.utils.Items;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapedRecipe;

public class EnchantedGold extends CustomRecipe {
    Items items = new Items();

    public EnchantedGold(NamespacedKey namespacedKey) {
        super(namespacedKey);
        final ShapedRecipe recipe = new ShapedRecipe(namespacedKey, items.getEnchantedGold());
        ItemStack flower = new ItemStack(Material.SUNFLOWER);
        flower.setAmount(16);
        RecipeChoice flowers = new RecipeChoice.ExactChoice(flower);
        recipe.shape("AAA","ABA","AAA");
        recipe.setIngredient('A', Material.GOLD_INGOT);
        recipe.setIngredient('B',flowers);
        
        setRecipe(recipe);
    }
}
