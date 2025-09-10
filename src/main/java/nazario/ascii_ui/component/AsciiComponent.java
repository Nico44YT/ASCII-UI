package nazario.ascii_ui.component;

import nazario.ascii_ui.AsciiScene;
import nazario.ascii_ui.util.Position;

import java.util.UUID;

public abstract class AsciiComponent {
    protected Position position;

    protected UUID id;

    protected UpdateListener updateListener;

    public AsciiComponent(int x, int y) {
        this.position = new Position(x, y);

        this.id = UUID.randomUUID();
    }

    public void addUpdateListener(UpdateListener listener) {
        this.updateListener = listener;
    }

    public void render(String[] frame, AsciiScene scene) {

    }

    public Position getPosition() {
        return this.position;
    }

    public void setPosition(int x, int y) {
        this.position = new Position(x, y);
    }

    public void setPosition(Position position) {
        this.position = position.copy();
    }

    public UUID getId() {
        return this.id;
    }

    public UpdateListener getUpdateListener() {
        return this.updateListener;
    }
}
