package org.victor.backtracking;

import java.util.*;

/**
 * {@code MinimumCostToExitMaze} - the question is we are the origin of maze ie .(0,0)
 *  there is exit provided in (m,n) we need reach it with minimum path distance. Each step in the patch as a cost to
 *  bear, hence we need to spend minimum amount to the end.
 * */

public class MinimumCostToExitMaze {

    public static final int[][] directions = new int[][]{{0,1}, {1,0}, {1,1}};

    /** RECURSIVE SOLUTION **/

    public Integer findMinPathInMaze(int[][] mazeGrid, int m , int n){

        Integer[] minimumPathValue = new Integer[]{Integer.MAX_VALUE};
        helper(mazeGrid, 0, 0, m, n, new boolean[mazeGrid.length][mazeGrid[0].length], 0, minimumPathValue);
        return minimumPathValue[0];

    }

    private void helper(int[][] grid, int x, int y, int target_x, int target_y, boolean[][] visited, Integer currPathValue, Integer[] minimumPathVal) {

        if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length) return; //bound condition
        if (visited[x][y]) return; //revisited check condition

        //visiting it.
        currPathValue += grid[x][y];
        visited[x][y] = true;

        if (x == target_x && y == target_y){
            Integer min = minimumPathVal[0];
            min = Math.min(min, currPathValue);
            minimumPathVal[0] = min;
        }

        for (int[] direction : directions) {

            int temp_x = direction[0] + x;
            int temp_y = direction[1] + y;

            helper(grid, temp_x, temp_y, target_x, target_y, visited, currPathValue, minimumPathVal);

        }

        //backtrack.
        currPathValue -= grid[x][y];
        visited[x][y] = false;

    }



    /** DP TABLE SOLUTION **/
}
