package org.victor.array;

import java.util.ArrayList;
import java.util.List;

/**
  HackerRank. -- Problem Statement in the resource.
  -. HK01_climbing-the-leaderboard-.pdf
 * */
public class ClimbingLeaderboard {

    public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {

        int nr = ranked.size();
        List<Integer> ranks = new ArrayList<>();
        List<Integer> ret = new ArrayList<>();

        Integer prev = ranked.get(0);

        for (int i = 1; i < nr; i++){

            if (prev.equals(ranked.get(i))){
                continue;
            }

            ranks.add(prev);
            prev = ranked.get(i);
        }

        ranks.add(prev);

        int search_pointer = ranks.size() - 1;

        for (Integer score : player) {

            for (int i = search_pointer; i >= 0; i--) {

                if (score.equals(ranks.get(i))) {
                    ret.add(i + 1);
                    search_pointer = i;
                    break;
                }

                if (score < ranks.get(i)) {
                    ret.add(i + 2);
                    search_pointer = i;
                    break;
                }

                if (i == 0)
                    ret.add(i + 1);

            }

        }

        return ret;
    }

}
