package nazario.ascii_ui;

import java.awt.*;
import java.io.InputStream;

public class Fonts {
    public static final Font FREE_MONOSPACED = getFont("FreeMonospaced.ttf", 29);

    protected static Font getFont(String name, float fontSize) {
        Font font = null;

        try{
            Thread thread = Thread.currentThread();
            InputStream fileInputStream = thread.getContextClassLoader().getResourceAsStream("font/" + name);
            if (fileInputStream != null) {
                font = Font.createFont(Font.TRUETYPE_FONT, fileInputStream);
                font = font.deriveFont(Font.PLAIN, fontSize);

                GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
                ge.registerFont(font);
            } else {
                System.err.println("Font file not found.");
            }
        } catch(Exception ignored) {}

        return font;
    }

    public static Font createDefault(float fontSize) {
        return getFont("FreeMonospaced.ttf", fontSize);
    }
}
