package org.victor.stack;

import java.util.Stack;

/**
 * LeetCode problem :: 739.
 * Given an array of integers temperatures represents the daily temperatures,
 * return an array answer such that answer[i] is the number of days you have to wait after the ith day to get a warmer temperature.
 * If there is no future day for which this is possible, keep answer[i] == 0 instead.
 * */

public class WarmerTemperature {

    public int[] dailyTemperatures(int[] temperatures) {

        Stack<Integer[]> tempStack = new Stack<>();
        int[] dayToGetWarmer = new int[temperatures.length];

        for (int i = 0; i < temperatures.length; i++) {

            int curr_temperature = temperatures[i];

            while (!tempStack.isEmpty() && tempStack.peek()[0] < curr_temperature){

                Integer[] peek = tempStack.pop();
                Integer prevDayIdx = peek[1];

                dayToGetWarmer[prevDayIdx] = i - prevDayIdx;

            }

           tempStack.push(new Integer[]{curr_temperature, i});
        }

        //for last not warmer no fore-weather data available dates
        while (!tempStack.isEmpty()){
            Integer[] peek = tempStack.pop();
            dayToGetWarmer[peek[1]] = 0;
        }

        return dayToGetWarmer;
    }

}
