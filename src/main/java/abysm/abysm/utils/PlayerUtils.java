package abysm.abysm.utils;

import abysm.abysm.discord.DiscordManager;
import abysm.abysm.managers.PlayerData;
import org.bukkit.entity.Player;

import java.util.HashMap;

public class PlayerUtils {

    public HashMap<String, PlayerData> jugadores;
    public static PlayerUtils playerUtils = new PlayerUtils();

    public PlayerUtils() {
        this.jugadores = new HashMap<>();
        jugadores.put("SRDQRK", new PlayerData("Abandono a SN y tambien el server"));
        jugadores.put("ZEKTRUM", new PlayerData("Sabia que era furro, pero no tanto"));
        jugadores.put("IGAMER", new PlayerData("Le supo  al skywars pero no esto"));
    }

    public static PlayerUtils getInstance() {
        if (PlayerUtils.playerUtils == null)
            PlayerUtils.playerUtils = new PlayerUtils();
        return PlayerUtils.playerUtils;
    }

}
