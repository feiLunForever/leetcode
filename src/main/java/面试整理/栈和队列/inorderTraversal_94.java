package 面试整理.栈和队列;

import 中级.树和图.connect;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class inorderTraversal_94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> results = new ArrayList<>();
        inorderRecur(root, results);
        return results;
    }

    /**
     * 递归实现中序遍历
     *
     * @param root
     * @param results
     */
    private void inorderRecur(TreeNode root, List<Integer> results) {
        if (root == null)
            return;
        inorderRecur(root.left, results);
        results.add(root.val);
        inorderRecur(root.right, results);
    }

    /**
     * 迭代实现中序遍历
     * @param root
     * @return
     */
    public static List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> results = new ArrayList<>();
        if (root == null)
            return results;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (!stack.isEmpty() || cur != null) {
            // 找到最左子树
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            results.add(cur.val);
            cur = cur.right;
        }
        return results;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        node1.left = node2;
        node1.right = node3;
        /*TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        node2.left = node4;
        node2.right = node5;
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        node3.left = node6;
        node3.right = node7;*/
        List<Integer> integers = inorderTraversal2(node1);
        System.out.println();
    }
}
