package review;

public class kthLargest {
    int res;
    int index;

    public int kthLargest(TreeNode root, int k) {
        dfs(root, k);
        return res;
    }

    private void dfs(TreeNode root, int k) {
        if (root == null)
            return;
        // 右 -》 中 -》 左
        dfs(root.right, k);// 右
        index++; // 每比较一次，就代表遍历过一个节点
        if (k == index) res = root.val; // 根
        dfs(root.left, k);
    }
}
