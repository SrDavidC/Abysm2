package abysm.abysm.commands;

import abysm.abysm.Abysm;
import abysm.abysm.utils.Utils;
import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.Conditions;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

public class SetDays extends BaseCommand {

    @CommandAlias("DaysSet")
    public void onSend(Player sender, @Conditions("min=1 , max=31")Integer number){
        if (!sender.hasPermission("abysm.daysset")){
            Bukkit.broadcastMessage(Utils.prefix + Utils.noPerms);
            sender.playSound(sender.getLocation(), Sound.BLOCK_NOTE_BLOCK_BASEDRUM,1.0F,0);
            return;
        }

        Abysm abysm = Abysm.getPl();
        abysm.setDias(number);
        sender.sendMessage(ChatColor.AQUA + "Los dias se han cambiado a: " + ChatColor.DARK_AQUA + number);
    }
}
