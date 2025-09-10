package net.letscode.nau.windowed.component.interactiable;

import net.letscode.nau.languaged.LanguageProvider;
import net.letscode.nau.languaged.text.LiteralText;
import net.letscode.nau.languaged.text.Text;
import net.letscode.nau.languaged.text.TranslatableText;
import net.letscode.nau.utiled.Vector2;
import net.letscode.nau.windowed.Window;

public class WButton extends WSelectableComponent {
    protected Runnable action;
    private Text name;

    public WButton(Text name, Vector2 position, Runnable action) {
        super(position);
        this.action = action;
        this.name = name;
    }

    public void performAction() {
        if(action == null) return;
        action.run();
    }

    public void setAction(Runnable action) {
        this.action = action;
    }


    /**
     * Should never be called manually.
     * @param window
     * @param languageProvider
     */
    @Override
    public void render(Window window, LanguageProvider languageProvider) {
        String text = "";

        if(name instanceof TranslatableText translatableText) {
            text = languageProvider.getKey(translatableText);
        } else if(name instanceof LiteralText literalText) {
            text = literalText.text;
        }

        text = (selected?"▻":" ") + text;

        window.addText(position.x, position.y, text);
    }
}
