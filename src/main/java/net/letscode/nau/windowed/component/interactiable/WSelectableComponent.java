package net.letscode.nau.windowed.component.interactiable;

import net.letscode.nau.utiled.Vector2;
import net.letscode.nau.windowed.component.WComponent;

public abstract class WSelectableComponent extends WComponent {

    public boolean selected;
    public boolean selectable;

    public WSelectableComponent(Vector2 position) {
        super(position);
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public boolean isSelected() {
        return this.selected;
    }

    public void setSelectable(boolean selectable) {
        this.selectable = selectable;
    }

    public boolean isSelectable() {
        return this.selectable;
    }
}
