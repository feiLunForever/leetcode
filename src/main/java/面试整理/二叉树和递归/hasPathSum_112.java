package 面试整理.二叉树和递归;

import java.util.LinkedList;
import java.util.Queue;

public class hasPathSum_112 {
    /**
     * 递归实现
     *
     * @param root
     * @param targetSum
     * @return
     */
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null)
            return false;
        if (root.left == null && root.right == null) // 递归的终止条件是叶子节点
            return root.val == targetSum;
        // 递归查找左右子树
        return hasPathSum(root.left, targetSum - root.val)
                || hasPathSum(root.right, targetSum - root.val);
    }

    /**
     * 递归实现
     *
     * @param root
     * @param targetSum
     * @return
     */
    private boolean res;

    public boolean hasPathSum1(TreeNode root, int targetSum) {
        if (root == null)
            return false;
        // dfs 递归查找
        dfs(root, 0, targetSum);
        return res;
    }

    /**
     * dfs 递归查找
     *
     * @param node      节点
     * @param originSum 上一节点的和
     * @param targetSum 目标和
     */
    private void dfs(TreeNode node, int originSum, int targetSum) {
        if (node == null || res) // 当前节点为空或者已经找到节点，直接返回
            return;
        if (node.left == null && node.right == null) { // 叶子节点
            res = node.val + originSum == targetSum; // 更新结果
        }
        if (node.left != null)
            dfs(node.left, node.val + originSum, targetSum);
        if (node.right != null)
            dfs(node.right, node.val + originSum, targetSum);
    }

    /**
     * 迭代实现
     *
     * @param root
     * @param targetSum
     * @return
     */
    public boolean hasPathSum2(TreeNode root, int targetSum) {
        if (root == null)
            return false;
        Queue<TreeVal> queue = new LinkedList<>();
        queue.offer(new TreeVal(root, root.val));
        while (!queue.isEmpty()) {
            TreeVal treeVal = queue.poll();
            TreeNode node = treeVal.node;
            int sum = treeVal.val;
            if (node.left == null && node.right == null) {
                if (sum == targetSum)
                    return true;
                continue;
            }
            if (node.left != null)
                queue.offer(new TreeVal(node.left, sum + node.left.val));
            if (node.right != null)
                queue.offer(new TreeVal(node.right, sum + node.right.val));
        }
        return false;
    }

    public class TreeVal {
        private TreeNode node; // 存放树节点
        private int val;  // 存放到该节点的和

        public TreeVal() {
        }

        public TreeVal(TreeNode node, int val) {
            this.node = node;
            this.val = val;
        }
    }
}
