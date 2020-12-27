package de.teddy.advancementhunt.config;

import de.teddy.advancementhunt.AdvancementHunt;

public class AdvancementSeed extends AbstractFile {

    public AdvancementSeed() {
        super(AdvancementHunt.getInstance(), "nosql.yml","", true);
    }
}
