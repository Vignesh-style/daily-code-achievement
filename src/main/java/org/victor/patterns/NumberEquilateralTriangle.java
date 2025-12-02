package org.victor.patterns;

public class NumberEquilateralTriangle {
    
    // Function to demonstrate pattern
    public static void printPattern(int n)
    {
        int i;
        
        // outer loop to handle number of rows
        for (i = 1; i <= n; i++) {
            
            // inner loop to print space
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }
            
//             inner loop to print star
//            for (int j = 1; j <= i; j++) {
//                System.out.print(j + " ");
//            }

            //hollow

            for (int j = 1; j <= i; j++) {
                if (j == 1 || j == i || i == n) {
                    System.out.print(i + " ");
                } else {
                    System.out.print("  "); // Double space for alignment
                }
            }
            
            // print new line for each row
            System.out.println();
        }
    }

    // Driver Function
    public static void main(String args[])
    {
        int n = 6;
        printPattern(n);
    }
}