package org.victor.heap;

import java.util.*;

/**
 * LeetCode Problem :: 1353.
 * Maximum No.of event that can be attended.

 You are given an array of events where events[i] = [startDayi, endDayi]. Every event i starts at startDayi and ends at endDayi.
 You can attend an event i at any day d where startDayi <= d <= endDayi. You can only attend one event at any time d.
 Return the maximum number of events you can attend.

 * */

public class MaximumEventAttended {

    public int maxEvents(int[][] events) {

        Map<Integer, List<Integer>> dayToEnds = new HashMap<>();
        int minDay = Integer.MAX_VALUE;
        int maxDay = Integer.MIN_VALUE;

        for (int[] event : events) {
            int start = event[0], end = event[1];
            dayToEnds.computeIfAbsent(start, k -> new ArrayList<>()).add(end);
            minDay = Math.min(minDay, start);
            maxDay = Math.max(maxDay, end);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int attended = 0;

        for (int day = minDay; day <= maxDay; day++) {

            if (dayToEnds.containsKey(day)) {
                for (int end : dayToEnds.get(day)) {
                    pq.offer(end);
                }
            }

            while (!pq.isEmpty() && pq.peek() < day) {
                pq.poll();
            }

            if (!pq.isEmpty()) {
                pq.poll();
                attended++;
            }
        }

        return attended;

    }

}


/**
 * Example 1:

 * Input: events = [[1,2],[2,3],[3,4]]
 * Output: 3
 * Explanation: You can attend all the three events.
 * One way to attend them all is as shown.
 * Attend the first event on day 1.
 * Attend the second event on day 2.
 * Attend the third event on day 3.

 * Example 2:

 * Input: events= [[1,2],[2,3],[3,4],[1,2]]
 * Output: 4
 * */