package org.victor.graph;

import java.util.*;

public class WordLadder {

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);
        if (!dict.contains(endWord)) return 0;

        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        Map<String, Integer> visited = new HashMap<>();
        visited.put(beginWord, 1);

        while (!queue.isEmpty()) {
            String word = queue.poll();
            int level = visited.get(word);

            for (int i = 0; i < word.length(); i++) {
                char[] chars = word.toCharArray();
                for (char c = 'a'; c <= 'z'; c++) {
                    if (chars[i] == c) continue;
                    chars[i] = c;
                    String newWord = new String(chars);
                    if (newWord.equals(endWord)) return level + 1;
                    if (dict.contains(newWord) && !visited.containsKey(newWord)) {
                        visited.put(newWord, level + 1);
                        queue.add(newWord);
                    }
                }
            }
        }
        return 0; // no path found
    }

    public static void main(String[] args) {
        String startWord = "hit";
        String endWord = "cog";
        List<String> wordList = Arrays.asList("hot","dot","dog","lot","log","cog");
        System.out.println("Shortest ladder length: " + ladderLength(startWord, endWord, wordList)); // 5
    }
}
