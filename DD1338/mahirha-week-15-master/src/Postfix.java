/**
 * The Postfix class implements an evaluator for integer postfix expressions.
 *
 * Postfix notation is a simple way to define and write arithmetic expressions
 * without the need for parentheses or priority rules. For example, the postfix
 * expression "1 2 - 3 4 + *" corresponds to the ordinary infix expression
 * "(1 - 2) * (3 + 4)". The expressions may contain decimal 32-bit integer
 * operands and the four operators +, -, *, and /. Operators and operands must
 * be separated by whitespace.
 *
 * @author  NN // TODO
 * @version 2017-12-12
 */
public class Postfix {

    public static class ExpressionException extends Exception {
        public ExpressionException(String message) {
            super(message);
        }
    }

    /**
     * Evaluates the given postfix expression.
     *
     * @param expr  Arithmetic expression in postfix notation
     * @return      The value of the evaluated expression
     * @throws      ExpressionException if the expression is wrong
     */
    public static int evaluate(String expr) throws ExpressionException {
        Stack<Integer> stack = new LinkedList<>();
        // Split string into substrings of components
        String[] strings = expr.trim().split("\\s+");

        // Evaluate each component
        for(String s : strings){
            // If integer, add to stack
            if(isInteger(s)){
                stack.push(Integer.parseInt(s));
            }
            // If operator, calculate on two topmost values in stack, adding total to stack.
            else if(isOperator(s) && stack.size() >= 2){
                int i1 = stack.pop();
                int i2 = stack.pop();
                stack.push(operationsPerformer(i2, i1, s));
            }
            else {
                throw new ExpressionException(s + "is not a valid expression");
            }
        }
        // Make sure there are no excess numbers
        if(stack.size() != 1){ throw new ExpressionException("Not enough operators"); }

        return stack.pop();

    }

    /**
     * Returns true if s is an operator.
     *
     * A word of caution on using the String.matches method: it returns true
     * if and only if the whole given string matches the regex. Therefore
     * using the regex "[0-9]" is equivalent to "^[0-9]$".
     *
     * An operator is one of '+', '-', '*', '/'.
     */
    private static boolean isOperator(String s) {
        return s.matches("[*+-/]");
    }

    /**
     * Returns true if s is an integer.
     *
     * A word of caution on using the String.matches method: it returns true
     * if and only if the whole given string matches the regex. Therefore
     * using the regex "[0-9]" is equivalent to "^[0-9]$".
     *
     * We accept two types of integers:
     *
     * - the first type consists of an optional '-'
     *   followed by a non-zero digit
     *   followed by zero or more digits,
     *
     * - the second type consists of an optional '-'
     *   followed by a single '0'.
     */
    private static boolean isInteger(String s) {
        if(s.matches("-?[1-9]+\\d*")){
            return true;
        }
        else if(s.matches("-?0")){
            return true;
        }
        return false;
    }

    /**
     * Helper function for interpreting operators and actually performing calculations.
     * Takes two ints and an operator string and returns a value.
     * @throws ExpressionException if operator is not +-/* there is division by zero
     */
    private static int operationsPerformer(int a, int b, String operator) throws ExpressionException {
        if(operator.equals("+")){
            return a+b;
        }
        else if(operator.equals("-")){
            return a-b;
        }
        else if(operator.equals("*")){
            return a*b;
        }
        // Check for division by zero
        else if(operator.equals("/") && b != 0){
            return a/b;
        }
        else{
            throw new ExpressionException(a + operator + b + " is not a valid expression.");
        }
    }
}
