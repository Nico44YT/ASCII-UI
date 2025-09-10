package net.letscode.nau.windowed;

import net.letscode.nau.windowed.component.WComponent;
import net.letscode.nau.windowed.component.interactiable.WButton;
import net.letscode.nau.windowed.component.interactiable.WSelectableComponent;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class WScene extends WAbstractScene {

    protected int selectedComponentIndex = 0;
    protected List<WSelectableComponent> selectableComponents = new ArrayList<>();

    public WScene(String title) {
        super(title);
    }

    public WScene() {
        super();
    }

    @Override
    public void init() {
        super.init();
    }

    @Override
    public void render() {
        super.render();
    }

    @Override
    public void update() {
        for(WSelectableComponent component : selectableComponents) {
            component.setSelected(false);
        }
        for(int i = 0; i< selectableComponents.size(); i++) {
            if(i == selectedComponentIndex) {
                selectableComponents.get(i).setSelected(true);
            }
        }

        super.update();
    }

    @Override
    public String getTitle() {
        return super.getTitle();
    }

    @Override
    public void keyTyped(KeyEvent e) {
        super.keyTyped(e);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_W) {
            selectedComponentIndex = (selectedComponentIndex - 1 + selectableComponents.size()) % selectableComponents.size();
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_S) {
            selectedComponentIndex = (selectedComponentIndex + 1) % selectableComponents.size();
        }

        if(e.getKeyCode() == KeyEvent.VK_ENTER || e.getKeyCode() == KeyEvent.VK_SPACE) {
            WSelectableComponent component = selectableComponents.get(selectedComponentIndex);

            if(component instanceof WButton button) {
                button.performAction();
            }
        }

        super.keyPressed(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        super.keyReleased(e);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        super.mouseClicked(e);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        super.mousePressed(e);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        super.mouseReleased(e);
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        super.mouseEntered(e);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        super.mouseExited(e);
    }

    @Override
    public void stop() {
        super.stop();
    }
}
