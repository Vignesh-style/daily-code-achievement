package org.victor.linkedlist;

/**
 * LeetCode Problem.
 * */
public class IntersectionFinder {

    public static ListNode findIntersectionLL(ListNode A, ListNode B){

        ListNode aHead = A;
        ListNode bHead = B;

        while (aHead == bHead){

            aHead = aHead == null ? bHead : aHead.next;
            bHead = bHead == null ? aHead : bHead.next;

        }

        return aHead;
    }


    public static void main(String[] args) {

        ListNode aHead = new ListNode(1);
        ListNode a1Head = new ListNode(2);
        aHead.next = a1Head;
        ListNode a2Head = new ListNode(3);
        a1Head.next = a2Head;
        ListNode a3Head = new ListNode(4);
        a2Head.next = a3Head;
        ListNode a4Head = new ListNode(5);
        a3Head.next = a4Head;


        ListNode bHead = new ListNode(-2);
        ListNode b1Head = new ListNode(-1);
        bHead.next = b1Head;
        ListNode b2Head = new ListNode(0);
        b1Head.next = b2Head;
        ListNode b3Head = new ListNode(1);
        b2Head.next = b3Head;
        ListNode b4Head = new ListNode(2);
        b3Head.next = b4Head;

        ListNode intersectionLL = findIntersectionLL(aHead, bHead);
        System.out.println(intersectionLL);
    }
}
