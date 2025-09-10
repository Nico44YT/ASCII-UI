package net.letscode.nau.sounded;

import java.io.File;

public class SoundProvider {
    public float soundVolume;
    public SoundProvider() {
        this.soundVolume = 1f;
    }

    public void registerSounds() {
        for(Sound sound : Sounds.getSounds()) {
            try {
                sound.setFile(new File(Thread.currentThread().getContextClassLoader().getResource("assets/sounds/"+sound.name+".wav").toURI()));
            } catch (Exception e) {}
        }
    }

    public void playSound(Sound sound) {
        sound.playSound();
    }
}
