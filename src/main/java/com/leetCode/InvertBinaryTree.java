package com.leetCode;

public class InvertBinaryTree {

    public TreeNode invertTree(TreeNode root) {

        if (root == null)
            return null;
        // 방법1 : DFS 재귀 호출
        final TreeNode left = root.left;
        final TreeNode right = root.right;

        root.left = invertTree(right);
        root.right = invertTree(left);

        // 방법2 : 큐를 만들고 넣는다.
//        final Queue<TreeNode> queue = new LinkedList<>();
//        queue.offer(root);
//
//        while(!queue.isEmpty()) {
//            final TreeNode node = queue.poll();
//            final TreeNode left = node.left;
//            node.left = node.right;
//            node.right = left;
//
//            if(node.left != null) {
//                queue.offer(node.left);
//            }
//            if(node.right != null) {
//                queue.offer(node.right);
//            }
//        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right = new TreeNode(7);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);

        System.out.println(new InvertBinaryTree().invertTree(root));
    }
}
