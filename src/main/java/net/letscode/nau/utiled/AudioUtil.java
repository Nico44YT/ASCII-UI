package net.letscode.nau.utiled;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class AudioUtil {
    public static void playSound(File soundFile, float volume) {
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

    public static void playSound(File soundFile, float volume, int loop) {
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

            clip.loop(loop);

            clip.start();
        } catch (UnsupportedAudioFileException | LineUnavailableException | IOException e) {
            e.printStackTrace();
        }
    }
}
