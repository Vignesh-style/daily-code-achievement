package org.victor.stack;

import java.util.Arrays;
import java.util.List;

/**
 * Scaler problem :: Given an expression string A, examine whether the pairs and the orders of “{“,”}”, ”(“,”)”, ”[“,”]” are correct in A.
 * Refer to the examples for more clarity.
 * */

public class BalancedParanthesis {

    public int solve(String A) {

        List<String> openingBrackets = Arrays.asList("{", "[", "(");

        java.util.Stack<String> bStack = new java.util.Stack<>();

        char[] arr = A.toCharArray();

        for (char c : arr) {

            String a = "" + c;

            if (openingBrackets.contains(a)) {
                bStack.push(a);
            } else if (bStack.isEmpty() && !openingBrackets.contains(a)) {
                return 0;
            } else {

                if (a.equals("}") && bStack.peek().equals("{")) {
                    bStack.pop();
                }

                if (a.equals("]") && bStack.peek().equals("[")) {
                    bStack.pop();
                }

                if (a.equals(")") && bStack.peek().equals("(")) {
                    bStack.pop();
                }
            }
        }

        if (bStack.isEmpty()) return 1;
        else return 0;
    }
}
