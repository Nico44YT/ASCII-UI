package net.letscode.nau.utiled;

public class Vector2 {

    public int x;
    public int y;

    public Vector2(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Vector2 add(int x, int y) {
        this.x+=x;
        this.y+=y;
        return this;
    }

    public Vector2 add(Vector2 pos) {
        return this.add(pos.x, pos.y);
    }
}