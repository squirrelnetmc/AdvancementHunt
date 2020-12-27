package de.teddy.advancementhunt.util;

import com.onarandombox.MultiverseCore.MultiverseCore;
import de.teddy.advancementhunt.AdvancementHunt;
import org.bukkit.*;
import org.bukkit.entity.Player;

import java.util.Random;

public class WorldUtil {

    private static World.Environment environment;
    private static String name;
    private static String seed;
    private static Player player;
    private static int x = 0;
    private static int z = 0;

    public void worldCreate(String name, World.Environment environment, String seed) {
        this.name = name;
        this.environment = environment;
        this.seed = seed;
        worldCreation();
    }

    private void worldCreation() {
        MultiverseCore mcore= AdvancementHunt.getInstance().getMultiverseCore();
        //long mapSeed = new Random().nextLong();
        boolean added = mcore.getMVWorldManager().addWorld(name, environment, seed, WorldType.NORMAL, false, "Generator:.");
    }

    public void teleportation() {
        MultiverseCore mcore= AdvancementHunt.getInstance().getMultiverseCore();
        long mapSeed = new Random().nextLong();
        boolean added = mcore.getMVWorldManager().addWorld(name, World.Environment.NORMAL, String.valueOf(mapSeed), WorldType.NORMAL, false, "Generator:.");
        player.sendMessage("Generating new world with seed... You will be teleported in 5 seconds.");
        Bukkit.getScheduler().scheduleSyncDelayedTask(AdvancementHunt.getInstance(), new Runnable() {
            public void run() {
                World w = Bukkit.getServer().getWorld(name);
                w.getBlockAt(new Location(w, x, 63, z)).setType(Material.BEDROCK);
                w.getBlockAt(new Location(w, x, 64, z)).setType(Material.TORCH);
                player.teleport(new Location(w, x, 64, z));
                player.sendMessage("You have created a new world named: " +w.getName());
            }
        }, 20*5);
    }

}
