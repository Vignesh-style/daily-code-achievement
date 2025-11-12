package org.victor.array;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * LeetCode Problem
 * */
public class SortArrayBasedOnFrequency {

    public static int[] sort(int[] arr) {

        if (arr.length <= 1) return arr;

        Map<Integer, Long> freq = Arrays.stream(arr).boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        Integer[] array = Arrays.stream(arr).boxed().toArray(Integer[]::new);

        Arrays.sort(array, (o1, o2) -> {

            if (freq.get(o1) > freq.get(o2)) return 1;
            else if (freq.get(o1) < freq.get(o2)) return -1;
            else return Integer.compare(o1, o2);

        });

        return Arrays.stream(array).mapToInt(Integer::intValue).toArray();
    }


    public static void main(String[] args) {

        int[] sort = sort(new int[]{0, 9, 9, 1, 1, 1, 2, 8, -9, 00, 1});
        System.out.println(Arrays.toString(sort));

    }
}
