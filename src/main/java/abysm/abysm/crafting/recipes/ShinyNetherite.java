package abysm.abysm.crafting.recipes;

import abysm.abysm.crafting.CustomRecipe;
import abysm.abysm.utils.Items;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapedRecipe;

public class ShinyNetherite extends CustomRecipe {
    final Items items = new Items();
    public ShinyNetherite(NamespacedKey namespacedKey){
        super(namespacedKey);
        final ShapedRecipe recipe = new ShapedRecipe(namespacedKey, items.getShinyNetherite());

        RecipeChoice neth = new RecipeChoice.ExactChoice(items.getEnchantedNetherite());
        RecipeChoice gold = new RecipeChoice.ExactChoice(items.getEnchantedGold());
        RecipeChoice obsi = new RecipeChoice.ExactChoice(items.getEnchantedObsidian());
        RecipeChoice sugar = new RecipeChoice.ExactChoice(items.getEnchantedSugar());
        RecipeChoice ore = new RecipeChoice.ExactChoice(items.getShinyNetheriteOre());

        recipe.shape("ABC","DEF","GHI");
        recipe.setIngredient('A',neth);
        recipe.setIngredient('B',gold);
        recipe.setIngredient('C',Material.COPPER_INGOT);
        recipe.setIngredient('D',Material.MAGMA_CREAM);
        recipe.setIngredient('E',ore);
        recipe.setIngredient('F',Material.SLIME_BALL);
        recipe.setIngredient('G',obsi);
        recipe.setIngredient('H',sugar);
        recipe.setIngredient('I',Material.GLOWSTONE_DUST);

        setRecipe(recipe);
    }
}
