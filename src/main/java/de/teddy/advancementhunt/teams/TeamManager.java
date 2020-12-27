package de.teddy.advancementhunt.teams;

import org.bukkit.entity.Player;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class TeamManager {

    private HashMap<Player, Team> teams = new HashMap<Player, Team>();

    public void setInTeam(Player player, Team team) {
        teams.put(player, team);
    }

    public Boolean isTeamEmpty(Team team) {
        if(this.teams.containsValue(team)) {
            return false;
        } else {
            return true;
        }
    }

    public ArrayList<Player> getPlayers(Team team) {
        ArrayList<Player> list = new ArrayList<Player>();
        for(Player key : teams.keySet()) {
            if(teams.get(key).equals(team)) {
                list.add(key);
            }
        }
        return list;
    }

    /*public Team getTeam(Player player) {
        for(Team key : teams.keySet()) {
            if(teams.get(key).equals(player)) {
                return key;
            }
        }
        return null;
    }*/

    public void clear() {
        this.teams.clear();
    }

    public HashMap<Player, Team> getTeams() { return teams; }

}
