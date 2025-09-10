package net.letscode.nau.sounded;

public class Sounds {
    static Sound CLICK;
    static Sound SELECT;

    protected static Sound[] sounds = new Sound[]{CLICK, SELECT};

    public static Sound[] getSounds() {
        return sounds;
    }
}
