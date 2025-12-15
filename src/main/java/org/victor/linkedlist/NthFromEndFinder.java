package org.victor.linkedlist;

/**
 * LeetCode 19 — Remove Nth Node From End of List
 * Problem : Given the head of a linked list, remove the n-th node from the end of the list and return its head.
 * */

public class NthFromEndFinder {

    public ListNode findNthFromEnd(ListNode head, int n) {
        if (head == null || n <= 0)
            return null;

        ListNode first = head;
        ListNode second = head;

        // Step 1: Move first pointer n steps ahead
        for (int i = 0; i < n; i++) {
            if (first == null) return null; // n > length
            first = first.next;
        }

        // Step 2: Move both pointers until first reaches end
        while (first != null) {
            first = first.next;
            second = second.next;
        }

        // second now points to the nth node from end
        return second;
    }

    // Helper method to test
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        NthFromEndFinder finder = new NthFromEndFinder();
        int n = 2;
        ListNode result = finder.findNthFromEnd(head, n);

        if (result != null)
            System.out.println("Nth node from end: " + result);
        else
            System.out.println("Invalid n or empty list");
    }
}
