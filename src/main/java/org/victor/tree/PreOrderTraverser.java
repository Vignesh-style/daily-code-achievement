package org.victor.tree;

import java.util.ArrayList;

/**
 * Scaler problem :: Given a binary tree, return the preorder traversal of its nodes values.
 * */

public class PreOrderTraverser {

    public ArrayList<Integer> preorderTraversal(TreeNode A) {

        return traversePreOrderOnTree(A, new ArrayList<>());

    }

    public static ArrayList<Integer> traversePreOrderOnTree(TreeNode root, ArrayList<Integer> traversedValues){

        if (root == null)
            return traversedValues;

        traversedValues.add(root.val);
        traversePreOrderOnTree(root.left, traversedValues);
        traversePreOrderOnTree(root.right, traversedValues);

        return traversedValues;
    }

}
