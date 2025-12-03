package org.victor.patterns;

public class LeftDiamondOddColumnsLimited {

    public static void main(String[] args) {
        int n = 10; // Must be odd
        int maxStars = (n / 2) + 1;  // usable star columns

        // Upper Half
        for (int i = 1; i <= maxStars; i++) {

            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }

        // Lower Half
        for (int i = maxStars - 1; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
