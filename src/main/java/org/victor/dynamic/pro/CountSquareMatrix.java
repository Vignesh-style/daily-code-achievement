package org.victor.dynamic.pro;

import java.util.Arrays;

/**
 * LeetCode :: 1277. Count Square Sub Matrix With All Ones.
 * Given an m * n matrix of ones and zeros, return how many square submatrices have all ones.
 * */

public class CountSquareMatrix {

    public static int count(int[][] matrix) {

        int row_length = matrix.length;
        int col_length = matrix[0].length;
        int[][] dp = new int[row_length][col_length];

        //filling the 1st column... because they can have a maximum of 1 square count and its itself.
        //these form the base of the dp - memoization.

        int rw = 0;
        System.arraycopy(matrix[rw], 0, dp[rw], 0, col_length);

        //filling the 1st row... because they can have a maximum of 1 square count and its itself.
        //these form the base of the dp - memoization.

        int cl = 0;
        for (int r = 0; r < row_length; r++) {
            dp[r][cl] = matrix[r][cl];
        }


        for (int row = 1; row < row_length; row++) {

            for (int col = 1; col < col_length; col++) {

                if (matrix[row][col] == 1)
                    dp[row][col] = Math.min(Math.min(dp[row - 1][col - 1], dp[row][col - 1]), dp[row - 1][col]) + 1;
            }

        }

        return Arrays.stream(dp).mapToInt(arr -> Arrays.stream(arr).sum()).sum();
    }
}
