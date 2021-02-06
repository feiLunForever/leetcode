package org.example.剑指Offer;

public class kthLargest_54 {

    private int k;
    private TreeNode node;

    public int kthLargest(TreeNode root, int k) {
        this.k = k;
        dfs(root);
        return node.val;
    }

    private void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.right);
        if (k == 0) return;
        if (--k == 0) node = root;
        dfs(root.left);
    }

}
