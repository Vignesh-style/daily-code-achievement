package org.victor.bit.manipulation;

import java.util.ArrayList;

/**
 * Scaler problem :: Given an array of positive integers A, two integers appear only once, and all the other integers appear twice.
 * Find the two integers that appear only once.

 * Note: Return the two numbers in ascending order.
 * */

public class SingleNumberII {

    public ArrayList<Integer> solve(ArrayList<Integer> A) {

        int XorValue = 0;

        for (Integer a : A)
            XorValue = XorValue ^ a;

        System.out.println(XorValue);

        int X = 0;

        for (int i = 0; i < 32; i++){
            if ((XorValue & 1 << i) > 0){
                X = i;
                break;
            }
        }

        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();

        for (Integer a : A){
            if ((a & 1 << X) > 0) list1.add(a);
            else list2.add(a);
        }

        int i1 = 0;

        for (Integer l1 : list1)
            i1 = i1 ^ l1;

        int i2 = 0;
        for (Integer l2 : list2)
            i2 = i2 ^ l2;

        ArrayList<Integer> list = new ArrayList<>();

        if (i1 < i2){
            list.add(i1);
            list.add(i2);
        }
        else {
            list.add(i2);
            list.add(i1);
        }

        return list;
    }
}
