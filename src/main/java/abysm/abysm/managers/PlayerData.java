package abysm.abysm.managers;

import lombok.Getter;
import lombok.Setter;
import org.bukkit.Location;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;

public class PlayerData {
    @Getter @Setter public Location location;
    @Getter @Setter public ItemStack[] storageI;
    @Getter @Setter public ItemStack[] ArmorI;
    @Getter @Setter public ItemStack Offhand;
    public String mensajeMuerte;

    public PlayerData(String mensajeMuerte){
        this.mensajeMuerte = mensajeMuerte;
    }

}
