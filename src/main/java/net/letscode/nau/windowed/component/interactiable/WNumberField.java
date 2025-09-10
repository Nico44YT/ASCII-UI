package net.letscode.nau.windowed.component.interactiable;

import net.letscode.nau.languaged.LanguageProvider;
import net.letscode.nau.utiled.Vector2;
import net.letscode.nau.windowed.Window;

import java.awt.event.KeyEvent;

public class WNumberField extends WInputField {
    protected String text;
    protected Runnable action;

    protected int min;
    protected int max;

    public WNumberField(Vector2 position) {
        super(position);
        this.text = "";
    }

    public WNumberField(Vector2 position, Runnable action) {
        super(position);
        this.text = "";
        this.action = action;
    }

    public WNumberField setMax(int max) {
        this.max = max;
        return this;
    }
    public WNumberField setMin(int min) {
        this.min = min;
        return this;
    }


    public String getText() {
        return this.text;
    }

    @Override
    public void setText(String text) {
        if(Integer.parseInt(text) > max) {
            this.text = String.valueOf(max);
            return;
        }
        if(Integer.parseInt(text) < min){
            this.text = String.valueOf(min);
            return;
        }
        this.text = text;
    }
    @Override
    public void addToText(String text) {
        this.setText(this.text + text);
    }

    @Override
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

        if(e.getKeyChar() < '0') return;
        if(e.getKeyChar() > '9') return;

        this.addToText(String.valueOf((e.getKeyChar())));
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
