package org.victor.tree;

import java.util.ArrayList;

/**
 * Scaler Problem :: Given a binary tree, return the inorder traversal of its nodes' values.
 * */

public class InOrderTraverser {

    public static ArrayList<Integer> inorderTraversal(TreeNode A) {

        ArrayList<Integer> list =  new ArrayList<Integer>();

        traverseInOrderOnTree(A, list);

        return list;
    }

    public static void traverseInOrderOnTree(TreeNode root, ArrayList<Integer> traversedValues){

        if (root == null)
            return;

        traverseInOrderOnTree(root.left, traversedValues);
        traversedValues.add(root.val);
        traverseInOrderOnTree(root.right, traversedValues);

    }

}
