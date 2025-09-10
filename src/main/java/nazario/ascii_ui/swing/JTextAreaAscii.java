package nazario.ascii_ui.swing;

import nazario.ascii_ui.AsciiScene;
import nazario.ascii_ui.Fonts;
import nazario.ascii_ui.util.RenderUtil;

import javax.swing.*;
import java.awt.*;

public class JTextAreaAscii extends JTextArea {

    protected AsciiScene scene;

    public JTextAreaAscii(AsciiScene scene) {
        this.scene = scene;

        this.setFont(Fonts.FREE_MONOSPACED);
        this.setEditable(false);
        this.setDragEnabled(false);

        this.setBackground(Color.DARK_GRAY);
        this.setForeground(Color.LIGHT_GRAY);
    }

    public void render() {
        this.setText(RenderUtil.renderStringArray(scene.render()));
    }
}
