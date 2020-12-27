package de.teddy.advancementhunt.timer;

import de.teddy.advancementhunt.AdvancementHunt;
import de.teddy.advancementhunt.gamestates.GameState;
import de.teddy.advancementhunt.message.MessageType;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class EndingTimer extends Timer {

    private int seconds = 5;

    @Override
    public void start() {

        counter = Bukkit.getScheduler().scheduleSyncRepeatingTask(AdvancementHunt.getInstance(), new Runnable() {

            @Override
            public void run() {
                switch (seconds) {
                    case 0:
                        cancel();
                        AdvancementHunt.getInstance().getGameStateManager().resetGameStates();
                        break;

                    default:
                        for(Player player : Bukkit.getOnlinePlayers()) {
                            AdvancementHunt.getInstance().getMessageManager().sendMessageReplace(player, MessageType.STOP_GAME,"%seconds%",seconds + "");
                        }
                        break;
                }
                seconds--;
            }
        }, 0, 20 * 1); // 1 Second
    }

    @Override
    public void cancel() {
        this.seconds = 5;
        System.out.println("EndingSeconds: " + this.seconds);
        Bukkit.getScheduler().cancelTask(counter);
    }
}
