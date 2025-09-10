package nazario.ascii_ui.util;

public class Position implements Cloneable {
    protected int x;
    protected int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Position(Position position) {
        this(position.x, position.y);
    }

    public Position add(int x, int y) {
        return new Position(this.x + x, this.y + y);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Position copy() {
        return new Position(this.x, this.y);
    }

    @Override
    public Position clone() {
        return this.copy();
    }

    public String toString() {
        return "{x: " + this.x + "; y: " + this.y + "}";
    }
}
