package org.victor.array;

/**
 * LeetCode :: 3195.

 * You are given a 2D binary array grid. Find a rectangle with horizontal and vertical sides with the smallest area, such that all the 1's in grid lie inside this rectangle.
 * Return the minimum possible area of the rectangle.
 * */

public class MinimumBoundingRectangle {

    public int minimumArea(int[][] grid) {


        int x_min = Integer.MAX_VALUE;
        int y_min = Integer.MAX_VALUE;
        int x_max = Integer.MIN_VALUE;
        int y_max = Integer.MIN_VALUE;

        int r = grid.length;
        int c = grid[0].length;

        for (int i = 0; i < r; i++){

            for (int j = 0; j < c; j++){

                if (grid[i][j] == 1){

                    x_min = Math.min(x_min, i);
                    y_min = Math.min(y_min, j);

                    x_max = Math.max(x_max, i);
                    y_max = Math.max(y_max, j);

                }

            }

        }

        if (x_min == Integer.MAX_VALUE) return 0;

        return ( (x_max - x_min) + 1 ) * ( (y_max - y_min) + 1 ); //area formula.

    }

}
