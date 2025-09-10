package net.letscode.nau.windowed.component.interactiable;

import net.letscode.nau.languaged.LanguageProvider;
import net.letscode.nau.utiled.Vector2;
import net.letscode.nau.windowed.Window;

import java.awt.event.KeyEvent;

public class WInputField extends WSelectableComponent {
    protected String text;
    protected Runnable action;

    public WInputField(Vector2 position) {
        super(position);
        this.text = "";
    }

    public WInputField(Vector2 position, Runnable action) {
        super(position);
        this.text = "";
        this.action = action;
    }


    public String getText() {
        return this.text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void addToText(String text) {
        this.text += text;
    }

    public void handleKeyEvent(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_ENTER) {
            if(action != null) action.run();
            return;
        }

        if(e.getKeyChar() == KeyEvent.VK_BACK_SPACE) {
            this.removeTextSpace(1);
            return;
        }

        if(e.getKeyCode() == KeyEvent.VK_SHIFT || e.getKeyCode() == KeyEvent.VK_CONTROL) return;

        this.addToText(String.valueOf(e.getKeyChar()));
    }

    public void removeTextSpace(int amount) {
        if(text.length() > 0) {
            this.text = text.substring(0, text.length()-amount);
        }
    }

    @Override
    public void render(Window window, LanguageProvider languageProvider) {
        window.addText(position.x, position.y, (this.selected?"▻":" ")+text);
    }
}
