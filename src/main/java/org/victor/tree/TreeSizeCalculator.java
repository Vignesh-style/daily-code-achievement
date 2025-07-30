package org.victor.tree;

import java.util.concurrent.*;

class TreeSizeCalculator implements Callable<Integer> {

    ExecutorService executor;
    Node root;

    public TreeSizeCalculator(Node root, ExecutorService executor){
        this.root = root;
        this.executor = executor;
    }


    @Override
    public Integer call() throws Exception{

        if (root == null) return 0;

        Future<Integer> leftFuture = null;
        Future<Integer> rightFuture = null;

        if (root.left != null){
            TreeSizeCalculator leftTree = new TreeSizeCalculator(root.left, executor);
            leftFuture = executor.submit(leftTree);
        }

        if (root.right != null){
            TreeSizeCalculator rightTree = new TreeSizeCalculator(root.right, executor);
            rightFuture = executor.submit(rightTree);
        }


        int leftSize  = leftFuture == null ? 0 : leftFuture.get();
        int rightSize = rightFuture == null ? 0 : rightFuture.get();

        return leftSize + rightSize + 1;

    }

}