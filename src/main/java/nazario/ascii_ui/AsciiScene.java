package nazario.ascii_ui;

import nazario.ascii_ui.component.AsciiComponent;
import nazario.ascii_ui.util.Position;
import nazario.ascii_ui.util.RenderUtil;

import javax.print.attribute.standard.QueuedJobCount;
import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.function.Consumer;

public class AsciiScene {
    protected int width;
    protected int height;

    protected AsciiCharacterSet characterSet;
    protected Set<AsciiSceneProperties> properties;

    protected List<Consumer<String>> setTextQueue;
    protected List<AsciiComponent> components;

    protected float fontSize;
    protected Font font;

    public AsciiScene(int width, int height, AsciiSceneProperties... properties) {
        this(width, height, 29, AsciiCharacterSet.DEFAULT, properties);
    }

    public AsciiScene(int width, int height, float fontSize, AsciiCharacterSet characterSet, AsciiSceneProperties... properties) {
        this.width = width;
        this.height = height;

        this.characterSet = characterSet;
        this.components = new LinkedList<>();
        this.setTextQueue = new LinkedList<>();

        this.font = Fonts.createDefault(fontSize);

        this.properties = new HashSet<>(List.of(properties));
    }

    public String[] render() {
        String[] frame = new String[height];

        for(int y = 0;y<height;y++) {
            if(y == 0) {
                frame[y] = characterSet.topLeft() + RenderUtil.repeatString(width - 2, characterSet.horizontal().toString()) + characterSet.topRight();
                continue;
            }

            if(y == height-1) {
                frame[y] = characterSet.bottomLeft() + RenderUtil.repeatString(width - 2, characterSet.horizontal().toString()) + characterSet.bottomRight();
                continue;
            }

            frame[y] = characterSet.vertical() + RenderUtil.repeatString(width - 2, " ") + characterSet.vertical();
        }

        this.components.forEach(component -> {
            component.render(frame, this);
        });

        this.setTextQueue.clear();

        return frame;
    }

    public void setStringAt(String[] frame, Position position, String string) {
        this.setStringAt(frame, position.getX(), position.getY(), string);
    }

    public void setStringAt(String[] frame, int x, int y, String string) {
        String line = frame[y];

        frame[y] = RenderUtil.replaceWithLength(line, x, string);
    }

    public void addComponent(AsciiComponent... components) {
        this.components.addAll(List.of(components));
    }

    public List<AsciiComponent> getComponents() {
        return this.components;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public Font getFont() {
        return this.font;
    }
}
