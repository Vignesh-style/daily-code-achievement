package org.victor.string;

import java.util.ArrayList;
import java.util.List;

/**
    HackerRank. -- 02

    An English text needs to be encrypted using the following encryption scheme.
    First, the spaces are removed from the text. Let  be the length of this text.
    Then, characters are written into a grid, whose rows and columns have the following constraints:

    [SQRT(l) <= row <= column <= SQRT(l)] where [x] is the floor function & [x] is a ciel function. l -> length of string.

    Example : if String = "Vignesh-Style" --> length  is 13. hence sqrt(13) is between [3 - 4].
    3 x 4 = 12 grid < 13. hence we populate in 4 x 4 = 16 > 13.

    then the gridValues will be like [Vign, esh-, Styl, e] --> encrypting with column --> VeSe ist ghy n-l </done>.

 * */

public class RowColumnWiseEncryption {

    public static String encryption(String s) {

        String s_space_removed = s.replace(" ", "");

        int s_length = s_space_removed.length();

        double s_sqrt = Math.sqrt(s_length);

        int upper_bound = (int) Math.ceil(s_sqrt);
        int lower_bound = (int) Math.floor(s_sqrt);

        //System.out.println("L :" + s_length + " spqrt : " + s_sqrt);

        int row;
        int col;

        //System.out.println("lp : " + lower_bound + " up : " + upper_bound);

        if (upper_bound == lower_bound || (upper_bound * lower_bound) >= s_length) {
            row = lower_bound;
        } else {
            row = upper_bound;
        }
        col = upper_bound;


        List<String> splitList = new ArrayList<>(row);

        for (int i = 0; i < s_length; i = i + col) {

            String split = s_space_removed.substring(i, Math.min(s_length, i + col));
            splitList.add(split);

        }

        // System.out.println("splits " + splitList);

        StringBuilder ret = new StringBuilder();

        for (int i = 0; i < col; i++) {

            StringBuilder sb = new StringBuilder();

            for (String split : splitList) {

                if (i <= split.length() - 1)
                    sb.append(split.charAt(i));
            }

            if (ret.isEmpty()) ret.append(sb);
            else {
                ret.append(" ");
                ret.append(sb);
            }
        }

        return ret.toString();
    }
}
