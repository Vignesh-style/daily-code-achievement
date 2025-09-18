package org.victor.stack;

/**
 * Scaler problem ::
 * You have a string, denoted as A.

 * To transform the string, you should perform the following operation repeatedly:
 * Identify the first occurrence of consecutive identical pairs of characters within the string.
 * Remove this pair of identical characters from the string.
 * Repeat steps 1 and 2 until there are no more consecutive identical pairs of characters.
 * The final result will be the transformed string.
 * */

public class DoubleCharacterTrouble {

    public String solve(String A) {

        java.util.Stack<String> dStack = new java.util.Stack<>();

        char[] arr = A.toCharArray();

        for (char ch : arr){

            String s = "" + ch; //String value

            if (dStack.isEmpty()){
                dStack.push(s);
            }

            else {

                if (!dStack.peek().equals(s))
                    dStack.push(s);
                else {
                    dStack.pop();
                }

            }
        }

        String ret = "";

        while (!dStack.isEmpty()){
            ret = dStack.pop() + ret;
        }
        return ret;
    }
}
