package 初级.树;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class isValidBST {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static boolean isValidBST(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        double val = -Double.MAX_VALUE;
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (root.val <= val)
                return false;
            val = root.val;
            root = root.right;
        }
        return true;
    }

    public static void main(String[] args) {
        // [1,2,3,4,null,null,5]
        TreeNode h = new TreeNode(2);
        TreeNode h2 = new TreeNode(1);
        TreeNode h3 = new TreeNode(3);
        h.left = h2;
        h.right = h3;

        System.out.println(isValidBST(h));

    }

}
