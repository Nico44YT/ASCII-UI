package nazario.ascii_ui;

public record AsciiCharacterSet(Character topRight, Character topLeft, Character bottomRight, Character bottomLeft, Character vertical, Character horizontal) {
    public static final AsciiCharacterSet DEFAULT = new AsciiCharacterSet(
            '╗', '╔', '╝', '╚', '║', '═'
    );
}
