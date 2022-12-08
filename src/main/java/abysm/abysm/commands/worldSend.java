package abysm.abysm.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.Conditions;
import co.aikar.commands.annotation.Default;
import co.aikar.commands.annotation.Syntax;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;

@CommandAlias("sendw")
public class worldSend extends BaseCommand {
    @Default
    @Syntax("Usage /sendw <player> <world>")
    public void onSend(Player sender, Player p, World world){
        double x = p.getLocation().getX();
        double y = p.getLocation().getY();
        double z = p.getLocation().getZ();
        String w = String.valueOf(world);
        World sessionWorld = Bukkit.getServer().getWorld(w);
        Location loc = new Location(sessionWorld,x,y,z);
        p.teleport(loc);

    }
}
