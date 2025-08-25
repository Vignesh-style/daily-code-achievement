package org.victor.array;

import java.util.ArrayList;

/**
 * Scaler problem :: plus One.

 * You are given a non-negative number represented as an array of digits. Your goal is to add one to this number and return the result as a new array.
 -- Key Rules & Constraints:
 * Input Format: The digits are ordered from most significant to least significant (e.g., [1, 2, 3] represents the number 123). The input array can have leading zeros (e.g., [0, 1, 2, 3] is a valid input).
 * Output Format: The resulting array should not contain any leading zeros.
 * Core Task: You need to handle the "carry-over" logic. For instance, if the input is [1, 9, 9], adding one should result in [2, 0, 0]. If the input is [9, 9, 9], the result should be [1, 0, 0, 0], which requires increasing the array's size.

 * Example Scenarios:
 [1, 2, 3]  -> [1, 2, 4]
 [0, 9] -> [1, 0]
 [9, 9] -> [1, 0, 0]

 * */

public class PlusOne {

    public ArrayList<Integer> plusOne(ArrayList<Integer> A) {

        int zeroCount = 0;

        for (Integer a : A){
            if (a == 0)
                zeroCount++;
            else
                break;
        }

        while (zeroCount != 0){
            A.removeFirst();
            zeroCount--;
        }

        int carry = 1;

        if (A.isEmpty()) {
            A.add(1);
            return A;
        }
        else {

            for (int i = A.size() - 1; i >= 0; i--){

                if (A.get(i) == 9){

                    int curr_sum = A.get(i) + carry;

                    A.set(i, curr_sum % 10);

                    carry = curr_sum / 10;

                    if (carry == 0) break;

                }
                else {
                    A.set(i, A.get(i) + 1);
                    carry = 0;
                    break;
                }

            }

        }

        if (carry > 0){
            A.addFirst(1);
        }

        return A;

    }
}
