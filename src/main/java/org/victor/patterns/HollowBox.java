package org.victor.patterns;

public class HollowBox {

    public static void main(String[] args) {

        printHollowBox(5,10);

    }

    private static void printHollowBox(int n, int m) {

        for (int i = 0; i < n; i++){

            for (int j = 0; j < m; j++) {

                if (i == 0 || j == 0 || i == n -1 || j == m -1){
                    System.out.print(" * ");
                }
                else System.out.print("   ");

            }
            System.out.println();
        }
    }

}
