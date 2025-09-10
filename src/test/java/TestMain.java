
import nazario.ascii_ui.AsciiScene;
import nazario.ascii_ui.component.AsciiTextComponent;
import nazario.ascii_ui.swing.JFrameAscii;


public class TestMain {
    public static void main(String[] args) {
        AsciiScene scene = new AsciiScene(80, 24);
        JFrameAscii frame = new JFrameAscii(scene);

        String text = "Hello World";
        scene.addComponent(new AsciiTextComponent(text, scene.getWidth()/2 - text.length()/2, scene.getHeight()/2));

        String text2 = "Another Text!";
        scene.addComponent(new AsciiTextComponent(text2, scene.getWidth()/2 - text2.length()/2, scene.getHeight()/2 + 1));

        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrameAscii.EXIT_ON_CLOSE);

        frame.update();
    }
}
