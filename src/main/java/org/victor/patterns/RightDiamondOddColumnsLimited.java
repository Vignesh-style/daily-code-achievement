package org.victor.patterns;

public class RightDiamondOddColumnsLimited {

    public static void main(String[] args) {
        int n = 7; // Must be odd
        int maxStars = (n / 2) + 1;  // usable star columns

        // Upper Half
        for (int i = 1; i <= maxStars; i++) {
            // Print spaces before stars (Right shift)
            for (int j = 1; j <= maxStars - i; j++) {
                System.out.print("  ");
            }
            // Print stars
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }

        // Lower Half
        for (int i = maxStars - 1; i >= 1; i--) {
            // Print leading spaces
            for (int s = maxStars - i; s >= 1; s--) {
                System.out.print("  ");
            }
            // Print stars
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
