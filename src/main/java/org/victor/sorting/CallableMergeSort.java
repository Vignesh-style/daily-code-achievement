package org.victor.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

/**
 * Merge Sort Algorithm implement via callables. TC : O(n log n) remains the same.
 *
 */

public record CallableMergeSort(List<Integer> integers,
                                ExecutorService executorService) implements Callable<List<Integer>> {

    @Override
    public List<Integer> call() throws Exception {

        //base case.
        if (integers.size() <= 1) return integers;

        int mid = integers.size() / 2;

        List<Integer> partition1 = integers.subList(0, mid);
        List<Integer> partition2 = integers.subList(mid, integers.size());

        CallableMergeSort task1 = new CallableMergeSort(partition1, executorService);
        CallableMergeSort task2 = new CallableMergeSort(partition2, executorService);

        Future<List<Integer>> task1_futures = executorService.submit(task1);
        Future<List<Integer>> task2_futures = executorService.submit(task2);

        return merge(task1_futures.get(), task2_futures.get());
    }

    public static List<Integer> merge(List<Integer> l1, List<Integer> l2) {

        List<Integer> mergedList = new ArrayList<>();

        int i1 = l1.size();
        int i2 = l2.size();

        int lp1 = 0;
        int lp2 = 0;

        while (lp1 < i1 && lp2 < i2) {

            if (l1.get(lp1) <= l2.get(lp2)) {
                mergedList.add(l1.get(lp1));
                lp1++;
            } else {
                mergedList.add(l2.get(lp2));
                lp2++;
            }

        }

        while (lp1 < i1) {

            mergedList.add(l1.get(lp1));
            lp1++;

        }
        while (lp2 < i2) {
            mergedList.add(l2.get(lp2));
            lp2++;
        }

        return mergedList;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {


        ExecutorService main_executor = Executors.newCachedThreadPool();
        CallableMergeSort mergeSortCallable = new CallableMergeSort(Arrays.asList(1, 10, 6, 4, 14, 56, 35, 134, 514, 51), main_executor);

        Future<List<Integer>> submit = main_executor.submit(mergeSortCallable);
        List<Integer> res = submit.get();

        System.out.println(res);
        main_executor.shutdown();

    }
}
