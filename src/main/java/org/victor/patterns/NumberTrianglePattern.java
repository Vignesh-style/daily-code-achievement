package org.victor.patterns;

public class NumberTrianglePattern {
    
    public static void printPattern(int n)
    {
        int i, j;

        //upper
        for (i = 1; i <= n; i++) {
            
            for (j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }
            
            for (j = 1; j <= i; j++) {
                System.out.print(i + " ");
            }
            
            System.out.println();
        }

        //lower
        for (i = n - 1; i >= 1; i--) {

            for (j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }

            for (j = 1; j <= i; j++) {
                System.out.print(i + " ");
            }

            System.out.println();
        }
    }

    public static void main(String args[])
    {
        int n = 5;
        printPattern(n);
    }
}