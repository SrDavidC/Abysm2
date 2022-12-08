package abysm.abysm.commands;

import abysm.abysm.utils.Utils;
import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.Conditions;
import co.aikar.commands.annotation.Default;
import co.aikar.commands.annotation.Syntax;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;

import fr.mrmicky.fastinv.ItemBuilder;

import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.Objects;

@CommandAlias("dm")
public class debugMode extends BaseCommand {


    @Default
    @Syntax("Usage /dm <numbre of mode>")
    public void onSend(Player player, @Conditions("limits:min=1,max=3") Integer number) {
        if (!player.hasPermission("abysm.debugMode")){
            Bukkit.broadcastMessage(Utils.prefix + Utils.noPerms);
            return;
        }

        PlayerInventory inv = player.getInventory();
        switch (number) {
            case 1: //Full p4
                inv.setHelmet(
                        new ItemBuilder(Material.DIAMOND_HELMET).enchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4).build());
                inv.setChestplate(new ItemBuilder(Material.DIAMOND_CHESTPLATE)
                        .enchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4).build());
                inv.setLeggings(new ItemBuilder(Material.DIAMOND_LEGGINGS).enchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4)
                        .build());
                inv.setBoots(
                        new ItemBuilder(Material.DIAMOND_BOOTS).enchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4).build());
                inv.setItem(0, new ItemBuilder(Material.DIAMOND_SWORD).enchant(Enchantment.DAMAGE_ALL, 5).build());

                break;
            case 2:
                inv.setHelmet(new ItemBuilder(Material.DIAMOND_HELMET).build());
                inv.setChestplate(new ItemBuilder(Material.DIAMOND_CHESTPLATE).build());
                inv.setLeggings(new ItemBuilder(Material.DIAMOND_LEGGINGS).build());
                inv.setBoots(new ItemBuilder(Material.DIAMOND_BOOTS).build());
                inv.setItem(0, new ItemBuilder(Material.DIAMOND_SWORD).build());
                break;
            case 3:
                inv.setHelmet(
                        new ItemBuilder(Material.NETHERITE_HELMET).enchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4).build());
                inv.setChestplate(new ItemBuilder(Material.NETHERITE_CHESTPLATE)
                        .enchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4).build());
                inv.setLeggings(new ItemBuilder(Material.NETHERITE_LEGGINGS).enchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4)
                        .build());
                inv.setBoots(
                        new ItemBuilder(Material.NETHERITE_BOOTS).enchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4).build());
                inv.setItem(0, new ItemBuilder(Material.NETHERITE_SWORD).enchant(Enchantment.DAMAGE_ALL, 5).build());
                inv.setItem(11, new ItemStack(Material.TOTEM_OF_UNDYING));
                inv.setItem(10, new ItemStack(Material.TOTEM_OF_UNDYING));
                inv.setItem(12, new ItemStack(Material.TOTEM_OF_UNDYING));
                inv.setItem(13, new ItemStack(Material.TOTEM_OF_UNDYING));
                inv.setItem(14, new ItemStack(Material.TOTEM_OF_UNDYING));
                break;
        }
        inv.setItemInOffHand(new ItemStack(Material.SHIELD));
        Objects.requireNonNull(inv.getItemInOffHand().getItemMeta()).setUnbreakable(true);
        Objects.requireNonNull(Objects.requireNonNull(inv.getChestplate()).getItemMeta()).setUnbreakable(true);
        Objects.requireNonNull(Objects.requireNonNull(inv.getHelmet()).getItemMeta()).setUnbreakable(true);
        Objects.requireNonNull(Objects.requireNonNull(inv.getBoots()).getItemMeta()).setUnbreakable(true);
        Objects.requireNonNull(Objects.requireNonNull(inv.getLeggings()).getItemMeta()).setUnbreakable(true);
        inv.setItem(4, new ItemStack(Material.GOLDEN_APPLE, 64));
        player.setFoodLevel(40);
        player.setAllowFlight(true);
        player.addPotionEffect(new PotionEffect(PotionEffectType.HEAL, 20, 20));

    }
}
