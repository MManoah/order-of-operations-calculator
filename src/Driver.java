import javax.swing.*;

public class Driver {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(320, 420);
        frame.setLayout(null); //Not using a layout manager
        Components components = new Components(frame); //Adds in all the components to frame
        frame.setResizable(false);
        frame.setVisible(true);
    }
}