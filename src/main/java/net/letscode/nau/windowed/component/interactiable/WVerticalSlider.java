package net.letscode.nau.windowed.component.interactiable;

import net.letscode.nau.languaged.LanguageProvider;
import net.letscode.nau.languaged.text.LiteralText;
import net.letscode.nau.languaged.text.Text;
import net.letscode.nau.languaged.text.TranslatableText;
import net.letscode.nau.utiled.RenderUtil;
import net.letscode.nau.utiled.Vector2;
import net.letscode.nau.windowed.Window;
import net.letscode.nau.windowed.component.text.WArt;

public class WVerticalSlider extends WSlider {

    public WVerticalSlider(Text name, Vector2 position) {
        super(name, position);
    }

    @Override
    public void render(Window window, LanguageProvider languageProvider) {
        String text[] = new String[maxValue+2];

        String name = " ";
        if(this.name instanceof TranslatableText translatableText) {
            name = translatableText.text;
        } else if(this.name instanceof LiteralText literalText) {
            name = literalText.text;
        }

        char pointer = '◈';
        char line = '║';
        char endLine = '┃';

        text[0] = endLine+"";
        for(int i = 1;i<this.maxValue;i++) {
            text[i] = line+"";

            if(i == value-1) text[i] = pointer+"";
        }
        text[this.maxValue+1] = endLine+"";

        for(int i = 0;i<text.length;i++) {
            if(text[i] == null) continue;
            window.addText(position.x, position.y+i, text[i]);
        }
    }
}
