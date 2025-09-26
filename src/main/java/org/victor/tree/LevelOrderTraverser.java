package org.victor.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Scaler problem :: Given a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).
 * 1 <= number of nodes <= 105
 * */

public class LevelOrderTraverser {

    public ArrayList<ArrayList<Integer>> traverse(TreeNode A) {

        ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
        Queue<ArrayList<TreeNode>> queue = new LinkedList<>();


        if (A == null)
            return new ArrayList<>();

        ArrayList<TreeNode> rootList = new ArrayList<>();
        rootList.add(A);
        queue.add(rootList);

        while (!queue.isEmpty()) {

            ArrayList<TreeNode> currNodes = queue.poll();

            ArrayList<Integer> childValues = new ArrayList<>();
            ArrayList<TreeNode> childNodes = new ArrayList<>();

            for (TreeNode currNode : currNodes) {

                childValues.add(currNode.val);

                TreeNode left = currNode.left;
                TreeNode right = currNode.right;


                if (left != null) {
                    childNodes.add(left);
                }
                if (right != null) {
                    childNodes.add(right);
                }
            }

            if (!childNodes.isEmpty())
                queue.add(childNodes);

            if (!childValues.isEmpty())
                ret.add(childValues);
        }

        return  ret;


    }

}
