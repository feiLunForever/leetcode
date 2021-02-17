package 面试整理.二叉树和递归;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class binaryTreePaths_257 {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        dfs(root, "", res);
        return res;
    }

    /**
     * dfs
     *
     * @param root
     * @param path
     * @param res
     */
    private void dfs(TreeNode root, String path, List<String> res) {
        if (root == null)
            return;
        if (root.left == null && root.right == null) { // 叶子节点
            res.add(path + root.val); // 只有叶子节点才将路径放进去
            return;
        }
        dfs(root.left, path + root.val + "->", res);
        dfs(root.right, path + root.val + "->", res);
    }

    /**
     * 迭代实现
     *
     * @param root
     * @return
     */
    public List<String> binaryTreePaths1(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null)
            return res;
        Queue<TreeVal> queue = new LinkedList<>();
        queue.offer(new TreeVal(root, ""));
        while (!queue.isEmpty()) {
            TreeVal treeVal = queue.poll();
            TreeNode node = treeVal.node;
            String path = treeVal.path;
            if (node.left == null && node.right == null) {
                res.add(path + node.val);
                continue;
            }
            if (node.left != null)
                queue.offer(new TreeVal(node.left, path + node.val + "->"));
            if (node.right != null)
                queue.offer(new TreeVal(node.right, path + node.val + "->"));
        }
        return res;
    }

    public class TreeVal {
        private TreeNode node; // 存放树节点
        private String path;  // 存放到上一个节点的路径

        public TreeVal() {
        }

        public TreeVal(TreeNode node, String path) {
            this.node = node;
            this.path = path;
        }
    }
}
