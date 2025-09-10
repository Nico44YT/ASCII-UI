package net.letscode.nau.windowed.component;

import net.letscode.nau.languaged.LanguageProvider;
import net.letscode.nau.windowed.Window;
import net.letscode.nau.utiled.Vector2;

import java.util.UUID;

public abstract class WComponent {
    public Vector2 position;
    protected UUID id;


    public WComponent(Vector2 position) {
        this.position = position;
        id = UUID.randomUUID();
    }

    // * Methods * //
    public void setPosition(Vector2 position) {
        this.position = position;
    }

    public void setPosition(int x, int y) {
        this.position = new Vector2(x, y);
    }

    public Vector2 getPosition() {
        return this.position;
    }

    public void render(Window window, LanguageProvider languageProvider) {

    };

    public UUID getID() {
        return this.id;
    }
}
