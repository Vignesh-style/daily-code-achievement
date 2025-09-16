package org.victor.linkedlist;

 public class ListNode {
      public int val;
      public ListNode next;
      ListNode(int x) { val = x; next = null; }

     @Override
     public String toString() {
         return "ListNode{" +
                 "next=" + next +
                 ", val=" + val +
                 '}';
     }
 }
