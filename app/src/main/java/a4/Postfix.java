package a4;

import java.util.ArrayDeque;

public class Postfix {

    /**
     * @param tokens the postfix expression
     * @return the result as double
     */

    public static Double postfix(ArrayDeque<Object> tokens) {
        ArrayDeque<Double> stack = new ArrayDeque<>(); // stack for numbers

        Object token; // declare token

        while (!tokens.isEmpty()) { //token processed until the queue is empty
            token = tokens.removeFirst(); // remove first token
        

            if (token instanceof Double) {  //differentiate Doubles from operators (Character)
                stack.push((Double) token); //add to stack
            } else if (token instanceof Character) {
                if (stack.size() < 2) {
                    throw new IllegalArgumentException("Not enough numbers to operate.");
                }
        

            double a = (Double) stack.pop();
            double b = (Double) stack.pop();
            char operator = (Character) token;
            double result;

            switch(operator) {
                case '+':
                    result = b + a;
                    break;

                case '-':
                    result = b - a;
                    break;

                case '/':
                    if(b == 0.0) {
                        throw new IllegalArgumentException("Can't divide by zero.");
                    }
                    result = b / a;
                    break;     

                case '*':
                    result = b * a;
                    break;

                case '^':
                    result = Math.pow(b, a);
                    break;

                default:
                    throw new IllegalArgumentException("Must input a valid operator.");
            }
            stack.push(result);

        } else {
            throw new IllegalArgumentException("Invalid token.");
        }
    }

    if (stack.size() != 1) {
        throw new IllegalArgumentException();
    }
    

    return (Double) stack.pop(); // return final result
    
}

}
