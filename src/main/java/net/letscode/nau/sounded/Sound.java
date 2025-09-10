package net.letscode.nau.sounded;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class Sound {

    String name;

    UUID uuid;

    File soundFile;
    float volume;

    public Sound(String name) {
        this.volume = 1f;
        this.name = name;
        this.uuid = UUID.randomUUID();
    }

    public void setFile(File soundFile) {
        this.soundFile = soundFile;
    }

    public void playSound() {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundFile);
            AudioFormat format = audioInputStream.getFormat();
            DataLine.Info info = new DataLine.Info(Clip.class, format);
            Clip clip = (Clip) AudioSystem.getLine(info);
            clip.open(audioInputStream);

            FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            // Set the volume

            if(volume == 0) gainControl.setValue(-1000f);

            gainControl.setValue(volume * 0.6f);

            clip.start();
        } catch (UnsupportedAudioFileException | LineUnavailableException | IOException e) {
            e.printStackTrace();
        }
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }
}
