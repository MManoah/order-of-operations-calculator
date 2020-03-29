import javax.swing.*;
import java.awt.*;

public class Components {
    private static JTextArea display_area; //Text area at the top of the frame

    Components(JFrame frame) {
        display_area = new JTextArea();
        display_area.setEditable(false);
        display_area.setBounds(10, 10, 285, 75);
        display_area.setFont(new Font("Arial", Font.BOLD, 20));
        frame.add(display_area);
        Buttons.createButtons(frame);
    }

    public static JTextArea getDisplayArea() {
        return display_area;
    }
}
