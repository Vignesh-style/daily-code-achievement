package org.victor.linkedlist;

/**
 * //todo Classic Problem

 * Scaler problem :: You are given a linked list A
 * Each node in the linked list contains two pointers: a next pointer and a random pointer
 * The next pointer points to the next node in the list
 * The random pointer can point to any node in the list, or it can be NULL
 * Your task is to create a deep copy of the linked list A
 * The copied list should be a completely separate linked list from the original list, but with the same node values and random pointer connections as the original list
 * You should create a new linked list B, where each node in B has the same value as the corresponding node in A
 * The next and random pointers of each node in B should point to the corresponding nodes in B (rather than A)

 * */

public class DeepCopyLinkedList {

    public RandomListNode copyRandomList(RandomListNode head) {

        //intermediate cloning part.

        RandomListNode currNode = head;

        while (currNode != null){

            RandomListNode copyNode = new RandomListNode(currNode.label);
            copyNode.next = currNode.next;
            currNode.next = copyNode;

            //moving frw
            currNode = copyNode.next;

        }


        //update random pointers.
        RandomListNode n1 = head;
        RandomListNode n2 = n1.next;

        while (n1 != null){

            RandomListNode random = n1.random;

            if (random != null)
                n2.random = random.next;

            n1 = n2.next;

            if (n1 != null)
                n2 = n1.next;

        }

        //splitting the intermediate copies.

        RandomListNode ret = head.next;
        RandomListNode tempNode = head;

        while (tempNode != null){

            RandomListNode copyNode = tempNode.next;
            tempNode.next = copyNode.next;
            tempNode = tempNode.next;

            if (tempNode != null)
                copyNode.next = tempNode.next;

        }
        return ret;
    }
}
