import java.util.Stack;

public class NumberStorage {
    private static StringBuilder equation = new StringBuilder(); //Stores equation in postfix notation
    private static Stack<Character> operators = new Stack<>(); //Stack for the operators for postfix

    public static void insert(Character a) { //Converts to postfix as the equation is being entered
        if (Character.isDigit(a) || a == '.' || a == '~') { //Appends digit if it's a number
            equation.append(a);
        } else {
            if (equation.charAt(equation.length() - 1) != ' ') { //Adds in a whitespace if there is no whitespace, whitespaces determine if a number is 2 and 3 or 23
                equation.append(" ");
            }
            if (operators.empty()) { //If stack is empty push an operator
                operators.push(a);
            } else {
                switch (a) { //Switch statements for * / + - operators for conversion to postfix
                    //Each case searches for operators with the same precedence or higher precedence and pops the operators that meet those requirements
                    case '*': {
                        int position_d = operators.search('/');
                        int position_m = operators.search('*');
                        if (position_d != -1) {
                            if (operators.size() == 1) position_d -= 1;
                            equation.append(operators.get(position_d));
                            equation.append(" ");
                            operators.remove(position_d);
                            operators.push('*');
                        } else if (position_m != -1) {
                            if (operators.size() == 1) position_m -= 1;
                            equation.append(operators.get(position_m));
                            equation.append(" ");
                            operators.remove(position_m);
                            operators.push('*');
                        } else {
                            operators.push('*');
                        }
                        break;
                    }
                    case '/': {
                        int position_d = operators.search('/');
                        int position_m = operators.search('*');
                        if (position_d != -1) {
                            if (operators.size() == 1) position_d -= 1;
                            equation.append(operators.get(position_d));
                            equation.append(" ");
                            operators.remove(position_d);
                            operators.push('/');
                        } else if (position_m != -1) {
                            if (operators.size() == 1) position_m -= 1;
                            equation.append(operators.get(position_m));
                            equation.append(" ");
                            operators.remove(position_m);
                            operators.push('/');
                        } else {
                            operators.push('/');
                        }
                        break;
                    }
                    case '+': {
                        int position_d = operators.search('/');
                        boolean action_performed = false;
                        if (position_d != -1) {
                            if (operators.size() == 1) position_d -= 1;
                            equation.append(operators.get(position_d));
                            equation.append(" ");
                            operators.remove(position_d);
                            action_performed = true;
                        }
                        int position_m = operators.search('*');
                        if (position_m != -1) {
                            if (operators.size() == 1) position_m -= 1;
                            equation.append(operators.get(position_m));
                            equation.append(" ");
                            operators.remove(position_m);
                            action_performed = true;
                        }
                        int position_a = operators.search('+');
                        if (position_a != -1) {
                            if (operators.size() == 1) position_a -= 1;
                            equation.append(operators.get(position_a));
                            equation.append(" ");
                            operators.remove(position_a);
                            action_performed = true;
                        }
                        int position_s = operators.search('-');
                        if (position_s != -1) {
                            if (operators.size() == 1) position_s -= 1;
                            equation.append(operators.get(position_s));
                            equation.append(" ");
                            operators.remove(position_s);
                            action_performed = true;
                        }
                        if (action_performed) operators.push('+');
                        break;
                    }
                    case '-': {
                        int position_d = operators.search('/');
                        boolean action_performed = false;
                        if (position_d != -1) {
                            if (operators.size() == 1) position_d -= 1;
                            equation.append(operators.get(position_d));
                            equation.append(" ");
                            operators.remove(position_d);
                            action_performed = true;
                        }
                        int position_m = operators.search('*');
                        if (position_m != -1) {
                            if (operators.size() == 1) position_m -= 1;
                            equation.append(operators.get(position_m));
                            equation.append(" ");
                            operators.remove(position_m);
                            action_performed = true;
                        }
                        int position_a = operators.search('+');
                        if (position_a != -1) {
                            if (operators.size() == 1) position_a -= 1;
                            equation.append(operators.get(position_a));
                            equation.append(" ");
                            operators.remove(position_a);
                            action_performed = true;
                        }
                        int position_s = operators.search('-');
                        if (position_s != -1) {
                            if (operators.size() == 1) position_s -= 1;
                            equation.append(operators.get(position_s));
                            equation.append(" ");
                            operators.remove(position_s);
                            action_performed = true;
                        }
                        if (action_performed) operators.push('-');
                        break;
                    }
                    default:
                        break;
                }
            }
        }
    }

    public static void dumpStack() { //Dumps the reminder of the operators in the stack into the postfix equation
        while (!operators.empty()) {
            equation.append(" ");
            equation.append(operators.pop());
        }
    }

    public static String calculate() { //Algorithm to calculate postfix equation
        Stack<Double> result = new Stack<>(); //Stack of doubles which will be left with the result at the end
        StringBuilder temp_number = new StringBuilder(); //Stores a number as a string
        for (int i = 0; i < equation.length(); i++) {
            if (Character.isDigit(equation.charAt(i)) || equation.charAt(i) == '.' || equation.charAt(i) == '~') {
                if (equation.charAt(i) == '~') temp_number.append('-'); //Negative numbers
                else temp_number.append(equation.charAt(i));
            } else if (equation.charAt(i) == ' ') { //Whitespaces determine if numbers are 1 and 2 or 12
                result.push(Double.parseDouble(temp_number.toString())); //Converts the string temp_number to a double and pushes it to the stack called result
                temp_number.setLength(0);
            } else {
                double number1 = result.pop();
                double number2 = result.pop();
                double answer;
                switch (equation.charAt(i)) { //Switch cases for * / + - operators
                    case '*': {
                        answer = number2 * number1;
                        result.push(answer);
                        i++;
                        break;
                    }
                    case '/': {
                        answer = number2 / number1;
                        result.push(answer);
                        i++;
                        break;
                    }
                    case '+': {
                        answer = number2 + number1;
                        result.push(answer);
                        i++;
                        break;
                    }
                    case '-': {
                        answer = number2 - number1;
                        result.push(answer);
                        i++;
                        break;
                    }
                }
            }

        }
        equation.setLength(0); //Clears equation
        return Double.toString(result.pop()); //Returns the result
    }

    public static void clearEquation() { //Clears equation
        equation.setLength(0);
    }

    public static void clearOperators() { //Clears operator stack
        operators.clear();
    }
}
