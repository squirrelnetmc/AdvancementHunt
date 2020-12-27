package de.teddy.advancementhunt.listener;

import de.teddy.advancementhunt.AdvancementHunt;
import de.teddy.advancementhunt.gamestates.GameState;
import de.teddy.advancementhunt.message.MessageType;
import de.teddy.advancementhunt.teams.Team;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerAdvancementDoneEvent;

public class PlayerAdvancementDoneListener implements Listener {

    @EventHandler
    public void onAdvancementIsDone(PlayerAdvancementDoneEvent event) {
        Player player = event.getPlayer();
        if (AdvancementHunt.getInstance().getAdvancement_id().contains(event.getAdvancement().getKey().getKey())) {
            AdvancementHunt.getInstance().getGameStateManager().setGameState(GameState.ENDING_STATE);

            for(Player all : Bukkit.getOnlinePlayers())
            {
                AdvancementHunt.getInstance().getMessageManager().sendMessageReplace(all, MessageType.WON,"%player%",player.getDisplayName());
            }
            // Bukkit.broadcastMessage(AdvancementHunt.getInstance().getConfigManager().getMessageWithReplace("Game.Messages.Won", "%player%", player.getDisplayName()));

            AdvancementHunt.getInstance().getUtils().getFightUtil().addLoose(AdvancementHunt.getInstance().getTeamManager().getPlayers(Team.HUNTER).get(0), 1);
            AdvancementHunt.getInstance().getUtils().getFightUtil().addLoose(AdvancementHunt.getInstance().getTeamManager().getPlayers(Team.HUNTER).get(1), 1);
            AdvancementHunt.getInstance().getUtils().getFightUtil().addWin(AdvancementHunt.getInstance().getTeamManager().getPlayers(Team.PLAYER).get(0), 1);
        }
        //player.sendMessage("Du hast ein neues Advancement: " + event.getAdvancement().getKey().getKey());
    }

}
