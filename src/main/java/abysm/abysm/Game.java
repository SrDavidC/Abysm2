package abysm.abysm;

import lombok.Data;
import org.bukkit.Bukkit;

import java.util.HashMap;

@Data
public class Game {

    HashMap<String, Boolean> difficultyChanges = new HashMap<>();

    public Game(Abysm instance){


        difficultyChanges.put("dia1", false);
        difficultyChanges.put("dia3", false);
        difficultyChanges.put("dia5", true);



    }


}
