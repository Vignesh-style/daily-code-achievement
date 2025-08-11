package org.victor.tree;

import java.util.HashMap;
import java.util.Map;

/**
 * Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree and inorder is the inorder traversal of the same tree,
 * construct and return the binary tree.

 * Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
 * Output: [3,9,20,null,null,15,7]

 * */

public class ConstructBTFromPreNdInOrder {

    private static Map<Integer, Integer> map = new HashMap<>();

    public Node buildTree(int[] preorder, int[] inorder) {

        for (int i = 0; i < inorder.length; i++) map.put(inorder[i], i);

        return ConstructBT(inorder, 0, inorder.length - 1, preorder, 0, preorder.length - 1);
    }


    private Node ConstructBT(int[] inOrder, int ins, int ine, int[] preOrder, int ps, int pe) {

        if (ps > pe) return null;

        int rootVal = preOrder[ps];
        Node root = new Node(rootVal);

        Integer idx = map.get(rootVal);
        int l = idx - ins;

        //System.out.println(root);

        root.left = ConstructBT(inOrder, ins, idx - 1, preOrder, ps + 1, ps + l);
        root.right = ConstructBT(inOrder, idx + 1, ine , preOrder, ps + l + 1, pe);

        return root;
    }
}
