package abysm.abysm.commands;


import abysm.abysm.utils.Utils;
import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.Default;
import co.aikar.commands.annotation.Subcommand;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;

@CommandAlias("g1")
public class gamemode1 extends BaseCommand {
    @Default
    public void onCreative(Player player) {
        if (!player.hasPermission("abysm.gamemodes")){
            Bukkit.broadcastMessage(Utils.prefix + Utils.noPerms);
            return;
        }
        player.sendMessage(ChatColor.AQUA + "[Abysm] Gamemode set to Creative");
        player.setGameMode(GameMode.CREATIVE);
    }
    @Subcommand("g2")
    @CommandAlias("g2")
    public void onSurvival(Player player){
        if (!player.hasPermission("abysm.gamemodes")){
            Bukkit.broadcastMessage(Utils.prefix + ChatColor.GRAY + "Usted no tiene permisos para este comando.Si cree que es un error" +
                    "contacte en Discord con @DavidAS#2830 (SrDqrk)");
            return;
        }
        player.sendMessage(ChatColor.AQUA + "[Abysm] Gamemode set to Survival");
        player.setGameMode(GameMode.SURVIVAL);
    }
}


