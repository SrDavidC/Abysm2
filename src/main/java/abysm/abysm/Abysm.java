package abysm.abysm;

import abysm.abysm.Listeners.GlobalListener;
import abysm.abysm.crafting.CraftingManager;
import abysm.abysm.dimension.EmptyChunkGenerator;
import abysm.abysm.dimension.SimpleBiomeProvider;
import abysm.abysm.dimension.SimpleChunkGenerator;
import abysm.abysm.discord.DiscordManager;
import abysm.abysm.game.GameListeners;
import abysm.abysm.game.ItemSkills;
import abysm.abysm.game.PlayerDeath;
import abysm.abysm.game.PlayerJoin;
import abysm.abysm.Listeners.MobsListener;
import abysm.abysm.managers.CommandManager;
import abysm.abysm.Listeners.Naturally;
import fr.mrmicky.fastinv.FastInvManager;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.generator.BiomeProvider;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;


public final class Abysm extends JavaPlugin {

    private @Getter CommandManager commandManager;
    private @Getter static Abysm pl;
    private @Getter @Setter int probFallo;
    private @Getter @Setter int dias;
    final private @Getter String token = "OTI3NjA0NTc1MTAyNDQ3NjY3.YdMpFA.6FZCmG0Gxnq1xKW4uliF8Baqzj8";
    private @Getter Game game;
    private @Getter @Setter CraftingManager crafts;

    @Override
    public void onEnable() {
        dias = 1;
        pl = this;
        probFallo = 2;
        this.commandManager = new CommandManager();
        System.out.println("[ABYSM] ON MI REY");
        FastInvManager.register(this);
        this.getServer().getPluginManager().registerEvents(new MobsListener(), this);
        this.getServer().getPluginManager().registerEvents(new PlayerDeath(), this);
        this.getServer().getPluginManager().registerEvents(new PlayerJoin(),this);
        this.getServer().getPluginManager().registerEvents(new ItemSkills(), this);
        this.getServer().getPluginManager().registerEvents(new GameListeners(),this);
        this.getServer().getPluginManager().registerEvents(new GlobalListener(),this);
        this.getServer().getPluginManager().registerEvents(new Naturally(),this);
        DiscordManager.getInstance();
        game = new Game(pl);
        crafts = new CraftingManager(pl);
        WorldCreator wc = new WorldCreator("NecronsPit");
        wc.generator(new EmptyChunkGenerator());
        wc.environment(World.Environment.NETHER);
        wc.biomeProvider(new SimpleBiomeProvider());
        wc.createWorld();

    }
    public void animation(String text, String sound, String letter, int number, boolean right){

        var chain = PERMADED.newChain();

        var count = 0;
        var character = 92;
        var charac = Character.toString((char)character);

        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "title @a times 0 1 60");

        Bukkit.getOnlinePlayers().forEach(p->{
            p.playSound(p.getLocation(), sound, 1, 1);
        });

        while (count < number) {

            final var current = count;

            var id = "" + (current <= 9 ? "0" + current : current);
            var code = right ? (charac + "uE" + id + letter) : (charac + "uE" + letter + id);

            chain.delay(1).sync(() -> {
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "title @a title {\"text\":\"" + code + "\"}");
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "title @a actionbar {\"text\":\"" + text + "\"}");

            });
            count++;
        }

        chain.sync(TaskChain::abort).execute();
    }

    @Override
    public void onDisable() {
        System.out.println("[ABYSM] SHUT DOWN");
    }
    //Dimension

    @Nullable
    @Override
    public BiomeProvider getDefaultBiomeProvider(@NotNull String worldName, @Nullable String id) {
        return new SimpleBiomeProvider();
    }

    @Nullable
    @Override
    public ChunkGenerator getDefaultWorldGenerator(String worldName, String id){
        return new SimpleChunkGenerator();
    }

    public static <T> TaskChain<T> newChain() {
        return taskChainFactory.newChain();
    }

    public static <T> TaskChain<T> newSharedChain(String name) {
        return taskChainFactory.newSharedChain(name);
    }
}
