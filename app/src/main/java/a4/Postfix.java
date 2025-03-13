package a4;

import java.util.ArrayDeque;

public class Postfix {

    public static Double postfix(ArrayDeque<Object> tokens) {
        Deque<double> stack = new ArrayDeque<>(); // stack

        while (!=tokens.isEmpty()) { //token processed until the queue is empty
            Object token = removeFirst(); //removeFirst from queue
        }

        if (token instanceof double) {  //differentiate Doubles from operators (Character)
            stack.push((Double) token); //add to stack
        } else if (token instanceof Character) {
            if (stack.size() < 2) {
                throw new IllegalArgumentException("Not enough numbers to operate.")
            }
        }

        double a = stack.removeFirst();
        double b = stack.removeFirst();
        char operator = (Character) token;
        double result;

        switch(operator) {
            case '+':
                result: 'a + b';
                break;
            case '-':
                result: 'b - a';
                break;
            case '/':
                if(b == 0.0) {
                    throw new IllegalArgumentException("Can't divide by zero.");
                }
                result: 'a / b';
                break;     
            case '*':
                result: 'a * b';
                break;
            case '^':
                result: 'Math.pow(a, b)';
                break;
            default:
                throw new IllegalArgumentException("Must input a valid operator.");
        }



        
    }
    
}