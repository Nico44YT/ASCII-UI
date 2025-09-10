package net.letscode.nau.windowed.component.interactiable;

import net.letscode.nau.annoted.DoNotUse;
import net.letscode.nau.languaged.LanguageProvider;
import net.letscode.nau.languaged.text.LiteralText;
import net.letscode.nau.languaged.text.Text;
import net.letscode.nau.languaged.text.TranslatableText;
import net.letscode.nau.utiled.Vector2;
import net.letscode.nau.windowed.Window;

public class WSelector extends WSelectableComponent {
    public String[] options;
    public int selectedOption;
    boolean loop;

    protected Text name;

    public WSelector(Text name, Vector2 position) {
        super(position);
        this.name = name;
    }


    public WSelector setOptions(String[] options) {
        this.options = options;
        return this;
    }

    public WSelector loop(boolean loop) {
        this.loop = loop;
        return this;
    }

    public WSelector setIndex(int newIndex) {
        if(loop) {
            if(newIndex > options.length-1) this.selectedOption = 0;
            else this.selectedOption = options.length-1;
        } else {
            this.selectedOption = Math.max(0, Math.min(newIndex, options.length-1));
        }
        return this;
    }

    public WSelector addIndex(int newIndex) {
        this.setIndex(newIndex + selectedOption);
        return this;
    }

    public int getIndex() {
        return this.selectedOption;
    }


    @Override @DoNotUse
    public void render(Window window, LanguageProvider languageProvider) {
        String text = "";

        if(name instanceof TranslatableText translatableText) {
            text = translatableText.text;
        } else if(name instanceof LiteralText literalText) {
            text = literalText.text;
        }

        window.addText(position.x, position.y, " "+text);
        if(loop) {
            window.addText(position.x, position.y+1, (selected?"▻":" ") + "◀ " + options[selectedOption] + " ▶");
        } else {

            String text2 = (selectedOption==0?"◁ ":"◀ ") + options[selectedOption] + (selectedOption==options.length-1?" ▷":" ▶");

            window.addText(position.x, position.y+1, (selected?"▻":" ") + text2);
        }
    }
}
