package org.victor.stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Scaler problem :: An arithmetic expression is given by a string array A of size N. Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 * Valid operators are +, -, *, /. Each string may be an integer or an operator.

 * Note: Reverse Polish Notation is equivalent to Postfix Expression, where operators are written after their operands.
 * */

public class ArithmeticExpoValidator {

    public int evalRPN(ArrayList<String> A) {

        List<String> operators = Arrays.asList("+", "-", "*", "/");

        java.util.Stack<String> oStack = new java.util.Stack<>();

        for (String a : A){

            if (operators.contains(a)){

                Integer operand2 = Integer.parseInt(oStack.pop());
                Integer operand1 = Integer.parseInt(oStack.pop());

                Integer res = compute(a, operand1, operand2);

                oStack.push("" + res);
            }
            else {
                oStack.push(a);
            }
        }

        if (oStack.isEmpty()) return -1;


        return Integer.parseInt(oStack.peek());
    }


    private static Integer compute(String operator, Integer operand1, Integer operand2){

        switch(operator){
            case "+":
                return operand1 + operand2;

            case "-":
                return operand1 - operand2;

            case "*":
                return operand1 * operand2;

            case "/":
                if (operand2 == 0) return 0;
                else return operand1 / operand2;
        }
        return -1;
    }
}
