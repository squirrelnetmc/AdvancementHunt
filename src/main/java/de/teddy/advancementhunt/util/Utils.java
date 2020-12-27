package de.teddy.advancementhunt.util;

public class Utils {

    private WorldUtil worldUtil = new WorldUtil();
    private LocationUtil locationUtil = new LocationUtil();
    private FightUtil fightUtil = new FightUtil();

    public WorldUtil getWorldUtil() {
        return worldUtil;
    }

    public LocationUtil getLocationUtil() { return locationUtil; }

    public FightUtil getFightUtil() { return fightUtil; }
}
