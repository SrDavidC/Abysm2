package abysm.abysm.utils;
import lombok.Getter;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;



public class Items {
    static String pink = ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD;
    static String blue = ChatColor.BLUE + "" + ChatColor.BOLD;
    static String black = ChatColor.DARK_GRAY + "" + ChatColor.BOLD;
    static ItemStack item = new ItemStack(Material.ARROW);
    static String gold = ChatColor.GOLD + "" + ChatColor.BOLD;
    static String redB = ChatColor.DARK_RED + "" +  ChatColor.BOLD;

    static public ItemStack getEnchantedSugar(){
        final ItemMeta meta = item.getItemMeta();
        meta.setCustomModelData(203);
        meta.setDisplayName(blue + "ENCHANTED SUGAR");
        meta.addEnchant(Enchantment.DIG_SPEED, 10,true);
        final ItemStack item = new ItemStack(Material.SUGAR);

        item.setItemMeta(meta);
        return item;
    }
    static public ItemStack getEnchantedObsidian(){
        final ItemMeta meta = item.getItemMeta();
        meta.setCustomModelData(204);
        meta.setDisplayName(black + "ENCHANTED OBSIDIAN");
        meta.addEnchant(Enchantment.PROTECTION_EXPLOSIONS, 10,true);
        final ItemStack item = new ItemStack(Material.OBSIDIAN);

        item.setItemMeta(meta);
        return item;
    }
    static public ItemStack getEnchantedGold(){
        final ItemMeta meta = item.getItemMeta();
        meta.setCustomModelData(205);
        meta.setDisplayName(gold + "ENCHANTED OBSIDIAN");
        meta.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 10,true);
        final ItemStack item = new ItemStack(Material.GOLD_INGOT);

        item.setItemMeta(meta);
        return item;
    }
    static public ItemStack getEnchantedNetherite(){
        final ItemMeta meta = item.getItemMeta();
        meta.setCustomModelData(206);
        meta.setDisplayName(pink + "ENCHANTED NETHERITE");
        meta.addEnchant(Enchantment.DURABILITY, 10,true);
        final ItemStack item = new ItemStack(Material.NETHERITE_INGOT);


        item.setItemMeta(meta);
        return item;
    }
    static public ItemStack getShinyNetherite(){
        final ItemMeta meta = item.getItemMeta();
        meta.setCustomModelData(202);
        meta.setDisplayName(ChatColor.YELLOW + "" + ChatColor.BOLD +  "SHINY NETHERITE");
        final ItemStack item = new ItemStack(Material.POPPED_CHORUS_FRUIT);

        item.setItemMeta(meta);
        return item;
    }
    static public ItemStack getShinyNetheriteOre(){
        final ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.YELLOW + "" + ChatColor.BOLD +  "SHINY NETHERITE "+ redB +  "ORE");
        final ItemStack item = new ItemStack(Material.SMOOTH_BASALT);
        item.setItemMeta(meta);
        return item;
    }

}
