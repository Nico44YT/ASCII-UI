package net.letscode.nau.windowed.component.text;

import net.letscode.nau.languaged.LanguageProvider;
import net.letscode.nau.languaged.text.TranslatableText;
import net.letscode.nau.utiled.Vector2;
import net.letscode.nau.windowed.Window;

public class WTextTranslatable extends WTextComponent {

    TranslatableText translatableText;

    public WTextTranslatable(String key, Vector2 position) {
        super(position);
        this.translatableText = new TranslatableText(key);
    }

    public WTextTranslatable(TranslatableText translatableText, Vector2 position) {
        super(position);
        this.translatableText = translatableText;
    }

    @Override
    public void render(Window window, LanguageProvider languageProvider) {
        window.addText(position.x, position.y, languageProvider.getKey(translatableText));
    }
}
