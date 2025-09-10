package nazario.ascii_ui.swing;

import nazario.ascii_ui.AsciiScene;
import nazario.ascii_ui.component.UpdateListener;

import javax.swing.*;
import java.awt.*;

public class JFrameAscii extends JFrame {

    protected AsciiScene scene;
    protected JTextAreaAscii renderer;

    protected double fontWidth;
    protected double fontHeight;

    protected boolean runningThread = false;

    public JFrameAscii(AsciiScene scene) {
        this.scene = scene;
        this.renderer = new JTextAreaAscii(this.scene);

        this.setContentPane(this.renderer);

        this.setVisible(true);
        this.setFont(scene.getFont());

        FontMetrics metrics = this.getGraphics().getFontMetrics(scene.getFont());

        this.fontWidth = metrics.charWidth('#'); // width of one character
        this.fontHeight = metrics.getHeight();   // height of one line

        int windowWidth = (int) Math.ceil((scene.getWidth() + 1) * fontWidth);
        int windowHeight = (int) Math.ceil((scene.getHeight() + 1) * fontHeight);

        this.setMinimumSize(new Dimension(windowWidth, windowHeight));
        this.setMaximumSize(new Dimension(windowWidth, windowHeight));
        this.setPreferredSize(new Dimension(windowWidth, windowHeight));
        this.setSize(new Dimension(windowWidth, windowHeight));

        this.renderer.render();

        this.pack();
    }

    public void update() {
        try{
            Thread.sleep(20);
        }catch (Exception ignore) {}

        this.scene.getComponents().forEach(component -> {
            UpdateListener listener = component.getUpdateListener();
            if(listener != null) listener.update(component);
        });

        this.renderer.render();

        if(this.runningThread) this.update();
    }

    public void startUpdateThread() {
        this.runningThread = true;

        this.update();
    }
}