package org.victor.array;

import java.util.ArrayList;

/**
 * Scaler problem :: Given an array with N objects colored red, white, or blue, sort them so that objects of the same color are adjacent,
 * with the colors in the order red, white, and blue.
 */

public class SortByColor {

    public ArrayList<Integer> sortColors(ArrayList<Integer> A) {

        int red = 0;
        int white = 0;
        int blue = 0;

        for (Integer a : A){
            if (a == 0)
                red++;
            else if (a == 1)
                white++;
            else
                blue++;

        }

        int idx = 0;
        for (int i = 0; i < red; i++){
            A.set(idx, 0);
            idx++;
        }

        for (int i = 0; i < white; i++ ){
            A.set(idx, 1);
            idx++;
        }

        for (int i = 0; i < blue; i++){
            A.set(idx, 2);
            idx++;
        }

        return A;
    }
}
