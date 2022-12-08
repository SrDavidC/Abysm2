package abysm.abysm.commands;

import abysm.abysm.Abysm;
import abysm.abysm.utils.Items;
import abysm.abysm.utils.Utils;
import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.CommandPermission;
import org.bukkit.entity.Player;

public class GetItems extends BaseCommand {
    @CommandAlias("getItem")
    @CommandPermission("abysm.staff")
    public void onSend(Player sender, String item){
        Items items = new Items();
        Abysm instance = Abysm.getPl();
        if (item.equalsIgnoreCase("shinyore")){
            sender.getInventory().addItem(items.getShinyNetheriteOre());
            sender.sendMessage(Utils.prefix + "Has obtenido un NetheriteShinyOre");
        }
        else if (item.equalsIgnoreCase("days")){
            sender.sendMessage("Los dias son: "+ instance.getDias());
        }
        else if (item.equalsIgnoreCase("shinyneth")){
            sender.getInventory().addItem(items.getShinyNetherite());
            sender.sendMessage(Utils.prefix + "Has obtenido un NetheriteShinyOre");
        }
    }
}
