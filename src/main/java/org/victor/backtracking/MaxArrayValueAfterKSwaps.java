package org.victor.backtracking;

/**
 * HackerRank problem
 * */
public class MaxArrayValueAfterKSwaps {

    private static String maxValue;

    private static void findMax(int[] arr, int k, int idx) {
        if (k == 0 || idx == arr.length) return;

        for (int j = idx; j < arr.length; j++) {
            if (arr[j] > arr[idx]) {
                swap(arr, idx, j);

                String current = arrayToString(arr);
                if (current.compareTo(maxValue) > 0) {
                    maxValue = current;
                }

                findMax(arr, k - 1, idx + 1);
                swap(arr, idx, j); // backtrack
            }
        }
        findMax(arr, k, idx + 1); // move without swapping
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i]; arr[i] = arr[j]; arr[j] = temp;
    }

    private static String arrayToString(int[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int num : arr) sb.append(num);
        return sb.toString();
    }

    public static String maxArrayValue(int[] arr, int k) {
        maxValue = arrayToString(arr);
        findMax(arr, k, 0);
        return maxValue;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        int k = 1;
        System.out.println("Maximum array value: " + maxArrayValue(arr, k)); // 321

        int[] arr2 = {9, 1, 7, 3};
        int k2 = 2;
        System.out.println("Maximum array value: " + maxArrayValue(arr2, k2)); // 9731
    }
}
