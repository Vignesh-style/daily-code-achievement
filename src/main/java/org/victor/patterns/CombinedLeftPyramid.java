package org.victor.patterns;

public class CombinedLeftPyramid {
    public static void main(String[] args) {
        int n = 3;

        // Upper Left Half Pyramid
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }

        // Lower Reverse Left Half Pyramid
        for (int i = n - 1; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}

