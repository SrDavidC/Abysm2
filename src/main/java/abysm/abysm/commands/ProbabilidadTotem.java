package abysm.abysm.commands;

import abysm.abysm.Abysm;
import abysm.abysm.utils.Utils;
import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.Conditions;
import co.aikar.commands.annotation.Default;
import co.aikar.commands.annotation.Syntax;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

@CommandAlias("probabilidadT")
public class ProbabilidadTotem extends BaseCommand {
    @Default
    @Syntax("Usage /probabilidadT <number of prob>")
    public void onSend(Player sender, @Conditions("limits:min=0,max=100") Integer number){
        if (!sender.hasPermission("abysm.totem")){
            Bukkit.broadcastMessage(Utils.prefix + Utils.noPerms);
            return;
        }

        String senderName = ChatColor.GRAY + "[" + sender.getName().toString() + "] ";
        String message = ChatColor.YELLOW + "Se ha cambiado la probabilidad de fallo de totem a " + number;
        Abysm.getPl().setProbFallo(number);
        Bukkit.broadcastMessage(senderName + message);
    }

}
