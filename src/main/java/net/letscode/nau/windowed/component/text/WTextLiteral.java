package net.letscode.nau.windowed.component.text;

import net.letscode.nau.languaged.LanguageProvider;
import net.letscode.nau.languaged.text.LiteralText;
import net.letscode.nau.utiled.RenderUtil;
import net.letscode.nau.utiled.Vector2;
import net.letscode.nau.windowed.Window;

public class WTextLiteral extends WTextComponent {
    LiteralText literalText;
    public WTextLiteral(String text, Vector2 position) {
        super(position);
        this.literalText = new LiteralText(text);
    }

    public WTextLiteral(LiteralText literalText, Vector2 position) {
        super(position);
        this.literalText = literalText;
    }

    public WTextLiteral(Vector2 position) {
        super(position);
        this.literalText = null;
    }

    @Override
    public void render(Window window, LanguageProvider languageProvider) {
        try{
            window.addText(position.x, position.y, literalText.text);
        } catch(Exception ignored) {}
    }

    public WTextLiteral setText(String text) {
        this.literalText = new LiteralText(text);
        return this;
    }

    public WTextLiteral setText(LiteralText literalText) {
        this.literalText = literalText;
        return this;
    }

    public LiteralText getText() {
        return this.literalText;
    }
}
