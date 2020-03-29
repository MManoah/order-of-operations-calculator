import javax.swing.*;
import java.util.EmptyStackException;

public class ButtonAction {
    private static JTextArea display_area;
    private static String answer; //Stores answer to equation
    private static boolean clear = false; //Variable to determine whether to clear display

    ButtonAction(JTextArea display_area) { //Constructor to pass display_area from Buttons
        ButtonAction.display_area = display_area;
    }

    //All methods for button actions
    ///////////////////////////////////////////////////////////////////
    public static void one() {
        ButtonAction.checkClear();
        display_area.append("1");
        NumberStorage.insert('1');
    }

    public static void two() {
        ButtonAction.checkClear();
        display_area.append("2");
        NumberStorage.insert('2');
    }

    public static void three() {
        ButtonAction.checkClear();
        display_area.append("3");
        NumberStorage.insert('3');
    }

    public static void four() {
        ButtonAction.checkClear();
        display_area.append("4");
        NumberStorage.insert('4');
    }

    public static void five() {
        ButtonAction.checkClear();
        display_area.append("5");
        NumberStorage.insert('5');
    }

    public static void six() {
        ButtonAction.checkClear();
        display_area.append("6");
        NumberStorage.insert('6');
    }

    public static void seven() {
        ButtonAction.checkClear();
        display_area.append("7");
        NumberStorage.insert('7');
    }

    public static void eight() {
        ButtonAction.checkClear();
        display_area.append("8");
        NumberStorage.insert('8');
    }

    public static void nine() {
        ButtonAction.checkClear();
        display_area.append("9");
        NumberStorage.insert('9');
    }

    public static void zero() {
        ButtonAction.checkClear();
        display_area.append("0");
        NumberStorage.insert('0');
    }

    public static void decimal() {
        ButtonAction.checkClear();
        display_area.append(".");
        NumberStorage.insert('.');

    }

    public static void equals() {
        ButtonAction.checkClear();
        try {
            NumberStorage.dumpStack();
            answer = NumberStorage.calculate();
            display_area.append(" ");
            display_area.append("=");
            display_area.append(" ");
            display_area.append("\n");
            display_area.append(answer);
            clear = true;
        } catch (EmptyStackException | NumberFormatException e) {
            NumberStorage.clearEquation();
            NumberStorage.clearOperators();
            display_area.setText("");
            display_area.append("ERROR");
            clear = true;
        }
    }

    public static void divide() {
        ButtonAction.checkClear();
        if (answer != null && display_area.getText().equals("")) {
            display_area.append(answer);
            for (int i = 0; i < answer.length(); i++) {
                if (answer.charAt(i) == '-') {
                    NumberStorage.insert('~');
                } else {
                    NumberStorage.insert(answer.charAt(i));
                }
            }
        }
        display_area.append(" ");
        display_area.append("÷");
        display_area.append(" ");
        NumberStorage.insert('/');
    }

    public static void multiply() {
        ButtonAction.checkClear();
        if (answer != null && display_area.getText().equals("")) {
            display_area.append(answer);
            for (int i = 0; i < answer.length(); i++) {
                if (answer.charAt(i) == '-') {
                    NumberStorage.insert('~');
                } else {
                    NumberStorage.insert(answer.charAt(i));
                }
            }
        }
        display_area.append(" ");
        display_area.append("×");
        display_area.append(" ");
        NumberStorage.insert('*');
    }

    public static void subtract() {
        ButtonAction.checkClear();
        if (answer != null && display_area.getText().equals("")) {
            display_area.append(answer);
            for (int i = 0; i < answer.length(); i++) {
                if (answer.charAt(i) == '-') {
                    NumberStorage.insert('~');
                } else {
                    NumberStorage.insert(answer.charAt(i));
                }
            }
        }
        display_area.append(" ");
        display_area.append("-");
        display_area.append(" ");
        NumberStorage.insert('-');
    }

    public static void add() {
        ButtonAction.checkClear();
        if (answer != null && display_area.getText().equals("")) {
            display_area.append(answer);
            for (int i = 0; i < answer.length(); i++) {
                if (answer.charAt(i) == '-') {
                    NumberStorage.insert('~');
                } else {
                    NumberStorage.insert(answer.charAt(i));
                }
            }
        }
        display_area.append(" ");
        display_area.append("+");
        display_area.append(" ");
        NumberStorage.insert('+');

    }

    public static void sign() {
        ButtonAction.checkClear();
        display_area.append("-");
        NumberStorage.insert('~');
    }

    public static void ans() {
        ButtonAction.checkClear();
        try {
            display_area.append(answer);
            for (int i = 0; i < answer.length(); i++) {
                if (answer.charAt(i) == '-') {
                    NumberStorage.insert('~');
                } else {
                    NumberStorage.insert(answer.charAt(i));
                }
            }
        } catch (NullPointerException e) {
            NumberStorage.clearEquation();
            NumberStorage.clearOperators();
            display_area.setText("");
            display_area.append("ERROR");
            clear = true;
        }
    }

    public static void clear() { //Clears display and everything from Number Storage
        display_area.setText("");
        NumberStorage.clearOperators();
        NumberStorage.clearEquation();
    }

    ///////////////////////////////////////////////////////////////////
    private static void checkClear() { //Method to determine whether to clear the display or not
        if (clear) {
            display_area.setText("");
            clear = false;
        }
    }
}
