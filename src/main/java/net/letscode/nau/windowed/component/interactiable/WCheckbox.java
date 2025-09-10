package net.letscode.nau.windowed.component.interactiable;

import net.letscode.nau.languaged.LanguageProvider;
import net.letscode.nau.languaged.text.LiteralText;
import net.letscode.nau.languaged.text.Text;
import net.letscode.nau.languaged.text.TranslatableText;
import net.letscode.nau.utiled.Vector2;
import net.letscode.nau.windowed.Window;

public class WCheckbox extends WSelectableComponent {

    public boolean checked;
    private Text name;

    public WCheckbox(Text name, Vector2 position) {
        super(position);
        this.checked = false;
        this.name = name;
    }

    /**
     * Should never be called manually.
     * @param window
     * @param languageProvider
     */
    @Override
    public void render(Window window, LanguageProvider languageProvider) {
        char uncheckedChar = '◇';
        char checkedChar = '◈';

        String text = "";

        if(name instanceof TranslatableText translatableText) {
            text = languageProvider.getKey(translatableText.text);
        } else if(name instanceof LiteralText literalText) {
            text = literalText.text;
        }

        window.addText(position.x, position.y, (this.selected?"▻":" ") + text + " " + (checked?checkedChar:uncheckedChar));
    }


    public void setChecked(boolean checked) {
        this.checked = checked;
    }
    public void toggleCheck() {
        checked = !checked;
    }
}
