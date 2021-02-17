package 面试整理.二叉树和递归;

import java.util.LinkedList;
import java.util.Queue;

public class invertTree_226 {

    /**
     * 递归实现
     *
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) //递归函数的终止条件，节点为空时返回
            return null;
        invertTree(root.left); //递归交换当前节点的 左子树
        invertTree(root.right); //递归交换当前节点的 右子树
        // 左右子树交换
        TreeNode tempNode = root.left;
        root.left = root.right;
        root.right = tempNode;
        return root;
    }

    /**
     * 迭代实现
     *
     * @param root
     * @return
     */
    public TreeNode invertTree2(TreeNode root) {
        if (root == null)
            return null;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            swapLeftAndRight(temp); // 交换左右子树
            if (temp.left != null)
                queue.offer(temp.left);
            if (temp.right != null)
                queue.offer(temp.right);
        }
        return root;
    }

    /**
     * 交换左右子树
     *
     * @param root
     */
    private void swapLeftAndRight(TreeNode root) {
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }

}
