package review;

import java.util.Deque;
import java.util.LinkedList;

public class maxDepth {
    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        int high = 0;
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);
        while (deque.size() > 0) {
            TreeNode parent = deque.poll();
            if (parent.left != null)
                deque.offer(parent.left);
            if (parent.right != null)
                deque.offer(parent.right);
            high++;
        }
        return high;
    }
}
