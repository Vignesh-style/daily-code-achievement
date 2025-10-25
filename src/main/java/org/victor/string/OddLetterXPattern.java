package org.victor.string;

public class OddLetterXPattern {
    public static void main(String[] args) {
        String word = "VICKY";
        int n = word.length();

        for (int i = 0; i < n; i++) {           // loop through each row
            for (int j = 0; j < n; j++) {       // loop through each column
                if (j == i || j == n - 1 - i)   // check diagonal condition
                    System.out.print(word.charAt(j));
                else
                    System.out.print(" ");
            }
            System.out.println();               // move to next row
        }
    }
}
