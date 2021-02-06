package 初级.树;

import org.example.算法.BFS;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class maxDepth {

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

    public static int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        int depth = 0;
        Queue<TreeNode> deque = new LinkedList<>();
        deque.offer(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            while (size > 0) {
                TreeNode node = deque.poll();
                size--;
                if (node.left != null)
                    deque.offer(node.left);
                if (node.right != null)
                    deque.offer(node.right);
            }
            depth++;
        }
        return depth;
    }

    public static void main(String[] args) {
        // [1,2,3,4,null,null,5]
        TreeNode h = new TreeNode(1);
        TreeNode h2 = new TreeNode(2);
        TreeNode h3 = new TreeNode(3);
        h.left = h2;
        h.right = h3;
        TreeNode h4 = new TreeNode(4);
        h2.left = h4;
        TreeNode h5 = new TreeNode(5);
        h3.right = h5;
        System.out.println(maxDepth(h));

    }

}
