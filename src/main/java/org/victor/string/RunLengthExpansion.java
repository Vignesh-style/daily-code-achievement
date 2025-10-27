package org.victor.string;

public class RunLengthExpansion {

    public static String expand(String input) {
        StringBuilder result = new StringBuilder();
        int i = 0;
        while (i < input.length()) {
            char ch = input.charAt(i++);
            // read following number (may be >9)
            int num = 0;
            while (i < input.length() && Character.isDigit(input.charAt(i))) {
                num = num * 10 + (input.charAt(i) - '0');
                i++;
            }
            // repeat the character num times
            for (int k = 0; k < num; k++) {
                result.append(ch);
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(expand("a1b10"));            // abbbbbbbbbb
        System.out.println(expand("b3c6d15"));          // bbbccccccddddddddddddddd
    }
}
