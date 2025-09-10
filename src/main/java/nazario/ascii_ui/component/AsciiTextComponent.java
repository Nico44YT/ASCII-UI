package nazario.ascii_ui.component;

import nazario.ascii_ui.AsciiScene;

public class AsciiTextComponent extends AsciiComponent {

    protected String text;

    public AsciiTextComponent(String text, int x, int y) {
        super(x, y);

        this.text = text;
    }

    @Override
    public void render(String[] frame, AsciiScene scene) {
        scene.setStringAt(frame, this.position, this.text);
    }
}
