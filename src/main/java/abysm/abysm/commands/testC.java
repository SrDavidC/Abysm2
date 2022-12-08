package abysm.abysm.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.Default;
import co.aikar.commands.annotation.Subcommand;
import co.aikar.commands.annotation.Syntax;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;


@CommandAlias("test")
public class testC extends BaseCommand {
    private final ChatColor sunflowerYellow = ChatColor.YELLOW;

    @Default
    @Syntax("<message> &e- The message do you want")
    public void onSend(Player player, String message) {
        player.sendMessage(sunflowerYellow + "[Helpop] " + ChatColor.GRAY + player.getName() + ": " + message);
    }
    @Subcommand("thanks|tk|tks")
    @CommandAlias("thanks|tk|tks")
    public void ty4Hosting(Player sender){
        sender.sendMessage(sunflowerYellow + "[grax]");
    }
}


