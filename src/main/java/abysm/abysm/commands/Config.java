package abysm.abysm.commands;

import abysm.abysm.Abysm;
import abysm.abysm.crafting.CustomRecipe;
import abysm.abysm.utils.Utils;
import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.CommandPermission;
import co.aikar.commands.annotation.Default;
import co.aikar.commands.annotation.Subcommand;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;

@CommandAlias("config")
@CommandPermission("abysm.staff")
public class Config extends BaseCommand {
    Abysm instance = Abysm.getPl();
    @Subcommand("crafting")
    @CommandAlias("crafting")
    @Default
    @CommandPermission("abysm.staff")
    public void crafting(Player sender) {
        HashMap<String, CustomRecipe> allRecipes = Abysm.getPl().getCrafts().getAllRecipes();
        if (!(Abysm.getPl().getCrafts().isEnabled())) {
            for (Map.Entry me : allRecipes.entrySet()) {
                CustomRecipe recipe = (CustomRecipe) me.getValue();
                Bukkit.addRecipe(recipe.getRecipe());
                recipe.setEnabled(true);
                Bukkit.getOnlinePlayers().forEach(all -> all.discoverRecipe(recipe.getNamespacedKey()));
                Bukkit.broadcastMessage(Utils.prefix + "Crafteos custom ACTIVADOS.");
                Abysm.getPl().getCrafts().setEnabled(true);
            }
        } else {
            for (Map.Entry me : allRecipes.entrySet()) {
                CustomRecipe recipe = (CustomRecipe) me.getValue();
                Bukkit.removeRecipe(recipe.getNamespacedKey());
                recipe.setEnabled(true);
                Bukkit.getOnlinePlayers().forEach(all -> all.undiscoverRecipe(recipe.getNamespacedKey()));
                Bukkit.broadcastMessage(Utils.prefix + "Crafteos custom DESACTIVADOS.");
                Abysm.getPl().getCrafts().setEnabled(false);
            }
        }
    }


}
