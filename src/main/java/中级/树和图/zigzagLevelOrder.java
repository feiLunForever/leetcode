package 中级.树和图;

import java.util.*;

public class zigzagLevelOrder {

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null)
            return new ArrayList<>();
        List<List<Integer>> lists = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean left = true;
        while (!queue.isEmpty()) {
            Deque<Integer> deque = new LinkedList<>();
            int size = queue.size();
            while (size > 0) {
                TreeNode node = queue.poll();
                size--;
                if (left)
                    deque.offerLast(node.val);
                else
                    deque.offerFirst(node.val);
                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);
            }
            left = !left;
            lists.add(new ArrayList<>(deque));
        }
        return lists;
    }
}
