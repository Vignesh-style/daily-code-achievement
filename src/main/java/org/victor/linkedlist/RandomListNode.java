package org.victor.linkedlist;

public class RandomListNode {

      int label;
      RandomListNode next, random;

      RandomListNode(int x) { this.label = x; }

    @Override
    public String toString() {
        return "RandomListNode{" +
                "label=" + label +
                ", next=" + next +
                ", random=" + random +
                '}';
    }
};