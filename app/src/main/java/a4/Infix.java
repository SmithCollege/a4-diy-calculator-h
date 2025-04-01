package a4;

import java.lang.reflect.Array;
import java.util.ArrayDeque;

public class Infix {

    public static Double infixToPostfix(ArrayDeque<Object> tokens) {
        ArrayDeque<Character> stack = new ArrayDeque<>(); // stack for operators
        ArrayDeque<Object> queue = new ArrayDeque<>(); // queue for output, holds it in postfix order

        while (!tokens.isEmpty()) { // token processed until the queue is empty; make sure there are tokens to be read
            Object token = tokens.poll(); // removeFirst from queue
        

            if (token instanceof Double) { // if token is a number, then add to output queue
                queue.addLast(token);
            } else if (token instanceof Character) { // if token is an operator
                char operator = (Character) token;

                if (operator == '(') {
                    stack.addFirst(operator); // left parenthesis -> push it onto the stack
                } else if (operator == ')') { 
                    while (!stack.isEmpty() && stack.peekFirst() != '(') { 
                        queue.addLast(stack.removeFirst());
                    }
                    if (stack.isEmpty()) {
                        throw new IllegalArgumentException("Mismatched parentheses.");
                    }
                    stack.removeFirst();
               
                } else {
                    while (!stack.isEmpty() && precedence(stack.peekFirst()) >= precedence(operator)) {
                        queue.addLast(stack.removeFirst());
                    }
                    stack.addFirst(operator);
                }
            } else {
                throw new IllegalArgumentException("Invalid token.");
            }
        }

        while (!stack.isEmpty()) { 
            char top = stack.removeFirst();

            if (top == '(' || top == ')') { // If the token on the top of the stack is a parenthesis, then there are mismatched parentheses.
                throw new IllegalArgumentException("Mismatched parentheses.");
            }
            queue.addLast(top);

        }

        System.out.println(queue);

        return Postfix.postfix(queue);
        

    }
    private static int precedence(char operator) { // returns int that represents priority of operator
        switch (operator) {
            case '+':
            case '-':
                return 1; // + and - lowest precedence

            case '*':
            case '/':
                return 2; 

            case '^':
                return 3; // power = highest precedence

            default:
                throw new IllegalArgumentException("Invalid operator.");
        }

    }

    public static void main(String[] args) { // for testing, change equations to test different operations
        String[] equation = {"2*2+5"};
        System.out.println(Infix.infixToPostfix(Tokenizer.readTokens(equation[0])));
    }

}


