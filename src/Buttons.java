import javax.swing.*;
import java.awt.*;

public class Buttons {
    public static void createButtons(JFrame frame) {
        JButton one = new JButton("1");
        JButton two = new JButton("2");
        JButton three = new JButton("3");
        JButton four = new JButton("4");
        JButton five = new JButton("5");
        JButton six = new JButton("6");
        JButton seven = new JButton("7");
        JButton eight = new JButton("8");
        JButton nine = new JButton("9");
        JButton zero = new JButton("0");
        JButton decimal = new JButton(".");
        JButton equals = new JButton("=");
        JButton divide = new JButton("÷");
        JButton multiply = new JButton("×");
        JButton subtract = new JButton("−");
        JButton add = new JButton("+");
        JButton sign = new JButton("+/-");
        JButton ans = new JButton("ANS");
        JButton clear = new JButton("CLEAR");
        //--------------------------------------
        //Button styles for all the buttons
        buttonStyle(one, 10, 240, 50, 50, Color.BLACK, Color.WHITE);
        buttonStyle(two, 80, 240, 50, 50, Color.BLACK, Color.WHITE);
        buttonStyle(three, 150, 240, 50, 50, Color.BLACK, Color.WHITE);
        buttonStyle(four, 10, 180, 50, 50, Color.BLACK, Color.WHITE);
        buttonStyle(five, 80, 180, 50, 50, Color.BLACK, Color.WHITE);
        buttonStyle(six, 150, 180, 50, 50, Color.BLACK, Color.WHITE);
        buttonStyle(seven, 10, 120, 50, 50, Color.BLACK, Color.WHITE);
        buttonStyle(eight, 80, 120, 50, 50, Color.BLACK, Color.WHITE);
        buttonStyle(nine, 150, 120, 50, 50, Color.BLACK, Color.WHITE);
        buttonStyle(zero, 10, 300, 50, 50, Color.BLACK, Color.WHITE);
        buttonStyle(decimal, 80, 300, 50, 50, Color.GRAY, Color.WHITE);
        buttonStyle(equals, 150, 300, 50, 50, Color.RED, Color.WHITE);
        buttonStyle(divide, 230, 120, 50, 50, Color.GREEN, Color.BLACK);
        buttonStyle(multiply, 230, 180, 50, 50, Color.GREEN, Color.BLACK);
        buttonStyle(subtract, 230, 240, 50, 50, Color.GREEN, Color.BLACK);
        buttonStyle(add, 230, 300, 50, 50, Color.GREEN, Color.BLACK);
        buttonStyle(sign, 230, 90, 50, 20, Color.ORANGE, Color.BLACK);
        buttonStyle(ans, 10, 90, 50, 20, Color.ORANGE, Color.BLACK);
        buttonStyle(clear, 80, 90, 120, 20, Color.WHITE, Color.BLACK);
        //--------------------------------------
        //Button actions for each button
        ButtonAction action = new ButtonAction(Components.getDisplayArea());
        one.addActionListener(e -> ButtonAction.one());
        two.addActionListener(e -> ButtonAction.two());
        three.addActionListener(e -> ButtonAction.three());
        four.addActionListener(e -> ButtonAction.four());
        five.addActionListener(e -> ButtonAction.five());
        six.addActionListener(e -> ButtonAction.six());
        seven.addActionListener(e -> ButtonAction.seven());
        eight.addActionListener(e -> ButtonAction.eight());
        nine.addActionListener(e -> ButtonAction.nine());
        zero.addActionListener(e -> ButtonAction.zero());
        decimal.addActionListener(e -> ButtonAction.decimal());
        equals.addActionListener(e -> ButtonAction.equals());
        divide.addActionListener(e -> ButtonAction.divide());
        multiply.addActionListener(e -> ButtonAction.multiply());
        subtract.addActionListener(e -> ButtonAction.subtract());
        add.addActionListener(e -> ButtonAction.add());
        sign.addActionListener(e -> ButtonAction.sign());
        ans.addActionListener(e -> ButtonAction.ans());
        clear.addActionListener(e -> ButtonAction.clear());
        //--------------------------------------
        //Places all buttons on frame
        placeButton(frame, one);
        placeButton(frame, two);
        placeButton(frame, three);
        placeButton(frame, four);
        placeButton(frame, five);
        placeButton(frame, six);
        placeButton(frame, seven);
        placeButton(frame, eight);
        placeButton(frame, nine);
        placeButton(frame, zero);
        placeButton(frame, decimal);
        placeButton(frame, equals);
        placeButton(frame, divide);
        placeButton(frame, multiply);
        placeButton(frame, subtract);
        placeButton(frame, add);
        placeButton(frame, sign);
        changeButtonFont(sign, 13);
        placeButton(frame, ans);
        changeButtonFont(ans, 8);
        placeButton(frame, clear);
        changeButtonFont(clear, 16);
    }

    //Changes button position(x, y), width, height, background/foreground color, and the font
    private static void buttonStyle(JButton button, int x, int y, int width, int height, Color Backgroundcolor, Color Foregroundcolor) {
        button.setBounds(x, y, width, height);
        button.setBackground(Backgroundcolor);
        button.setForeground(Foregroundcolor);
        button.setFont(new Font("Arial", Font.BOLD, 20));
    }

    //Places button on frame
    private static void placeButton(JFrame frame, JButton button) {
        frame.add(button);
    }

    //Changes button font and size
    private static void changeButtonFont(JButton button, int font_size) {
        button.setFont(new Font("Arial", Font.BOLD, font_size));
    }
}
