package 面试整理.栈和队列;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class preorderTraversal_144 {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> results = new ArrayList<>();
        preorderRecur(root, results);
        return results;
    }

    /**
     * 递归实现前序遍历
     *
     * @param root
     * @param results
     */
    private void preorderRecur(TreeNode root, List<Integer> results) {
        if (root == null)
            return;
        results.add(root.val);
        preorderRecur(root.left, results);
        preorderRecur(root.right, results);
    }

    /**
     * 迭代实现前序遍历
     *
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> results = new ArrayList<>();
        if (root == null)
            return results;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            results.add(node.val);
            if (node.right != null) // 先要弹出左子树的节点，所以先将右子树的节点入栈
                stack.push(node.right);
            if (node.left != null)
                stack.push(node.left);
        }
        return results;
    }


}
