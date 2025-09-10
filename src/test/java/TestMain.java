
import nazario.ascii_ui.AsciiCharacterSet;
import nazario.ascii_ui.AsciiScene;
import nazario.ascii_ui.component.AsciiTextComponent;
import nazario.ascii_ui.swing.JFrameAscii;

import java.time.LocalTime;

public class TestMain {
    public static void main(String[] args) {
        AsciiScene scene = new AsciiScene(80, 24, 29, AsciiCharacterSet.DEFAULT);
        JFrameAscii frame = new JFrameAscii(scene);

        String text = "Hello World";
        scene.addComponent(new AsciiTextComponent(text, scene.getWidth()/2 - text.length()/2, scene.getHeight()/2));

        String text2 = "00:00";
        AsciiTextComponent time = new AsciiTextComponent(text2, 2, scene.getHeight()/2 + 1);
        time.addUpdateListener(lis -> {
            LocalTime timeDate = LocalTime.now();
            time.setText(timeDate.getHour() + ":" + timeDate.getMinute() + ":" + timeDate.getSecond());
            time.setPosition(scene.getWidth()/2 - time.getText().length()/2, scene.getHeight()/2 + 1);
        });
        scene.addComponent(time);

        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrameAscii.EXIT_ON_CLOSE);

        frame.startUpdateThread();
    }
}
