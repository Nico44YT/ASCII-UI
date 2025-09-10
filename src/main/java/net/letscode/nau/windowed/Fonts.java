package net.letscode.nau.windowed;

import java.awt.*;
import java.io.InputStream;

public class Fonts {
    public static Font freeMonospaced = getFont("FreeMonospaced.ttf");

    protected static Font getFont(String name) {
        Font font = null;

        try{
            Thread thread = Thread.currentThread();
            InputStream fileInputStream = thread.getContextClassLoader().getResourceAsStream("assets/font/" + name);
            if (fileInputStream != null) {
                font = Font.createFont(Font.TRUETYPE_FONT, fileInputStream);
                font = font.deriveFont(Font.PLAIN, 29);

                GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
                ge.registerFont(font);
            } else {
                System.err.println("Font file not found.");
            }
        } catch(Exception ignored) {}

        return font;
    }
}
