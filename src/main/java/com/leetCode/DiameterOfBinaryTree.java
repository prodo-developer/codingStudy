package com.leetCode;


public class DiameterOfBinaryTree {

    int maxValue = 0;
    public int diameterOfBinaryTree(TreeNode root) {

        getDiameter(root);

        return maxValue;
    }

    private int getDiameter(TreeNode root) {
        if(root == null)
            return 0;

        int leftValue = getDiameter(root.left);
        int rightValue = getDiameter(root.right);

        maxValue = Math.max(maxValue, leftValue+rightValue);

        return Math.max(leftValue, rightValue)+1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);

        System.out.println(new DiameterOfBinaryTree().diameterOfBinaryTree(root));
    }
}
