package net.letscode.nau.windowed.component.text;

import net.letscode.nau.languaged.LanguageProvider;
import net.letscode.nau.utiled.Vector2;
import net.letscode.nau.windowed.Window;
import net.letscode.nau.windowed.component.WComponent;

public class WArt extends WComponent {
    String[] content;
    public WArt(String[] content, Vector2 position) {
        super(position);
        this.content = content;
    }

    @Override
    public void render(Window window, LanguageProvider languageProvider) {
        for(int i = 0;i<content.length;i++) {
            window.addText(position.x, position.y+i, content[i]);
        }
    }

    public WArt setContent(String[] content) {
        this.content = content;
        return this;
    }

    public String[] getContent() {
        return this.content;
    }
}
