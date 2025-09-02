package org.victor.string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Hackerrank problem :: Two strings are said to be anagrams of each other if the letters of one string can be rearranged to form the other string.
 * Given a string s, determine the number of pairs of substrings of s that are anagrams of each other.

 * Example
 * If s = "mom", the anagrammatic pairs are: [m, m] at positions ([0], [2]), [mo, om] at positions ([0,1], [1,2])
 * So, the total number of anagrammatic pairs is 2.
 * * */

public class SherlockAnagrams {

    public static int sherlockAndAnagrams(String s) {

        Map<String, Integer> anagramRefMap = new HashMap<>();

        int n = s.length();

        for (int i = 0; i < n; i++){

            for (int j = i + 1; j <= n; j++){

                String subS = s.substring(i, j);

                char[] subSChars = subS.toCharArray();
                Arrays.sort(subSChars);

                String sortedSubS = new String(subSChars);

                System.out.println(subS + " ---> " + sortedSubS);

                Integer freq = anagramRefMap.getOrDefault(sortedSubS, 0);
                anagramRefMap.put(sortedSubS, freq + 1);

            }

        }

        int anagramCount = 0;

        for (Map.Entry<String, Integer> entry : anagramRefMap.entrySet()){

            if (entry.getValue() >= 2){

                Integer val = entry.getValue();

                anagramCount +=  (int) val * (val - 1) / 2;

            }

        }
        return anagramCount;
    }

}
