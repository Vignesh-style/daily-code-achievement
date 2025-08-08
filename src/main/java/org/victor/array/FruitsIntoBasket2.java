package org.victor.array;

/**
 *  LeetCode : 3477.

 *  You are given two arrays of integers, fruits and baskets, each of length n, where fruits[i] represents the quantity of the ith type of fruit, and baskets[j] represents the capacity of the jth basket.
 *  From left to right, place the fruits according to these rules:
 *    - Each fruit type must be placed in the leftmost available basket with a capacity greater than or equal to the quantity of that fruit type.
 *    - Each basket can hold only one type of fruit.
 *    - If a fruit type cannot be placed in any basket, it remains unplaced.

 * Return the number of fruit types that remain unplaced after all possible allocations are made.

 * Constraints:
 * n == fruits.length == baskets.length
 * 1 <= n <= 100
 * 1 <= fruits[i], baskets[i] <= 1000
 * */

public class FruitsIntoBasket2 {

    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {

        int unplacedFruitTypes = 0;

        for (int fruit_quantity : fruits) {

            for (int j = 0; j < baskets.length; j++) {

                if (fruit_quantity <= baskets[j]) {
                    baskets[j] *= -1;
                    break;
                }

                if (j == baskets.length - 1) {
                    unplacedFruitTypes++;
                }
            }
        }

        return unplacedFruitTypes;
    }

}


/**
 *   TC : O(N^2) SPC : O(1).
 * */