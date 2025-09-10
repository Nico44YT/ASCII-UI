package net.letscode.nau.windowed.component.interactiable;

import net.letscode.nau.languaged.LanguageProvider;
import net.letscode.nau.languaged.text.LiteralText;
import net.letscode.nau.languaged.text.Text;
import net.letscode.nau.languaged.text.TranslatableText;
import net.letscode.nau.utiled.RenderUtil;
import net.letscode.nau.utiled.Vector2;
import net.letscode.nau.windowed.Window;

public class WSlider extends WSelectableComponent {

    int value;
    int minValue;
    int maxValue;

    protected Text name;

    public WSlider(Text name, Vector2 position) {
        super(position);
        this.name = name;
    }


    public WSlider setMaxValue(int maxValue) {
        this.maxValue = maxValue;
        return this;
    }
    public WSlider setMinValue(int minValue) {
        this.minValue = minValue;
        return this;
    }

    public WSlider setValue(int value) {
        this.value = value;
        return this;
    }
    public WSlider addValue(int value) {
        this.value = Math.max(minValue, Math.min(this.value+value, maxValue));
        return this;
    }

    public int getValue() {
        return value;
    }

    @Override
    public void render(Window window, LanguageProvider languageProvider) {
        String text;

        String name = " ";
        if(this.name instanceof TranslatableText translatableText) {
            name = translatableText.text;
        } else if(this.name instanceof LiteralText literalText) {
            name = literalText.text;
        }

        char pointer = '◈';
        char line = '═';
        char endLine = '━';

        text = endLine + RenderUtil.getSpacer(value, line+"") + pointer + RenderUtil.getSpacer(Math.abs(value-maxValue), line+"") + endLine;

        window.addText(position.x, position.y, " " + name);
        window.addText(position.x, position.y+1, (selected?"▻":" ")+text);
    }
}
