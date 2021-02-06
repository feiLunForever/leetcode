package org.example.剑指Offer;

public class isSymmetric_28 {
    public static boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return recur(root.left, root.right);
    }

    public static boolean recur(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        else if (left == null || right == null || left.val != right.val) return false;
        return recur(left.left, right.right) && recur(left.right, right.left);
    }
}
