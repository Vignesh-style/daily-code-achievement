package org.victor.string;

/**
 * Leet Code Problem :: String Compression.
 * */

public class StringCompression {

    public static void main(String[] args) {

        int compress = compress(new char[]{'a','a', 'c'});

    }

    public static int compress(char[] chars) {

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < chars.length; i++){

            int counter = 1;

            while ((i + 1) < chars.length && chars[i] == chars[i + 1]){
                counter++;
                i++;
            }

            if (counter != 1) sb.append(chars[i]).append(counter);
            if (counter == 1) sb.append(chars[i]);

        }

        System.out.println(sb);
        return sb.toString().length();
    }
}
