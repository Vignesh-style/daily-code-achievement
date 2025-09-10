package org.victor.linkedlist;

/**
 * Scaler problem :: You are given a singly linked list having head node A. You have to reverse the linked list and return the head node of that reversed list.
 * NOTE: You have to do it in-place and in one-pass.
 * */

public class ReverseLinkedList {

    public ListNode reverseList(ListNode A) {

        if (A == null)
            return null;

        ListNode nextNode = A.next;

        if (nextNode == null)
            return A;

        ListNode currN = A;
        ListNode prevN = null;

        while (currN != null) {

            // System.out.println("--------------");

            // System.out.println(prevN);
            // System.out.println(currN);
            // System.out.println(nextNode);

            nextNode = currN.next;
            currN.next = prevN;
            prevN = currN;
            currN = nextNode;

            // System.out.println(prevN);
            // System.out.println(currN);
            // System.out.println(nextNode);


        }
        return prevN;
    }
}
