package nazario.ascii_ui.swing;

import nazario.ascii_ui.AsciiScene;
import nazario.ascii_ui.Fonts;
import javax.swing.*;
import java.awt.*;

public class JFrameAscii extends JFrame {

    protected AsciiScene scene;
    protected JTextAreaAscii renderer;

    protected double fontWidth;
    protected double fontHeight;

    public JFrameAscii(AsciiScene scene) {
        this.scene = scene;
        this.renderer = new JTextAreaAscii(this.scene);

        this.setContentPane(this.renderer);

        this.setVisible(true);
        this.setFont(Fonts.FREE_MONOSPACED);

        FontMetrics metrics = this.getGraphics().getFontMetrics(Fonts.FREE_MONOSPACED);

        this.fontWidth = metrics.charWidth('#'); // width of one character
        this.fontHeight = metrics.getHeight();   // height of one line

        int windowWidth = (int) ((scene.getWidth() + 1) * fontWidth);
        int windowHeight = (int) ((scene.getHeight() + 1) * fontHeight);

        this.setMinimumSize(new Dimension(windowWidth, windowHeight));
        this.setMaximumSize(new Dimension(windowWidth, windowHeight));
        this.setPreferredSize(new Dimension(windowWidth, windowHeight));
        this.setSize(new Dimension(windowWidth, windowHeight));

        this.renderer.render();

        this.pack();
    }

    public void update() {
        this.renderer.render();
    }
}