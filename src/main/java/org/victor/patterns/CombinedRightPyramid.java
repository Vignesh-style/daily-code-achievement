package org.victor.patterns;

public class CombinedRightPyramid {

    public static void print(int n) {

        //upper
        for (int i = 1; i <= n; i++) {

            for (int j = 1; j <= n - i; j++) {
                System.out.print("  ");
            }

            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }

            System.out.println();
        }

        for (int i = n - 1; i >= 1; i--) {

            for (int j = i; j <= n - 1; j++) {
                System.out.print("  ");
            }

            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {
        print(5);
    }
}