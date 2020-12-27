package de.teddy.advancementhunt.config;

import de.teddy.advancementhunt.AdvancementHunt;

public class Messages extends AbstractFile {

    public Messages() {
        super(AdvancementHunt.getInstance(), "messages.yml", "", true);
    }
}
