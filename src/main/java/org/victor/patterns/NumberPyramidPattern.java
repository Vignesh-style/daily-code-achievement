package org.victor.patterns;

public class NumberPyramidPattern {

    public static void main(String[] args) {

        rightPyramid(5);

    }
    private static void rightPyramid(int n) {

        n = n;

        for (int i = 1; i <= n; i++) {

            for (int j = 1; j <= n - i ; j++) {
                System.out.print("  ");
            }


            for (int j = i; j >= 1 ; j--) {
                System.out.print(j + " ");
            }
            System.out.println();
        }

        for (int i = n - 1; i >= 1; i--) {

            for (int j = 1; j <= n - i ; j++) {
                System.out.print("  ");
            }


            for (int j = i; j >= 1 ; j--) {
                System.out.print(j + " ");
            }
            System.out.println();
        }

    }

}
