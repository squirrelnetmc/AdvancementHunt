package de.teddy.advancementhunt.listener;

import de.teddy.advancementhunt.AdvancementHunt;
import de.teddy.advancementhunt.gamestates.EndingState;
import de.teddy.advancementhunt.gamestates.GameState;
import de.teddy.advancementhunt.gamestates.IngameState;
import de.teddy.advancementhunt.gamestates.LobbyState;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerPreLoginEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerConnectionListener implements Listener {

    LobbyState lobbyState = (LobbyState) AdvancementHunt.getInstance().getGameStateManager().getCurrentGameState();

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Bukkit.getScheduler().runTaskLater(AdvancementHunt.getInstance(), new Runnable() {
            @Override
            public void run() {
                Player player = event.getPlayer();

                if(!(AdvancementHunt.getInstance().getGameStateManager().getCurrentGameState() instanceof EndingState)) {
                    AdvancementHunt.getInstance().getUtils().getLocationUtil().teleport(player, "LobbySpawn");
                } else {
                    player.kickPlayer("§cRound already started");
                }
            }
        },100);
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        if(AdvancementHunt.getInstance().getGameStateManager().getCurrentGameState() instanceof IngameState) {
            AdvancementHunt.getInstance().getGameStateManager().setGameState(GameState.ENDING_STATE);
        }

        if (lobbyState.getLobbyTimer().isStarted()) {
            lobbyState.getLobbyTimer().cancel();
        }
    }

}
