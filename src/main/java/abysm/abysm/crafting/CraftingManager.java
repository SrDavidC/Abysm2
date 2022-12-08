package abysm.abysm.crafting;

import abysm.abysm.Abysm;
import abysm.abysm.crafting.recipes.*;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.NamespacedKey;
import java.util.HashMap;

public class CraftingManager {

    final private @Getter
    HashMap<String, CustomRecipe> allRecipes = new HashMap<>();

    private @Getter @Setter boolean enabled = false;

    public CraftingManager(Abysm abysm){
        EnchantedSugar enchantedSugar = new EnchantedSugar(new NamespacedKey(abysm,"enchantedSugar"));
        EnchantedObsidian enchantedObsidian = new EnchantedObsidian(new NamespacedKey(abysm,"enchantedObsidian"));
        EnchantedGold enchantedGold = new EnchantedGold(new NamespacedKey(abysm,"enchantedGold"));
        EnchantedNetherite enchantedNetherite = new EnchantedNetherite(new NamespacedKey(abysm,"enchantedNetherite"));
        ShinyNetherite shinyNetherite = new ShinyNetherite(new NamespacedKey(abysm,"shinyNetherite"));

        allRecipes.put("Sugar",enchantedSugar);
        allRecipes.put("Obsidian",enchantedObsidian);
        allRecipes.put("Gold",enchantedGold);
        allRecipes.put("Netherite",enchantedNetherite);
        allRecipes.put("ShinyNetherite",shinyNetherite);

    }
}
