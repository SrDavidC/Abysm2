package abysm.abysm.Listeners;

import abysm.abysm.utils.Items;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.event.inventory.FurnaceBurnEvent;
import org.bukkit.event.inventory.FurnaceSmeltEvent;
import org.bukkit.event.inventory.PrepareItemCraftEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;
import java.util.List;

public class GlobalListener implements Listener {
    @EventHandler
    public void onCraftingTable(PrepareItemCraftEvent e) {
        if (e.getRecipe() == null)
            return;
        Items items = new Items();
        List<ItemStack> matrix = Arrays.asList(e.getInventory().getMatrix());
        ItemStack result = e.getRecipe().getResult();
        if (result.isSimilar(items.getEnchantedGold()) || result.isSimilar(items.getEnchantedNetherite())) {
            if (matrix.get(4).getAmount() != 16)
                e.getInventory().setResult(null);
        }
//        else if (result.isSimilar(items.getShinyNetheriteOre())) {
//            if ((matrix.get(0).getAmount() != 4) || (matrix.get(1).getAmount() != 8) || (matrix.get(2).getAmount() != 16) || (matrix.get(3).getAmount() != 64) ||
//                    (matrix.get(4).getAmount() != 1) || (matrix.get(5).getAmount() != 64) || (matrix.get(6).getAmount() != 8) || (matrix.get(7).getAmount() != 32) || (matrix.get(8).getAmount() != 64))
//                e.getInventory().setResult(null);
//        }
    }

    @EventHandler
    public void onCrafted(CraftItemEvent e) {
        Items items = new Items();
        ItemStack[] matrix = e.getInventory().getMatrix();
        if (e.getInventory().getResult() == null)
            return;
        if (e.getRecipe().getResult().isSimilar(items.getEnchantedGold())) {
            matrix[4].setAmount(matrix[4].getAmount() - 15);
        } else if (e.getRecipe().getResult().isSimilar(items.getEnchantedNetherite())) {
            matrix[4].setAmount(matrix[4].getAmount() - 15);
        }
        else if(e.getRecipe().getResult().isSimilar(items.getShinyNetheriteOre())){
            for (ItemStack item : matrix){
                item.setAmount(0);
            }
        }
    }
    @EventHandler
    public void onFurnace(FurnaceSmeltEvent e){
        if (e.getSource().getType() == Material.BASALT)
            e.getResult().setType(Material.AIR);
    }

}
