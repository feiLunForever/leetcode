package 面试整理.栈和队列;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class postorderTraversal_145 {

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> results = new ArrayList<>();
        postorderRecur(root, results);
        return results;
    }

    /**
     * 递归实现后序遍历
     *
     * @param root
     * @param results
     */
    private void postorderRecur(TreeNode root, List<Integer> results) {
        if (root == null)
            return;
        postorderRecur(root.left, results);
        postorderRecur(root.right, results);
        results.add(root.val);
    }

    /**
     * 迭代实现后序遍历
     *
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal2(TreeNode root) {
        List<Integer> results = new ArrayList<>();
        if (root == null)
            return results;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode pre = null; //pre节点用于记录前一次访问的节点
        while (!stack.isEmpty() || cur != null) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.peek();
            if (cur.right == null || cur.right == pre) { // 若右节点为空 或右节点访问过
                results.add(cur.val);
                pre = cur;
                stack.pop();
                cur = null; // 此时下一轮循环不要将左子树压栈，直接判断栈顶元素
            } else {
                cur = cur.right;
            }
        }
        return results;
    }
}
