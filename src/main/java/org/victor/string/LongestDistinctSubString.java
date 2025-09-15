package org.victor.string;

import java.util.*;

/**
 * Interview Problem ::
 * Given a String find the longest distinct substring without repeating characters form it.

 * [proposed approach sliding window...]
 * */


public class LongestDistinctSubString {

    public static int distinctLength(String str){

        int max_distinct_len = 0;

        int left = 0;
        Map<Character, Integer> uniqueCharIdxMap = new HashMap<>();

        for (int right = 0; right < str.length(); right++) {

            char curr_char = str.charAt(right);

            if (uniqueCharIdxMap.containsKey(curr_char) && uniqueCharIdxMap.get(curr_char) >= left){
                left = uniqueCharIdxMap.get(curr_char) + 1;
            }

            uniqueCharIdxMap.put(curr_char, right);

            max_distinct_len = Math.max(max_distinct_len, right - left + 1);

        }
        return max_distinct_len;
    }
}
