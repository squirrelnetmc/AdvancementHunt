package de.teddy.advancementhunt.commands;

import de.teddy.advancementhunt.AdvancementHunt;
import de.teddy.advancementhunt.permissions.Permission;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player)) {
            return false;
        }
        Player player = (Player) sender;

        if(!(args.length == 1)) {
            player.sendMessage("§b/set <TYPE>");
            return false;
        }


        if(!(player.hasPermission(AdvancementHunt.getInstance().getPermissionManager().getPermission(Permission.SET)))) {
            return false;
        }

        if(args[0].equalsIgnoreCase("LobbySpawn")) {
            AdvancementHunt.getInstance().getUtils().getLocationUtil().setLobbySpawn(player);
            player.sendMessage(AdvancementHunt.getInstance().getPrefix() + "§e'LobbySpawn' §8» §a✔");
        } else {
            player.sendMessage("§bSet§8: §eLobbySpawn");
        }

        return false;
    }

}
