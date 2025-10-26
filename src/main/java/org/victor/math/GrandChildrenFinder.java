package org.victor.math;

import java.util.*;

public class GrandChildrenFinder {
    public static void main(String[] args) {
        String[][] relations = {
                {"luke", "shaw"},
                {"wayne", "rooney"},
                {"rooney", "ronaldo"},
                {"shaw", "rooney"}
        };

        Map<String, List<String>> family = new HashMap<>();

        // Build father -> children mapping
        for (String[] rel : relations) {
            String child = rel[0];
            String father = rel[1];
            family.computeIfAbsent(father, k -> new ArrayList<>()).add(child);
        }

        String person = "ronaldo";
        System.out.println("No. of grandchildren of " + person + ": " + countGrandChildren(family, person));
    }

    static int countGrandChildren(Map<String, List<String>> family, String person) {
        int count = 0;
        List<String> children = family.get(person);
        if (children == null) return 0;

        for (String child : children) {
            List<String> grandChildren = family.get(child);
            if (grandChildren != null)
                count += grandChildren.size();
        }
        return count;
    }
}
