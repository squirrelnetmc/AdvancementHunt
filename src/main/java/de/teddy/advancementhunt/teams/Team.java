package de.teddy.advancementhunt.teams;

import org.bukkit.ChatColor;

public enum Team {

    HUNTER("Hunter"),
    PLAYER("Player");

    private String teamName;

    private Team(String teamName) {
        this.teamName = teamName;
    }


    public String getTeamName() { return teamName; }

}
