package org.victor.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Scaler Problem :: Imagine a histogram where the bars' heights are given by the array A. Each bar is of uniform width, which is 1 unit. When it rains, water will accumulate in the valleys between the bars.
 * Your task is to calculate the total amount of water that can be trapped in these valleys.

 * Example:
 * The Array A = [5, 4, 1, 4, 3, 2, 7] is visualized as in the images in resource. The total amount of rain water trapped in A is 11.
 * */

public class RainWaterTrapped {

    public int getTrappedWaterMetric(final List<Integer> A) {

        int water_Sum = 0;

        List<Integer> lMax = new ArrayList<>();

        for (int i = 0; i < A.size(); i++){

            if (i == 0) lMax.add(0);
            else lMax.add(Math.max(lMax.get(i - 1), A.get(i - 1)));

        }

        List<Integer> rMax = new ArrayList<>(lMax);

        for (int i = A.size() - 1; i >= 0; i--){

            if (i == A.size() - 1) rMax.set(i, 0);
            else rMax.set(i, Math.max(rMax.get(i + 1), A.get(i + 1)));

        }

        for (int cur = 1; cur < A.size() - 1; cur++){

            int w = Math.min(lMax.get(cur), rMax.get(cur)) - A.get(cur);

            if(w > 0){
                water_Sum += w;
            }
        }
        return water_Sum;
    }
}
